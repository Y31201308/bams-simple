package com.pinhuba.web.controller.dwr;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import com.pinhuba.common.util.ConstWords;
import com.pinhuba.common.util.ConvertPinyin;
import com.pinhuba.common.util.LoginContext;
import com.pinhuba.common.util.UtilTool;
import com.pinhuba.core.iservice.ISysProcessService;
import com.pinhuba.core.pojo.SysAttachmentInfo;
import com.pinhuba.core.pojo.SysImageInfo;
import com.pinhuba.core.pojo.SysLibraryInfo;

/**
 * 通用dwr类
 * @author peng.ning
 */
@Controller
public class DwrCommonService {
	private final static Logger logger = Logger.getLogger(DwrCommonService.class);
	
	@Resource
	private ISysProcessService sysProcessService;

	public String getCodeByTable(ServletContext context, HttpServletRequest request, String upcode, String table, String colname, String upcol) {
		String code = sysProcessService.getCode(upcode, table, colname, upcol);
		logger.info(table);
		return code;
	}

	// =========字典表操作============
	/**
	 * 根据上级编码获取字典列表
	 */
	public List<SysLibraryInfo> getLibraryInfoByCode(ServletContext context, HttpServletRequest request, String code) {
		return sysProcessService.getSysLibraryInfoByCode(code);
	}

	/**
	 * 根据编码和公司主键获取字典对象
	 * 
	 * @param request
	 * @param code
	 * @return
	 */
	public SysLibraryInfo getSysLibraryByCode(ServletContext context, HttpServletRequest request, String code) {
		return sysProcessService.getSysLibraryByCode(code);
	}

	/**
	 * 根据逐渐获取字典对象
	 * 
	 * @param request
	 * @param pk
	 * @return
	 */
	public SysLibraryInfo getLibraryInfoByPk(ServletContext context, HttpServletRequest request, long pk) {
		return sysProcessService.getSysLibraryInfoByPk(pk);
	}

	/**
	 * 保存附件
	 * 
	 * @param context
	 * @param request
	 * @param fileNames
	 * @return
	 */
	public List<SysAttachmentInfo> saveAttachmentInfo(HttpServletRequest request, String fileNames) {
		return sysProcessService.saveAttachmentInfo(fileNames, UtilTool.getEmployeeId(request));
	}

	/**
	 * 删除附件 根据附件编号
	 * 
	 * @param context
	 * @param request
	 * @param ids
	 */
	public void deleteAttachmentInfoByIds(ServletContext context, HttpServletRequest request, String ids) {
		sysProcessService.deleteAttachmentInfoListByIds(ids,true);
	}
	
	public void deleteAttachmentInfoByIdsNoFile(ServletContext context, HttpServletRequest request, String ids){
		sysProcessService.deleteAttachmentInfoListByIds(ids,false);
	}

	/**
	 * 保存图片
	 * 
	 * @param context
	 * @param request
	 * @param fileNames
	 * @return
	 */
	public List<SysImageInfo> saveImageInfo(ServletContext context, HttpServletRequest request, String fileNames) {
		return sysProcessService.saveImageInfo(fileNames, UtilTool.getEmployeeId(request));
	}

	/**
	 * 删除图片,根据图片编号
	 * 
	 * @param context
	 * @param request
	 * @param ids
	 */
	public void deleteImageInfo(ServletContext context, HttpServletRequest request, String ids) {
		sysProcessService.deleteImageInfoListByIds(ids,true);
	}

	/**
	 * 删除图片,根据图片编号
	 * 
	 * @param context
	 * @param request
	 * @param ids
	 */
	public void deleteImageInfoNoFile(ServletContext context, HttpServletRequest request, String ids) {
		sysProcessService.deleteImageInfoListByIds(ids,false);
	}
	/**
	 * 根据主键获取附件对象
	 * 
	 * @param context
	 * @param request
	 * @param ids
	 * @return
	 */
	public List<SysAttachmentInfo> getAttachmentInfoList(ServletContext context, HttpServletRequest request, String ids) {
		return sysProcessService.getAttachmentInfoListByIds(ids);
	}

	public SysAttachmentInfo getAttachmentInfoByPk(ServletContext context, HttpServletRequest request, long id){
		return sysProcessService.getAttachmentInfoByPk(id);
	}
	
	
	/**
	 * 根据主键获取图片对象
	 * 
	 * @param context
	 * @param request
	 * @param ids
	 * @return
	 */
	public List<SysImageInfo> getImageInfoList(ServletContext context, HttpServletRequest request, String ids) {
		return sysProcessService.getImageInfoListByIds(ids);
	}

	/**
	 * 将附件id转换为编辑时可用字符串
	 * @param context
	 * @param request
	 * @param ids
	 * @return
	 */
	public String getAttachmentInfoListToString(ServletContext context, HttpServletRequest request, String ids) {
		List<SysAttachmentInfo> list = sysProcessService.getAttachmentInfoListByIds(ids);
		String names = "";
		for (SysAttachmentInfo sysAttachmentInfo : list) {
			names += sysAttachmentInfo.getAttachmentName() + "|" + sysAttachmentInfo.getAttachmentFilename() + ",";
		}
		if (names.length() > 0) {
			names = names.substring(0, names.length() - 1);
		}
		return names;
	}
	/**
	 * 将图片id转换为编辑时可用字符串
	 * @param context
	 * @param request
	 * @param ids
	 * @return
	 */
	public String getImageInfoListToString(ServletContext context, HttpServletRequest request, String ids) {
		List<SysImageInfo> list = sysProcessService.getImageInfoListByIds(ids);
		String names = "";
		for (SysImageInfo image : list) {
			names += image.getImageInfoName() + "|" + image.getImageInfoFilename() + ",";
		}
		if (names.length() > 0) {
			names = names.substring(0, names.length() - 1);
		}
		return names;
	}
	
	/**
	 * 验证附件是否改变
	 * @param context
	 * @param request
	 * @param ids
	 * @param files
	 * @return
	 */
	public boolean isAttachmentChange(ServletContext context, HttpServletRequest request, String ids,String files){
		boolean bl = false;
		String oldfiles = this.getAttachmentInfoListToString(context, request, ids);
		if(!oldfiles.equals(files)){
			bl = true;
		}
		return bl;
	}
	
	/**
	 * 验证图片信息是否改变
	 * @param context
	 * @param request
	 * @param ids
	 * @param files
	 * @return
	 */
	public boolean isImageInfoChange(ServletContext context, HttpServletRequest request, String ids,String files){
		boolean bl = false;
		String oldfiles = this.getImageInfoListToString(context, request, ids);
		if(!oldfiles.equals(files)){
			bl = true;
		}
		return bl;
	}
	//===================根据人员ids加载人员名称===================
	
	public List<String> getHrmEmployeeNamesByIds(ServletContext context, HttpServletRequest request,String ids){
		List<String> namelist = new ArrayList<String>();
		if (ids==null||ids.length()==0) {
			return namelist;
		}
		namelist =  sysProcessService.getEmployeeNamesByids(ids);
		return namelist;
	}
	
	//===================根据部门ids加载部门名称===================
	
	public List<String> getHrmDeptNamesByIds(ServletContext context, HttpServletRequest request,String ids){
		List<String> namelist = new ArrayList<String>();
		if (ids==null||ids.length()==0) {
			return namelist;
		}
		namelist =  sysProcessService.getDeptNamesByIds(ids);
		return namelist;
	}
	
	//==================根据用户ids加载人员名称=========================
	public List<String> getHrmEmployeeNamesByUserIds(ServletContext context, HttpServletRequest request,String ids){
		List<String> namelist = new ArrayList<String>();
		if (ids==null||ids.length()==0) {
			return namelist;
		}
		namelist =  sysProcessService.getEmployeeNamesByUserIds(ids);
		return namelist;
	}
	//==================根据编组ids加载编组名称=========================
	public List<String> getGroupNamesByIds(ServletContext context, HttpServletRequest request,String ids){
		List<String> namelist = new ArrayList<String>();
		if (ids==null||ids.length()==0) {
			return namelist;
		}
		namelist =  sysProcessService.getGroupNamesByIds(ids);
		return namelist;
	}
	//==================根据岗位ids加载岗位名称=========================
	public List<String> getHrmPostNamesByIds(ServletContext context, HttpServletRequest request,String ids){
		List<String> namelist = new ArrayList<String>();
		if (ids==null||ids.length()==0) {
			return namelist;
		}
		namelist =  sysProcessService.getPostNamesByIds(ids);
		return namelist;
	}
	
	//========================汉字转拼音========================
	public String getPinYinByString(ServletContext context, HttpServletRequest request,String str) throws Exception{
		return ConvertPinyin.getPinyin(str);
	}
	
	//======================验证验证码=========================
	public boolean validCodeEquals(ServletContext context, HttpServletRequest request,String inputcode) throws Exception{
		boolean bl = false;
		if (LoginContext.getSessionValue(request, ConstWords.ValidCodeTempSession)==null) {
			return bl;
		}
		String code = (String) LoginContext.getSessionValue(request, ConstWords.ValidCodeTempSession);
		if (code.equalsIgnoreCase(inputcode)) {
			bl = true;
		}
		return bl;
	}
	
	public boolean validCodeEqualsBySession(ServletContext context, HttpServletRequest request,String inputcode,String sessionName) throws Exception{
		boolean bl = false;
		String code = (String) LoginContext.getSessionValue(request, sessionName);
		if (code.equalsIgnoreCase(inputcode)) {
			bl = true;
		}
		return bl;
	}

}
