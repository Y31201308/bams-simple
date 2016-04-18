package com.pinhuba.common.util;

import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import com.pinhuba.common.module.ResultBean;
import com.pinhuba.common.module.SessionUser;
import com.pinhuba.core.pojo.HrmDepartment;
import com.pinhuba.core.pojo.SysAttachmentInfo;
import com.pinhuba.core.pojo.SysColumnControl;
import com.pinhuba.core.pojo.SysImageInfo;
import com.pinhuba.core.pojo.SysLibraryInfo;
import com.pinhuba.core.pojo.SysMethodHelp;
import com.pinhuba.core.pojo.SysMethodInfo;
import com.pinhuba.core.pojo.SysRoleDetail;
import com.pinhuba.core.pojo.SysUserInfo;
import com.pinhuba.core.pojo.SysUserMethods;
import com.pinhuba.web.controller.dwr.DwrCommonService;
import com.pinhuba.web.controller.dwr.DwrHrmEmployeeService;
import com.pinhuba.web.controller.dwr.DwrSysProcessService;
import com.pinhuba.web.taglib.table.SysGridColumnBean;
import com.pinhuba.web.taglib.table.SysGridTitleBean;
import com.pinhuba.web.taglib.table.cloumntype.TextType;

public class UtilTool {
	Logger log = Logger.getLogger(UtilTool.class);

	public static List<SysColumnControl> getColumnShow(ServletContext servletContext, String tableName) {
		WebApplicationContext webAppContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		DwrSysProcessService sysProcessService = (DwrSysProcessService) webAppContext.getBean("dwrSysProcessService");
		SysColumnControl columnControl = new SysColumnControl();
		columnControl.setTableName(tableName);

		List<SysColumnControl> resultList = sysProcessService.listColumn(columnControl);
		return resultList;
	}

	public static ArrayList<SysGridColumnBean> getGridColumnList(List<SysColumnControl> sysList) {
		ArrayList<SysGridColumnBean> bcList = new ArrayList<SysGridColumnBean>();
		for (SysColumnControl sysColumnControl : sysList) {
			SysGridColumnBean bc = new SysGridColumnBean();
			bc.setDataName(sysColumnControl.getColumnCode());
			bc.setShowName(sysColumnControl.getColumnName());
			if (sysColumnControl.getIsShow() == EnumUtil.SYS_ISACTION.Vaild.value) {
				bc.setShowColumn(true);
			} else {
				bc.setShowColumn(false);
			}
			if (sysColumnControl.getIsshowSimple() == EnumUtil.SYS_ISACTION.Vaild.value) {
				bc.setShowQuerySelsect(true);
			} else {
				bc.setShowQuerySelsect(false);
			}
			if (sysColumnControl.getIsshowAdvanced() == EnumUtil.SYS_ISACTION.Vaild.value) {
				bc.setShowAdvanced(true);
			} else {
				bc.setShowAdvanced(false);
			}
			bc.setColumnTypeClass(new TextType());
			bc.setColumnReplace("null");
			bc.setColumnStrCount(sysColumnControl.getColumnStrcount());
			bc.setColumnToObject(true);
			bcList.add(bc);
		}
		return bcList;
	}

	public static SysMethodInfo getSysMethodInfoByPk(ServletContext context, String pk) {
		WebApplicationContext webAppContext = WebApplicationContextUtils.getWebApplicationContext(context);
		DwrSysProcessService sysProcessService = (DwrSysProcessService) webAppContext.getBean("dwrSysProcessService");
		return sysProcessService.getMethodInfoByPk(pk);
	}

	/**
	 * 根据上级编码获取下级编码
	 * 
	 * @param context
	 * @param request
	 * @param upcode
	 *            上级编码
	 * @param table
	 *            表名称
	 * @param colname
	 *            编码列名
	 * @param upcol
	 *            上级编码列名
	 * @return
	 */
	public static String getCodeByUpCode(ServletContext context, HttpServletRequest request, String upcode, String table, String colname, String upcol) {
		WebApplicationContext webAppContext = WebApplicationContextUtils.getWebApplicationContext(context);
		DwrCommonService commonService = (DwrCommonService) webAppContext.getBean("dwrCommonService");
		return commonService.getCodeByTable(context, request, upcode, table, colname, upcol);
	}

	public static String getEmployeeId(HttpServletRequest request) {
		SessionUser user = (SessionUser) LoginContext.getSessionValueByLogin(request);
		return user.getEmployeeInfo().getPrimaryKey();
	}

	public static long getDeptId(HttpServletRequest request) {
		SessionUser user = (SessionUser) LoginContext.getSessionValueByLogin(request);
		return user.getDepartmentInfo().getPrimaryKey();
	}

	public static void writeTextXml(HttpServletResponse response, String xml) throws Exception {
		if (xml.length() > 0) {
			response.setContentType("text/xml; charset=UTF-8");
			PrintWriter pw = response.getWriter();
			pw.print(xml.replaceAll("&", "&amp;"));
			pw.flush();
			pw.close();
		}
	}

	/**
	 * 将字符串转为select
	 * 
	 * @param enumString
	 * @return
	 */
	public static String getSelectOptionsByEnum(String enumString) {
		StringBuffer tmp = new StringBuffer();
		if (enumString != null && enumString.length() > 0) {
			String[] options = enumString.split("\\|");
			for (int j = 0; j < options.length; j++) {
				String[] tmpstr = options[j].split(",");
				String ck = "";
				tmp.append("<option value ='" + tmpstr[0] + "' " + ck + ">" + tmpstr[1] + "</option>\n");
			}
		}
		return tmp.toString();
	}
	
	/**
	 * 将字符串转为select option标签不换行
	 * 
	 * @param enumString
	 * @return
	 */
	public static String getSelectOptionsByEnumNo(String enumString) {
		StringBuffer tmp = new StringBuffer();
		if (enumString != null && enumString.length() > 0) {
			String[] options = enumString.split("\\|");
			for (int j = 0; j < options.length; j++) {
				String[] tmpstr = options[j].split(",");
				String ck = "";
				tmp.append("<option value ='" + tmpstr[0] + "' " + ck + ">" + tmpstr[1] + "</option>");
			}
		}
		return tmp.toString();
	}
	
	/**
	 * 将字符串转为select
	 * 
	 * @param enumString
	 * @return
	 */
	public static String getSelectOptionsByEnum(String[] enumString) {
		StringBuffer tmp = new StringBuffer();
		if (enumString != null && enumString.length > 0) {
			if(enumString[0]!=null&&enumString[0].length()>0){
				String[] options = enumString[0].split("\\|");
				String pk = enumString[1];
				for (int j = 0; j < options.length; j++) {
					String[] tmpstr = options[j].split(",");
					if(tmpstr[0].trim().equalsIgnoreCase(pk)){
						tmp.append("<option value ='" + tmpstr[0] + "' selected='selected'>" + tmpstr[1] + "</option>\n");
					}else{
						tmp.append("<option value ='" + tmpstr[0] + "'>" + tmpstr[1] + "</option>\n");
					}
				}
			}
		}
		return tmp.toString();
	}
	
	/**
	 * 将字符串转为radio
	 * 
	 * @param enumString
	 * @return
	 */
	public static String getRadioOptionsByEnum(String enumString , String nameStr) {
		StringBuffer tmp = new StringBuffer();
		if (enumString != null && enumString.length() > 0) {
			String[] options = enumString.split("\\|");
			for (int j = 0; j < options.length; j++) {
				String[] tmpstr = options[j].split(",");
				if(j == 0){
					//第一个选项，设置为默认
					tmp.append("<input type=\"radio\" id='" + tmpstr[1] + "' value ='" + tmpstr[0] + "' name ='" + nameStr + "' checked='checked'>");
				}else{
					tmp.append("<input type=\"radio\" id='" + tmpstr[1] + "' value ='" + tmpstr[0] + "' name ='" + nameStr + "'>");
				}
				tmp.append("<label for='" + tmpstr[1] + "' style='padding-right:10px'>" + tmpstr[1] + "</label>");
			}
		}
		return tmp.toString();
	}
	
	/**
	 * 将字符串转为checkbox
	 * 
	 * @param enumString
	 * @return
	 */
	public static String getCheckboxOptionsByEnum(String enumString , String nameStr) {
		StringBuffer tmp = new StringBuffer();
		if (enumString != null && enumString.length() > 0) {
			String[] options = enumString.split("\\|");
			for (int j = 0; j < options.length; j++) {
				String[] tmpstr = options[j].split(",");
				tmp.append("<input type=\"checkbox\" id='" + tmpstr[1] + "' value ='" + tmpstr[0] + "' name ='" + nameStr + "'>");
				tmp.append("<label for='" + tmpstr[1] + "' style='padding-right:10px'>" + tmpstr[1] + "</label>");
			}
		}
		return tmp.toString();
	}

	/**
	 * 加载字典表为select jsp页面直接使用（公司已自动传入）
	 * 
	 * @param context
	 * @param request
	 * @param andtxt
	 *            追加的字符串
	 * @param code
	 *            上级编码
	 * @return
	 */
	public static String getSelectOptions(ServletContext context, HttpServletRequest request, String andtxt, String code) {
		String tmp = getLibraryInfoList(context, request, andtxt, code);
		return getSelectOptionsByEnum(tmp);
	}
	
	/**
	 * 加载字典表为checkbox jsp页面直接使用
	 * 
	 * @param context
	 * @param request
	 * @param andtxt
	 *            追加的字符串
	 * @param code
	 *            上级编码
	 * @return
	 */
	public static String getCheckboxOptions(ServletContext context, HttpServletRequest request, String andtxt, String code, String nameStr) {
		String tmp = getLibraryInfoList(context, request, andtxt, code);
		return getCheckboxOptionsByEnum(tmp, nameStr);
	}
	

	/**
	 * 列表高级查询时生成下拉列表（公司已自动传入）
	 * 
	 * @param context
	 * @param request
	 * @param andtxt
	 *            追加的字符串
	 * @param code
	 *            上级编码
	 * @return
	 */
	public static String getLibraryInfoList(ServletContext context, HttpServletRequest request, String andtxt, String code) {
		String tmp = "";
		if (andtxt != null && andtxt.length() > 0) {
			tmp = andtxt + "|";
		}
		WebApplicationContext webAppContext = WebApplicationContextUtils.getWebApplicationContext(context);
		DwrCommonService commonService = (DwrCommonService) webAppContext.getBean("dwrCommonService");
		List<SysLibraryInfo> list = commonService.getLibraryInfoByCode(context, request, code);
		for (SysLibraryInfo sysLibraryInfo : list) {
			tmp += sysLibraryInfo.getPrimaryKey() + "," + sysLibraryInfo.getLibraryInfoName() + "|";
		}
		if (tmp != null && tmp.length() > 0)
			return tmp.substring(0, tmp.length() - 1);
		else
			return tmp;
	}

	/**
	 * 根据编码获取字典对象(公司已自动传入)
	 * 
	 * @param context
	 * @param request
	 * @param code
	 * @return
	 */
	public static SysLibraryInfo getLibraryInfoByCode(ServletContext context, HttpServletRequest request, String code) {
		WebApplicationContext webAppContext = WebApplicationContextUtils.getWebApplicationContext(context);
		DwrCommonService commonService = (DwrCommonService) webAppContext.getBean("dwrCommonService");
		return commonService.getSysLibraryByCode(context, request, code);
	}

	/**
	 * 根据主键获取字典对象
	 * 
	 * @param context
	 * @param request
	 * @param pk
	 * @return
	 */
	public static SysLibraryInfo getLibraryInfoByPk(ServletContext context, HttpServletRequest request, long pk) {
		WebApplicationContext webAppContext = WebApplicationContextUtils.getWebApplicationContext(context);
		DwrCommonService commonService = (DwrCommonService) webAppContext.getBean("dwrCommonService");
		return commonService.getLibraryInfoByPk(context, request, pk);
	}

	//==========================附件、图片操作====================
	/**
	 * 保存附件并返回附件id,多个以逗号分隔
	 */
	public static String saveAttachments(ServletContext context, HttpServletRequest request, String fileNames) {
		WebApplicationContext webAppContext = WebApplicationContextUtils.getWebApplicationContext(context);
		DwrCommonService commonService = (DwrCommonService) webAppContext.getBean("dwrCommonService");
		List<SysAttachmentInfo> list = commonService.saveAttachmentInfo(request, fileNames);
		String ids = "";
		for (SysAttachmentInfo sysAttachmentInfo : list) {
			ids += sysAttachmentInfo.getPrimaryKey() + ",";
		}
		if (ids.length() > 0) {
			ids = ids.substring(0, ids.length() - 1);
		}
		return ids;
	}

	/**
	 * 保存图片并返回图片id,多个以逗号分隔
	 */
	public static String saveImages(ServletContext context, HttpServletRequest request, String fileNames) {
		WebApplicationContext webAppContext = WebApplicationContextUtils.getWebApplicationContext(context);
		DwrCommonService commonService = (DwrCommonService) webAppContext.getBean("dwrCommonService");
		List<SysImageInfo> list = commonService.saveImageInfo(context, request, fileNames);
		String ids = "";
		for (SysImageInfo sysImageInfo : list) {
			ids += sysImageInfo.getPrimaryKey() + ",";
		}
		if (ids.length() > 0) {
			ids = ids.substring(0, ids.length() - 1);
		}
		return ids;
	}

	/**
	 * 根据id获取附件对象，并转化为[名称|路径,名称|路径]形式
	 * 
	 * @param context
	 * @param request
	 * @param ids
	 * @return
	 */
	public static String getAttachments(ServletContext context, HttpServletRequest request, String ids) {
		WebApplicationContext webAppContext = WebApplicationContextUtils.getWebApplicationContext(context);
		DwrCommonService commonService = (DwrCommonService) webAppContext.getBean("dwrCommonService");
		String names = commonService.getAttachmentInfoListToString(context, request, ids);
		return names;
	}

	/**
	 * 根据id获取图片对象，并转化为[名称|路径,名称|路径]形式
	 * 
	 * @param context
	 * @param request
	 * @param ids
	 * @return
	 */
	public static String getImages(ServletContext context, HttpServletRequest request, String ids) {
		WebApplicationContext webAppContext = WebApplicationContextUtils.getWebApplicationContext(context);
		DwrCommonService commonService = (DwrCommonService) webAppContext.getBean("dwrCommonService");
		String names = commonService.getImageInfoListToString(context, request, ids);
		return names;
	}

	/**
	 * 删除附件记录及文件
	 * 
	 * @param context
	 * @param request
	 * @param ids
	 */
	public static void deleteAttachmentsAndFile(ServletContext context, HttpServletRequest request, String ids) {
		WebApplicationContext webAppContext = WebApplicationContextUtils.getWebApplicationContext(context);
		DwrCommonService commonService = (DwrCommonService) webAppContext.getBean("dwrCommonService");
		commonService.deleteAttachmentInfoByIds(context, request, ids);
	}

	/**
	 * 删除图片记录及文件
	 * 
	 * @param context
	 * @param request
	 * @param ids
	 */
	public static void deleteImagesAndFile(ServletContext context, HttpServletRequest request, String ids) {
		WebApplicationContext webAppContext = WebApplicationContextUtils.getWebApplicationContext(context);
		DwrCommonService commonService = (DwrCommonService) webAppContext.getBean("dwrCommonService");
		commonService.deleteImageInfo(context, request, ids);
	}

	/**
	 * 删除附件记录
	 * 
	 * @param context
	 * @param request
	 * @param ids
	 */
	public static void deleteAttachmentsNoFile(ServletContext context, HttpServletRequest request, String ids) {
		WebApplicationContext webAppContext = WebApplicationContextUtils.getWebApplicationContext(context);
		DwrCommonService commonService = (DwrCommonService) webAppContext.getBean("dwrCommonService");
		commonService.deleteAttachmentInfoByIdsNoFile(context, request, ids);
	}

	/**
	 * 删除图片记录
	 * 
	 * @param context
	 * @param request
	 * @param ids
	 */
	public static void deleteImagesNoFile(ServletContext context, HttpServletRequest request, String ids) {
		WebApplicationContext webAppContext = WebApplicationContextUtils.getWebApplicationContext(context);
		DwrCommonService commonService = (DwrCommonService) webAppContext.getBean("dwrCommonService");
		commonService.deleteImageInfoNoFile(context, request, ids);
	}
	
	/**
	 * 列表高级查询时生成下拉列表 部门
	 * 
	 * @param context
	 * @param request
	 * @param andtxt
	 *            追加的字符串
	 * @return
	 */
	public static String getDepInfoList(ServletContext context, HttpServletRequest request, String andtxt) {
		String tmp = "";
		if (andtxt != null && andtxt.length() > 0) {
			tmp = andtxt + "|";
		}
		WebApplicationContext webAppContext = WebApplicationContextUtils.getWebApplicationContext(context);
		DwrHrmEmployeeService depService = (DwrHrmEmployeeService) webAppContext.getBean("dwrHrmEmployeeService");
		ResultBean bean = depService.getAlldepartmentNopager(context, request);
		List<HrmDepartment> list = bean.getResultList();
		for (HrmDepartment dep : list) {
			tmp += dep.getPrimaryKey() + "," + dep.getHrmDepName() + "|";
		}
		if (tmp != null && tmp.length() > 0)
			return tmp.substring(0, tmp.length() - 1);
		else
			return tmp;
	}
	
	// ==================================end==================

	@SuppressWarnings("unchecked")
	public static List<SysRoleDetail> getSysRoleDetailList(ServletContext context, HttpServletRequest request, Integer roleId) {
		WebApplicationContext webAppContext = WebApplicationContextUtils.getWebApplicationContext(context);
		DwrSysProcessService sysProcessService = (DwrSysProcessService) webAppContext.getBean("dwrSysProcessService");
		List<SysRoleDetail> detailList = sysProcessService.listSysRoledetailByRoleId(roleId).getResultList();
		return detailList;
	}

	// 权限设置封装
	@SuppressWarnings("unchecked")
	public static List<SysMethodInfo> getSysMethodMap(ServletContext context, HttpServletRequest request, String code, List<SysRoleDetail> detailList, int level) {
		WebApplicationContext webAppContext = WebApplicationContextUtils.getWebApplicationContext(context);
		DwrSysProcessService sysProcessService = (DwrSysProcessService) webAppContext.getBean("dwrSysProcessService");
		List<SysMethodInfo> methodlist = sysProcessService.getSysMethodInfoList(context, request, code, level).getResultList();
		if (detailList != null && detailList.size() > 0) {
			// 进行是否选择绑定
			for (int i = 0; i < detailList.size(); i++) {
				SysRoleDetail detail = detailList.get(i);
				for (SysMethodInfo sysMethodInfo : methodlist) {
					if (detail.getMethodId().equalsIgnoreCase(sysMethodInfo.getPrimaryKey())) {
						sysMethodInfo.setIschecked(true);
						break;
					}
				}
			}
		}
		return methodlist;
	}

	public static boolean sysMethodIsCheck(String methodId, List<SysRoleDetail> detailList) {
		boolean bl = false;
		if (detailList != null && detailList.size() > 0) {
			for (int i = 0; i < detailList.size(); i++) {
				SysRoleDetail detail = detailList.get(i);
				if (detail.getMethodId().equalsIgnoreCase(methodId)) {
					bl = true;
					break;
				}
			}
		}
		return bl;
	}

	public static SysUserMethods getSysUserMethodByUid(ServletContext context, HttpServletRequest request, String uids) {
		WebApplicationContext webAppContext = WebApplicationContextUtils.getWebApplicationContext(context);
		DwrSysProcessService sysProcessService = (DwrSysProcessService) webAppContext.getBean("dwrSysProcessService");
		SysUserMethods methods = sysProcessService.getSysUserMethodsByUserId(context, request, uids);
		return methods;
	}

	public static Set<String> getSysUserMethodAllByUid(ServletContext context, HttpServletRequest request, int uids, String show) {
		Set<String> methodset = null;
		WebApplicationContext webAppContext = WebApplicationContextUtils.getWebApplicationContext(context);
		DwrSysProcessService sysProcessService = (DwrSysProcessService) webAppContext.getBean("dwrSysProcessService");
		methodset = sysProcessService.getSysUserMethodsAllByUserId(context, request, uids, show);
		return methodset;
	}

	public static boolean sysMethodIsCheckByUserMethods(String methodId, SysUserMethods methods) {
		boolean bl = false;
		if (methods != null && methods.getUserMethodDetail() != null && methods.getUserMethodDetail().length() > 0) {
			String[] tmps = methods.getUserMethodDetail().split(",");
			for (int i = 0; i < tmps.length; i++) {
				if (tmps[i].equalsIgnoreCase(methodId)) {
					bl = true;
					break;
				}
			}
		}
		return bl;
	}

	public static boolean sysMethodIsCheckByMethodSet(String methodId, Set<String> mset) {
		boolean bl = false;
		if (mset != null && mset.size() > 0) {
			Iterator<String> it = mset.iterator();
			while (it.hasNext()) {
				String elem = (String) it.next();
				if (elem.equalsIgnoreCase(methodId)) {
					bl = true;
					break;
				}
			}
		}
		return bl;
	}

	public static List<SysMethodInfo> getSysMethodMapByUserMethods(ServletContext context, HttpServletRequest request, String code, SysUserMethods usermethods, int level) {
		WebApplicationContext webAppContext = WebApplicationContextUtils.getWebApplicationContext(context);
		DwrSysProcessService sysProcessService = (DwrSysProcessService) webAppContext.getBean("dwrSysProcessService");
		List<SysMethodInfo> methodlist = sysProcessService.getSysMethodInfoList(context, request, code, level).getResultList();
		if (usermethods != null && usermethods.getUserMethodDetail() != null && usermethods.getUserMethodDetail().length() > 0) {
			String[] tmps = usermethods.getUserMethodDetail().split(",");
			// 进行是否选择绑定
			for (int i = 0; i < tmps.length; i++) {
				for (SysMethodInfo sysMethodInfo : methodlist) {
					if (tmps[i].equalsIgnoreCase(sysMethodInfo.getPrimaryKey())) {
						sysMethodInfo.setIschecked(true);
						break;
					}
				}
			}
		}
		return methodlist;
	}

	public static List<SysMethodInfo> getSysMethodMapByMethodSet(ServletContext context, HttpServletRequest request, String code, Set<String> mset, int level) {
		WebApplicationContext webAppContext = WebApplicationContextUtils.getWebApplicationContext(context);
		DwrSysProcessService sysProcessService = (DwrSysProcessService) webAppContext.getBean("dwrSysProcessService");
		List<SysMethodInfo> methodlist = sysProcessService.getSysMethodInfoList(context, request, code, level).getResultList();
		if (mset != null && mset.size() > 0) {
			Iterator<String> it = mset.iterator();
			// 进行是否选择绑定
			while (it.hasNext()) {
				String elem = (String) it.next();
				for (SysMethodInfo sysMethodInfo : methodlist) {
					if (elem.equalsIgnoreCase(sysMethodInfo.getPrimaryKey())) {
						sysMethodInfo.setIschecked(true);
						break;
					}
				}
			}
		}
		return methodlist;
	}
	
	/**
	 * 获取参数
	 * @param request
	 * @param index
	 * @return
	 */
	public static String getSysParamByIndex(HttpServletRequest request,String index){
		String value ="";
		SessionUser user = (SessionUser) LoginContext.getSessionValueByLogin(request);
		Map<String, String> paramMap = user.getParamMap();
		if (paramMap!=null&&paramMap.size()>0) {
			if(paramMap.containsKey(index)){
				value = paramMap.get(index);
			}
		}
		return value;
	}
	
	/**
	 * 将set结合转为字符串并用于主键为varchar类型in查询
	 * @param approvIds
	 * @return
	 */
	public static String getStringFormSetIsString(Set<String> approvIds){
		String arIds ="";
		if (approvIds!=null&&approvIds.size()>0) {
			Iterator<String> it = approvIds.iterator();
			while (it.hasNext()) {
				String elem = (String) it.next();
				arIds+="'"+elem+"',";
			}
			if (arIds != null && arIds.length()>0) {
				arIds =arIds.substring(0,arIds.length()-1);
			}
		}
		return arIds;
	}
	
	/**
	 * 将set结合转为字符串并用于主键为int/long类型in查询
	 * @param approvIds
	 * @return
	 */
	public static String getStringFormSetIsNum(Set<String> approvIds){
		String arIds ="";
		if (approvIds!=null&&approvIds.size()>0) {
			Iterator<String> it = approvIds.iterator();
			while (it.hasNext()) {
				String elem = (String) it.next();
				arIds+=elem+",";
			}
			if (arIds != null && arIds.length()>0) {
				arIds =arIds.substring(0,arIds.length()-1);
			}
		}
		return arIds;
	}
	
	/**
	 * 验证用户是否有该功能权限
	 * @param request
	 * @param pk
	 * @return
	 */
	public static boolean ishashMethodByCode(HttpServletRequest request,String pk){
		SessionUser user = (SessionUser) LoginContext.getSessionValueByLogin(request);
		boolean bl = false;
		if(user!=null){
			Set<String> methodSet =  user.getUserMethodsSet();
			bl = methodSet.contains(pk);
		}
		return bl;
	}
	
	/**
	 * 自定义方法，获取公司主键及用户主键并转为路径
	 * 
	 * @param request
	 * @return
	 */
	public static String getUserPath(HttpServletRequest request,boolean appSeptor) {
		SessionUser suser =(SessionUser) LoginContext.getSessionValueByLogin(request);
		StringBuffer path = new StringBuffer();
		if (appSeptor) {
			path.append(ConstWords.septor);
		}
		if(suser != null){
			path.append(ConstWords.UserName+suser.getUserInfo().getPrimaryKey());
		}else{
			path.append(ConstWords.MEMBER);
		}
		return path.toString();
	}

	/**
	 * 格式化银行账号
	 * @param account
	 * @param len
	 * @param split
	 * @return
	 */
	public static String formatAccount(String account,int len,String split){
		if (account==null||account.length()==0) {
			return account;
		}
		StringBuffer result = new StringBuffer();
		int a = 1;
		for (int i = 0; i <account.length(); i++) {
			result.append(account.charAt(i));
			if (i+1==len*a) {
				result.append(split);
				a++;
			}
		}
		return result.toString();
	}
	
	public static String getStrByDouble(Double val,DecimalFormat df){
		String str="&nbsp;";
		if (val!=null&&val!=0) {
			str = df.format(val);
		}
		return str;
	}
	/**
	 * 日期set集合排序
	 * @param dateSet
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static List<String> compDateBySet(Set<String> dateSet){
		List<String> dateList = new ArrayList<String>();
		Iterator<String> it = dateSet.iterator();
		while (it.hasNext()) {
			String elem = (String) it.next();
			dateList.add(elem);
		}
		CaseInsensitiveComparator comp = new CaseInsensitiveComparator();
		Collections.sort(dateList,comp);
		return dateList;
	}
	
	// 日期排序
	@SuppressWarnings("unchecked")
	static class CaseInsensitiveComparator implements Comparator {

		public int compare(Object arg0, Object arg1) {
			String d1 = (String) arg0;
			String d2 = (String) arg1;
			boolean bl = UtilWork.checkDay(d2, d1);
			if (bl) {
				return -1;
			} else {
				return 1;
			}
		}
	}
	
	
	/**
	 * 根据empId获取用户名  2014-02-06 JC
	 * @param context
	 * @param request
	 * @param empId
	 * @return
	 */
	public static String getUserName(ServletContext context, HttpServletRequest request, String empId) {
		WebApplicationContext webAppContext = WebApplicationContextUtils.getWebApplicationContext(context);
		DwrSysProcessService sysProcessService = (DwrSysProcessService) webAppContext.getBean("dwrSysProcessService");
		SysUserInfo sysUserInfo = sysProcessService.getSysUserInfoByEmpId(context, request, empId);
		return sysUserInfo.getUserName();
	}
	
	public static String getUserName(HttpServletRequest request) {
		SessionUser user = (SessionUser) LoginContext.getSessionValueByLogin(request);
		return user.getUserInfo().getUserName();
	}
	
	/**
	 * 获得操作提示
	 * @param context
	 * @param request
	 * @return
	 */
	public static ArrayList<SysGridTitleBean> getGridTitleList(ServletContext context, HttpServletRequest request) {
		WebApplicationContext webAppContext = WebApplicationContextUtils.getWebApplicationContext(context);
		DwrSysProcessService sysProcessService = (DwrSysProcessService) webAppContext.getBean("dwrSysProcessService");
		ArrayList<SysGridTitleBean> list = new ArrayList<SysGridTitleBean>();
		
		String methodId = request.getParameter(ConstWords.METHOD_INFO_ID);
		
		//如果为空，通过URI获取功能块
		if(StringUtils.isBlank(methodId)){
			String uri = "";
			String servletPath = request.getServletPath();
			int beginIndex = servletPath.lastIndexOf("/");
			if(beginIndex != -1){
				uri = servletPath.substring(beginIndex, servletPath.length());
			}
			if(StringUtils.isNotBlank(uri)){
				SysMethodInfo methodInfo = sysProcessService.getSysMethodInfoByUri(context, request, uri);
				if(methodInfo != null){
					methodId = methodInfo.getPrimaryKey();
				}
			}
		}
		
		List<SysMethodHelp> resultList = sysProcessService.listSysMethodHelpByMethodId(context, request, methodId);
		
		for (SysMethodHelp sysMethodHelp : resultList) {
			String img = "";
			if(StringUtils.isNotBlank(sysMethodHelp.getHelpImg())){
				String imgUrl = request.getContextPath()+"/images/grid_images/"+sysMethodHelp.getHelpImg();
						img = "<img src='"+imgUrl+"' border='0' height='12'/>";
			}
			SysGridTitleBean bean = new SysGridTitleBean(img,sysMethodHelp.getHelpDesc());
			list.add(bean);
		}
		
		return list;
	}
}
