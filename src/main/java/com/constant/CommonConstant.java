package com.constant;

/**
 * Created by Administrator on 2018/4/9 0009.
 */

/**
 * 此类的作用是标识数据库的状态
 */
public class CommonConstant {
    public static Integer SESSION_TIMEOUT = 30*60; //session有效时间,单位秒

    public static String SYSTEM_PERSSION_FILENAME = "/sys_current_use.xml";         //无需录入笔录模块
    public static String USER_PASSWORD_SALT = "intelPolice";                     //用户密码盐
    public static String USER_RESET_PASSWORD = "111111";                          //用户初始密码
    public static final String STATUS_USE = "1";                                //删除标识 可以修改   1 正在使用
    public static final String STATUS_DELETE = "0";                              //删除标识 可以修改   0  已删除

    public static String SESSION_FRIST = "1";                                   //判断当前的用户是否是  第一个用户登录
    public static final String FILE_UPLOAD_PATH = "D://upload";          //文件上传路径ftp
//    public static final String FILE_UPLOAD_PATH = "https://120.78.67.109/svn/贵阳公安/IntelPolice/upload";          //文件上传路径ftp
    public static final String FILE_UPLOAD_REGEX = ",==,";       //文件上传后返回的字符串分隔符

    public static final String CHANGEIND_NULOCK = "0";   //修改标识0 可以修改   1  不可修改
    public static final String CHANGEIND_ISLOCK = "1";   //修改标识0 可以修改   1  不可修改

    public static final String DICTORY_TYPE_PERMISSION = "1";      //字典表的类型为1 时为权限相关字典

    public static final String SYSTEM_MESSAGE = "message";         //request域消息值

    public static final String LINKED_TYPE_ADD = "add";                 //添加按钮显示
    public static final String LINKED_TYPE_UPDATE = "update";          //更新显示
    public static final String LINKED_TYPE_DELETE = "delete";          //删除按钮显示
    public static final String LINKED_TYPE_DETAILS = "details";        //详情按钮显示

    public static final String USER_TYPE_ADMIN = "6";                   //用户类型   管理员
    public static final String USER_TYPE_JINGBANYUUAN = "7";           //用户类型   经办员
    public static final String USER_TYPE_SYSTEM = "8";                  //用户类型   系统内置人员

    public static final String MODULE_RECORD_NOINPUT = "record_no_input";           //未录入笔录模块
    public static final String MODULE_RECORD_INPUT = "record_input";           //已经录入笔录模块
    public static final String MODULE_INVOLVED_NO_INPUT = "involved_no_input";     //未录入财务模块
    public static final String MODULE_INVOLVED_INPUT = "involved_input";            //已录入财务模块
    public static final String MODULE_INVOLVED_NOT_INPUT = "involved_not_input";   //无需录入财务模块
    public static final String MODULE_ARCHIVE_NO_INPUT = "archive_no_input";      //未录入卷宗模块
    public static final String MODULE_ARCHIVE_INPUT = "archive_input";             //已录入卷宗模块
    public static final String MODULE_ARCHIVE_NOT_INPUT = "archive_not_input";    //无需录入笔录模块
    public static final String MODULE_MEDIA_NO_RELATION = "media_no_relation";    //无需录入笔录模块

    public static final String CASE_NO_REQUIRE_SYNCHRONIZE = "1";                   //无需同步案件
    public static final String CASE_REQUIRE_SYNCHRONIZE = "0";                   //无需同步案件
    public static final String CODE_FIELD_CASE_TYPE = "CASE_TYPE";              //案件类型

    public static final String FILE_LIST_DETAIN = "file_list_detain";        //扣押清单模板
    public static final String FILE_LIST_IN = "file_list_in";                 //入库清单模板
    public static final String FILE_LIST_EXTRACT = "file_list_extract";     //提取清单模板
    public static final String FILE_LIST_TRANSFER = "file_list_transfer";   //移交清单模板
    public static final String FILE_LIST_OUT = "file_list_out";              //出库清单模板

    public static final String SYSNC_BPIP = "unit";                           //syncvalue         部门类型
    public static final String SYSNC_USER = "user";                           //syncvalue         用户类型
    public static final String SYSNC_POILCE = "police";                       //syncvalue         110
    public static final String SYSNC_CASE = "case";                            //syncvalue         案事件
    public static final String SYSNC_DOC = "doc";                            //syncvalue         文书
    public static final String SYSNC_HUMITURE = "humiture";                  //syncvalue         温湿度计
    public static final String SYSNC_INVESTIGATION = "investigation";        //syncvalue         受立案监督
    public static final String SYSNC_CODE = "code";                            //syncvalue       code
    public static final String SYSNC_DURG = "durg";                            //syncvalue       durg
    public static final String SYSNC_SMS_LOG = "smslog";                            //syncvalue       smslog
}
