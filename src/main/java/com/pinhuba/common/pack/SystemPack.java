package com.pinhuba.common.pack;

import com.pinhuba.common.module.UserMethodsInfo;
import com.pinhuba.common.util.EnumUtil;
import com.pinhuba.core.pojo.HrmEmployee;
import com.pinhuba.core.pojo.SysColumnControl;
import com.pinhuba.core.pojo.SysException;
import com.pinhuba.core.pojo.SysLibraryInfo;
import com.pinhuba.core.pojo.SysMethodHelp;
import com.pinhuba.core.pojo.SysMethodInfo;
import com.pinhuba.core.pojo.SysParam;
import com.pinhuba.core.pojo.SysRole;
import com.pinhuba.core.pojo.SysUserGroup;
import com.pinhuba.core.pojo.SysUserInfo;

/**
 * 系统后台设置
 * @author peng.ning
 * @date   Mar 4, 2010
 */
public class SystemPack {
	
	//==========用户管理 ======================
	
	public static String getSysUserInfoSql(SysUserInfo userinfo){
		StringBuffer result = new StringBuffer();
		result.append("select distinct sysuser.* from sys_user_info sysuser,hrm_employee emp,hrm_department dep where sysuser.hrm_employee_id = emp.hrm_employee_id and emp.hrm_employee_depid = dep.dep_id ");
		if (userinfo.getEmployee()!=null) {
			if (userinfo.getEmployee().getHrmEmployeeName()!=null&&userinfo.getEmployee().getHrmEmployeeName().length()>0) {
				result.append(" and emp.hrm_employee_name like '%"+userinfo.getEmployee().getHrmEmployeeName()+"%'");
			}
			if (userinfo.getEmployee().getHrmEmployeeDepidTree()!=null&&userinfo.getEmployee().getHrmEmployeeDepidTree().length()>0) {
				result.append(" and dep.dep_id  in ("+userinfo.getEmployee().getHrmEmployeeDepidTree()+") ");
			}
		}
		if (userinfo.getUserName()!=null&&userinfo.getUserName().length()>0) {
			result.append(" and sysuser.user_name like '%"+userinfo.getUserName()+"%'");
		}
		if (userinfo.getUserAction()!=null&&userinfo.getUserAction()>0) {
			result.append(" and sysuser.user_action = "+userinfo.getUserAction()+"");
		}
		return result.toString();
	}
	
	public static String getSysUserGroupSql(SysUserGroup group){
		StringBuffer result = new StringBuffer();
		HqlPack.getStringLikerPack(group.getGroupName(), "groupName", result);
		return result.toString();
	}
	
	public static String getEmployeeNameByUserIdsSql(String userIds){
		StringBuffer result = new StringBuffer();
		result.append("select distinct hrm.hrm_employee_name from sys_user_info suser,hrm_employee hrm where  hrm.hrm_employee_id = suser.hrm_employee_id");
		if (userIds!=null&&userIds.length()>0) {
			result.append(" and suser.user_id in ( "+userIds+" )");
		}
		return result.toString();
	}
	
	//=============角色=================
	public static String getSysRoleSql(SysRole role){
		StringBuffer result = new StringBuffer();
		HqlPack.getStringLikerPack(role.getRoleName(), "roleName", result);
		return result.toString();
	}
	
	//=========权限==================
	
	public static String getSysUserMethodSql(UserMethodsInfo info){
		StringBuffer result = new StringBuffer();
		result.append("select  userinfo.user_id,emp.hrm_employee_id,emp.hrm_employee_name,emp.hrm_employee_post_id,emp.hrm_part_post,dept.dep_id,dept.hrm_dep_name ");
		result.append("from sys_user_info userinfo,hrm_employee emp,hrm_department dept,sys_user_methods usermethod ");
		result.append("where userinfo.hrm_employee_id =emp.hrm_employee_id and emp.hrm_employee_depid = dept.dep_id and usermethod.user_id = userinfo.user_id ");
		result.append("and userinfo.user_action="+EnumUtil.SYS_ISACTION.Vaild.value);
		if (info.getEmployeeName()!=null&&info.getEmployeeName().length()>0) {
			result.append(" and emp.hrm_employee_name like '%"+info.getEmployeeName()+"%'");
		}
		if (info.getUpcode()!=null&&info.getUpcode().length()>0) {
			result.append(" and emp.hrm_employee_depid in ("+info.getUpcode()+")");
		}
		if (info.getPrimaryKey()!=null&&info.getPrimaryKey()>0) {
			result.append(" and userinfo.user_id = "+info.getPrimaryKey());
		}
		return result.toString();
	}
	
	/**
	 * pack system exception sql
	 * 
	 */
	public static String getSysExceptionSql(SysException sysException) {
		StringBuffer result = new StringBuffer();
		result.append("select exc.*,users.user_name from sys_exception exc,sys_user_info users where exc.user_id=users.user_id");
		if (sysException.getUserInfo() != null) {
			SqlPack.getStringLikerPack(sysException.getUserInfo().getUserName(), "users.user_name", result);
		}
		SqlPack.getStringLikerPack(sysException.getExceptionClass(), "exc.exception_class", result);
		SqlPack.timeBuilder(sysException.getExceptionDate(), "exc.exception_date", result,false,false);
		SqlPack.getStringLikerPack(sysException.getExceptionMsg(), "exc.exception_msg", result);
		SqlPack.getNumEqualPack(sysException.getExceptionStatus(), "exc.exception_status",result);
		
		result.append(" order by exc.exception_date desc");
		
		return result.toString();
	}
	
	public static String getSysParamSlq(SysParam param){
		StringBuffer result = new StringBuffer();
		HqlPack.getStringLikerPack(param.getParamIndex(), "paramIndex", result);
		HqlPack.getStringLikerPack(param.getParamTitle(), "paramTitle", result);
		HqlPack.getNumEqualPack(param.getParamType(), "paramType", result);
		return result.toString();
	}
	
	public static String packEmployeeQuery(HrmEmployee employee) {
       StringBuffer result = new StringBuffer();
       HqlPack.getStringLikerPack(employee.getHrmEmployeeName(), "hrmEmployeeName", result);
       HqlPack.getStringLikerPack(employee.getHrmEmployeeCode(), "hrmEmployeeCode", result);
       HqlPack.getNumEqualPack(employee.getHrmEmployeeSquadId(), "hrmEmployeeSquadId", result);
       HqlPack.getNumEqualPack(employee.getHrmEmployeeDepid(), "hrmEmployeeDepid", result);
       HqlPack.getInPack(employee.getHrmEmployeeDepidTree(), "hrmEmployeeDepid", result);
       HqlPack.getNumEqualPack(EnumUtil.SYS_ISACTION.Vaild.value, "hrmEmployeeActive", result);
		return result.toString();
	}
	
	/**
	 * 系统目录管理
	 * @param sysMethodInfo
	 * @return
	 */
	public static String packSysMethodInfo(SysMethodInfo info) {
		StringBuffer result = new StringBuffer();
		HqlPack.getStringLikerPack(info.getPrimaryKey(), "primaryKey", result);
		HqlPack.getStringLikerPack(info.getMethodInfoName(), "methodInfoName", result);
		HqlPack.getStringLikerPack(info.getMethodInfoEngname(), "methodInfoEngname", result);
		HqlPack.getNumEqualPack(info.getMethodLevel(), "methodLevel", result, -2);
		HqlPack.getNumEqualPack(info.getIsAction(), "isAction", result);
		HqlPack.getNumEqualPack(info.getMethodNo(), "methodNo", result);
		HqlPack.getStringRightLikerPack(info.getLevelUnit(), "levelUnit", result);
		return result.toString();
	}
	
	/**
	 * 查询页面显示列查询
	 * @param sysColumnControl
	 * @return
	 */
	public static String packSysColumn(SysColumnControl sysColumnControl) {
		StringBuffer result = new StringBuffer();

		HqlPack.getNumEqualPack(sysColumnControl.getPrimaryKey(),"primaryKey",result);
		HqlPack.getNumEqualPack(sysColumnControl.getIsShow(),"isShow",result);
		HqlPack.getStringEqualPack(sysColumnControl.getTableName(),"tableName",result);
		HqlPack.getStringEqualPack(sysColumnControl.getColumnName(),"columnName",result);
		HqlPack.getStringEqualPack(sysColumnControl.getColumnCode(),"columnCode",result);
		result.append(" order by model.priority asc");	
		return result.toString();
	}
	
	/**
	 * 查询页面显示列查询
	 * @param sysColumnControl
	 * @return
	 */
	public static String packSysColumnControlQuery(SysColumnControl sysColumnControl) {
		StringBuffer result = new StringBuffer();
		
		HqlPack.getNumEqualPack(sysColumnControl.getPrimaryKey(),"primaryKey",result);
		HqlPack.getNumEqualPack(sysColumnControl.getIsShow(),"isShow",result);
		HqlPack.getStringLikerPack(sysColumnControl.getTableName(),"tableName",result);
		HqlPack.getStringLikerPack(sysColumnControl.getColumnName(),"columnName",result);
		HqlPack.getStringLikerPack(sysColumnControl.getColumnCode(),"columnCode",result);
		result.append(" order by model.tableName,model.priority asc");
		return result.toString();
	}
	
	
	/**
	 * 业务字典表查询
	 * @param library
	 * @return
	 */
	public static String packSysLibraryInfo(SysLibraryInfo library){
		StringBuffer result = new StringBuffer();
		HqlPack.getStringEqualPack(library.getLibraryInfoCode(), "libraryInfoCode", result);
		HqlPack.getStringLikerPack(library.getLibraryInfoName(), "libraryInfoName", result);
		HqlPack.getStringEqualPack(library.getLibraryInfoUpcode(), "libraryInfoUpcode", result);
		HqlPack.getNumEqualPack(library.getLibraryInfoIsvalid(), "libraryInfoIsvalid",result);
		return result.toString();
	}
	
	public static String packSysMethodHelp(SysMethodHelp methodHelp) {

		StringBuffer result = new StringBuffer();
		result.append("select help.* from sys_method_help help,sys_method_info info where help.method_id = info.method_info_id ");
		SqlPack.getStringLikerPack(methodHelp.getMethodName(), "info.method_info_name", result);

		return result.toString();
	}
	
	/**
	 * 取得下级菜单
	 * @param code 上级编码
	 * @param level 等级
	 * @param bl 是否取得系统菜单
	 * @return
	 */
	public static String packSysMethodInfoByTree(String code){
		StringBuffer result = new StringBuffer();
		HqlPack.getStringEqualPack(code, "levelUnit", result);
		HqlPack.getNumNOEqualPack(-1, "methodNo", result);
		HqlPack.getNumEqualPack(EnumUtil.SYS_ISACTION.Vaild.value, "isAction", result);
		return result.toString();
	}
	
}
