package com.action;

import com.alibaba.fastjson.JSONObject;
import com.constant.CommonConstant;
import com.constant.Indicator;
import com.constant.Url;
import com.constant.WebExceptionConstant;
import com.exception.WebMessageException;
import com.model.Message;
import com.model.RecordPerson;
import com.model.User;
import com.model.bean.*;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.page.PageBean;
import com.service.*;
import com.utils.*;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.*;

/**
 * 类名称：LoginAction 类描述：用户控制器的实现
 */
@Action(value = Url.RECORD_PERSON)
public class RecordPersonAction extends BaseAction<RecordPersonBean> implements ModelDriven<RecordPersonBean> {
    private RecordPersonBean bean = new RecordPersonBean();

    @Override
    public RecordPersonBean getModel() {
        return bean;
    }
    @Autowired
    private RecordPersonService recordPersonService;
    @Autowired
    private RecordQuestionService recordQuestionService;
    @Autowired
    private CriminalService criminalService;
    @Autowired
    private RecordTypeService recordTypeService;
    //根路径，到时可以换成ftp 路径
    private String basePath = CommonConstant.FILE_UPLOAD_PATH;
    //分割字符串
    private String regex = CommonConstant.FILE_UPLOAD_REGEX;

    ActionContext context = ActionContext.getContext();
    private HttpServletRequest request = ServletActionContext.getRequest();
    private HttpServletResponse response = ServletActionContext.getResponse();
    private HttpSession session =  request.getSession();

    @Action(value = Url.RECORD_PERSON_PAGE_SHOW, results = {
            @Result(name = "SUCCESS", location = Url.VIEWS + "authority/person/show.jsp")})
    public String index() throws Exception {
        //获取当前登录的用户
        User user = this.getUser(request);
        //查询数据
        recordPersonService.pageQuery(getPageBean(), bean);
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
    @Action(value = Url.RECORD_PERSON_ADD_SHOW,
            results = {@Result(name = "SUCCESS", location = Url.VIEWS + "authority/person/add_update_show.jsp")})
    public String showAdd() {

        return "SUCCESS";
    }

    /**
     * 添加
     *
     * @throws Exception
     */
    @Action(value = Url.RECORD_PERSON_ADD_SUBMIT)
    public void addMenu() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = null;
        try {
            //上传图片
            try {
                for (int i = 0; i < bean.getFileBean().getFile().size(); i++) {
                    //文件名称
                    String name = bean.getFileBean().getFileFileName().get(i);
                    String fileName = ServiceUtils.generatePrimaryKey() + name.substring(name.lastIndexOf("."));

                    //文件路径
                    String filePath = DateUtils.dateToString(new Date(), "/yyyy/MM/dd/HH");
                    bean.setPic(filePath+ "/" + fileName);
                    //目标文件
                    File diestFile = new File(basePath + filePath, fileName);
                    System.out.println(filePath + fileName);
                    System.out.println(diestFile.getPath());
                    FileUploadUtils.upload(bean.getFileBean().getFile().get(i), diestFile);
                    jsonObject = new JSONObject();
                    jsonObject.put("statusCode", 200);
                    double fileSize = bean.getFileBean().getFile().get(i).length();
                    String size = "";
                    if (fileSize < 1000) {
                        size = fileSize + "B";
                    };
                    if (fileSize >= 1000) {
                        fileSize = fileSize / 1000;
                        size = fileSize + "KB";
                    };
                    if (fileSize >= 1000) {
                        fileSize = fileSize / 1000;
                        size = fileSize + "MB";
                    };
                    jsonObject.put("name", bean.getFileBean().getFileFileName().get(i));
                    jsonObject.put("size", size);
                    jsonObject.put("path", filePath + "/" + fileName);
                    jsonObject.put("message", "上传成功");
                    break;
                }
            } catch (Exception e) {
                jsonObject = ExecuteResult.jsonReturnCallOnAppException(ExecuteResult.ERROR_STATUS, e.getMessage());
            }

            recordPersonService.addBean(bean);

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
    @Action(value = Url.RECORD_PERSON_UPDATE_SHOW,
            results = {@Result(name = "SUCCESS", location =Url.VIEWS + "authority/person/add_update_show.jsp")})
    public String showEdit() {
        try {
            RecordPersonBean resultBean = recordPersonService.findRecordById(bean.getPersonId());
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
    @Action(value = Url.RECORD_PERSON_UPDATE_SUBMIT)
    public void updateMenu() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = null;
        String path = "";
        String  old = recordPersonService.findRecordById(bean.getPersonId()).getPic();
        if(!old.equals(bean.getPersonId())){
            //上传图片
            try {
                for (int i = 0; i < bean.getFileBean().getFile().size(); i++) {
                    //文件名称
                    String name = bean.getFileBean().getFileFileName().get(i);
                    String fileName = ServiceUtils.generatePrimaryKey() + name.substring(name.lastIndexOf("."));

                    //文件路径
                    String filePath = DateUtils.dateToString(new Date(), "/yyyy/MM/dd/HH");
                    path = filePath+ "/" + fileName;
                    //目标文件
                    File diestFile = new File(basePath + filePath, fileName);
                    System.out.println(filePath + fileName);
                    System.out.println(diestFile.getPath());
                    FileUploadUtils.upload(bean.getFileBean().getFile().get(i), diestFile);
                    jsonObject = new JSONObject();
                    jsonObject.put("statusCode", 200);
                    double fileSize = bean.getFileBean().getFile().get(i).length();
                    String size = "";
                    if (fileSize < 1000) {
                        size = fileSize + "B";
                    };
                    if (fileSize >= 1000) {
                        fileSize = fileSize / 1000;
                        size = fileSize + "KB";
                    };
                    if (fileSize >= 1000) {
                        fileSize = fileSize / 1000;
                        size = fileSize + "MB";
                    };
                    jsonObject.put("name", bean.getFileBean().getFileFileName().get(i));
                    jsonObject.put("size", size);
                    jsonObject.put("path", filePath + "/" + fileName);
                    jsonObject.put("message", "上传成功");
                    break;
                }
            } catch (Exception e) {
                jsonObject = ExecuteResult.jsonReturnCallOnAppException(ExecuteResult.ERROR_STATUS, e.getMessage());
            }
            //删除照片
            FileUtils.deleteFile(bean.getPic());
            //设置新路径
            bean.setPic(path);
        }
        try {
            recordPersonService.updateBean(bean.getPersonId(), bean);
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
    @Action(value = Url.RECORD_PERSON_DELETE_SUBMIT)
    public void deleteMenu() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = null;
        try {
            recordPersonService.deleteBean(bean.getPersonId());
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
    @Action(value = Url.RECORD_PERSON_DETAIL_SHOW,
            results = {@Result(name = "SUCCESS", location = Url.VIEWS + "authority/person/detail.jsp")})
    public String getMenuById() throws Exception {
        try {
            RecordPersonBean bean2 = recordPersonService.findRecordById(bean.getPersonId());
            request.setAttribute("entity", bean2);
        } catch (Exception e) {
            String resultMessage = e.getMessage();
            request.setAttribute("message", resultMessage);
        }
        return "SUCCESS";
    }


    /**
     * 员工树
     *
     * @return
     * @throws Exception
     */
    @Action(value = Url.RECORD_PERSON_TREE_SHOW, results = {
            @Result(name = "SUCCESS", location = Url.VIEWS + "authority/person/person_tree.jsp")})
    public String index2() throws Exception {
        // 查询数据
        recordPersonService.pageQuery(getPageBean(), bean);
        // 获取分页数据
        List entityList = pageBean.getRows();
        // 填充查询对象
        request.setAttribute("searchObj", bean);
        // 填充分页对象
        this.handlePageData(entityList, pageBean, request);

        String status = request.getParameter("status");
        return "SUCCESS";
    }

    /**
     * 员工树多选
     *
     * @return
     * @throws Exception
     */
    @Action(value = Url.RECORD_PERSON_TREE_SHOW1, results = {
            @Result(name = "SUCCESS", location = Url.VIEWS + "authority/person/person_tree1.jsp")})
    public String index3() throws Exception {
        // 查询数据
        recordPersonService.pageQuery(getPageBean(), bean);
        // 获取分页数据
        List entityList = pageBean.getRows();
        // 填充查询对象
        request.setAttribute("searchObj", bean);
        // 填充分页对象
        this.handlePageData(entityList, pageBean, request);

        String status = request.getParameter("status");
        return "SUCCESS";
    }
    /**
     * 讯问笔录
     *
     * @return
     * @throws Exception
     */
    @Action(value = Url.RECORD_IN_WRITING_PERSON_SHOW)
    public void interrogation() throws Exception {
        String status = request.getParameter("status");//讯/询问 状态 0
        String userId = request.getParameter("userId");//讯/询问人
        String userId1 = request.getParameter("userId1");//笔录人
        String caseIdPerson1 = request.getParameter("caseIdPerson1");//案件
        String typeId = request.getParameter("type");//问题类型
        String modelId = request.getParameter("model");//模板
        String[] personesId = request.getParameterValues("personesId");
        session.setAttribute("personesId",personesId);
        request.setAttribute("status",status);
        session.setAttribute("userId",userId);
        session.setAttribute("caseId",caseIdPerson1);
        session.setAttribute("userId1",userId1);
        session.setAttribute("statusPerson",status);
        session.setAttribute("typeId",typeId);
        session.setAttribute("modelId",modelId);
        session.setAttribute("person",recordPersonService.findRecordById(bean.getPersonId()));
       JSONObject jsonObject = null;
        try {
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.SUCCESS_STATUS, null);
        } catch (Exception e) {
            jsonObject = ExecuteResult.jsonReturn(ExecuteResult.ERROR_STATUS, e.getMessage());
        }
        response.getWriter().write(jsonObject.toJSONString());
    }
    @Action(value = Url.RECORD_IN_WRITING_SHOW, results = {
            @Result(name = "SUCCESS", location = Url.VIEWS + "record/messageManage/in_writing/in_writing.jsp"),
            @Result(name = "SUCCESS1", location = Url.VIEWS + "record/messageManage/identification/identification.jsp")})//identification/identification.jsp
    public String interrogation1() throws Exception {
        String typeId = (String)session.getAttribute("typeId");
        String caseId = (String)session.getAttribute("caseId");
        String modelId =(String)session.getAttribute("modelId");
        String[] personesId =  (String[])session.getAttribute("personesId");
        List<RecordPersonBean> personList = new ArrayList<>();
        for (int i = 0; i < personesId.length; i++){
            if(personesId[i] != null && personesId[i].length() > 0){
                personList.add(recordPersonService.findRecordById(personesId[i]));
            }
        }
        session.removeAttribute("personesId");
        session.removeAttribute("modelId");
        request.setAttribute("modelId",modelId);
        request.setAttribute("typeId",typeId);//模板类型Id
        request.setAttribute("userId",session.getAttribute("userId"));//主案人
        session.removeAttribute("userId");
        request.setAttribute("userId1",session.getAttribute("userId1"));//笔录人
        session.removeAttribute("userId1");
        String status =(String) session.getAttribute("statusPerson");
        request.setAttribute("status",status);
        session.removeAttribute("status");

        //模板类型储存的问题
        List<RecordQuestionBean> list = recordQuestionService.findDataByType(typeId);
        request.setAttribute("recordQuestionList",list);
        request.setAttribute("typeId",typeId);

        //所有类型
        List<RecordTypeBean> typeList = recordTypeService.findMenuBeanList();
        List<RecordTypeBean> recordTypeList = new ArrayList<>();
        //获取只含叶节和不包括自己
        for (RecordTypeBean recordTypeBean : typeList) {
            if(!typeId.equals(recordTypeBean.getId())){
                if(recordTypeBean.getOrder() != null && "0".equals(recordTypeBean.getOrder())){
                    recordTypeList.add(recordTypeBean);
                }
            }

        }
        request.setAttribute("recordTypeList",recordTypeList);
        //获取所有问题
        BaseAction<RecordQuestionBean> page = new BaseAction<RecordQuestionBean>();
        // 查询数据
        recordQuestionService.pageQuery(page.getPageBean(), new RecordQuestionBean(),typeId);
        // 获取分页数据
        List entityList = page.pageBean.getRows();
        // 填充查询对象
        request.setAttribute("entityList",entityList);
        // 填充分页对象
        page.handlePageData(entityList, page.pageBean, request);
        //讯问、讯问人
        RecordPersonBean recordPersonBean =(RecordPersonBean)session.getAttribute("person");
        request.setAttribute("person",recordPersonBean);
        session.removeAttribute("person");

        //案件信息
        request.setAttribute("caseS",criminalService.findCriminalById(caseId));

        //001 讯问、询问，jsp  002 辨认jsp
        if("002".equals(modelId)){
            request.setAttribute("personList",personList);
            return "SUCCESS1";
        }
        return "SUCCESS";
    }
    /**
     * 询问笔录
     *
     * @return
     * @throws Exception
     */
    @Action(value = Url.RECORD_INQUIRY_SHOW, results = {
            @Result(name = "SUCCESS", location = Url.VIEWS + "record/messageManage/identification/identification.jsp")})
    public String inquiry() throws Exception {
        String status = request.getParameter("status");//询问 状态 1
        String userId = request.getParameter("userId");//询问人
        String userId1 = request.getParameter("userId1");//笔录人
        request.setAttribute("userId",userId);
        request.setAttribute("userId1",userId1);
        request.setAttribute("person",recordPersonService.findRecordById(bean.getPersonId()));
        List<RecordQuestionBean> list = recordQuestionService.findDataByType(status);
        request.setAttribute("recordQuestionList",list);
        return "SUCCESS";
    }
}
