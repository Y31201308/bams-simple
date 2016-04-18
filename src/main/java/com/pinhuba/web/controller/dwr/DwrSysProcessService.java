package com.pinhuba.web.controller.dwr;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import com.pinhuba.common.module.ResultBean;
import com.pinhuba.common.module.SessionUser;
import com.pinhuba.common.module.UserMethodsInfo;
import com.pinhuba.common.pages.Pager;
import com.pinhuba.common.pages.PagerHelper;
import com.pinhuba.common.util.ConvertPinyin;
import com.pinhuba.common.util.EnumUtil;
import com.pinhuba.common.util.LoginContext;
import com.pinhuba.common.util.UtilTool;
import com.pinhuba.common.util.UtilWork;
import com.pinhuba.common.util.WebUtilWork;
import com.pinhuba.common.util.security.Base64;
import com.pinhuba.core.iservice.ISysProcessService;
import com.pinhuba.core.iservice.IUserLoginService;
import com.pinhuba.core.pojo.SysColumnControl;
import com.pinhuba.core.pojo.SysException;
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

/**
 * 系统管理
 */
@Controller
public class DwrSysProcessService {
	private final static Logger logger = Logger.getLogger(DwrSysProcessService.class);
	@Resource
	private ISysProcessService sysProcessService;
	@Resource
	private IUserLoginService userLoginService;

	public ResultBean saveColumnControl(ServletContext context, HttpServletRequest request, SysColumnControl column) {
		sysProcessService.saveColumnControl(column);
		return WebUtilWork.WebResultPack(null);
	}

	public ResultBean getColumnControlByPK(ServletContext context, HttpServletRequest request, long id) {
		SysColumnControl column = sysProcessService.getSysColumnControl(id);
		return WebUtilWork.WebObjectPack(column);
	}

	/**
	 * 显示所有列
	 * 
	 * @param context
	 * @param request
	 * @return
	 */
	public ResultBean listSysColumnControl(ServletContext context, HttpServletRequest request, SysColumnControl sysColumnControl, Pager pager) {
		List<SysColumnControl> list = null;
		pager = PagerHelper.getPager(pager, sysProcessService.listAllSysColumnControlCount(sysColumnControl));
		list = sysProcessService.listAllSysColumnControlPager(sysColumnControl, pager);
		logger.info("显示所有列...");
		return WebUtilWork.WebResultPack(list, pager);
	}

	public ResultBean deleteColumnControlById(ServletContext context, HttpServletRequest request, long[] pks) {
		sysProcessService.deleteColumnControlById(pks);
		return WebUtilWork.WebResultPack(null);
	}

	public ResultBean setColumnInfo(ServletContext context, HttpServletRequest request, long[] ids) {
		for (long id : ids) {
			SysColumnControl column = sysProcessService.getSysColumnControl(id);
			if (column.getIsShow() == EnumUtil.SYS_ISEDIT.EDIT.value) {
				column.setIsShow(EnumUtil.SYS_ISEDIT.No_EDIT.value);
			} else {
				column.setIsShow(EnumUtil.SYS_ISEDIT.EDIT.value);
			}
			sysProcessService.saveColumnControl(column);
		}
		return WebUtilWork.WebResultPack(null);
	}

	/**
	 * 设置排序
	 * 
	 * @param context
	 * @param request
	 * @param id
	 * @param flag
	 * @return
	 */
	public ResultBean setPriority(ServletContext context, HttpServletRequest request, long id, int flag) {
		SysColumnControl column = sysProcessService.getSysColumnControl(id);
		if (flag == EnumUtil.Tree_MOVE_Type.MOVE_DOWN.value) {
			column.setPriority(column.getPriority() + 1);
		} else if (flag == EnumUtil.Tree_MOVE_Type.MOVE_UP.value && column.getPriority() > 0) {
			column.setPriority(column.getPriority() - 1);
		}
		sysProcessService.saveColumnControl(column);
		return WebUtilWork.WebResultPack(null);
	}

	/**
	 * 根据表名显示列
	 * 
	 * @param context
	 * @param request
	 * @return
	 */
	public List<SysColumnControl> listColumn(SysColumnControl sysColumnControl) {
		List<SysColumnControl> list = sysProcessService.listAllSysColumnControl(sysColumnControl);
		logger.info("显示所有列...");
		return list;
	}

	/**
	 * 分页查询所有功能目录
	 * 
	 * @param context
	 * @param request
	 * @param methodinfo
	 * @param pager
	 * @return
	 */
	public ResultBean getSysMethodList(ServletContext context, HttpServletRequest request, SysMethodInfo methodinfo, Pager pager) {
		pager = PagerHelper.getPager(pager, sysProcessService.listAllSysMethodInfoCount(methodinfo));
		List<SysMethodInfo> list = sysProcessService.listAllSysMethodInfoPager(methodinfo, pager);
		for (SysMethodInfo method : list) {
			method.setUpSysMethodInfo(sysProcessService.getSysMethodInfoByPK(method.getLevelUnit()));
		}
		logger.info("显示所有目录信息...");
		return WebUtilWork.WebResultPack(list, pager);
	}

	public int getSysUserInfoCount(ServletContext context, HttpServletRequest request) {
		return sysProcessService.getSysUserInfoCount();
	}

	public SysMethodInfo getMethodInfoByPk(String pk) {
		return userLoginService.getMethodInfoByPk(pk);
	}

	public List<SysMethodInfo> getSysMethodInfoByUpCode(String code) {
		List<SysMethodInfo> methodList = null;

		// 限制目录层级，和权限分配有关
		SysMethodInfo tmp = sysProcessService.getSysMethodInfoByPK(code);
		if (tmp != null && tmp.getMethodLevel() == EnumUtil.SYS_METHOD_LEVEL.TWO.value) {
			methodList = new ArrayList<SysMethodInfo>();
		} else {
			methodList = sysProcessService.getMethodInfoListByUpCode(code);
		}
		return methodList;
	}

	public int getSysMethodInfoByUpCodeCount(String code) {
		int count = 0;
		SysMethodInfo tmp = sysProcessService.getSysMethodInfoByPK(code);
		if (tmp != null && tmp.getMethodLevel() == EnumUtil.SYS_METHOD_LEVEL.TWO.value) {
			return count;
		}
		return sysProcessService.getMethodInfoListByUpCodeCount(code);
	}

	public List<SysLibraryInfo> getSysLibraryInfoListBytree(HttpServletRequest request, SysLibraryInfo libraryInfo) {
		List<SysLibraryInfo> list = sysProcessService.getSysLibraryInfoByInfo(libraryInfo);
		return list;
	}

	public int getSysLibraryInfoCountListBytree(HttpServletRequest request, SysLibraryInfo libraryInfo) {
		int count = sysProcessService.getSysLibraryInfoCountByInfo(libraryInfo);
		return count;
	}

	public ResultBean getSysLibraryInfoListByPager(ServletContext context, HttpServletRequest request, SysLibraryInfo libraryInfo, Pager pager) {
		pager = PagerHelper.getPager(pager, sysProcessService.getSysLibraryInfoCountByInfo(libraryInfo));
		List<SysLibraryInfo> list = sysProcessService.getSysLibraryInfoByInfoPager(libraryInfo, pager);
		return WebUtilWork.WebResultPack(list, pager);
	}

	public ResultBean saveSysLibrayInfo(ServletContext context, HttpServletRequest request, SysLibraryInfo libraryInfo) {
		// 上级编码
		String code = UtilTool.getCodeByUpCode(context, request, libraryInfo.getLibraryInfoUpcode(), "sys_library_info", "library_info_code", "library_info_upcode");

		libraryInfo.setLibraryInfoCode(code);
		sysProcessService.saveSysLibraryInfo(libraryInfo);

		return WebUtilWork.WebResultPack(null);
	}

	public ResultBean updateSysLibraryInfo(ServletContext context, HttpServletRequest request, SysLibraryInfo libraryInfo) {
		sysProcessService.saveSysLibraryInfo(libraryInfo);
		return WebUtilWork.WebResultPack(null);
	}

	public ResultBean setSysLibraryInfoBypk(ServletContext context, HttpServletRequest request, long pk, int status) {
		sysProcessService.setLibraryInfoStatusByPk(pk, status);
		return WebUtilWork.WebResultPack(null);
	}

	public ResultBean setSysLibraryInfoByPks(ServletContext context, HttpServletRequest request, long[] pks) {
		sysProcessService.setLibraryInfoBatchByPks(pks);
		return WebUtilWork.WebResultPack(null);
	}

	public ResultBean deleteSysLibraryInfoByPks(ServletContext context, HttpServletRequest request, long[] pks) {
		sysProcessService.deleteLibraryInfoBatchByPks(pks);
		return WebUtilWork.WebResultPack(null);
	}

	public ResultBean getSysLibraryInfoByPk(ServletContext context, HttpServletRequest request, long pk) {
		SysLibraryInfo libraryInfo = sysProcessService.getSysLibraryInfoByPk(pk);
		if (libraryInfo.getLibraryInfoUpcode() != null && libraryInfo.getLibraryInfoUpcode().length() > 0) {
			SysLibraryInfo tmp = new SysLibraryInfo();
			tmp.setLibraryInfoCode(libraryInfo.getLibraryInfoUpcode());
			libraryInfo.setUpSysLibraryInfo(sysProcessService.getSysLibraryInfo(tmp));
		}
		List<SysLibraryInfo> list = new ArrayList<SysLibraryInfo>();
		list.add(libraryInfo);
		return WebUtilWork.WebResultPack(list);
	}

	public ResultBean saveSysUsers(ServletContext context, HttpServletRequest request, String[] empids, String[] usernames, String[] userpwds) {
		String empid = UtilTool.getEmployeeId(request);
		String nowtime = UtilWork.getNowTime();
		
		ArrayList<SysUserInfo> userlist = new ArrayList<SysUserInfo>();
		for (int i = 0; i < empids.length; i++) {
			SysUserInfo user = new SysUserInfo();
			user.setHrmEmployeeId(empids[i]);
			user.setUserName(usernames[i]);
			user.setUserpassword(Base64.getBase64FromString(userpwds[i]));
			user.setUserAction(EnumUtil.SYS_ISACTION.Vaild.value);
			user.setUserType(EnumUtil.SYS_USER_TYPE.DEFAULT.value);
			user.setRecordId(empid);
			user.setRecordDate(nowtime);
			user.setLastmodiId(empid);
			user.setLastmodiDate(nowtime);
			userlist.add(user);
		}
		sysProcessService.saveSysUserInfo(userlist);
		return WebUtilWork.WebResultPack(null);
	}

	public ResultBean saveSysUser(ServletContext context, HttpServletRequest request, SysUserInfo user) {
		// 判断用户名是否已用
		String empid = UtilTool.getEmployeeId(request);
		String nowtime = UtilWork.getNowTime();
		if (user.getPrimaryKey() > 0) {
			SysUserInfo tmp = sysProcessService.getSysUserInfoByPk(user.getPrimaryKey(), false);
			int usercount = sysProcessService.getSysUserInfoByUserNameEdit(user.getUserName().trim(), user.getPrimaryKey());
			if (usercount > 0) {
				return new ResultBean(false, "该用户名已存在!");
			}
			if (user.getUserName() != null && user.getUserName().trim().length() > 0) {
				tmp.setUserName(user.getUserName().trim());
			}
			if (user.getUserpassword() != null && user.getUserpassword().trim().length() > 0) {
				tmp.setUserpassword(Base64.getBase64FromString(user.getUserpassword().trim()));
			}
			if (user.getUserAction() != null && user.getUserAction().intValue() > 0) {
				tmp.setUserAction(user.getUserAction());
			}
			tmp.setLastmodiId(empid);
			tmp.setLastmodiDate(nowtime);
			sysProcessService.saveSysUserInfo(tmp);
		} else {
			
			int empcount = sysProcessService.getSysUserInfoCountByEmpId(user.getHrmEmployeeId());
			if (empcount > 0) {
				return new ResultBean(false, "该人员已注册为用户!");
			}
			int usercount = sysProcessService.getSysUserInfoByUserName(user.getUserName().trim());
			if (usercount > 0) {
				return new ResultBean(false, "该用户名已存在!");
			}
			String newpwd = Base64.getBase64FromString(user.getUserpassword().trim());
			user.setUserpassword(newpwd);
			user.setRecordId(empid);
			user.setRecordDate(nowtime);
			user.setLastmodiId(empid);
			user.setLastmodiDate(nowtime);
			sysProcessService.saveSysUserInfo(user);
		}
		return WebUtilWork.WebResultPack(null);
	}

	public ResultBean updateSysUserPassword(ServletContext context, HttpServletRequest request, String oldpwd, String newpwd) {
		SessionUser user = (SessionUser) LoginContext.getSessionValueByLogin(request);
		SysUserInfo userinfo = user.getUserInfo();
		SysUserInfo tmp = sysProcessService.getSysUserInfoByPk(userinfo.getPrimaryKey(), false);
		if (Base64.getBase64FromString(oldpwd.trim()).equals(tmp.getUserpassword())) {
			tmp.setUserpassword(Base64.getBase64FromString(newpwd.trim()));
			tmp.setLastmodiId(UtilTool.getEmployeeId(request));
			tmp.setLastmodiDate(UtilWork.getNowTime());
			sysProcessService.saveSysUserInfo(tmp);
		} else {
			return new ResultBean(false, "旧密码输入错误!");
		}
		return WebUtilWork.WebResultPack(null);
	}

	public ResultBean resetSysUserPassword(ServletContext context, HttpServletRequest request, long[] ids) {
		for (long l : ids) {
			SysUserInfo userInfo = sysProcessService.getSysUserInfoByPk(l, false);
			// 根据配置表中，获取初始密码
			String defaultPassword = UtilTool.getSysParamByIndex(request, "bams.user.initPwd");
			userInfo.setUserpassword(Base64.getBase64FromString(defaultPassword));
			sysProcessService.saveSysUserInfo(userInfo);
		}
		return WebUtilWork.WebResultPack(null);
	}

	public int vaildSysUserInfoByEmpId(ServletContext context, HttpServletRequest request, String empid) {
		return sysProcessService.getSysUserInfoCountByEmpId(empid);
	}

	public ResultBean vaildSysUserInfoByEmpIds(ServletContext context, HttpServletRequest request, String ids, String names, boolean convertpingyin, boolean showname) throws Exception {
		List<String[]> list = new ArrayList<String[]>();
		String[] empids = ids.split(",");
		String[] empnames = names.split(",");
		for (int i = 0; i < empids.length; i++) {
			if (empids[i] != null && empids[i].length() > 0) {
				int count = sysProcessService.getSysUserInfoCountByEmpId(empids[i]);
				if (showname && count > 0) {
					continue;
				}
				String[] tmps = new String[5];
				tmps[0] = empids[i];
				tmps[1] = empnames[i];
				String str = "";
				if (convertpingyin) {
					str = ConvertPinyin.getPinyin(empnames[i]);
				}
				tmps[2] = str;
				tmps[3] = UtilTool.getSysParamByIndex(request, "bams.user.initPwd");
				tmps[4] = String.valueOf(count);
				list.add(tmps);
			}
		}
		return WebUtilWork.WebResultPack(list);
	}

	public int vaildSysUserInfoByUserName(ServletContext context, HttpServletRequest request, String username) {
		return sysProcessService.getSysUserInfoByUserName(username);
	}

	public Integer[] vaildSysUserInfoByUserNames(ServletContext context, HttpServletRequest request, String[] usernames) {
		Integer[] count = new Integer[usernames.length];
		for (int i = 0; i < usernames.length; i++) {
			int c = sysProcessService.getSysUserInfoByUserName(usernames[i]);
			count[i] = c;
			if (c > 0) {
				break;
			}
		}
		return count;
	}

	public int vaildSysUserInfoByUserNameEdit(ServletContext context, HttpServletRequest request, String username) {
		SessionUser user = (SessionUser) LoginContext.getSessionValueByLogin(request);
		return sysProcessService.getSysUserInfoByUserNameEdit(username.trim(), user.getUserInfo().getPrimaryKey());
	}

	public ResultBean updateSysUserName(ServletContext context, HttpServletRequest request, String userpwd, String username) {
		SessionUser user = (SessionUser) LoginContext.getSessionValueByLogin(request);
		SysUserInfo userinfo = user.getUserInfo();
		SysUserInfo tmp = sysProcessService.getSysUserInfoByPk(userinfo.getPrimaryKey(), false);
		if (Base64.getBase64FromString(userpwd.trim()).equals(tmp.getUserpassword())) {
			int usercount = sysProcessService.getSysUserInfoByUserNameEdit(username.trim(), userinfo.getPrimaryKey());
			if (usercount > 0) {
				return new ResultBean(false, "该用户名已存在!");
			}
			tmp.setUserName(username.trim());
			tmp.setLastmodiId(UtilTool.getEmployeeId(request));
			tmp.setLastmodiDate(UtilWork.getNowTime());
			sysProcessService.saveSysUserInfo(tmp);
		} else {
			return new ResultBean(false, "密码输入错误!");
		}
		return WebUtilWork.WebResultPack(null);
	}

	public boolean vaildSysUserInfoOldPwd(ServletContext context, HttpServletRequest request, String oldpwd) {
		SessionUser user = (SessionUser) LoginContext.getSessionValueByLogin(request);
		SysUserInfo tmp = sysProcessService.getSysUserInfoByPk(user.getUserInfo().getPrimaryKey(), false);
		boolean bl = false;
		if (Base64.getBase64FromString(oldpwd.trim()).equals(tmp.getUserpassword())) {
			bl = true;
		}
		return bl;
	}

	public ResultBean listSysUserInfo(ServletContext context, HttpServletRequest request, SysUserInfo userinfo, Pager pager) {
		pager = PagerHelper.getPager(pager, sysProcessService.getSysUserInfoListCount(userinfo));
		List<SysUserInfo> userList = sysProcessService.getSysUserInfoListByPager(userinfo, pager);
		for (SysUserInfo sysUserInfo : userList) {
			sysUserInfo.setUserpassword(Base64.getStringFromBase64(sysUserInfo.getUserpassword()));
		}
		return WebUtilWork.WebResultPack(userList, pager);
	}

	/**
	 * 设置用户有效性
	 * 
	 * @param context
	 * @param request
	 * @param ids
	 *            主键
	 * @param isaction
	 * @return
	 */
	public ResultBean setSysUserInfoIsAction(ServletContext context, HttpServletRequest request, long[] ids, int isaction) {
		for (long l : ids) {
			SysUserInfo userInfo = sysProcessService.getSysUserInfoByPk(l, true);
			if (userInfo.getEmployee().getHrmEmployeeActive() == EnumUtil.SYS_ISACTION.No_Vaild.value) {
				return new ResultBean(false, userInfo.getUserName() + "用户人员已离职或人员信息被删除，不能进行有效性设置!");
			}
		}

		sysProcessService.updateSysUserInfoIsaction(ids, isaction, UtilTool.getEmployeeId(request));
		return WebUtilWork.WebResultPack(null);
	}

	public ResultBean getUserGroupDetailList(ServletContext context, HttpServletRequest request, String ids, String names, boolean isshow) {
		List<String[]> list = new ArrayList<String[]>();
		String[] userids = ids.split(",");
		String[] empnames = names.split(",");
		for (int i = 0; i < userids.length; i++) {
			if (userids[i] != null && userids[i].length() > 0) {
				// 查询用户是否已编组
				List<SysUserGroupDetail> detailList = sysProcessService.getSysUserGroupDetailList(Integer.parseInt(userids[i]));
				if (isshow && detailList.size() > 0) {
					continue;
				}
				String[] tmps = new String[3];
				tmps[0] = userids[i];
				tmps[1] = empnames[i];
				String str = "";
				for (SysUserGroupDetail detail : detailList) {
					str += detail.getUserGroup().getGroupName() + "<br/>";
				}
				tmps[2] = str;
				list.add(tmps);
			}
		}
		return WebUtilWork.WebResultPack(list);
	}

	public ResultBean saveSysUserGroupAndDetail(ServletContext context, HttpServletRequest request, SysUserGroup userGroup, String[] userIds) {
		String empid = UtilTool.getEmployeeId(request);
		String nowtime = UtilWork.getNowTime();
		if (userGroup.getPrimaryKey() > 0) {
			// 删除原明细
			sysProcessService.updateSysUsergroupAndDetail(userGroup, userIds, empid, nowtime);
		} else {
			userGroup.setRecordId(empid);
			userGroup.setRecordDate(nowtime);
			userGroup.setLastmodiId(empid);
			userGroup.setLastmodeDate(nowtime);
			sysProcessService.saveSysUsergroupAndDetail(userGroup, userIds);
		}
		return WebUtilWork.WebResultPack(null);
	}

	public ResultBean listSysUserGroupBypager(ServletContext context, HttpServletRequest request, SysUserGroup group, Pager pager) {
		pager = PagerHelper.getPager(pager, sysProcessService.listSysUserGroupCount(group));
		List<SysUserGroup> list = sysProcessService.listSysUserGroupBypager(group, pager);
		return WebUtilWork.WebResultPack(list, pager);
	}

	public List<SysUserGroup> listSysUserGroupAll(ServletContext context, HttpServletRequest request) {
		SysUserGroup group = new SysUserGroup();
		List<SysUserGroup> list = sysProcessService.listSysUserGroupAll(group);
		return list;
	}

	public ResultBean deleteSysUserGroupByIds(ServletContext context, HttpServletRequest requset, long[] ids) {
		sysProcessService.deleteSysUserGroupByIds(ids);
		return WebUtilWork.WebResultPack(null);
	}

	public ResultBean getSysUserGroupByPk(long pk) {
		return WebUtilWork.WebObjectPack(sysProcessService.getSysUserGroupByPk(pk));
	}

	public ResultBean getEmployeeNameByUserIds(ServletContext context, HttpServletRequest request, String userids) {
		List<Object[]> list = sysProcessService.getEmployeeNameByuserIds(userids);
		List<String> nameList = new ArrayList<String>();
		for (Object[] obj : list) {
			nameList.add((String) obj[0]);
		}
		return WebUtilWork.WebResultPack(nameList);
	}

	public ResultBean getSysMethodInfoList(ServletContext context, HttpServletRequest request, String upcode, int level) {
		List<SysMethodInfo> list = sysProcessService.getSysMethodInfoListByCode(upcode, level);
		return WebUtilWork.WebResultPack(list);
	}

	public ResultBean saveRoleAndDetailBind(ServletContext context, HttpServletRequest request, SysRole role, SysRoleBind[] binds, String[] methodIds) {
		String empId = UtilTool.getEmployeeId(request);
		sysProcessService.saveRoleAndDetailBind(empId, role, binds, methodIds);
		return WebUtilWork.WebResultPack(null);
	}

	public ResultBean listSysRoledetailByRoleId(int roleId) {
		List<SysRoleDetail> detailList = sysProcessService.getSysRoleDetailList(roleId);
		return WebUtilWork.WebResultPack(detailList);
	}

	public ResultBean listsysRoleByPager(ServletContext context, HttpServletRequest request, SysRole role, Pager pager) {
		pager = PagerHelper.getPager(pager, sysProcessService.getSysRoleCount(role));
		List<SysRole> roleList = sysProcessService.getSysRoleByPager(role, pager);
		return WebUtilWork.WebResultPack(roleList, pager);
	}

	public List<SysRole> listSysRoleAll(ServletContext context, HttpServletRequest request) {
		SysRole role = new SysRole();
		List<SysRole> roleList = sysProcessService.getSysRoleAll(role);
		return roleList;
	}

	public ResultBean deleteSysRoleByIds(ServletContext context, HttpServletRequest request, long[] ids) {
		sysProcessService.deleteSysRoleByIds(ids);
		return WebUtilWork.WebResultPack(null);
	}

	public ResultBean getSysRoleById(ServletContext context, HttpServletRequest request, long id) {
		SysRole role = sysProcessService.getSysRoleById(id);
		return WebUtilWork.WebObjectPack(role);
	}

	public ResultBean getSysRoleBindByRoleId(ServletContext context, HttpServletRequest request, int roleId) {
		List<SysRoleBind> bindList = sysProcessService.getSysRoleBindList(roleId);
		return WebUtilWork.WebResultPack(bindList);
	}

	public ResultBean getUserMethodsByPager(ServletContext context, HttpServletRequest request, UserMethodsInfo methodinfo, Pager pager) {
		pager = PagerHelper.getPager(pager, sysProcessService.getUserMethodsInfoCount(methodinfo));
		List<UserMethodsInfo> list = sysProcessService.getUserMethodsInfoByPager(methodinfo, pager);
		return WebUtilWork.WebResultPack(list, pager);
	}

	public SysUserMethods getSysUserMethodsByUserId(ServletContext context, HttpServletRequest request, String userids) {
		SysUserMethods method = null;
		if (userids.length() > 0) {
			if (userids.charAt(userids.length() - 1) == ',') {
				userids = userids.substring(0, userids.length() - 1);
			}
			String[] ids = userids.trim().split(",");
			if (ids.length == 1) {
				method = sysProcessService.getSysUserMethodsByUid(Integer.parseInt(ids[0]));
			}
		}
		return method;
	}

	public Set<String> getSysUserMethodsAllByUserId(ServletContext context, HttpServletRequest request, int userids, String show) {
		Set<String> methodset = new HashSet<String>();
		if (show == null || show.length() == 0) {
			SysUserMethods method = sysProcessService.getSysUserMethodsByUid(userids);
			if (method != null && method.getUserMethodDetail() != null && method.getUserMethodDetail().length() > 0) {
				String[] tmps = method.getUserMethodDetail().split(",");
				for (String string : tmps) {
					if (string != null && string.length() > 0) {
						methodset.add(string);
					}
				}
			}
		} else {
			methodset = userLoginService.getUserCompanyMethods((long) userids);
		}
		return methodset;
	}

	public ResultBean getUserMethodsInfoByUid(ServletContext context, HttpServletRequest request, int userids) {
		UserMethodsInfo info = sysProcessService.getUserMethodsInfoByUid(userids);
		return WebUtilWork.WebObjectPack(info);
	}

	public ResultBean updateSysUserMethods(ServletContext context, HttpServletRequest request, String userids, String[] methodIds) {
		ArrayList<SysUserMethods> methodslist = new ArrayList<SysUserMethods>();
		String ms = "";
		if (methodIds.length > 0) {
			for (int i = 0; i < methodIds.length; i++) {
				if (methodIds[i].length() > 0) {
					ms += methodIds[i] + ",";
				}
			}
		}
		if (userids.length() > 0) {
			if (userids.charAt(userids.length() - 1) == ',') {
				userids = userids.substring(0, userids.length() - 1);
			}
			String[] ids = userids.trim().split(",");
			for (String str : ids) {
				if (str != null && str.length() > 0) {
					SysUserMethods umthos = sysProcessService.getSysUserMethodsByUid(Integer.parseInt(str));
					umthos.setUserId(Integer.parseInt(str));
					umthos.setUserMethodDetail(ms);
					methodslist.add(umthos);
				}
			}
		}
		sysProcessService.saveSysUserMethods(methodslist);
		return WebUtilWork.WebResultPack(null);
	}

	/**
	 * 查询系统异常
	 * 
	 * @param context
	 * @param request
	 * @return ResultBean
	 */
	public ResultBean listSysException(ServletContext context, HttpServletRequest request, SysException sysException, Pager pager) {
		pager = PagerHelper.getPager(pager, sysProcessService.listSysExceptionCount(sysException));
		List<SysException> list = sysProcessService.listAllSysException(sysException, pager);

		logger.info("显示系统异常...");
		return WebUtilWork.WebResultPack(list, pager);
	}

	/**
	 * 删除系统异常
	 * 
	 * @param context
	 * @param request
	 * @return ResultBean
	 */
	public ResultBean delectSysExceptionsByid(ServletContext context, HttpServletRequest request, long[] ids) {

		try {
			sysProcessService.delectSysExceptionsByid(ids);
			logger.info("删除系统异常...");
		} catch (Exception e) {
			logger.error("删除系统异常出错..." + e.getMessage());
			return new ResultBean(false, e.getMessage());
		}
		return WebUtilWork.WebResultPack(null);
	}

	/**
	 * 更新系统异常
	 * 
	 * @param context
	 * @param request
	 * @return ResultBean
	 */
	public ResultBean updateSysException(ServletContext context, HttpServletRequest request, SysException sysException) {

		try {
			sysProcessService.updateSysException(sysException);
			logger.info("处理系统异常成功...");
		} catch (Exception e) {
			logger.error("处理系统异常出错..." + e.getMessage());
			return new ResultBean(false, e.getMessage());
		}
		return WebUtilWork.WebResultPack(null);
	}

	/**
	 * 根据ID获取系统异常
	 * 
	 * @param context
	 * @param request
	 * @return ResultBean
	 */
	public ResultBean getSysExceptionByPk(ServletContext context, HttpServletRequest request, long id) throws Exception {
		SysException sysException = sysProcessService.getSysExceptionByid(id);

		logger.info("根据ID获取系统异常...");
		List<SysException> list = new ArrayList<SysException>();
		list.add(sysException);
		return WebUtilWork.WebResultPack(list);
	}

	public ResultBean getSysParamBypager(ServletContext context, HttpServletRequest request, SysParam param, Pager pager) {
		pager = PagerHelper.getPager(pager, sysProcessService.getSysParamCount(param));
		List<SysParam> list = sysProcessService.getSysParamByPager(param, pager);
		return WebUtilWork.WebResultPack(list, pager);
	}

	public ResultBean saveSysparam(ServletContext context, HttpServletRequest request, SysParam param) {
		if (param.getPrimaryKey() > 0) {
			SysParam tmp = sysProcessService.getSysParamByPk(param.getPrimaryKey());
			param.setRecordId(tmp.getRecordId());
			param.setRecordDate(tmp.getRecordDate());
		} else {
			param.setRecordId(UtilTool.getEmployeeId(request));
			param.setRecordDate(UtilWork.getNowTime());
		}
		param.setLastmodiId(UtilTool.getEmployeeId(request));
		param.setLastmodiDate(UtilWork.getNowTime());
		sysProcessService.saveSysParam(param);
		return WebUtilWork.WebResultPack(null);
	}

	public ResultBean getSysParamByPk(ServletContext context, HttpServletRequest request, long pk) {
		SysParam tmp = sysProcessService.getSysParamByPk(pk);
		return WebUtilWork.WebObjectPack(tmp);
	}

	public ResultBean deleteSysParamByPk(ServletContext context, HttpServletRequest request, long pk) {
		sysProcessService.deleteSysParamByPk(pk);
		return WebUtilWork.WebResultPack(null);
	}

	public List<SysParam> getAllSysParam(ServletContext context, HttpServletRequest request) {
		return sysProcessService.getAllSysParam();
	}

	public ResultBean updateSysParams(ServletContext context, HttpServletRequest request, SysParam[] params) {
		ArrayList<SysParam> list = new ArrayList<SysParam>();
		for (SysParam sysParam : params) {
			SysParam tmp = sysProcessService.getSysParamByPk(sysParam.getPrimaryKey());
			tmp.setParamValue(sysParam.getParamValue());
			tmp.setLastmodiId(UtilTool.getEmployeeId(request));
			tmp.setLastmodiDate(UtilWork.getNowTime());
			list.add(tmp);
		}
		sysProcessService.updateSysparams(list);

		return WebUtilWork.WebResultPack(null);
	}

	/**
	 * 根据编号获取功能目录
	 * 
	 * @param context
	 * @param request
	 * @param id
	 * @return
	 */
	public ResultBean getSysMethodInfoByPK(ServletContext context, HttpServletRequest request, String id) {
		List<SysMethodInfo> list = new ArrayList<SysMethodInfo>();
		SysMethodInfo info = sysProcessService.getSysMethodInfoByPK(id);

		// 加载上级功能菜单信息
		if (info.getLevelUnit() != null && info.getLevelUnit().length() > 0) {
			SysMethodInfo me = sysProcessService.getSysMethodInfoByPK(info.getLevelUnit());
			if (me != null) {
				info.setUpSysMethodInfo(me);
			}
		}

		list.add(info);

		logger.info("根据主键获取功能目录...");
		return WebUtilWork.WebResultPack(list);
	}

	/**
	 * 删除功能目录
	 * 
	 * @param context
	 * @param request
	 * @param ids
	 *            主键
	 * @return
	 */
	public ResultBean deleteSysMethodInfoById(ServletContext context, HttpServletRequest request, String[] ids) {
		for (String s : ids) {
			SysMethodInfo info = sysProcessService.getSysMethodInfoByPK(s);

			// if(info.getIsAction() == EnumUtil.SYS_ISACTION.Vaild.value){
			// return new
			// ResultBean(false,info.getMethodInfoName()+"为有效状态，不能删除！");
			// }

			int count = sysProcessService.getMethodInfoListByUpCodeCount(info.getPrimaryKey());
			if (count > 0) {
				return new ResultBean(false, info.getMethodInfoName() + "有下级功能目录，不能删除！");
			}
		}
		sysProcessService.delectMethodByids(ids);

		logger.info("删除功能目录...");
		return WebUtilWork.WebResultPack(null);
	}

	/**
	 * 启用/禁用 功能菜单
	 * 
	 * @param context
	 * @param request
	 * @param ids
	 * @return
	 */
	public ResultBean setMethodInfoStatus(ServletContext context, HttpServletRequest request, String[] ids) {
		sysProcessService.setMethodStatus(ids);
		logger.info("设置功能菜单状态...");
		return WebUtilWork.WebResultPack(null);
	}

	/**
	 * 新增功能目录
	 * 
	 * @param context
	 * @param request
	 * @param method
	 * @return
	 */
	public ResultBean saveMethod(ServletContext context, HttpServletRequest request, SysMethodInfo method) {

		// 判断上级节点是否为空，不为空表示有上级节点。为空表示没有上级节点，则为顶级节点。
		if (StringUtils.isNotBlank(method.getLevelUnit())) {

			SysMethodInfo info = sysProcessService.getSysMethodInfoByPK(method.getLevelUnit());
			int upMethodLevel = info.getMethodLevel();
			if (upMethodLevel == -1)
				method.setMethodLevel(1);// 如果上级为-1，设置为第一级
			else
				method.setMethodLevel(upMethodLevel + 1);

		} else {
			method.setLevelUnit("-1");// 上级节点为空时
			method.setMethodLevel(-1);
		}

		int c = sysProcessService.getSysMethodInfoByNameAndLevelUnit(method.getMethodInfoName(), method.getLevelUnit(), method.getPrimaryKey());
		if (c > 0) {
			return new ResultBean(false, "同一级别下，功能目录名称不能重名！");
		}

		String code = UtilTool.getCodeByUpCode(context, request, method.getLevelUnit(), "sys_method_info", "method_info_id", "level_unit");
		method.setPrimaryKey(code);// 设置主键（编号）
		int count = sysProcessService.getMethodInfoListByUpCodeCount(method.getLevelUnit());
		method.setMethodNo(count + 1);// 设置默认排序值

		sysProcessService.saveSysMethodInfo(method);
		logger.info("新增功能目录...");
		return WebUtilWork.WebResultPack(null);
	}

	/**
	 * 编辑功能目录信息
	 * 
	 * @param context
	 * @param request
	 * @param info
	 * @return
	 */
	public ResultBean updateSysMethodInfo(ServletContext context, HttpServletRequest request, SysMethodInfo method) {
		if (StringUtils.isBlank(method.getLevelUnit())) {
			method.setLevelUnit("-1");
		}

		SysMethodInfo methodinfo = sysProcessService.getSysMethodInfoByPK(method.getPrimaryKey());
		int count = sysProcessService.getSysMethodInfoByNameAndLevelUnit(method.getMethodInfoName(), method.getLevelUnit(), method.getPrimaryKey());
		if (count > 0) {
			return new ResultBean(false, "同一级别下，功能目录名称不能重名！");
		}

		if (!method.getLevelUnit().equals(methodinfo.getLevelUnit())) {// 上级编码未变动
			boolean bl = false;
			// 判断上级目录是否为自己和自己的下级目录
			List<SysMethodInfo> list = sysProcessService.getSysMethodInfoListByPK(methodinfo.getPrimaryKey());
			for (SysMethodInfo smi : list) {
				if (smi.getPrimaryKey().equals(method.getLevelUnit())) {
					bl = true;
					break;
				}
			}
			if (bl) {
				return new ResultBean(false, "上级目录不能为自己和自己的下级目录!");
			}
		}
		sysProcessService.saveSysMethodInfo(method);

		logger.info("编辑功能目录信息...");
		return WebUtilWork.WebResultPack(null);
	}

	/**
	 * 根据uri获得功能目录
	 * 
	 * @param context
	 * @param request
	 * @param uri
	 * @return
	 */
	public SysMethodInfo getSysMethodInfoByUri(ServletContext context, HttpServletRequest request, String uri) {
		return sysProcessService.getSysMethodInfoByUri(uri);
	}

	
	/**
	 * 根据empId获取用户名 2014-02-06 JC
	 * 
	 * @param context
	 * @param request
	 * @param empId
	 * @return
	 */
	public SysUserInfo getSysUserInfoByEmpId(ServletContext context, HttpServletRequest request, String empId) {
		return sysProcessService.getSysUserInfoByEmpId(empId);
	}

	public ResultBean listSysMethodHelpByPager(ServletContext context, HttpServletRequest request, SysMethodHelp methodHelp, Pager pager) {
		pager = PagerHelper.getPager(pager, sysProcessService.listSysMethodHelpCount(methodHelp));
		List<SysMethodHelp> list = sysProcessService.listSysMethodHelpByPager(methodHelp, pager);

		for (SysMethodHelp sysMethodHelp : list) {
			sysMethodHelp.setMethodInfo(sysProcessService.getSysMethodInfoByPK(sysMethodHelp.getMethodId()));
		}

		return WebUtilWork.WebResultPack(list, pager);
	}

	public ResultBean getSysMethodHelpByPk(ServletContext context, HttpServletRequest request, long pk) {
		SysMethodHelp methodHelp = sysProcessService.getSysMethodHelpByPk(pk);

		if (StringUtils.isNotBlank(methodHelp.getMethodId())) {
			methodHelp.setMethodInfo(sysProcessService.getSysMethodInfoByPK(methodHelp.getMethodId()));
		}

		return WebUtilWork.WebObjectPack(methodHelp);
	}

	public ResultBean deleteMethodHelpByIds(ServletContext context, HttpServletRequest request, long[] pks) {
		sysProcessService.deleteMethodHelpByIds(pks);
		return WebUtilWork.WebResultPack(null);
	}

	public ResultBean saveSysMethodHelp(ServletContext context, HttpServletRequest request, SysMethodHelp methodHelp) {
		sysProcessService.saveSysMethodHelp(methodHelp);
		return WebUtilWork.WebResultPack(null);
	}

	public ResultBean updateSysMethodHelp(ServletContext context, HttpServletRequest request, SysMethodHelp methodHelp) {
		sysProcessService.saveSysMethodHelp(methodHelp);
		return WebUtilWork.WebResultPack(null);
	}

	public List<SysMethodHelp> listSysMethodHelpByMethodId(ServletContext context, HttpServletRequest request, String methodId) {
		List<SysMethodHelp> helpList = sysProcessService.listSysMethodHelpByMethodId(methodId);
		return helpList;
	}
	
	public List<SysMethodInfo> listSysmethodInfoByPage(ServletContext context, HttpServletRequest request, String page) {
		List<SysMethodInfo> list = sysProcessService.listSysmethodInfoByPage(page);
		return list;
	}
}
