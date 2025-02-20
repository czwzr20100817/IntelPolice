package com.action;

import com.alibaba.fastjson.JSONObject;
import com.constant.Url;
import com.exception.WebMessageException;
import com.model.RecordQuestion;
import com.model.User;
import com.model.bean.*;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.service.*;
import com.service.impl.RecordQuestionServiceImpl;
import com.utils.ExecuteResult;
import com.utils.RandomUtils;
import com.utils.StoreUtil;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * 类名称：RecordQuestionAction 类描述：笔录问题
 */
@SuppressWarnings("serial")
// @ParentPackage("json-default")
@Action(value = Url.RECORD_QUESTION)
// 使用 convention-plugin 插件提供的@Action 注解将一个普通 java 类标注为一个可以处理用户请求的 Action，Action的名字为 struts2Test
// @Results({ @Result(name = "jsonmenu",params={"root","list"}, type = "json") })
// @Namespace("/")//使用 convention-plugin 插件提供的@Namespace 注解为这个 Action 指定一个命名空间
public class RecordQuestionAction extends BaseAction<RecordQuestionBean> implements ModelDriven<RecordQuestionBean> {
    @Autowired
    private RecordQuestionService service;
    @Autowired
    private CodeService codeService;
    @Autowired
    private RecordTypeService recordTypeService;
    @Autowired
    private RecordPersonService recordPersonService;
    @Autowired
    private CriminalService criminalService;
    private RecordQuestionBean bean = new RecordQuestionBean();

    @Override
    public RecordQuestionBean getModel() {
        return bean;
    }

    ActionContext context = ActionContext.getContext();
    private HttpServletRequest request = ServletActionContext.getRequest();

    @Action(value = Url.RECORD_QUESTION_PAGE_SHOW, results = {@Result(name = "SUCCESS", location = Url.VIEWS + "record/question/show.jsp")})
    public String index() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = null;
        //获取当前登录的用户
        User user = this.getUser(request);
        //查询数据
        service.pageQuery(getPageBean(), bean, null);
        //获取分页数据
        List entityList = pageBean.getRows();
        //填充查询对象
        request.setAttribute("searchObj", bean);
        //填充分页对象
        this.handlePageData(entityList, pageBean, request);
        //查询案件类型
        List<CodeBean> codeBeanList= codeService.findBeanListByField("CASECLASS");
        request.setAttribute("codeBeanList",codeBeanList);
        return "SUCCESS";
    }
    //搜索
    @Action(value = Url.RECORD_QUESTION_PAGE_SHOW1/*,results = {@Result(name = "SUCCESS", location = Url.VIEWS + "record/messageManage/in_writing/in_writing.jsp")}*/)
    public void index1() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = null;
        //获取当前登录的用户
        User user = this.getUser(request);
        String typeId = request.getParameter("typeId");
        List entityList = service.findDataAll(bean, typeId);
        try {
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.SUCCESS_STATUS, true);
        } catch (Exception e) {
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.ERROR_STATUS, e.getMessage());
        }
        response.getWriter().write(jsonObject.toJSONString(entityList));
    }
    /**
     * 添加页面
     *
     * @return
     */
    @Action(value = Url.RECORD_QUESTION_ADD_SHOW,
            results = {@Result(name = "SUCCESS", location = Url.VIEWS + "record/question/add_update_show.jsp")})
    public String showAdd() throws WebMessageException {
        //查询案件类型
        List<CodeBean> codeBeanList= codeService.findBeanListByField("CASECLASS");
        request.setAttribute("codeBeanList",codeBeanList);

        List<RecordTypeBean> recordTypeBeanList = recordTypeService.findAllByLevel();
        List<RecordTypeBean> recordTypeOneList = new ArrayList<RecordTypeBean>();
        for(int i = 0; i < recordTypeBeanList.size(); i++){
            if(recordTypeBeanList.get(i).getParentid() != null){
                if(recordTypeBeanList.get(i).getParentid().equals("01")){
                    recordTypeOneList.add(recordTypeBeanList.get(i));
                }
            }
        }
        if(recordTypeOneList.size() > 0){
            for(RecordTypeBean RecordTypeOne:recordTypeOneList){
                RecordTypeOne.setSonList(new ArrayList<RecordTypeBean>());
                for(RecordTypeBean RecordType:recordTypeBeanList){
                    if(RecordTypeOne.getId().equals(RecordType.getParentid())){
                        RecordTypeOne.getSonList().add(RecordType);
                    }
                }
            }
            for(RecordTypeBean RecordTypeOne:recordTypeOneList){
                if(RecordTypeOne.getSonList().size() > 0){
                    for(RecordTypeBean RecordTypeTwo:RecordTypeOne.getSonList()){
                        RecordTypeTwo.setSonList(new ArrayList<RecordTypeBean>());
                        for(RecordTypeBean RecordType:recordTypeBeanList){
                            if(RecordTypeTwo.getId().equals(RecordType.getParentid())){
                                RecordTypeTwo.getSonList().add(RecordType);
                            }
                        }
                    }
                }

            }
        }
        request.setAttribute("recordTypeBeanList", recordTypeOneList);

        return "SUCCESS";
    }

    /**
     * 添加
     *
     * @throws Exception
     */
    @Action(value = Url.RECORD_QUESTION_ADD_SUBMIT)
    public void addInvolved() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = null;
        //获取当前登录的用户
        User user = this.getUser(request);
        String type = request.getParameter("typeIdasd");
        //生成笔录问题编码
        String code = RandomUtils.RandomCode("Q",user.getDeptId());
        bean.setQuestionCode(code);
        //添加者id
        bean.setAddUser(user.getId());
        try {
            service.addBean(bean);//添加问题
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
    @Action(value = Url.RECORD_QUESTION_UPDATE_SHOW,
            results = {@Result(name = "SUCCESS", location = Url.VIEWS + "record/question/add_update_show.jsp")})
    public String showEdit() {
        try {
            List<RecordTypeBean> recordTypeBeanList = recordTypeService.findAllByLevel();
            List<RecordTypeBean> recordTypeOneList = new ArrayList<RecordTypeBean>();
            for(int i = 0; i < recordTypeBeanList.size(); i++){
                if(recordTypeBeanList.get(i).getParentid() != null){
                    if(recordTypeBeanList.get(i).getParentid().equals("01")){
                        recordTypeOneList.add(recordTypeBeanList.get(i));
                    }
                }
            }
            if(recordTypeOneList.size() > 0){
                for(RecordTypeBean RecordTypeOne:recordTypeOneList){
                    RecordTypeOne.setSonList(new ArrayList<RecordTypeBean>());
                    for(RecordTypeBean RecordType:recordTypeBeanList){
                        if(RecordTypeOne.getId().equals(RecordType.getParentid())){
                            RecordTypeOne.getSonList().add(RecordType);
                        }
                    }
                }
                for(RecordTypeBean RecordTypeOne:recordTypeOneList){
                    if(RecordTypeOne.getSonList().size() > 0){
                        for(RecordTypeBean RecordTypeTwo:RecordTypeOne.getSonList()){
                            RecordTypeTwo.setSonList(new ArrayList<RecordTypeBean>());
                            for(RecordTypeBean RecordType:recordTypeBeanList){
                                if(RecordTypeTwo.getId().equals(RecordType.getParentid())){
                                    RecordTypeTwo.getSonList().add(RecordType);
                                }
                            }
                        }
                    }

                }
            }
            request.setAttribute("recordTypeBeanList", recordTypeOneList);

            //查询案件类型
            List<CodeBean> codeBeanList= codeService.findBeanListByField("CASECLASS");
            request.setAttribute("codeBeanList",codeBeanList);
            RecordQuestionBean resultBean = service.findRecordQuestionBeanById(bean.getId());
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
    @Action(value = Url.RECORD_QUESTION_UPDATE_SUBMIT)
    public void updateInvolved() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = null;
        try {
            String type = request.getParameter("type1");
            service.updateBean(bean.getId(), bean);
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
    @Action(value = Url.RECORD_QUESTION_DELETE_SUBMIT)
    public void deleteInvolved() throws Exception {
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
     * 详情展示
     *
     * @throws Exception
     */
    @Action(value = Url.RECORD_QUESTION_DETAIL_SHOW,
            results = {@Result(name = "SUCCESS", location = Url.VIEWS + "record/question/detail.jsp")})
    public String getInvolvedById() throws Exception {
        try {
            //查询案件类型
            List<CodeBean> codeBeanList= codeService.findBeanListByField("CASECLASS");
            request.setAttribute("codeBeanList",codeBeanList);
            RecordQuestionBean bean2 = service.findRecordQuestionBeanById(bean.getId());
            request.setAttribute("entity", bean2);
        } catch (Exception e) {
            String resultMessage = e.getMessage();
            request.setAttribute("message", resultMessage);
        }
        return "SUCCESS";
    }
}
