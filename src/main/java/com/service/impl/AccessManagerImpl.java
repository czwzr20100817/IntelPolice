package com.service.impl;

import com.model.ArchiveStores;
import com.service.*;
import com.utils.*;
import org.activiti.engine.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.constant.WebExceptionConstant;
import com.exception.WebMessageException;
import com.model.User;

@Service("AccessManager")
public class AccessManagerImpl implements AccessManager {
    @Autowired
    private DeptService deptService;
    @Autowired
    private UserService userService;
    @Autowired
    private ArchiveStoresService archiveStoresService;
    @Autowired
    private ArchiveStoresLockersService archiveStoresLockersService;
    @Autowired
    private InvolvedStoresService involvedStoresService;
    @Autowired
    private InvolvedTypesService involvedTypesService;
    @Autowired
    private InvolvedStoresLockersService involvedStoresLockersService;
    @Autowired
    private DictoryService dictoryService;
    @Autowired
    private MenuService menuService;
    @Autowired
    private BpipUserService bpipUserService;
    @Autowired
    private CodeService codeService;
    @Autowired
    private RecordPersonService recordPersonService;
    @Autowired
    private RecordTypeService recordTypeService;

    //==============以下为activiti 注入Service start============
    @Autowired
    RepositoryService repositoryService;
    @Autowired
    RuntimeService runtimeService;
    @Autowired
    TaskService taskService;
    @Autowired
    FormService formService;
    @Autowired
    HistoryService historyService;

//==============end============

    /**
     * 检查用户可否访问指定uri
     * 说明：1、如果用户没登录，抛出未登录异常
     * 2、登录后，如果访问的权限为通用权限，允许访问
     * 3、如果不是通用权限，判断用户是否有权访问，如果有，允许访问
     * 4、如果无权访问，抛出权限不足这个异常
     * 注意：上面列出了主要检验步骤，不等于不会抛出其他异常
     *
     * @param uri  [必填] uri
     * @param user [非必填] 当前登录用户
     */
    @Override
    public void checkAccessUrl(String uri, User user) throws WebMessageException {
        //对登录页面，登录提交 与注销请求直接放行,不予拦截  ,
        if (uri.endsWith("login.action") || uri.endsWith("logout.action") || uri.endsWith("login.jsp")) {
            return;
        }
        // 1、判断用户是否登录 抛出异常
        if (user == null) {
            throw new WebMessageException(WebExceptionConstant.LOGIN_ERROR);
        }
        //测试使用
     /*   if (true) {
            return ;
        }*/

        // 2、判断是否需要验证
        if (AccessUtils.isUnloginUri(uri)) {
            //无需登录即可访问的权限
            return;
        }

        // 3、判断用户权限是否匹配
     /*   if (AccessUtils.isPatternUri(uri, user.getUriSet())) {
            // 匹配
            return ;
        } else {
            // 不匹配
            throw new WebMessageException(WebExceptionConstant.ACCESS_ERROR);
        }*/
    }

    @Override
    public void doCacheData() {
        //缓存部门信息
        try {
            //部门缓存
            //deptService.cacheDeptAll();
            //注入 deptService
            SysDeptVo.deptService = deptService;
            //注入 userService
            SysUserVo.userService = userService;
            //注入 archiveStoresService
            SysArchiveStoresVo.archiveStoresService = archiveStoresService;
            //注入 involvedStoresService
            SysInvolvedStoresVo.involvedStoresService = involvedStoresService;
            //注入 involvedStoresService
            SysArchiveStoresLockersVo.archiveStoresLockersService = archiveStoresLockersService;
            //注入 archiveStoresService
            SysArchiveStoresByLockersIdVo.archiveStoresService = archiveStoresService;
            //注入 archiveStoresLockersService
            SysArchiveStoresByLockersIdVo.archiveStoresLockersService1 = archiveStoresLockersService;
            //注入 involvedTypesService
            SysInvolvedTypesVo.involvedTypesService = involvedTypesService;
            //注入 involvedLockersService
            SysInvolvedStoresLockersVo.involvedStoresLockersService = involvedStoresLockersService;
            //注入 bpipUserService
            SysBpipUserVo.bpipUserService=bpipUserService;
            //注入 recordPersonService
            SysRecordPersonVo.recordPersonService=recordPersonService;
            //注入 recordTypeService
            SysRecordTypeVo.recordTypeService=recordTypeService;
            //注入 codeService
            SysCodeVo.codeService = codeService;

            // 用户登录缓存字典信息，以后正式部署项目时可以放入整个context容器中做缓存

            //以下为ActiviUitls注入service
            //-------------------------------------------------------
            ActivitiUtils.repositoryService = repositoryService;
            ActivitiUtils.runtimeService = runtimeService;
            ActivitiUtils.taskService = taskService;
            ActivitiUtils.formService = formService;
            ActivitiUtils.historyService = historyService;
            //-------------------------------------------------------

            //缓存菜单功能
            dictoryService.doCacheForDictroy();
            //缓存菜单
            menuService.doCacheMenu();
            //缓存字典
            codeService.doCacheCode();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("系统启动，缓存出问题！");
        }
    }
}