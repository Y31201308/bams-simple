package com.pinhuba.core.iservice;

import java.util.ArrayList;
import java.util.List;
import com.pinhuba.common.module.UserMethodsInfo;
import com.pinhuba.common.pages.Pager;
import com.pinhuba.core.pojo.HrmEmployee;
import com.pinhuba.core.pojo.SysAttachmentInfo;
import com.pinhuba.core.pojo.SysColumnControl;
import com.pinhuba.core.pojo.SysException;
import com.pinhuba.core.pojo.SysImageInfo;
import com.pinhuba.core.pojo.SysLibraryInfo;
import com.pinhuba.core.pojo.SysMethodHelp;
import com.pinhuba.core.pojo.SysMethodInfo;
import com.pinhuba.core.pojo.SysParam;
import com.pinhuba.core.pojo.SysRole;
import com.pinhuba.core.pojo.SysRoleBind;
import com.pinhuba.core.pojo.SysRoleDetail;
import com.pinhuba.core.pojo.SysUserGroup;
import com.pinhuba.core.pojo.SysUserGroupDetail;
import com.pinhuba.core.pojo.SysUserInfo;
import com.pinhuba.core.pojo.SysUserMethods;

public interface ISysProcessService {
	public SysException saveSysException(SysException sysException);

	public List<SysMethodInfo> getSysMethodInfoList(ArrayList<String> ids);

	public List<SysMethodInfo> getMethodInfoListByUpCode(String code); // 获取功能列表

	public int getMethodInfoListByUpCodeCount(String code); // 统计功能数量

	public List<SysMethodInfo> listAllSysMethodInfoPager(SysMethodInfo sysMethodInfo, Pager pager);

	public int listAllSysMethodInfoCount(SysMethodInfo sysMethodInfo);

	public void delectMethodByids(String[] ids); // 删除功能菜单

	public void setMethodStatus(String[] ids); // 启用、禁用功能菜单

	public List<SysLibraryInfo> getSysLibraryInfoByInfo(SysLibraryInfo libraryInfo);

	public int getSysLibraryInfoCountByInfo(SysLibraryInfo libraryInfo);
	
	public SysLibraryInfo getSysLibraryInfo(SysLibraryInfo libraryInfo);

	public List<SysLibraryInfo> getSysLibraryInfoByInfoPager(SysLibraryInfo libraryInfo, Pager pager);

	public SysLibraryInfo saveSysLibraryInfo(SysLibraryInfo libraryInfo);
	
	public String getCode(String upcode, String table, String colname, String upcol);

	public List<SysLibraryInfo> getSysLibraryInfoByCode(String code);

	public SysLibraryInfo getSysLibraryByCode(String code);

	public SysLibraryInfo getSysLibraryInfoByPk(long pk);
	
	public String getSysLibraryNamesByPks(String[] pks);
	
	public List<SysLibraryInfo> getSysLibraryInfoByName(String name);

	public SysLibraryInfo setLibraryInfoStatusByPk(long pk, int status);

	public void setLibraryInfoBatchByPks(long[] pks);

	public void deleteLibraryInfoBatchByPks(long[] pks);

	public List<SysAttachmentInfo> saveAttachmentInfo(String fileNames, String empid);

	public List<SysImageInfo> saveImageInfo(String fileNames, String empid);

	public List<SysAttachmentInfo> getAttachmentInfoListByIds(String ids);
	public SysAttachmentInfo getAttachmentInfoByPk(long id);

	public List<SysImageInfo> getImageInfoListByIds(String ids);

	public void deleteAttachmentInfoListByIds(String ids, boolean bl);

	public void deleteImageInfoListByIds(String ids, boolean bl);

	public List<String> getEmployeeNamesByids(String ids);

	public List<String> getDeptNamesByIds(String ids);

	public SysUserInfo saveSysUserInfo(SysUserInfo user);

	public int getSysUserInfoCountByEmpId(String empid);
	
	public SysUserInfo getSysUserInfoByEmpId(String empid);

	public int getSysUserInfoByUserName(String username);

	public SysUserInfo getSysUserInfoByPk(long pk, boolean bl);

	public int getSysUserInfoCount();

	public int getSysUserInfoByUserNameEdit(String newusername, long userid);

	public ArrayList<SysUserInfo> saveSysUserInfo(ArrayList<SysUserInfo> list);

	public int getSysUserInfoListCount(SysUserInfo userinfo);

	public List<SysUserInfo> getSysUserInfoListByPager(SysUserInfo userinfo, Pager pager);

	public void updateSysUserInfoIsaction(long[] ids, int isaction, String empid);

	public List<SysUserGroupDetail> getSysUserGroupDetailList(int userId);

	public SysUserGroup saveSysUsergroupAndDetail(SysUserGroup group, String[] userIds);

	public List<SysUserGroup> listSysUserGroupBypager(SysUserGroup usergroup, Pager pager);
	public List<SysUserGroup> listSysUserGroupAll(SysUserGroup usergroup);

	public int listSysUserGroupCount(SysUserGroup usergroup);

	public SysUserGroup getSysUserGroupByPk(long pk);

	public void deleteSysUserGroupByIds(long[] ids);

	public List<Object[]> getEmployeeNameByuserIds(String userIds);

	public void updateSysUsergroupAndDetail(SysUserGroup group, String[] userIds, String empid, String nowtime);

	public List<SysMethodInfo> getSysMethodInfoListByCode(String code, int level);

	public SysRole saveRoleAndDetailBind(String empId, SysRole role, SysRoleBind[] binds, String[] methodIds);

	public int getSysRoleCount(SysRole role);

	public List<SysRole> getSysRoleByPager(SysRole role, Pager pager);
	public List<SysRole> getSysRoleAll(SysRole role);

	public void deleteSysRoleByIds(long[] ids);

	public List<SysRoleDetail> getSysRoleDetailList(int roleId);

	public SysRole getSysRoleById(long id);

	public List<SysRoleBind> getSysRoleBindList(int roleId);

	public List<String> getEmployeeNamesByUserIds(String ids);

	public List<String> getGroupNamesByIds(String ids);

	public List<String> getPostNamesByIds(String ids);

	public List<UserMethodsInfo> getUserMethodsInfoByPager(UserMethodsInfo info, Pager pager);

	public int getUserMethodsInfoCount(UserMethodsInfo info);

	public SysUserMethods getSysUserMethodsByUid(int uid);

	public void saveSysUserMethods(ArrayList<SysUserMethods> list);

	public UserMethodsInfo getUserMethodsInfoByUid(int uid);

	public int getSysParamCount(SysParam param);

	public List<SysParam> getSysParamByPager(SysParam param, Pager pager);

	public SysParam saveSysParam(SysParam param);

	public SysParam getSysParamByPk(long pk);

	public void deleteSysParamByPk(long pk);

	public List<SysParam> getAllSysParam();

	public void updateSysparams(ArrayList<SysParam> list);

	public HrmEmployee getEmployeeByPK(String employeePK);

	public int listSysExceptionCount(SysException sysException);

	public List<SysException> listAllSysException(SysException sysException, Pager pager);

	public SysException getSysExceptionByid(long id);

	public void delectSysExceptionsByid(long[] id);

	public void updateSysException(SysException sysException);
	
	//功能菜单
	public SysMethodInfo getSysMethodInfoByPK(String sid);
	public SysMethodInfo getSysMethodInfoByUri(String uri);
	public SysMethodInfo saveSysMethodInfo(SysMethodInfo info);
	public int getSysMethodInfoByLevelUnit(String levelUnit);
	public void deleteSysMethodInfoById(String sid);
	public boolean getCountBySysMethodInfoPK(String pk);//判断功能目录主键是否重复
	public int getSysMethodInfoByNameAndLevelUnit(String name,String levelunit,String PK);//根据上级目录和目录名称统计功能目录数量
	public List<SysMethodInfo> getSysMethodInfoListByPK(String pk);//根据节点查询下级信息

	//控制列名和显示
	public void deleteColumnControlById(long[] pks);
	public SysColumnControl saveColumnControl(SysColumnControl column);
	public SysColumnControl saveSysColumnControl(SysColumnControl sysColumnControl);
	public List<SysColumnControl> listAllSysColumnControl(SysColumnControl sysColumnControl);
	public List<SysColumnControl> listAllSysColumnControlPager(SysColumnControl sysColumnControl, Pager pager);
	public int listAllSysColumnControlCount(SysColumnControl sysColumnControl);
	public SysColumnControl getSysColumnControl(long pk);

	//帮助
	public int listSysMethodHelpCount(SysMethodHelp methodHelp);
	public List<SysMethodHelp> listSysMethodHelpByPager(SysMethodHelp methodHelp, Pager pager);
	public void deleteMethodHelpByIds(long[] pks);
	public SysMethodHelp saveSysMethodHelp(SysMethodHelp methodHelp);
	public SysMethodHelp getSysMethodHelpByPk(long pk);
	public List<SysMethodHelp> listSysMethodHelpByMethodId(String methodId);

	public List<SysMethodInfo> listSysmethodInfoByPage(String page);
}
