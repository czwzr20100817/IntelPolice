package com.constant;

/**
 * 此类的作用是，定义全局的url 路径属性 整个项目的的请求路径从此处获取，保存（*.jsp *.action）
 *
 * @author Administrator
 */
public class Url {
    /**
     * 临时jd
     */
    public static final String JD = "/jd";                // 临时控制器
    public static final String JD_MEDIA = "/jd/media";                // 临时音视频展示
    public static final String JD_CASE = "/jd/case";                // 临时案事件监督展示
    public static final String JD_MESSAGE = "/jd/message";                // 临时消息展示
    public static final String JD_INVOLVED = "/jd/involved";                // 临时财务展示
    public static final String JD_BIGSHOW = "/jd/bigShow";                // 临时大屏展示
    /**
     * 文件上传下载
     */
    public static final String FILE_UPLOAD = "/file/upload";                // 文件上传
    public static final String FILE_DOWNLOAD = "/file/download";            // 文件下载
    /**
     * DEMO
     */
    public static final String DEMO = "/demoAction"; // 控制器
    public static final String DEMO_PAGE_SHOW = "/demo/page_show";// 页面展示
    public static final String DEMO_DATA = "/demo/data"; // 获取json数据
    public static final String DEMO_ADD_SHOW = "/demo/add_show";// 添加-页面
    public static final String DEMO_ADD_SUBMIT = "/demo/add_submit";// 添加-提交
    public static final String DEMO_UPDATE_SHOW = "/demo/update_show";// 编辑-页面
    public static final String DEMO_UPDATE_SUBMIT = "/demo/update_submit";// 编辑-提交
    public static final String DEMO_DELETE_SUBMIT = "/demo/delete_submit";// 删除-提交
    public static final String DEMO_QUERY = "/demo/query";// 查询
    public static final String DEMO_EXCEL = "/demo/excel";// EXCEL导出
    public static final String DEMO_DETAIL_SHOW = "/demo/detail_show";// 详情
    /**
     * 系统根目录
     */
    public static final String VIEWS = "/WEB-INF/views/";
    public static final String ROOT = "IntelPolice";
    public static final String INTELVIEWS = "/IntelPolice/WEB-INF/views/";
    /**
     * 系统参数设置
     */
    public static final String SYSTEM_SETTINGS_SHOW = "/system/settings_show";                                //系统参数设置页面
    public static final String SYSTEM_SETTINGS_CURRENT_DEPT_SUBMIT = "/system/settings_current_dept_submit";                        //系统参数当前使用网点提交
    /**
     * Archive 卷宗信息表
     */

    public static final String ARCHIVE = "/archiveAction";// 控制器
    public static final String ARCHIVE_PAGE_SHOW = "/archive/page_show";// 页面展示
    public static final String ARCHIVE_ADD_SHOW = "/archive/add_show";// 添加-页面
    public static final String ARCHIVE_ADD_SUBMIT = "/archive/add_submit";// 添加-提交
    public static final String ARCHIVE_UPDATE_SHOW = "/archive/update_show";// 编辑-页面
    public static final String ARCHIVE_UPDATE_SUBMIT = "/archive/update_submit";// 编辑-提交
    public static final String ARCHIVE_DELETE_SUBMIT = "/archive/delete_submit";// 删除-提交
    public static final String ARCHIVE_EXCEL = "/archive/excel";// EXCEL导出
    public static final String ARCHIVE_DETAIL_SHOW = "/archive/detail";// 详情
    public static final String ARCHIVE_NO_INPUT_SHOW = "/archive/no_input_show";// 未录入卷宗案件
    public static final String ARCHIVE_INFOS_CASE_SHOW = "/archive/case_show"; // 同步卷宗
    public static final String ARCHIVE_INPUT_SHOW = "/archive/input_show";// 已录入卷宗案件
    public static final String ARCHIVE_NOT_INPUT_SHOW = "/archive/not_input_show";// 无需录入卷宗案件
    public static final String ARCHIVE_NOT_INPUT_SUBMIT = "/archive/not_input_submit";// 无需录入卷宗确认
    public static final String ARCHIVE_ADD_UPLOAD_SHOW = "/archive/add_upload_show";// 添加-上传-页面
    public static final String ARCHIVE_ADD_DETAIL_SHOW = "/archive/add_detail_show";// 添加-详情-页面
    public static final String ARCHIVE_IMG_SHOW1 = "/archive/imgShow";// 图片展示
    /**
     * ArchiveCase 卷宗案件关联表
     */
    public static final String ARCHIVE_CASE = "/archiveCaseAction";// 控制器
    public static final String ARCHIVE_CASE_PAGE_SHOW = "/archiveCase/page_show";// 页面展示
    public static final String ARCHIVE_CASE_ADD_SHOW = "/archiveCase/add_show";// 添加-页面
    public static final String ARCHIVE_CASE_ADD_SUBMIT = "/archiveCase/add_submit";// 添加-提交
    public static final String ARCHIVE_CASE_UPDATE_SHOW = "/archiveCase/update_show";// 编辑-页面
    public static final String ARCHIVE_CASE_UPDATE_SUBMIT = "/archiveCase/update_submit";// 编辑-提交
    public static final String ARCHIVE_CASE_DELETE_SUBMIT = "/archiveCase/delete_submit";// 删除-提交
    public static final String ARCHIVE_CASE_EXCEL = "/archiveCase/excel";// EXCEL导出
    public static final String ARCHIVE_CASE_DETAIL_SHOW = "/archiveCase/detail";// 查看案件关联卷宗信息
    public static final String ARCHIVE_CASE_ADDNEW_SHOW = "/archiveCase/addNew_submit";// 同步卷宗
    /**
     * ArchiveStores 卷宗仓库
     */
    public static final String ARCHIVE_STORES = "/archiveStoresAction";// 控制器
    public static final String ARCHIVE_STORES_PAGE_SHOW = "/archiveStores/page_show";// 页面展示
    public static final String ARCHIVE_STORES_ADD_SHOW = "/archiveStores/add_show";// 添加-页面
    public static final String ARCHIVE_STORES_ADD_SUBMIT = "/archiveStores/add_submit";// 添加-提交
    public static final String ARCHIVE_STORES_UPDATE_SHOW = "/archiveStores/update_show";// 编辑-页面
    public static final String ARCHIVE_STORES_UPDATE_SUBMIT = "/archiveStores/update_submit";// 编辑-提交
    public static final String ARCHIVE_STORES_DELETE_SUBMIT = "/archiveStores/delete_submit";// 删除-提交
    public static final String ARCHIVE_STORES_EXCEL = "/archiveStores/excel";// EXCEL导出
    public static final String ARCHIVE_STORES_TREE_SHOW = "/archiveStores/tree_show";// 仓库柜子树
    public static final String ARCHIVE_STORES_DETAIL_SHOW = "/archiveStores/detail";// 详情
    /**
     * ArchiveStoresBox 卷宗柜箱子
     */
    public static final String ARCHIVE_STORES_BOX = "/archiveStoresBoxAction";// 控制器
    public static final String ARCHIVE_STORES_BOX_PAGE_SHOW = "/archiveStoresBox/page_show";// 页面展示
    public static final String ARCHIVE_STORES_BOX_PAGE_DATA = "/archiveStoresBox/page_data";// 获得数据
    public static final String ARCHIVE_STORES_BOX_ADD_SHOW = "/archiveStoresBox/add_show";// 添加-页面
    public static final String ARCHIVE_STORES_BOX_ADD_SUBMIT = "/archiveStoresBox/add_submit";// 添加-提交
    public static final String ARCHIVE_STORES_BOX_UPDATE_SHOW = "/archiveStoresBox/update_show";// 编辑-页面
    public static final String ARCHIVE_STORES_BOX_UPDATE_SUBMIT = "/archiveStoresBox/update_submit";// 编辑-提交
    public static final String ARCHIVE_STORES_BOX_DELETE_SUBMIT = "/archiveStoresBox/delete_submit";// 删除-提交
    public static final String ARCHIVE_STORES_BOX_EXCEL = "/archiveStoresBox/excel";// EXCEL导出
    public static final String ARCHIVE_STORES_BOX_DETAIL_SHOW = "/archiveStoresBox/detail";// 详情
    public static final String ARCHIVE_STORES_BOX_OPEN_BOX = "/archiveStoresBox/openBoxasdas";//开锁
    public static final String ARCHIVE_STORES_BOX_ADD_CASE_SUBMIT = "/archiveStoresBox/add_case_submit";// 添加案件关联-提交
    public static final String ARCHIVE_STORES_BOX_ADD_AR_SUBMIT = "/archiveStoresBox/add_AR_submit";// 添加卷宗关联-提交
    public static final String ARCHIVE_STORES_BOX_WARE_SHOW = "/archiveStoresBox/ware_show";//入库-页面
    public static final String ARCHIVE_STORES_BOX_WARE_SUBMIT = "/archiveStoresBox/ware_submit";//入库-提交

    public static final String ARCHIVE_STORES_BOX_TODAY_BOX = "/archiveStoresBox/isDeposit";//是否当天存入
    /**
     * ArchiveStoresLockers 卷宗柜
     */
    public static final String ARCHIVE_STORES_LOCKERS = "/archiveStoresLockersAction";// 控制器
    public static final String ARCHIVE_STORES_LOCKERS_PAGE_SHOW = "/archiveStoresLockers/page_show";// 页面展示
    public static final String ARCHIVE_STORES_LOCKERS_ADD_SHOW = "/archiveStoresLockers/add_show";// 添加页面
    public static final String ARCHIVE_STORES_LOCKERS_TREE_SHOW = "/archiveStoresLockers/tree_show";// 仓库柜子模态框展示
    public static final String ARCHIVE_STORES_LOCKERS_ADD_SUBMIT = "/archiveStoresLockers/add_submit";        // 添加提交
    public static final String ARCHIVE_STORES_LOCKERS_DETAIL_SHOW = "/archiveStoresLockers/detail_show";    // 详情
    public static final String ARCHIVE_STORES_LOCKERS_UPDATE_SHOW = "/archiveStoresLockers/update_show";    // 修改页面
    public static final String ARCHIVE_STORES_LOCKERS_UPDATE_SUBMIT = "/archiveStoresLockers/update_submit";// 修改提交
    public static final String ARCHIVE_STORES_LOCKERS_DELETE_SUBMIT = "/archiveStoresLockers/delete_submit";// 删除
    /**
     * Case 受立案监督
     */
    public static final String CASE = "/caseAction";// 控制器
    public static final String CASE_PAGE_SHOW = "/case/page_show";// 页面展示
    public static final String CASE_DETAIL_SHOW = "/case/detail";// 详情
    //--------------------------------------------------------------------------------
    public static final String ABNORMAL_CONFIRM_PAGE_SHOW = "/case/abnormalConfirm/page_show";// 已确认异常页面展示
    public static final String ABNORMAL_CONFIRM_DETAIL_SHOW = "/case/abnormalConfirm/detail";// 已确认异常详情
    /**
     * CJ处警单
     */
    public static final String CJ = "/cjAction";// 控制器
    public static final String CJ_PAGE_SHOW = "/cj/page_show";// 页面展示
    public static final String CJ_EXCEL = "/cj/excel";// EXCEL导出
    public static final String CJ_DETAIL_SHOW = "/cj/detail";// 详情

    public static final String CJ_TIMEOUT_UNTREATED_SHOW = "/jj/unrelated/timeout_untreated";// 超时未反馈
    public static final String CJ_TIMEOUT_UNTREATED_DETAIL_SHOW = "/cj/unrelated/timeout_untreated_detail";// 超时未反馈详情

    public static final String CJ_TIMEOUT_CSWLA_SHOW = "/cj/timeout_wla/timeout_wla";// 超时未立案
    public static final String CJ_TIMEOUT_CSWLA_DETAIL_SHOW = "/cj/timeout_wla/timeout_wla_detail";// 超时未立案详情

    public static final String CJ_TIMEOUT_CSLA_SHOW = "/cj/timeout_la/timeout_la";// 超时立案
    public static final String CJ_TIMEOUT_CSLA_DETAIL_SHOW = "/cj/timeout_la/timeout_wla_detail";// 超时立案详情

    public static final String CJ_FEEDBACKS_SHOW = "/cj/feedbacks/page_show";// 多反馈
    public static final String CJ_FEEDBACKS_DETAIL_SHOW = "/cj/feedbacks/detail";// 多反馈详情

    public static final String  CJ_NOTCORRELATE_VIEW_SHOW="/cj/selectCJNotView";
    public static final String  CJ_CORRELATE_VIEW_SHOW="/cj/selectCJView";
    /**
     * CMD 110指令表
     */
    public static final String CMD = "/cmdAction";// 控制器
    public static final String CMD_PAGE_SHOW = "/cmd/page_show";// 页面展示
    public static final String CMD_EXCEL = "/cmd/excel";// EXCEL导出
    public static final String CMD_DETAIL_SHOW = "/cmd/detail";// 详情
    /**
     * Criminal 案事件
     */
    public static final String CRIMINAL = "/criminalAction";// 控制器
    public static final String CRIMINAL_PAGE_SHOW = "/criminal/page_show";// 页面展示
    public static final String CRIMINAL_EXCEL = "/criminal/excel";// EXCEL导出
    public static final String CRIMINAL_DETAIL_SHOW = "/criminal/detail";// 详情

    public static final String CRIMINAL_NOTJCJ_PAGE_SHOW = "/criminal/notJcj/page_show";// 页面展示(无接处警异常)
    public static final String CRIMINAL_NOTJCJ_DETAIL_SHOW = "/criminal/notJcj/detail";// 详情(无接处警异常)

    public static final String CRIMINAL_ZJSL_PAGE_SHOW = "/criminal/zjsl/page_show";// 页面展示(直接受理)
    public static final String CRIMINAL_ZJSL_DETAIL_SHOW = "/criminal/notJcj/detail";// 详情(直接受理)


    public static final String CRIMINAL_SMS_NOTCG_PAGE_SHOW = "/criminal/page_wcg_show";// 回告未成功页面展示
    public static final String CRIMINAL_SMS_NOTFS_PAGE_SHOW = "/criminal/page_wfs_show";// 回告未发送页面展示
    public static final String CRIMINAL_SMS_CF_PAGE_SHOW = "/criminal/page_cf_show";// 回告重复页面展示

    public static final String CRIMINAL_NOTCORRELATE_VIEW_SHOW="/criminal/selectCriminalNotView";//没关联音视频案件展示
    public static final String CRIMINAL_CORRELATE_VIEW_SHOW="/criminal/selectCriminalView";//已关联视音频案件展示
    /**
     * Dept 部门
     */
    public static final String DEPT = "/deptAction";// 控制器
    public static final String DEPT_SHOW_BY_PARENTID = "/dept/show_by_parentid";// 控制器
    public static final String DEPT_SHOW_BY_ID = "/dept/show_by_id";                        // 通过id 查询deptBean
    public static final String DEPT_ALL = "/dept/all";// 所有数据
    public static final String DEPT_PAGE_SHOW = "/dept/page_show";// 页面
    public static final String DEPT_ADD_SHOW = "/dept/add_show";// 添加-页面
    public static final String DEPT_ADD_SUBMIT = "/dept/add_submit";// 添加-提交
    public static final String DEPT_UPDATE_SHOW = "/dept/update_show";// 编辑-页面
    public static final String DEPT_UPDATE_SUBMIT = "/dept/update_submit";// 编辑-提交
    public static final String DEPT_DELETE_SUBMIT = "/dept/delete_submit";// 删除-提交
    public static final String DEPT_DETAIL_SHOW = "/dept/detail";// 详情
    public static final String DEPT_TREE_SHOW = "/dept/tree_show";// 详情
    /**
     * Feedback 留言
     */
    public static final String FEEDBACK = "/feedbackAction";// 控制器
    public static final String FEEDBACK_PAGE_SHOW = "/feedback/page_show";// 页面展示
    public static final String FEEDBACK_ADD_SHOW = "/feedback/add_show";// 添加-页面
    public static final String FEEDBACK_ADD_SUBMIT = "/feedback/add_submit";// 添加-提交
    public static final String FEEDBACK_UPDATE_SHOW = "/feedback/update_show";// 编辑-页面
    public static final String FEEDBACK_UPDATE_SUBMIT = "/feedback/update_submit";// 编辑-提交
    public static final String FEEDBACK_DELETE_SUBMIT = "/feedback/delete_submit";// 删除-提交
    public static final String FEEDBACK_EXCEL = "/feedback/excel";// EXCEL导出
    public static final String FEEDBACK_SETLOCKABLE_SUBMIT = "/feedback/setLockAble_submit";// 设置是否可见
    public static final String FEEDBACK_SETTOP_SUBMIT = "/feedback/setTop_submit";// 设置是否置顶
    public static final String FEEDBACK_DETAIL_SHOW = "/feedback/detail";// 详情
    /**
     * Files 文件消息
     */
    public static final String FILES = "/filesAction";// 控制器
    public static final String FILES_PAGE_SHOW = "/files/page_show";// 页面展示
    public static final String FILES_ADD_UPLOAD_SHOW = "/files/add_upload_show";// 添加-上传-页面
    public static final String FILES_ADD_DETAIL_SHOW = "/files/add_detail_show";// 添加-详情-页面
    public static final String FILES_ADD_SUBMIT = "/files/add_submit";// 添加-提交
    public static final String FILES_UPDATE_SHOW = "/files/update_show";// 编辑-页面
    public static final String FILES_UPDATE_SUBMIT = "/files/update_submit";// 编辑-提交
    public static final String FILES_DELETE_SUBMIT = "/files/delete_submit";// 删除-提交
    public static final String FILES_EXCEL = "/files/excel";// EXCEL导出
    public static final String FILES_SETENABLE_SUBMIT = "/files/setLockAble_submit";// 设置是否启用
    public static final String FILES_DETAIL_SHOW = "/files/detail";// 详情
    public static final String FILES_LIST_DETAIN_PAGE_SHOW = "/files/list_detain_page_show";        //扣押清单模板
    public static final String FILES_LIST_IN_PAGE_SHOW = "/files/list_in_page_show";                 //入库清单模板
    public static final String FILES_LIST_EXTRACT_PAGE_SHOW = "/files/list_extract_page_show";     //提取清单模板
    public static final String FILES_LIST_TRANSFER_PAGE_SHOW = "/files/list_transfer_page_show";   //移交清单模板
    public static final String FILES_LIST_OUT_PAGE_SHOW = "/files/list_out_page_show";              //出库清单模板
    /**
     * FK   反馈单
     */
    public static final String FK = "/fkAction";// 控制器
    public static final String FK_PAGE_SHOW = "/fk/page_show";// 页面展示
    public static final String FK_DETAIL_SHOW = "/fk/detail";// 详情
    /**
     * HF   回访单
     */
    public static final String HF = "/hfAction";// 控制器
    public static final String HF_PAGE_SHOW = "/hf/page_show";// 页面展示
    public static final String HF_DETAIL_SHOW = "/hf/detail";// 详情
    /**
     * InvolvedInfos 涉案财物信息表/archiveStoresBox/update_show.action
     */
    public static final String INVOLVED_INFOS = "/infosAction";// 控制器
    public static final String INVOLVED_INFOS_CASE_PAGE_SHOW = "/involvedInfos/case_show";        // 关联案件页面展示
    public static final String INVOLVED_INFOS_PAGE_SHOW = "/involvedInfos/page_show";        // 页面展示
    public static final String INVOLVED_INFOS_ADD_SHOW = "/involvedInfos/add_show";            // 添加页面
    public static final String INVOLVED_INFOS_ADD_SUBMIT = "/involvedInfos/add_submit";        // 添加提交
    public static final String INVOLVED_INFOS_SYNCHRO_SHOW = "/involvedInfos/addSynchro_show";            // 财务同步
    public static final String INVOLVED_INFOS_SYNCHRO_SUBMIT = "/involvedInfos/addSynchro_submit";        // 添财务同步提交
    public static final String INVOLVED_INFOS_DETAIL_SHOW = "/involvedInfos/detail_show";    // 财物详情
    public static final String INVOLVED_INFOS_KEEP_DETAIL_SHOW = "/involvedInfos/keep_detail_show";    // 存放详情
    public static final String INVOLVED_INFOS_KEEP_NO_KEEP_SHOW = "/involvedInfos/keep_no_keep_show";    // 未上交财物
    public static final String INVOLVED_INFOS_KEEP_KEEPED_SHOW = "/involvedInfos/keep_keeped_show";    // 已保管财物
    public static final String INVOLVED_INFOS_DISPOSE_NO_DISPOSE_SHOW = "/involvedInfos/keep_no_dispose_show";    // 未处置财物
    public static final String INVOLVED_INFOS_DISPOSE_DISPOSED_SHOW = "/involvedInfos/keep_disposed_show";    // 已处置财物
    public static final String INVOLVED_INFOS_UPDATE_SHOW = "/involvedInfos/update_show";    // 修改页面
    public static final String INVOLVED_INFOS_UPDATE_SUBMIT = "/involvedInfos/update_submit";// 修改提交
    public static final String INVOLVED_INFOS_DELETE_SUBMIT = "/involvedInfos/delete_submit";// 删除提交
    public static final String INVOLVED_INFOS_KEEP_UPDATE_SHOW = "/involvedInfos/keep_update_show";// 修改财物存放
    public static final String INVOLVED_INFOS_KEEP_UPDATE_SUBMIT = "/involvedInfos/keep_submit_submit";// 修改财物存放页面
    public static final String INVOLVED_INFOS_KEEP_OUT_SHOW = "/involvedInfos/out_show";// 已出库财物页面
    public static final String INVOLVED_INFOS_KEEP_OUT_DATE_SHOW = "/involvedInfos/out_date_show";// 即将到期财物页面
    public static final String INVOLVED_INFOS_EXCEL = "/involvedInfos/excel";// EXCEL导出

    /**
     * InvolvedTemp涉案财物临时信息表
     */
    public static final String INVOLVED_TEMP = "/tempAction";// 控制器
    public static final String INVOLVED_TEMP_CASE_PAGE_SHOW = "/involvedTemp/page_case_show";        // 页面展示根据案件id
    public static final String INVOLVED_TEMP_CASE_SUBMIT = "/involvedTemp/submit";        // 同步

    /**
     * InvolvedTask 涉案财物工作流表
     */
    public static final String INVOLVED_TASK = "/involvedTaskAction";// 控制器

    public static final String INVOLVED_KEEP_TASK_START_SHOW = "/involvedTask/keep_task_start_show";    //启动保管流程的显示页面
    public static final String INVOLVED_KEEP_TASK_START = "/involvedTask/keep_task_start";    //启动保管流程操作
    public static final String INVOLVED_KEEP_TASK_SUBMIT_SHOW = "/involvedTask/keep_task_submit_show";    //提交申请保管页面
    public static final String INVOLVED_KEEP_TASK_SUBMIT = "/involvedTask/keep_task_submit";    //提交申请保管
    public static final String INVOLVED_KEEP_TASK_FZ_ADOPT_SHOW = "/involvedTask/keep_task_fz_adopt_show";    //法制审批申请保管页面
    public static final String INVOLVED_KEEP_TASK_FZ_ADOPT = "/involvedTask/keep_fz_task_adopt";    //法制审批申请保管操作
    public static final String INVOLVED_KEEP_TASK_LD_ADOPT_SHOW = "/involvedTask/keep_task_ld_adopt_show";    //领导审批申请保管页面
    public static final String INVOLVED_KEEP_TASK_LD_ADOPT = "/involvedTask/keep_ld_task_adopt";    //领导审批申请保管操作
    public static final String INVOLVED_KEEP_TASK_KEEP_SHOW = "/involvedTask/keep_task_keep_show";    //保管员审批申请保管页面
    public static final String INVOLVED_KEEP_TASK_KEEP = "/involvedTask/keep_task_keep";    //保管员审批申请保管操作

    public static final String INVOLVED_DISPOSE_TASK_START_SHOW = "/involvedTask/dispose_task_start_show";    //启动处置流程的显示页面
    public static final String INVOLVED_DISPOSE_TASK_START = "/involvedTask/dispose_task_start";    //启动处置流程操作
    public static final String INVOLVED_DISPOSE_TASK_SUBMIT_SHOW = "/involvedTask/dispose_task_submit_show";    //提交申请处置页面
    public static final String INVOLVED_DISPOSE_TASK_SUBMIT = "/involvedTask/dispose_task_submit";    //提交申请处置
    public static final String INVOLVED_DISPOSE_TASK_FZ_ADOPT_SHOW = "/involvedTask/dispose_task_adopt_show";    //法制审批申请处置页面
    public static final String INVOLVED_DISPOSE_TASK_FZ_ADOPT = "/involvedTask/dispose_task_adopt";    //法制审批申请处置操作
    public static final String INVOLVED_DISPOSE_TASK_LD_ADOPT_SHOW = "/involvedTask/dispose_task_adopt_show";    //领导审批申请处置页面
    public static final String INVOLVED_DISPOSE_TASK_LD_ADOPT = "/involvedTask/dispose_task_adopt";    //领导审批申请处置操作

    //申请保管菜单（办案人员）
    public static final String INVOLVED_KEEP_NO_SUBMIT_SHOW = "/involvedTask/keep_no_submit_show";// 未提交保管的财物
    public static final String INVOLVED_KEEP_NO_FINISH_SHOW = "/involvedTask/keep_no_finish_show";//待完成任务（办案人员保管）
    public static final String INVOLVED_KEEP_FINISHED_SHOW = "/involvedTask/keep_finished_show";//已完成任务（办案人员保管）
    //申请处置菜单（办案人员）
    public static final String INVOLVED_DISPOSE_NO_SUBMIT_SHOW = "/involvedTask/dispose_no_submit_show";// 未提交处置的财物
    public static final String INVOLVED_DISPOSE_NO_FINISH_SHOW = "/involvedTask/dispose_no_finish_show";//待完成任务（办案人员处置）
    public static final String INVOLVED_DISPOSE_FINISHED_SHOW = "/involvedTask/dispose_finished_show";//已完成任务（办案人员处置）
    //审批保管菜单（法制）
    public static final String INVOLVED_KEEP_FZ_NO_ADOPT_SHOW = "/involvedTask/keep_fz_no_adopt_show";//待完成任务（法制保管）
    public static final String INVOLVED_KEEP_FZ_ADOPTED_SHOW = "/involvedTask/keep_fz_adopted_show";//已完成任务（法制保管）
    //审批处置菜单（法制）
    public static final String INVOLVED_DISPOSE_FZ_NO_ADOPT_SHOW = "/involvedTask/dispose_fz_no_adopt_show";//待完成任务（法制处置）
    public static final String INVOLVED_DISPOSE_FZ_ADOPTED_SHOW = "/involvedTask/dispose_fz_adopted_show";//已完成任务（法制处置）
    //审批保管菜单（领导）
    public static final String INVOLVED_KEEP_LD_NO_ADOPT_SHOW = "/involvedTask/keep_ld_no_adopt_show";//待完成任务（领导保管）
    public static final String INVOLVED_KEEP_LD_ADOPTED_SHOW = "/involvedTask/keep_ld_adopted_show";//已完成任务（领导保管）
    //审批处置菜单（领导）
    public static final String INVOLVED_DISPOSE_LD_NO_ADOPT_SHOW = "/involvedTask/dispose_ld_no_adopt_show";//待完成任务（领导处置）
    public static final String INVOLVED_DISPOSE_LD_ADOPTED_SHOW = "/involvedTask/dispose_ld_adopted_show";//已完成任务（领导处置）
    //审批保管菜单（财务保管人员入库）
    public static final String INVOLVED_KEEP_NO_KEEP_SHOW = "/involvedTask/keep_no_keep_show";//待完成任务（财务保管人员入库）
    public static final String INVOLVED_KEEP_KEEPED_SHOW = "/involvedTask/keep_keeped_show";//已完成任务（财务保管人员入库）
    /**
     * InvolvedCase 财务案件箱子关联表
     */
    public static final String INVOLVED_CASE = "/involvedCaseAction";// 控制器
    public static final String INVOLVED_CASE_PAGE_SHOW = "/involvedCase/page_show";// 页面展示
    public static final String INVOLVED_CASE_ADD_SHOW = "/involvedCase/add_show";// 添加-页面
    public static final String INVOLVED_CASE_ADD_SUBMIT = "/involvedCase/add_submit";// 添加-提交
    public static final String INVOLVED_CASE_UPDATE_SHOW = "/involvedCase/update_show";// 编辑-页面
    public static final String INVOLVED_CASE_UPDATE_SUBMIT = "/involvedCase/update_submit";// 编辑-提交
    public static final String INVOLVED_CASE_DELETE_SUBMIT = "/involvedCase/delete_submit";// 删除-提交
    public static final String INVOLVED_CASE_EXCEL = "/involvedCase/excel";// EXCEL导出
    public static final String INVOLVED_CASE_DETAIL_SHOW = "/involvedCase/detail";// 查看案件关联卷宗信息
    public static final String INVOLVED_CASE_ADDNEW_SHOW = "/involvedCase/addNew_submit";// 同步卷宗
    //Involvedcase 涉案财物与案事件关联
    public static final String INVOLVED_CASE_NO_INPUT = "/involvedInfos/show_no_input";       // 未录入财务页面展示
    public static final String INVOLVED_CASE_INPUT = "/involvedInfos/show_input";        // 已录入财务页面展示
    public static final String INVOLVED_CASE_NOT_INPUT = "/involvedInfos/show_not_input";        // 无需录入页面展示
    public static final String INVOLVED_CASE_SYNC_SHOW = "/involvedInfos/case_sync_show";                    // 同步财务
    public static final String INVOLVED_CASE_REQUIRE_SYNC = "/involvedInfos/case_require_sync";                // 需要财务
    public static final String INVOLVED_CASE_NO_REQUIRE_SYNC = "/involvedInfos/case_no_require_sync";        // 无需同步
    public static final String INVOLVED_CASE_SYNC = "/involvedInfos/case_sync";                    // 同步财务
    /**
     * InvolvedTypes 涉案财物类别表
     */
    public static final String INVOLVED_TYPES = "/involvedTypes";//财务类型查询所有
    public static final String INVOLVED_TYPES_PAGE_SHOW = "/involvedTypes/page_show";        // 页面展示
    public static final String INVOLVED_TYPES_TREE_SHOW = "/involvedTypes/tree_show";        // 页面展示
    public static final String INVOLVED_TYPES_SHOW_BY_PARENTID = "/involvedTypes/show_byParentId";        // 页面展示
    public static final String INVOLVED_TYPES_ADD_SHOW = "/involvedTypes/add_show";            // 添加页面
    public static final String INVOLVED_TYPES_ADD_SUBMIT = "/involvedTypes/add_submit";        // 添加提交
    public static final String INVOLVED_TYPES_DETAIL_SHOW = "/involvedTypes/detail_show";    // 详情
    public static final String INVOLVED_TYPES_UPDATE_SHOW = "/involvedTypes/update_show";    // 修改页面
    public static final String INVOLVED_TYPES_UPDATE_SUBMIT = "/involvedTypes/update_submit";// 修改提交
    public static final String INVOLVED_TYPES_DELETE_SUBMIT = "/involvedTypes/delete_submit";// 删除
    public static final String INVOLVED_TYPES_FIND_ALL = "/involvedTypes/types_find_all";//财务类型查询所有
    /**
     * InvolvedStores 仓库表
     */
    public static final String INVOLVED_STORES = "/storesAction";// 控制器
    public static final String INVOLVED_STORES_PAGE_SHOW = "/involvedStores/page_show";// 页面展示
    public static final String INVOLVED_STORES_TREE_SHOW = "/involvedStores/tree_show";// 仓库模态框展示
    public static final String INVOLVED_STORES_ADD_SHOW = "/involvedStores/add_show";            // 添加页面
    public static final String INVOLVED_STORES_ADD_SUBMIT = "/involvedStores/add_submit";        // 添加提交
    public static final String INVOLVED_STORES_DETAIL_SHOW = "/involvedStores/detail_show";    // 详情
    public static final String INVOLVED_STORES_UPDATE_SHOW = "/involvedStores/update_show";    // 修改页面
    public static final String INVOLVED_STORES_UPDATE_SUBMIT = "/involvedStores/update_submit";// 修改提交
    public static final String INVOLVED_STORES_DELETE_SUBMIT = "/involvedStores/delete_submit";// 删除
    /**
     * InvolvedStoresBox 储物柜箱子表
     */
    public static final String INVOLVED_STORES_BOX = "/storesBoxAction";// 控制器
    public static final String INVOLVED_STORES_BOX_PAGE_SHOW = "/involvedBox/page_show";// 页面展示
    public static final String INVOLVED_STORES_BOX_PAGE_DATA = "/involvedBox/page_data";// 页面展示
    public static final String INVOLVED_STORES_BOX_TREE_SHOW = "/involvedBox/tree_show";// 箱子模态框展示
    public static final String INVOLVED_STORES_BOX_ADD_SHOW = "/involvedBox/add_show";            // 添加页面
    public static final String INVOLVED_STORES_BOX_ADD_SUBMIT = "/involvedBox/add_submit";        // 添加提交
    public static final String INVOLVED_STORES_BOX_DETAIL_SHOW = "/involvedBox/detail_show";    // 详情
    public static final String INVOLVED_STORES_BOX_UPDATE_SHOW = "/involvedBox/update_show";    // 修改页面
    public static final String INVOLVED_STORES_BOX_UPDATE_SUBMIT = "/involvedBox/update_submit";// 修改提交
    public static final String INVOLVED_STORES_BOX_DELETE_SUBMIT = "/involvedBox/delete_submit";// 删除
    public static final String INVOLVED_STORES_BOX_OPEN_BOX = "/involvedBox/open_box";// 开箱
    /**
     * InvolvedStoresLockers 仓库储物柜
     */
    public static final String INVOLVED_STORES_LOCKERS = "/storesLockersAction";// 控制器
    public static final String INVOLVED_STORES_LOCKERS_PAGE_SHOW = "/involvedStoresLockers/page_show";// 页面展示
    public static final String INVOLVED_STORES_LOCKERS_TREE_SHOW = "/involvedStoresLockers/tree_show";// 仓库柜子模态框展示
    public static final String INVOLVED_STORES_LOCKERS_ADD_SHOW = "/involvedStoresLockers/add_show";            // 添加页面
    public static final String INVOLVED_STORES_LOCKERS_ADD_SUBMIT = "/involvedStoresLockers/add_submit";        // 添加提交
    public static final String INVOLVED_STORES_LOCKERS_DETAIL_SHOW = "/involvedStoresLockers/detail_show";    // 详情
    public static final String INVOLVED_STORES_LOCKERS_UPDATE_SHOW = "/involvedStoresLockers/update_show";    // 修改页面
    public static final String INVOLVED_STORES_LOCKERS_UPDATE_SUBMIT = "/involvedStoresLockers/update_submit";// 修改提交
    public static final String INVOLVED_STORES_LOCKERS_DELETE_SUBMIT = "/involvedStoresLockers/delete_submit";// 删除


    /**
     * JJ接警单
     */
    public static final String JJ = "/jjAction";// 控制器
    public static final String JJ_PAGE_SHOW = "/jj/page_show";// 页面展示
    public static final String JJ_UNRELATED_PAGE_SHOW = "/jj/unrelated/page_show";
    public static final String JJ_NOTRECORDINGS_PAGE_SHOW = "/jj/notRecordings/page_show";
    public static final String JJ_EXCEL = "/jj/excel";// EXCEL导出
    public static final String JJ_DETAIL_SHOW = "/jj/detail";// 详情
    public static final String JJ_UNRELATED_DETAIL_SHOW = "/jj/unrelated/detail";// 详情
    public static final String JJ_TIMEOUT_UNTREATED_SHOW = "/jj/unrelated/timeout_untreated";// 超时未反馈

    public static final String JJ_NOTCORRELATE_VIEW_SHOW= "/jj/selectJJNotView"; //未关联音视频的接警
    public static final String JJ_CORRELATE_VIEW_SHOW= "/jj/selectJJView"; //已关联音视频的接警
    /**
     * LY   录音单
     */
    public static final String LY = "/lyAction";// 控制器
    public static final String LY_PAGE_SHOW = "/ly/page_show";// 页面展示
    public static final String LY_DETAIL_SHOW = "/ly/detail";// 详情
    /**
     * Main 用户控制器的实现
     */
    public static final String MAIN = "mainAction";// 控制器
    /**
     * Media 视频
     */
    public static final String MEDIA = "mediaAction";// 控制器
    public static final String MEDIA_PAGE_SHOW = "/media/page_show"; // 显示列表视图
    public static final String MEDIA_ADD_SHOW = "/media/add_show"; // 添加-页面
    public static final String MEDIA_ADD_SUBMIT = "/media/add_submit"; // 添加-提交
    public static final String MEDIA_UPDATE_SHOW = "/media/update_show"; // 编辑-页面
    public static final String MEDIA_UPDATE_SUBMIT = "/media/update_submit"; // 编辑-提交
    public static final String MEDIA_DELETE_SUBMIT = "/media/delete_submit"; // 删除-提交
    public static final String MEDIA_DETAIL_SHOW = "/media/detail_show"; // 详情-页面
    public static final String MEDIA_FILE_SHOW = "/media/file_show";                // 视频文件关联页面
    public static final String MEDIA_FILE_SUBMIT = "/media/file_submit";            // 视频文件关联提交
    public static final String MEDIA_CASE_SHOW = "/media/case_show";                // 视频案件关联页面
    public static final String MEDIA_CASE_SUBMIT = "/media/case_submit";            // 视频案件关联提交
    /**
     * MediaFiles 视频文件
     */
    public static final String MEDIAFILES_PAGE_SHOW = "/mediaFiles/page_show"; // 显示列表视图
    public static final String MEDIAFILES_DATA = "/mediaFiles/data"; // 获取json数据
    public static final String MEDIAFILES_ADD_SUBMIT = "/mediaFiles/add_submit"; // 添加-提交
    public static final String MEDIAFILES_DELETE_SUBMIT = "/mediaFiles/delete_submit"; // 删除-提交
    public static final String MEDIAFILES_UPDATE_SUBMIT = "/mediaFiles/update_submit"; // 更新-提交
    public static final String MEDIAFILES_BY_ID = "/mediaFiles/getBeanById"; // 根据id查询
    public static final String MEDIAFILES_QUERY_PAGE_SHOW = "/mediaFiles/query_page_show"; // 查询 数据
    /**
     * MediaCase 视频文件
     */
    public static final String MEDIACASE_SHOW_VIEW_LIST = "/mediaCase/page_show"; // 显示列表视图
    public static final String MEDIACASE_DATA = "/mediaCase/data"; // 获取json数据
    public static final String MEDIACASE_ADD_SUBMIT = "/mediaCase/add_submit"; // 添加-提交
    public static final String MEDIACASE_DELETE_SUBMIT = "/mediaCase/delete_submit"; // 删除-提交
    public static final String MEDIACASE_UPDATE_SUBMIT = "/mediaCase/update_submit"; // 更新-提交
    public static final String MEDIACASE_BY_ID = "/mediaCase/getBeanById"; // 根据id查询
    public static final String MEDIACASE_PAGE_SHOW = "/mediaCase/query_page_show"; // 查询 数据
    /**
     * Menu 菜单
     */
    public static final String MENU = "/menuAction";// 删除-提交
    public static final String MENU_PAGE_SHOW = "/menu/page_show"; // 显示视图
    public static final String MENU_ADD_SHOW = "/menu/add_show"; // 添加-页面
    public static final String MENU_ADD_SUBMIT = "/menu/add_submit";// 添加-提交
    public static final String MENU_DELETE_SUBMIT = "/menu/delete_submit";// 删除-提交
    public static final String MENU_UPDATE_SHOW = "/menu/update_show";// 更新-提交
    public static final String MENU_UPDATE_SUBMIT = "/menu/update_submit";// 更新-提交
    public static final String MENU_ALL_LIST = "/menu/aLL_list";// 查询 数据
    /**
     * Message 消息
     */
    public static final String MESSAGE = "/messageAction";// 控制器
    public static final String MESSAGE_PAGE_SHOW = "/message/page_show";// 页面展示
    public static final String MESSAGE_INDEX_SHOW = "/message/index_show";// 首页未读展示
    public static final String MESSAGE_ADD_SHOW = "/message/add_show";// 添加-页面
    public static final String MESSAGE_ADD_SUBMIT = "/message/add_submit";// 添加-提交
    public static final String MESSAGE_UPDATE_SHOW = "/message/update_show";// 编辑-页面
    public static final String MESSAGE_UPDATE_SUBMIT = "/message/update_submit";// 编辑-提交
    public static final String MESSAGE_RECOVER_SHOW = "/message/recovery_show";// 回收-页面
    public static final String MESSAGE_RECOVER_SUBMIT = "/message/recovery_submit";// 回收-提交
    public static final String MESSAGE_REFRESH_SUBMIT = "/message/refresh_submit";// 刷新-提交
    public static final String MESSAGE_SEND_SHOW = "/message/send_show";// 发送-管理
    public static final String MESSAGE_NOREAD_SHOW = "/message/noread_show";// 未读-查看
    public static final String MESSAGE_DELETE_SUBMIT = "/message/delete_submit";// 删除-提交
    public static final String MESSAGE_EXCEL = "/message/excel";// EXCEL导出
    public static final String MESSAGE_DETAIL_SHOW = "/message/detail";// 详情
    /**
     * Notice 公告
     */
    public static final String NOTICE = "/noticeAction";// 控制器
    public static final String NOTICE_PAGE_SHOW = "/notice/page_show";// 页面展示
    public static final String NOTICE_LIST_SHOW = "/notice/list_show";// 列表展示
    public static final String NOTICE_ADD_SHOW = "/notice/add_show";// 添加-页面
    public static final String NOTICE_ADD_SUBMIT = "/notice/add_submit";// 添加-提交
    public static final String NOTICE_UPDATE_SHOW = "/notice/update_show";// 编辑-页面
    public static final String NOTICE_UPDATE_SUBMIT = "/notice/update_submit";// 编辑-提交
    public static final String NOTICE_DELETE_SUBMIT = "/notice/delete_submit";// 删除-提交
    public static final String NOTICE_EXCEL = "/notice/excel";// EXCEL导出
    public static final String NOTICE_SETLOCKABLE_SUBMIT = "/notice/setLockAble_submit";// 设置是否可见
    public static final String NOTICE_SETTOP_SUBMIT = "/notice/setTop_submit";// 设置是否置顶
    public static final String NOTICE_DETAIL_SHOW = "/notice/detail";// 详情
    /**
     * Permission 权限
     */
    public static final String PERMISSION = "permissionAction";
    public static final String PERMISSION_PAGE_SHOW = "/permission/page_show";// 页面
    public static final String PERMISSION_ADD_SHOW = "/permission/add_show";// 添加-页面
    public static final String PERMISSION_ADD_SUBMIT = "/permission/add_submit";// 添加-提交
    public static final String PERMISSION_UPDATE_SHOW = "/permission/update_show";// 编辑-页面
    public static final String PERMISSION_UPDATE_SUBMIT = "/permission/update_submit";// 编辑-提交
    public static final String PERMISSION_DELETE_SUBMIT = "/permission/delete_submit";// 硬删除-提交
    public static final String PERMISSION_DETAIL_SHOW = "/permission/detail_show";// 详情-页面

    /**
     * activiti工作流
     */
    public static final String ACTIVITI = "/activitiAction"; // 控制器
    public static final String ACTIVITI_PAGE_SHOW = "/activiti/page_show";// 页面
    public static final String ACTIVITI_ADD_SHOW = "/activiti/add_show";// 添加-提交
    public static final String ACTIVITI_ADD_SUBMIT = "/activiti/add_submit";// 添加-提交
    public static final String ACTIVITI_DELETE_SUBMIT = "/activiti/delete_submit";// 删除-提交
    public static final String ACTIVITI_DETAIL_SHOW = "/activiti/detail_show";// 详情-页面
    public static final String ACTIVITI_START_PROCESS = "/activiti/start_process";// 启用流程
    public static final String ACTIVITI_SUSPEND_PROCESS = "/activiti/suspend_process";// 挂起流程
    /**
     * dictory 系统菜单模板模块
     */
    public static final String DICTORY = "dictoryAction";
    public static final String DICTORY_PAGE_SHOW = "/dictory/page_show";// 页面
    public static final String DICTORY_ADD_SHOW = "/dictory/add_show";// 添加-页面
    public static final String DICTORY_ADD_SUBMIT = "/dictory/add_submit";// 添加-提交
    public static final String DICTORY_UPDATE_SHOW = "/dictory/update_show";// 编辑-页面
    public static final String DICTORY_UPDATE_SUBMIT = "/dictory/update_submit";// 编辑-提交
    public static final String DICTORY_DELETE_SUBMIT = "/dictory/delete_submit";// 硬删除-提交
    public static final String DICTORY_DETAIL_SHOW = "/dictory/detail_show";// 详情-页面
    /**
     * Record 笔录
     */
    public static final String RECORD = "/recordAction";// 控制器
    public static final String RECORD_PAGE_SHOW = "/record/page_show";// 页面展示
    public static final String RECORD_ADD_SHOW = "/record/add_show";// 添加-页面
    public static final String RECORD_ADD_SUBMIT = "/record/add_submit";// 添加-提交
    public static final String RECORD_UPDATE_SHOW = "/record/update_show";// 编辑-页面
    public static final String RECORD_UPDATE_SUBMIT = "/record/update_submit";// 编辑-提交
    public static final String RECORD_DELETE_SUBMIT = "/record/delete_submit";// 删除-提交
    public static final String RECORD_EXCEL = "/record/excel";// EXCEL导出
    public static final String RECORD_DETAIL_SHOW = "/record/detail";// 详情

    public static final String RECORD_PAGE_SHOW_NO_INPUT = "/record/page_show_no_input";// 页面展示,未录入笔录
    public static final String RECORD_PAGE_SHOW_INPUT = "/record/page_show_input";// 页面展示,已录入笔录
    public static final String RECORD_PERSON_SHOW = "/record/page_person_show";//选择人员
    public static final String RECORD_INFOS_CASE_SHOW = "/record/case_show"; // 查看笔录
    public static final String RECORD_ADD_CASE_SUBMIT = "/record/add_submit1";// 添加-提交-关联案件

    public static final String RECORD_INTERROGATION_SHOW = "/recordPerson/page_interrogation_person_show";//辨认
    public static final String RECORD_INTERROGATION_PERSON_SHOW = "/recordPerson/page_interrogation_show";//辨认
    public static final String RECORD_IN_WRITING_PERSON_SHOW = "/recordPerson/page_interrogation_person_show";//笔录
    public static final String RECORD_IN_WRITING_SHOW = "/recordPerson/page_interrogation_show";//笔录
    public static final String RECORD_INQUIRY_SHOW = "/recordPerson/page_inquiry_show";//询问笔录
    public static final String RECORD_IDENTIFY_SHOW = "/recordPerson/page_identify_show";//辨认
    public static final String RECORD_MESSSAGEMANAGE_DETAIL_SHOW = "/recordMessageManage/detail";// 详情


    public static final String RECORD_PERSON = "/recordPersonAction";// 控制器
    public static final String RECORD_PERSON_PAGE_SHOW = "/recordPerson/page_show";//页面展示
    public static final String RECORD_PERSON_ADD_SHOW = "/recordPerson/add_show";// 添加-页面
    public static final String RECORD_PERSON_ADD_SUBMIT = "/recordPerson/add_submit";// 添加-提交
    public static final String RECORD_PERSON_UPDATE_SHOW = "/recordPerson/update_show";// 编辑-页面
    public static final String RECORD_PERSON_UPDATE_SUBMIT = "/recordPerson/update_submit";// 编辑-提交
    public static final String RECORD_PERSON_DELETE_SUBMIT = "/recordPerson/delete_submit";// 删除-提交
    public static final String RECORD_PERSON_EXCEL = "/recordPerson/excel";// EXCEL导出
    public static final String RECORD_PERSON_DETAIL_SHOW = "/recordPerson/detail";// 详情
    public static final String RECORD_PERSON_TREE_SHOW = "/recordPerson/tree_show";//被询问人-树
    public static final String RECORD_PERSON_TREE_SHOW1 = "/recordPerson/tree_show1";//被询问人-树
    /**
     * Record 笔录问题
     */
    public static final String RECORD_QUESTION = "/recordQuestionAction";// 控制器
    public static final String RECORD_QUESTION_PAGE_SHOW = "/recordQuestion/page_show";// 页面展示
    public static final String RECORD_QUESTION_PAGE_SHOW1 = "/recordQuestion/page_show1";// 搜索展示
    public static final String RECORD_QUESTION_ADD_SHOW = "/recordQuestion/add_show";// 添加-页面
    public static final String RECORD_QUESTION_ADD_SUBMIT = "/recordQuestion/add_submit";// 添加-提交
    public static final String RECORD_QUESTION_UPDATE_SHOW = "/recordQuestion/update_show";// 编辑-页面
    public static final String RECORD_QUESTION_UPDATE_SUBMIT = "/recordQuestion/update_submit";// 编辑-提交
    public static final String RECORD_QUESTION_DELETE_SUBMIT = "/recordQuestion/delete_submit";// 删除-提交
    public static final String RECORD_QUESTION_EXCEL = "/recordQuestion/excel";// EXCEL导出
    public static final String RECORD_QUESTION_DETAIL_SHOW = "/recordQuestion/detail";// 详情
    /**
     * Record 笔录问题类型
     */
    public static final String RECORD_QUESTION_TYPE = "/recordQuestionTypeAction";// 控制器
    public static final String RECORD_QUESTION_TYPE_PAGE_SHOW = "/recordQuestionType/page_show";// 页面展示
    public static final String RECORD_QUESTION_TYPE_PAGE_SHOWLIST = "/recordQuestionType/page_showList";
    public static final String RECORD_QUESTION_TYPE_ADD_SHOW = "/recordQuestionType/add_show";// 添加-页面
    public static final String RECORD_QUESTION_TYPE_ADD_SUBMIT = "/recordQuestionType/add_submit";// 添加-提交
    public static final String RECORD_QUESTION_TYPE_UPDATE_SHOW = "/recordQuestionType/update_show";// 编辑-页面
    public static final String RECORD_QUESTION_TYPE_UPDATE_SUBMIT = "/recordQuestionType/update_submit";// 编辑-提交
    public static final String RECORD_QUESTION_TYPE_DELETE_SUBMIT = "/recordQuestionType/delete_submit";// 删除-提交
    public static final String RECORD_QUESTION_TYPE_EXCEL = "/recordQuestionType/excel";// EXCEL导出
    public static final String RECORD_QUESTION_TYPE_DETAIL_SHOW = "/recordQuestionType/detail";// 详情
    /**
     * Role角色
     */
    public static final String ROLE = "/roleAction";// 控制器
    public static final String ROLE_PAGE_SHOW = "/role/page_show";                                    // 页面展示
    public static final String ROLE_ADD_SHOW = "/role/add_show";                                        // 添加-页面
    public static final String ROLE_ADD_SUBMIT = "/role/add_submit";                                // 添加-提交
    public static final String ROLE_UPDATE_SHOW = "/role/update_show";                                // 编辑-页面
    public static final String ROLE_UPDATE_SUBMIT = "/role/update_submit";                            // 编辑-提交
    public static final String ROLE_DELETE_SUBMIT = "/role/delete_submit";                            // 删除-提交
    public static final String ROLE_DETAIL_SHOW = "/role/detail_show";                                    // 详情
    public static final String ROLE_UPDATE_PERMISSION_SHOW = "/role/update_permission_show";   // 权限编辑显示
    public static final String ROLE_UPDATE_PERMISSION_SUBMIT = "/role/update_permission_submit";// 权限编辑提交
    public static final String ROLE_UPDATE_MENU_SHOW = "/role/update_menu_show";                     // 角色菜单编辑显示
    public static final String ROLE_UPDATE_MENU_SUBMIT = "/role/update_menu_submit";                // 角色菜单编辑提交
    public static final String ROLE_DEPT_TREE_SHOW = "/role/dept_tree_show";                     // 角色菜单编辑显示
    /**
     * User 用户
     */
    public static final String USER = "/userAction"; // 控制器
    public static final String USER_PAGE_SHOW = "/user/page_show";// 页面
    public static final String USER_ADD_SHOW = "/user/add_show";// 添加-提交
    public static final String USER_ADD_SUBMIT = "/user/add_submit";// 添加-提交
    public static final String USER_UPDATE_SHOW = "/user/update_show";// 编辑-提交
    public static final String USER_UPDATE_SUBMIT = "/user/update_submit";// 编辑-提交
    public static final String USER_DELETE_SUBMIT = "/user/delete_submit";// 删除-提交
    public static final String USER_DETAIL_SHOW = "/user/detail_show";// 详情-页面
    public static final String USER_LOGIN_VALIDATE = "/user/login_validate"; // 登录
    public static final String USER_LOGIN = "/user/login"; // 登录
    public static final String USER_LOGOUT = "/user/logout"; // 注销
    public static final String USER_PASSWORD_CHANGE_SHOW = "/user/password_change_show";        // 修改密码
    public static final String USER_PASSWORD_CHANGE_SUBMIT = "/user/password_change_submit"; // 修改密码
    public static final String USER_DEPT_TREE_SHOW = "/user/dept_tree_show";                     // 部门树页面展示
    public static final String USER_TREE_SHOW = "/user/user_tree_show";                     // 员工树页面展示
    public static final String USER_TREE_SHOW1 = "/user/user_tree_show1";                     // 员工树2页面展示
    public static final String USER_DATA = "/user/user_data";                     // 员工数据
    public static final String USER_MENU_BY_DEPTID = "/user/findMenuBy_DeptId";                //根据部门查询当前部门角色
    public static final String USER_RESET_PASSWORD_SUBMIT = "/user/reset_password_submit";    //重置密码
    public static final String USER_TO_ERROR_SHOW = "/user/to_error_show";                    //错误页面
    public static final String USER_LOGIN_TIMEOUT_SHOW = "/user/login_timeout_show";        //登录超时页面
    public static final String USER_LOCKED_SUBMIT = "/user/locked_submit";                        // 激活锁定-提交
    //数据备份ea_data_synctask
    public static final String DATA_SYNCTASK_PAGE_SHOW = "/dataSynctask/page_show";                // 备份历史列表页面
    public static final String DATA_SYNCTASK_NEXT_TASK_PAGE_SHOW = "/dataSynctask/next_task_page_show";                // 备份历史列表页面
    public static final String DATA_SYNCTASK_ADD_SHOW = "/dataSynctask/add_show";                    // 添加-提交
    public static final String DATA_SYNCTASK_ADD_SUBMIT = "/dataSynctask/add_submit";            // 添加-提交
    public static final String DATA_SYNCTASK_UPDATE_SHOW = "/dataSynctask/update_show";// 编辑-提交
    public static final String DATA_SYNCTASK_UPDATE_SUBMIT = "/dataSynctask/update_submit";// 编辑-提交
    public static final String DATA_SYNCTASK_DETAIL_SHOW = "/dataSynctask/detail_show";            // 详情-页面
    public static final String DATA_SYNCTASK_DELETE_SUBMIT = "/dataSynctask/delete_submit";// 删除-提交
    /**
     * report 在线打印
     */
    public static final String REPORT = "/report";          //在线打印
    public static final String REPORT_DATA = "/report/report_data";          //在线打印

    public static final String REPORT_RECORD_DATA = "/report/report_record_data";//在线打印笔录

    /**
     * INVESTIGATIONEXPALARM 受立案-异常警情
     */
    public static final String INVESTIGATIONEXPALARM = "/investigationexpalarm";          //受立案
    public static final String INVESTIGATIONEXPALARM_PAGE_SHOW = "/investigationexpalarm/page_show";          //正常警情
    public static final String INVESTIGATIONEXPALARM_NO_DISPOSE_PAGE_SHOW = "/investigationexpalarm_no_dispose/page_show"; //无需处理
    public static final String INVESTIGATIONEXPALARM_NO_ACCEPT_PAGE_SHOW = "/investigationexpalarm_no_accept/page_show"; //未处理
    public static final String INVESTIGATIONEXPALARM_INFORM_PAGE_SHOW = "/investigationexpalarm_inform/page_show"; //已告知
    public static final String INVESTIGATIONEXPALARM_NO_REVIEW_PAGE_SHOW = "/investigationexpalarm_no_review/page_show"; //待复合
    public static final String INVESTIGATIONEXPALARM_ACCEPT_PAGE_SHOW = "/investigationexpalarm_accept/page_show"; //已处理
    public static final String INVESTIGATIONEXPALARM_TIMEOUT_XZ_PAGE_SHOW = "/investigationexpalarm_timeout_xz/page_show"; //超时未受立行政案件
    public static final String INVESTIGATIONEXPALARM_TIMEOUT_XS_PAGE_SHOW = "/investigationexpalarm_timeout_xs/page_show"; //超时未受立行事案件
    public static final String INVESTIGATIONEXPALARM_DETAIL_SHOW = "/investigationexpalarm/detail_show";          //受立案

    /**
     * INVESTIGATIONSUPALARM 受立案-可疑接处警
     */
    public static final String INVESTIGATIONSUPALARM = "/investigationsupalarm";          //受立案-可疑接处警
    public static final String INVESTIGATIONSUPALARM_NO_ACCEPT_PAGE_SHOW = "/investigationsupalarm_no_accept/page_show";          //未确认
    public static final String INVESTIGATIONSUPALARM_ACCEPT_PAGE_SHOW = "/investigationsupalarm_accept/page_show";          //已确认
    public static final String INVESTIGATIONSUPALARM_PAGE_SHOW = "/investigationsupalarm/page_show";          //已确认无异常
    public static final String INVESTIGATIONSUPALARM_DETAIL_SHOW = "/investigationsupalarm/detail_show";          //详情

    /**
     * INVESTIGATIONRELATED 受立案-积案带破
     */
    public static final String INVESTIGATIONRELATED = "/investigationrelated";          //受立案-积案带破
    public static final String INVESTIGATIONRELATED_NO_ACCEPT_PAGE_SHOW = "/investigationrelated_no_accept/page_show";          //积案带破未确认列表
    public static final String INVESTIGATIONRELATED_ACCEPT_PAGE_SHOW = "/investigationrelated_accept/page_show";          //积案带破已确认列表
    public static final String INVESTIGATIONRELATED_PAGE_SHOW = "/investigationrelated/page_show";          //积案带破无异常列表
    public static final String INVESTIGATIONRELATED_DETAIL_SHOW = "/investigationrelated/detail_show";          //详情
    /**
     * CODE 字典
     */
    public static final String CODE = "/codeAction"; // 控制器
    public static final String CODE_PAGE_SHOW = "/code/page_show";// 页面展示
    public static final String CODE_ADD_SHOW = "/rcode/add_show";// 添加-页面
    public static final String CODE_ADD_SUBMIT = "/code/add_submit";// 添加-提交
    public static final String CODE_UPDATE_SHOW = "/code/update_show";// 编辑-页面
    public static final String CODE_UPDATE_SUBMIT = "/code/update_submit";// 编辑-提交
    public static final String CODE_DELETE_SUBMIT = "/code/delete_submit";// 删除-提交
    public static final String CODE_EXCEL = "/code/excel";// EXCEL导出
    public static final String CODE_DETAIL_SHOW = "/code/detail";// 详情

    /**
     * ONEKEYQUERY 一键查询
     */
    public static final String ONEKEYQUERY = "/oneKeyQueryAction"; // 控制器
    public static final String ONEKEYQUERY_PAGE_SHOW = "/oneKeyQuery/page_show";// 页面展示


    public static final String VIEWDOC = "/viewDocAction";// 控制器
    public static final String VIEWDOC_PAGE_SHOW = "/viewDoc/page_show"; // 显示列表视图
    public static final String VIEWDOC_DETAIL_SHOW = "/viewDoc/detail_show"; // 详情-页面

    public static final String VIEWDOC_CORRELATE_SHOW="/viewDoc/toCorrelateView"; //录音关联界面
    public static final String VIEWDOC_CORRELATE_SUBMIT="/viewDoc/viewCorrelate";// 录音关联提交

    public static final String  VIEWDOC_ONE_VIEWS_SHOW="/viewDoc/oneCorrelateViewShow";
    public static final String VIEWDOC_FILE_SHOW = "/viewDoc/file_show";                // 视频文件关联页面
    
    public static final String VIEWDOC_FILE_SUBMIT = "/viewDoc/file_submit";            // 视频文件关联提交
    public static final String VIEWDOC_CASE_SHOW = "/viewDoc/case_show";                // 视频案件关联页面
    public static final String VIEWDOC_CASE_SUBMIT = "/viewDoc/case_submit";            // 视频案件关联提交

    /**
     * @param s
     * @return
     */
    public static String getUrl(String s) {
        return s + ".action";
    }
}
