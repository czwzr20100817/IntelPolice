package com.action;

import com.alibaba.fastjson.JSONObject;
import com.constant.CommonConstant;
import com.constant.Url;
import com.exception.WebMessageException;
import com.model.Files;
import com.model.User;
import com.model.bean.FilesBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.service.FilesService;
import com.utils.ExecuteResult;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 类名称：FilesAction 类描述：公告的实现
 */
// @ParentPackage("json-default")
@Action(value = Url.FILES)
// 使用 convention-plugin 插件提供的@Action 注解将一个普通 java 类标注为一个可以处理用户请求的 Action，Action的名字为 struts2Test
// @Results({ @Result(name = "jsonmenu",params={"root","list"}, type = "json") })
// @Namespace("/")//使用 convention-plugin 插件提供的@Namespace 注解为这个 Action 指定一个命名空间
public class FilesAction extends BaseAction<Files> implements ModelDriven<Files> {
    @Autowired
    private FilesService service;
    private FilesBean bean = new FilesBean();

    @Override
    public FilesBean getModel() {
        return bean;
    }

    ActionContext context = ActionContext.getContext();
    private HttpServletRequest request = ServletActionContext.getRequest();

    /**
     * 文件查询
     *
     * @return
     * @throws Exception
     */
    @Action(value = Url.FILES_PAGE_SHOW, results = {@Result(name = "SHOW", location = Url.VIEWS + "others/files/show.jsp"), @Result(name = "LIST", location = Url.VIEWS + "others/files/list.jsp")})
    public String index() throws Exception {
        // 获取当前登录的用户
        User user = this.getUser(request);
        // 查询数据
        service.pageQuery(getPageBean(), bean);
        // 获取分页数据
        List entityList = pageBean.getRows();
        // 填充查询对象
        request.setAttribute("searchObj", bean);
        // 填充分页对象
        this.handlePageData(entityList, pageBean, request);
        if (bean.getStatus() != null && bean.getStatus().equals("1")) {
            return "LIST";
        } else {
            return "SHOW";
        }
    }

    /**
     * 添加页面
     *
     * @return
     */
    @Action(value = Url.FILES_ADD_UPLOAD_SHOW, results = {
            @Result(name = "SUCCESS", location = Url.VIEWS + "uploader.jsp")})
    public String showAddUpload() {
        String currentType = request.getParameter("currentType");
        request.setAttribute("currentType",currentType);
        return "SUCCESS";
    }

    /**
     * 添加文件展示详情
     *
     * @return
     */
    @Action(value = Url.FILES_ADD_DETAIL_SHOW, results = {
            @Result(name = "SUCCESS", location = Url.VIEWS + "others/files/add_update_show.jsp")})
    public String showAddDetail() {
        String currentType = request.getParameter("currentType");
        request.setAttribute("currentType",currentType);
        return "SUCCESS";
    }



    /**
     * 新增
     *
     * @throws Exception
     */
    @Action(value = Url.FILES_ADD_SUBMIT)
    public void add() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = null;
        try {
            service.addBean(bean);
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
    @Action(value = Url.FILES_UPDATE_SHOW, results = {
            @Result(name = "SUCCESS", location = Url.VIEWS + "others/files/add_update_show.jsp")})
    public String showEdit() {
        try {
            FilesBean resultBean = service.findFilesById(bean.getId());
            request.setAttribute("entity", resultBean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "SUCCESS";
    }

    /**
     * 编辑
     *
     * @throws Exception
     */
    @Action(value = Url.FILES_UPDATE_SUBMIT)
    public void update() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = null;
        try {
            service.updateBean(bean.getId(), bean);
            // 返回操作成功标志200， 并关闭对话框
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.SUCCESS_STATUS, true);
        } catch (Exception e) {
            // 返回失败标识，并写入错误信息
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.ERROR_STATUS, e.getMessage());
        }
        response.getWriter().write(jsonObject.toJSONString());
    }

    /**
     * 删除
     *
     * @throws Exception
     */
    @Action(value = Url.FILES_DELETE_SUBMIT)
    public void delete() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = null;
        try {
            service.deleteBean(bean.getId());
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.SUCCESS_STATUS, null);
        } catch (Exception e) {
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.ERROR_STATUS, e.getMessage());
        }
        response.getWriter().write(jsonObject.toJSONString());
    }

    /**
     * 设置显示/隐藏
     *
     * @throws Exception
     */
    @Action(value = Url.FILES_SETENABLE_SUBMIT)
    public void setLookAble() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = null;
        try {
            service.setEnable(bean.getId());
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
    @Action(value = Url.FILES_DETAIL_SHOW,
            results = {@Result(name = "SUCCESS", location = Url.VIEWS + "others/files/detail.jsp")})
    public String getDetails() throws Exception {
        try {
            FilesBean bean2 = service.findFilesById(bean.getId());
            request.setAttribute("entity", bean2);
        } catch (Exception e) {
            String resultMessage = e.getMessage();
            request.setAttribute("message", resultMessage);
        }
        return "SUCCESS";
    }

    /**
     * 扣押清单模板查询
     *
     * @return
     * @throws Exception
     */
    @Action(value = Url.FILES_LIST_DETAIN_PAGE_SHOW, results = {@Result(name = "SHOW", location = Url.VIEWS + "others/files/show.jsp"), @Result(name = "LIST", location = Url.VIEWS + "others/files/list.jsp")})
    public String detain() throws Exception {
        try {
            // 获取当前登录的用户
            User user = this.getUser(request);
            // 查询数据
            service.findBeanPageForModule(getPageBean(), bean, CommonConstant.FILE_LIST_DETAIN);
            // 获取分页数据
            List entityList = pageBean.getRows();
            // 填充查询对象
            request.setAttribute("searchObj", bean);
            request.setAttribute("currentType", "11");
            // 填充分页对象
            this.handlePageData(entityList, pageBean, request);
        } catch (WebMessageException e) {
            e.printStackTrace();
            request.setAttribute("message", e.getMessage());
            return "ERROR";
        }
        return "SHOW";
    }

    /**
     * 入库清单模板查询
     *
     * @return
     * @throws Exception
     */
    @Action(value = Url.FILES_LIST_IN_PAGE_SHOW, results = {@Result(name = "SHOW", location = Url.VIEWS + "others/files/show.jsp"), @Result(name = "LIST", location = Url.VIEWS + "others/files/list.jsp")})
    public String in() throws Exception {
        try {
            // 获取当前登录的用户
            User user = this.getUser(request);
            // 查询数据
            service.findBeanPageForModule(getPageBean(), bean, CommonConstant.FILE_LIST_IN);
            // 获取分页数据
            List entityList = pageBean.getRows();
            // 填充查询对象
            request.setAttribute("searchObj", bean);
            request.setAttribute("currentType", "12");
            // 填充分页对象
            this.handlePageData(entityList, pageBean, request);
        } catch (WebMessageException e) {
            e.printStackTrace();
            request.setAttribute("message", e.getMessage());
            return "ERROR";
        }
        return "SHOW";
    }

    /**
     * 提取清单模板查询
     *
     * @return
     * @throws Exception
     */
    @Action(value = Url.FILES_LIST_EXTRACT_PAGE_SHOW, results = {@Result(name = "SHOW", location = Url.VIEWS + "others/files/show.jsp"), @Result(name = "LIST", location = Url.VIEWS + "others/files/list.jsp")})
    public String extract() throws Exception {
        try {
            // 获取当前登录的用户
            User user = this.getUser(request);
            // 查询数据
            service.findBeanPageForModule(getPageBean(), bean, CommonConstant.FILE_LIST_EXTRACT);
            // 获取分页数据
            List entityList = pageBean.getRows();
            // 填充查询对象
            request.setAttribute("searchObj", bean);
            request.setAttribute("currentType", "13");
            // 填充分页对象
            this.handlePageData(entityList, pageBean, request);
        } catch (WebMessageException e) {
            e.printStackTrace();
            request.setAttribute("message", e.getMessage());
            return "ERROR";
        }
        return "SHOW";
    }

    /**
     * 移交清单模板查询
     *
     * @return
     * @throws Exception
     */
    @Action(value = Url.FILES_LIST_TRANSFER_PAGE_SHOW, results = {@Result(name = "SHOW", location = Url.VIEWS + "others/files/show.jsp"), @Result(name = "LIST", location = Url.VIEWS + "others/files/list.jsp")})
    public String transfer() throws Exception {
        try {
            // 获取当前登录的用户
            User user = this.getUser(request);
            // 查询数据
            service.findBeanPageForModule(getPageBean(), bean, CommonConstant.FILE_LIST_TRANSFER);
            // 获取分页数据
            List entityList = pageBean.getRows();
            // 填充查询对象
            request.setAttribute("searchObj", bean);
            request.setAttribute("currentType", "14");
            // 填充分页对象
            this.handlePageData(entityList, pageBean, request);
        } catch (WebMessageException e) {
            e.printStackTrace();
            request.setAttribute("message", e.getMessage());
            return "ERROR";
        }
        return "SHOW";
    }

    /**
     * 出库清单模板查询
     *
     * @return
     * @throws Exception
     */
    @Action(value = Url.FILES_LIST_OUT_PAGE_SHOW, results = {@Result(name = "SHOW", location = Url.VIEWS + "others/files/show.jsp"), @Result(name = "LIST", location = Url.VIEWS + "others/files/list.jsp")})
    public String out() throws Exception {
        try {
            // 获取当前登录的用户
            User user = this.getUser(request);
            // 查询数据
            service.findBeanPageForModule(getPageBean(), bean, CommonConstant.FILE_LIST_OUT);
            // 获取分页数据
            List entityList = pageBean.getRows();
            // 填充查询对象
            request.setAttribute("searchObj", bean);
            request.setAttribute("currentType", "15");
            // 填充分页对象
            this.handlePageData(entityList, pageBean, request);
        } catch (WebMessageException e) {
            e.printStackTrace();
            request.setAttribute("message", e.getMessage());
            return "ERROR";
        }
        return "SHOW";
    }
}