package com.utils;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by Administrator on 2018/4/9 0009.
 */

import java.math.BigDecimal;
import java.util.UUID;

import com.constant.CommonConstant;
import com.model.User;
import com.model.bean.UserBean;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.BigDecimalConverter;
import org.apache.commons.beanutils.converters.DateConverter;

import com.constant.WebExceptionConstant;
import com.exception.WebMessageException;
import org.apache.struts2.ServletActionContext;
import org.springframework.security.core.parameters.P;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 处理service的相关的东西
 */
public class ServiceUtils {
    /**
     * 生成主键策略
     * @return     主键字符串
     */
    public static String generatePrimaryKey(){
        return UUID.randomUUID().toString();
    }
	private static final BigDecimal BIGDECIMAL_ZERO = new BigDecimal("0");

	public static void copyProperties(Object dest,Object orig) throws WebMessageException {
    	try {
    		ConvertUtils.register(new DateConverter(null), java.util.Date.class);
			// 这里一定要注册默认值，使用null也可以
			BigDecimalConverter bd = new BigDecimalConverter(BIGDECIMAL_ZERO);
			ConvertUtils.register(bd, java.math.BigDecimal.class);
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException | InvocationTargetException e) {
			throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
		}
	}

	private HttpServletRequest request = ServletActionContext.getRequest();

	public static boolean hasPermissionAccessDept(String deptId) throws WebMessageException {
		ServiceUtils serviceUtils = new ServiceUtils();
		User user =(User) serviceUtils.request.getSession().getAttribute(SessionKey.USER);
		UserBean userBean = new UserBean();

		ServiceUtils.copyProperties(userBean, user);

		return hasPermissionAccessDept(userBean, deptId);
	}

	/**
	 *  判断  操作用户，是否有权限操作，此部门的信息
	 * @param currentUser						[必填]				当前操作用户
	 * @param deptId						    [必填]				当前操作部门id
	 * @return	是否有权限操作	true 为有权限，false 为无权
	 */
	public static boolean hasPermissionAccessDept(UserBean currentUser, String deptId){
		//非空校验
		if (CommonValidate.isEmpty(currentUser) || CommonValidate.isEmpty(deptId)
				|| CommonValidate.isEmpty(currentUser.getDeptId()) || CommonValidate.isEmpty(currentUser.getUserType())){
			return false;
		}
		//是否为超级管理员
		if (currentUser.isSuperAdmin()){
			return true;
		}

		//根据用户类型校验
		String userType = currentUser.getUserType();
		String userDeptID = currentUser.getDeptId();
		if (userType.equals(CommonConstant.USER_TYPE_ADMIN)){
			if (deptId.startsWith(userDeptID)){
				return true;
			}else {
				return false;
			}
		}else if (userType.equals(CommonConstant.USER_TYPE_JINGBANYUUAN)){
			if (deptId.equals(userDeptID)){
				return true;
			}else {
				return false;
			}
		}else if (userType.equals(CommonConstant.USER_TYPE_SYSTEM)){
			if (deptId.equals(userDeptID)){
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
//	public static void main(String[] args) {
//		UserBean userBean = new UserBean();
//		userBean.setId("03");
//		userBean.setDeptId("01");
//		userBean.setUserType(CommonConstant.USER_TYPE_JINGBANYUUAN);
//
//		System.out.println(hasPermissionAccessDept(userBean, "01"));
//
//		System.out.println(hasPermissionAccessDept(userBean, "03"));
//		System.out.println(hasPermissionAccessDept(userBean, "0101"));
//		System.out.println(hasPermissionAccessDept(userBean, "0303"));
//		System.out.println(hasPermissionAccessDept(userBean, "010304"));
//
//
//
//	}
}
