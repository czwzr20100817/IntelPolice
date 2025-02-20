package com.action;


import com.activiti.service.InvolvedActivitiService;
import com.alibaba.fastjson.JSONObject;
import com.constant.Url;
import com.model.Involved;
import com.model.InvolvedStoresBox;
import com.model.User;
import com.model.bean.InvolvedBean;
import com.model.bean.InvolvedCaseBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.service.CriminalService;
import com.service.InvolvedCaseService;
import com.service.InvolvedService;
import com.service.InvolvedStoresBoxService;
import com.utils.ExecuteResult;
import com.utils.RandomUtils;
import com.utils.ServiceUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletResponse;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 类名称：InvolvedInfosAction 类描述：涉案财物信息表的实现
 */
@Action(value = Url.INVOLVED_INFOS)
public class InvolvedAction extends BaseAction<Involved> implements ModelDriven<InvolvedBean> {
    private InvolvedBean bean = new InvolvedBean();

    @Override
    public InvolvedBean getModel() {
        return bean;
    }

    @Autowired
    private InvolvedService involvedService;
    @Autowired
    private InvolvedCaseService involvedCaseService;
    @Autowired
    private InvolvedStoresBoxService involvedStoresBoxService;
    @Autowired
    private CriminalService criminalService;
    @Autowired
    private InvolvedActivitiService involvedActivitiService;
    ActionContext context = ActionContext.getContext();

    /**
     * 展示页面
     *
     * @return
     * @throws Exception
     */
    @Action(value = Url.INVOLVED_INFOS_PAGE_SHOW, results = {@Result(name = "SUCCESS", location = Url.VIEWS + "involved/show.jsp")})
    public String index() throws Exception {
        //获取当前登录的用户
        User user = this.getUser(request);
        //设置参数
        bean.setDjrydw(request.getParameter("parentId"));
        //查询数据
        involvedService.pageQuery(getPageBean(), bean);
        //获取分页数据
        List entityList = pageBean.getRows();
        //填充查询对象
        request.setAttribute("searchObj", bean);
        //填充分页对象
        this.handlePageData(entityList, pageBean, request);
        return "SUCCESS";
    }

    /**
     * 添加页面
     *
     * @return
     */
    @Action(value = Url.INVOLVED_INFOS_ADD_SHOW,
            results = {@Result(name = "SUCCESS", location = Url.VIEWS + "involved/add_update_show.jsp")})
    public String showAdd() {
        String caseId = request.getParameter("caseid");
        //填充案件对象
        request.setAttribute("caseId", caseId);
        return "SUCCESS";
    }

    /**
     * 添加
     *
     * @throws Exception
     */
    @Action(value = Url.INVOLVED_INFOS_ADD_SUBMIT)
    public void addInvolved() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = null;
        //获取当前登录的用户
        User user = this.getUser(request);
        try {
            bean.setId(ServiceUtils.generatePrimaryKey());
            bean.setCwbm(RandomUtils.RandomCode("CW",user.getDeptId()));
            involvedService.addBean(bean);//添加财务
            InvolvedCaseBean involvedCaseBean = new InvolvedCaseBean();
            involvedCaseBean.setInvolvedId(bean.getId());
            String caseId = request.getParameter("caseId");
            involvedCaseBean.setCaseId(caseId);
            involvedCaseService.addBean(involvedCaseBean);//添加案件和财务的关联
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.SUCCESS_STATUS, true);
        } catch (Exception e) {
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.ERROR_STATUS, e.getMessage());
        }
        response.getWriter().write(jsonObject.toJSONString());
    }

    /**
     * 修改页面
     *
     * @return
     */
    @Action(value = Url.INVOLVED_INFOS_UPDATE_SHOW,
            results = {@Result(name = "SUCCESS", location = Url.VIEWS + "involved/add_update_show.jsp")})
    public String showEdit() {
        try {
            InvolvedBean resultBean = involvedService.findInvolvedById(bean.getId());
            request.setAttribute("entity", resultBean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "SUCCESS";
    }

    /**
     * 修改
     *
     * @throws Exception
     */
    @Action(value = Url.INVOLVED_INFOS_UPDATE_SUBMIT)
    public void updateInvolved() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = null;
        try {
            involvedService.updateBean(bean.getId(), bean);
            //返回操作成功标志200， 并关闭对话框
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.SUCCESS_STATUS, true);

        } catch (Exception e) {
            //返回失败标识，并写入错误信息
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.ERROR_STATUS, e.getMessage());
        }
        response.getWriter().write(jsonObject.toJSONString());
    }

    /**
     * 删除
     *
     * @throws Exception
     */
    @Action(value = Url.INVOLVED_INFOS_DELETE_SUBMIT)
    public void deleteInvolved() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = null;
        try {
            involvedService.deleteBean(bean.getId());
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.SUCCESS_STATUS, null);
        } catch (Exception e) {
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.ERROR_STATUS, e.getMessage());
        }
        response.getWriter().write(jsonObject.toJSONString());
    }

    /**
     * 详情展示
     *
     * @throws Exception
     */
    @Action(value = Url.INVOLVED_INFOS_DETAIL_SHOW,
            results = {@Result(name = "SUCCESS", location = Url.VIEWS + "involved/detail.jsp")})
    public String getInvolvedById() throws Exception {
        try {
            InvolvedBean bean2 = involvedService.findInvolvedById(bean.getId());
            request.setAttribute("entity", bean2);
        } catch (Exception e) {
            String resultMessage = e.getMessage();
            request.setAttribute("message", resultMessage);
        }
        return "SUCCESS";
    }

    /**
     * 存放详情展示
     *
     * @throws Exception
     */
    @Action(value = Url.INVOLVED_INFOS_KEEP_DETAIL_SHOW,
            results = {@Result(name = "SUCCESS", location = Url.VIEWS + "involved/keep_detail.jsp")})
    public String getInvolvedkeepById() throws Exception {
        try {
            InvolvedCaseBean involvedCaseBean = involvedCaseService.findInvolvedCaseByInvolvedId(bean.getId());
            Involved involved = involvedService.findInvolvedById(involvedCaseBean.getInvolvedId());
            InvolvedStoresBox involvedStoresBox = involvedStoresBoxService.findInvolvedStoresBoxById(involvedCaseBean.getBoxId());
            involvedCaseBean.setStoreId(involvedStoresBox.getStoreId());
            involvedCaseBean.setLockersId(involvedStoresBox.getLockerId());
            involvedCaseBean.setBoxNo(involvedStoresBox.getBoxNo());
            request.setAttribute("involved", involved);
            request.setAttribute("entity", involvedCaseBean);
        } catch (Exception e) {
            String resultMessage = e.getMessage();
            request.setAttribute("message", resultMessage);
        }
        return "SUCCESS";
    }

    /**
     * 保管员修改财物存放页面（保管员）
     *
     * @return
     */
    @Action(value = Url.INVOLVED_INFOS_KEEP_UPDATE_SHOW,
            results = {@Result(name = "SUCCESS", location = Url.VIEWS + "involved/keep_update.jsp")})
    public String keep_keep_show() {
        //填充查询对象
        request.setAttribute("entity", bean);
        request.setAttribute("iden", "修改");
        return "SUCCESS";
    }

    /**
     * 保管员修改财物存放（保管员）
     *
     * @throws Exception
     */
    @Action(value = Url.INVOLVED_INFOS_KEEP_UPDATE_SUBMIT)
    public void keep_keep() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = null;
        //获取当前登录的用户
        User user = this.getUser(request);
        try {
            String boxId = request.getParameter("involved_boxId");
            if (boxId != null) {
                InvolvedCaseBean involvedCaseBean = involvedCaseService.findInvolvedCaseByInvolvedId(bean.getId());
                involvedCaseBean.setBoxId(boxId);
                involvedCaseService.updateBean(involvedCaseBean.getId(), involvedCaseBean);
            }
            String bgdqsj = request.getParameter("bgdqsj");
            if (bgdqsj != null) {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                ParsePosition pos = new ParsePosition(0);
                Date bgdqsjDate = formatter.parse(bgdqsj, pos);
                InvolvedBean involvedBean = involvedService.findInvolvedById(bean.getId());
                involvedBean.setBgdqsj(bgdqsjDate);
                involvedService.updateBean(involvedBean.getId(), involvedBean);
            }
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.SUCCESS_STATUS, true);
        } catch (Exception e) {
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.ERROR_STATUS, e.getMessage());
        }
        response.getWriter().write(jsonObject.toJSONString());
    }

    /**
     * 已出库财物（保管员）
     *
     * @throws Exception
     */
    @Action(value = Url.INVOLVED_INFOS_KEEP_OUT_SHOW, results = {@Result(name = "SUCCESS", location = Url.VIEWS + "involved/out_show.jsp")})
    public String outShow() throws Exception {
        //获取当前登录的用户
        User user = this.getUser(request);
        //设置参数
        bean.setStoreState("5");
        //查询数据
        involvedService.pageQuery(getPageBean(), bean);
        //获取分页数据
        List entityList = pageBean.getRows();
        //填充查询对象
        request.setAttribute("searchObj", bean);
        //填充分页对象
        this.handlePageData(entityList, pageBean, request);
        return "SUCCESS";
    }

    /**
     * 保管即将到期财物（保管员）
     *
     * @throws Exception
     */
    @Action(value = Url.INVOLVED_INFOS_KEEP_OUT_DATE_SHOW, results = {@Result(name = "SUCCESS", location = Url.VIEWS + "involved/out_date_show.jsp")})
    public String outDateShow() throws Exception {
        //获取当前登录的用户
        User user = this.getUser(request);
        //设置参数
        if (bean.getBgdqsj() == null || bean.getBgdqsj().equals("")) {
            Calendar ca = Calendar.getInstance();
            ca.add(Calendar.MONTH,1);
            Date date = ca.getTime();
            bean.setBgdqsj(date);
        }
        //查询数据
        involvedService.pageQuery(getPageBean(), bean);
        //获取分页数据
        List entityList = pageBean.getRows();
        //填充查询对象
        request.setAttribute("searchObj", bean);
        //填充分页对象
        this.handlePageData(entityList, pageBean, request);
        return "SUCCESS";
    }

    /**
     * 未上交财物（保管员）
     *
     * @throws Exception
     */
    @Action(value = Url.INVOLVED_INFOS_KEEP_NO_KEEP_SHOW, results = {@Result(name = "SUCCESS", location = Url.VIEWS + "involved/no_keep_dispose_show.jsp")})
    public String noKeepShow() throws Exception {
        //获取当前登录的用户
        User user = this.getUser(request);
        //设置参数
        bean.setApproveState("2");
        bean.setStoreState("0");
        //查询数据
        involvedService.pageQuery(getPageBean(), bean);
        //获取分页数据
        List entityList = pageBean.getRows();
        //填充查询对象
        request.setAttribute("searchObj", bean);
        //填充分页对象
        this.handlePageData(entityList, pageBean, request);
        return "SUCCESS";
    }

    /**
     * 已保管财物（保管员）
     *
     * @throws Exception
     */
    @Action(value = Url.INVOLVED_INFOS_KEEP_KEEPED_SHOW, results = {@Result(name = "SUCCESS", location = Url.VIEWS + "involved/no_keep_dispose_show.jsp")})
    public String KeepedShow() throws Exception {
        //获取当前登录的用户
        User user = this.getUser(request);
        //设置参数
        bean.setApproveState("2");
        bean.setStoreState("1");
        //查询数据
        involvedService.pageQuery(getPageBean(), bean);
        //获取分页数据
        List entityList = pageBean.getRows();
        //填充查询对象
        request.setAttribute("searchObj", bean);
        //填充分页对象
        this.handlePageData(entityList, pageBean, request);
        return "SUCCESS";
    }

    /**
     * 未处置财物（保管员）
     *
     * @throws Exception
     */
    @Action(value = Url.INVOLVED_INFOS_DISPOSE_NO_DISPOSE_SHOW, results = {@Result(name = "SUCCESS", location = Url.VIEWS + "involved/no_keep_dispose_show.jsp")})
    public String noDisposeShow() throws Exception {
        //获取当前登录的用户
        User user = this.getUser(request);
        //设置参数
       bean.setDisposeState("2");
        bean.setStoreState("0");
        //查询数据
        involvedService.pageQuery(getPageBean(), bean);
        //获取分页数据
        List entityList = pageBean.getRows();
        //填充查询对象
        request.setAttribute("searchObj", bean);
        //填充分页对象
        this.handlePageData(entityList, pageBean, request);
        return "SUCCESS";
    }

    /**
     * 已处置财物（保管员）
     *
     * @throws Exception
     */
    @Action(value = Url.INVOLVED_INFOS_DISPOSE_DISPOSED_SHOW, results = {@Result(name = "SUCCESS", location = Url.VIEWS + "involved/no_keep_dispose_show.jsp")})
    public String disposedShow() throws Exception {
        //获取当前登录的用户
        User user = this.getUser(request);
        //设置参数
        bean.setDisposeState("2");
        bean.setStoreState("5");
        //查询数据
        involvedService.pageQuery(getPageBean(), bean);
        //获取分页数据
        List entityList = pageBean.getRows();
        //填充查询对象
        request.setAttribute("searchObj", bean);
        //填充分页对象
        this.handlePageData(entityList, pageBean, request);
        return "SUCCESS";
    }
}
