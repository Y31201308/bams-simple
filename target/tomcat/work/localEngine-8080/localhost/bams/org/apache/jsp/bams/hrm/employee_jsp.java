package org.apache.jsp.bams.hrm;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.pinhuba.common.exception.*;
import com.pinhuba.common.module.*;
import com.pinhuba.common.pack.*;
import com.pinhuba.common.pages.*;
import com.pinhuba.common.util.*;
import com.pinhuba.common.util.file.*;
import com.pinhuba.common.util.security.*;
import java.util.*;
import java.io.*;
import java.text.*;
import com.pinhuba.core.iservice.*;
import com.pinhuba.core.pojo.*;
import com.pinhuba.core.iservice.*;
import com.pinhuba.web.controller.dwr.*;
import com.pinhuba.web.taglib.*;
import com.pinhuba.web.taglib.table.*;
import com.pinhuba.web.taglib.table.cloumntype.*;
import com.pinhuba.common.util.file.properties.*;
import com.pinhuba.common.util.security.Base64;

public final class employee_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(4);
    _jspx_dependants.add("/bams/hrm/../common.jsp");
    _jspx_dependants.add("/WEB-INF/fileprocess.tld");
    _jspx_dependants.add("/WEB-INF/button.tld");
    _jspx_dependants.add("/WEB-INF/table.tld");
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

//文件及图片上传组件 
//按钮组件 
//table组件 

//项目相对及绝对路径
String contextPath = request.getContextPath();
String absPath = this.getServletContext().getRealPath("");

      out.write("<link rel='Shortcut Icon' href='");
      out.print(contextPath);
      out.write("/favicon.ico' />\n");
      out.write("<link rel='Bookmark' href='");
      out.print(contextPath);
      out.write("/favicon.ico' />\n");
      out.write("\n");
      out.write("<link type='text/css' rel='stylesheet'  href='");
      out.print(contextPath);
      out.write("/css/normal.css' />\n");
      out.write("<link type='text/css' rel='stylesheet' href='");
      out.print(contextPath);
      out.write("/js/artDialog/skins/blue.css' />\n");
      out.write("<script type='text/javascript' src='");
      out.print(contextPath );
      out.write("/js/artDialog/artDialog.source.js'></script>\n");
      out.write("\n");
      out.write("<script type='text/javascript' src='");
      out.print(contextPath);
      out.write("/js/normalutil.js'></script>\n");
      out.write("<script type='text/javascript' src='");
      out.print(contextPath);
      out.write("/js/pageToservice.js'></script>\n");
      out.write("<script type='text/javascript'>\n");
      out.write("Sys.setProjectPath('");
      out.print(contextPath);
      out.write("');\n");
      out.write("</script>\n");
      out.write("<script type='text/javascript' src='");
      out.print(contextPath);
      out.write("/js/cookie.js'></script>\n");
      out.write("<script type='text/javascript' src='");
      out.print(contextPath);
      out.write("/dwr/engine.js'></script>\n");
      out.write("<script type='text/javascript' src='");
      out.print(contextPath);
      out.write("/dwr/util.js'></script>\n");
      out.write("<script type='text/javascript' src='");
      out.print(contextPath);
      out.write("/dwr/interface/dwrCommonService.js'></script>\n");
      out.write("<script type='text/javascript' src='");
      out.print(contextPath);
      out.write("/js/dateJs/WdatePicker.js'></script>\n");
      out.write("<script type='text/javascript' src='");
      out.print(contextPath);
      out.write("/js/tabJs/sys_tab.js'></script>\n");
      out.write("\n");
      out.write("<link type='text/css' rel='stylesheet' href='");
      out.print(contextPath);
      out.write("/js/sys_btn/skin/default/btnskin.css' />\n");
      out.write("<script type='text/javascript' src='");
      out.print(contextPath);
      out.write("/js/sys_btn/sys_btn.js'></script>\n");
      out.write("\t\t\n");
      out.write("<link type='text/css' rel='stylesheet' href='");
      out.print(contextPath);
      out.write("/css/sysgrid.css' />\n");
      out.write("<link type='text/css' rel='stylesheet' href='");
      out.print(contextPath);
      out.write("/css/formstyle.css' />\n");
      out.write("<script type='text/javascript' src='");
      out.print(contextPath);
      out.write("/js/jquery-1.7.2.min.js'></script>\n");
      out.write("<script type='text/javascript' src='");
      out.print(contextPath);
      out.write("/js/formjs.js'></script>\n");
      out.write("<script type='text/javascript'>\n");
      out.write("formStylePath.setImagePath('");
      out.print(contextPath);
      out.write("/images/');\n");
      out.write("</script>\n");
      out.write("<script type='text/javascript' src='");
      out.print(contextPath);
      out.write("/js/tipalert/alertWin.js'></script>\n");
      out.write("<link type='text/css' rel='stylesheet' href='");
      out.print(contextPath);
      out.write("/js/tipalert/alertwin.css'/>\n");
      out.write("<script type='text/javascript' src='");
      out.print(contextPath);
      out.write("/js/selectJs.js'></script>\n");
      out.write("<script type='text/javascript'>\n");
      out.write("SEL.setProjectPath('");
      out.print(contextPath);
      out.write("');\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("<!-- 左右分栏效果 -->\n");
      out.write("<script type='text/javascript' src='");
      out.print(contextPath);
      out.write("/js/split/splitter.js'></script>\n");
      out.write("<link type='text/css' rel='stylesheet' href='");
      out.print(contextPath);
      out.write("/js/split/style.css' />\n");
      out.write("\n");
      out.write("<script type='text/javascript' src='");
      out.print(contextPath);
      out.write("/js/contextmenu.js'></script>\n");
      out.write("<script type='text/javascript' src='");
      out.print(contextPath);
      out.write("/js/jcarousellite.js'></script>\n");
      out.write("<script type='text/javascript' src='");
      out.print(contextPath);
      out.write("/js/jquery.hotkeys.js'></script>\n");
      out.write("\n");
      out.write("<div style='display:none;' id='clearMenu'>\n");
      out.write("\t<ul>\n");
      out.write("\t\t<li id='clear'>\n");
      out.write("\t\t<img src=\"");
      out.print(contextPath);
      out.write("/images/clearinput.png\" height=\"14\"> 清 除\n");
      out.write("\t\t</li>\n");
      out.write("\t</ul>\n");
      out.write("</div>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("function loginOut(){\n");
      out.write("\ttop.location.href = \"");
      out.print(contextPath);
      out.write("/centerSend.jsp\";\t\n");
      out.write("}\n");
      out.write("\n");
      out.write("function errormsg(){\n");
      out.write("\tSys.alert(\"系统好像出问题了，请截图保存后及时与技术人员联系！\\n\\n\"+ getFullCurrentDate());\n");
      out.write("}\n");
      out.write("\n");
      out.write("function reloadlogin(){\n");
      out.write("\ttop.location.href = \"");
      out.print(contextPath);
      out.write("/login.jsp\"\n");
      out.write("}\n");
      out.write("\n");
      out.write("window.status =\"品互网络 Pinhuba (c)2008-2014\";\n");
      out.write("</script>\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("<title>人员管理</title>\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(contextPath);
      out.write("/dwr/interface/dwrHrmEmployeeService.js\"></script>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("//查询方法\n");
      out.write("function queryData(){\n");
      out.write("\tstartQuery();\n");
      out.write("\tvar employee = getQueryParam();\n");
      out.write("\temployee.hrmEmployeeDepidTree = document.getElementById(\"upcode\").value;\n");
      out.write("\tvar pager = getPager();\n");
      out.write("\tdwrHrmEmployeeService.listAllEmployees(employee,pager,queryCallback);\n");
      out.write("}\n");
      out.write("\n");
      out.write("function queryCallback(data){\n");
      out.write("\tif(data.success == true){\n");
      out.write("\t\tinitGridData(data.resultList,data.pager);\n");
      out.write("\t\tshowQueryParam();\n");
      out.write("\t}else{\n");
      out.write("\t\talert(data.message);\n");
      out.write("\t}\n");
      out.write("\tendQuery();\n");
      out.write("}\n");
      out.write("\n");
      out.write("//双击数据\n");
      out.write("function dblCallback(obj){\n");
      out.write("\tvar box = new Sys.msgbox('明细查看','");
      out.print(contextPath);
      out.write("/bams/hrm/employee_detail.jsp?employeepk='+obj.value,'800','500');\n");
      out.write("\tbox.msgtitle=\"<b>查看人员信息明细</b>\";\n");
      out.write("\tbox.show();\n");
      out.write("}\n");
      out.write("\n");
      out.write("function update(employeepk){\n");
      out.write("\topenMDITab(\"");
      out.print(contextPath);
      out.write("/bams/hrm/employee_add.jsp?employeepk=\"+employeepk+\"&tab=\"+getMDITab());\n");
      out.write("}\n");
      out.write("\n");
      out.write("function separation(id){\n");
      out.write("\tconfirmmsg(\"确定要将人员设置为离职吗?\",\"SeparationOk('\"+id+\"')\");\n");
      out.write("}\n");
      out.write("\n");
      out.write("function SeparationOk(id){\n");
      out.write("\tvar ids = new Array();\n");
      out.write("\tids[0] = id;\n");
      out.write("\tdwrHrmEmployeeService.setSeparationByIds(ids,delcallback);\n");
      out.write("}\n");
      out.write("\n");
      out.write("function delcallback(data){\n");
      out.write("\talertmsg(data,\"queryData()\");\n");
      out.write("}\n");
      out.write("\n");
      out.write("function deletebatch(){\n");
      out.write("\tif(getAllRecordArray() != false){\n");
      out.write("\t\tconfirmmsg(\"确定要批量设置离职吗?\",\"delbatchok()\");\n");
      out.write("\t}else{\n");
      out.write("\t\talertmsg(\"请选择要设置离职的人员...\");\n");
      out.write("\t}\n");
      out.write("}\n");
      out.write("\n");
      out.write("function delbatchok(){\n");
      out.write("\tvar recordsPks = getAllRecordArray();\n");
      out.write("\tdwrHrmEmployeeService.setPinYinMaByIds(recordsPks,delcallback);\n");
      out.write("}\n");
      out.write("\n");
      out.write("function createProcessMethod(rowObj){\n");
      out.write("\tvar str=\"\";\n");
      out.write("\tif(rowObj.hrmEmployeeStatus == ");
      out.print(EnumUtil.HRM_EMPLOYEE_STATUS.Separation.value);
      out.write("){\n");
      out.write("\t    str=\"<a href='javascript:void(0)' title='编辑' onclick=\\\"update('\"+rowObj.primaryKey+\"')\\\"><img src='");
      out.print(contextPath);
      out.write("/images/grid_images/rowedit.png' border='0'/></a>\";\n");
      out.write("\t    str+=\"&nbsp;&nbsp;<a href='javascript:void(0)' title='设置拼音码' onclick=\\\"setPYM('\"+rowObj.primaryKey+\"')\\\"><img src='");
      out.print(contextPath);
      out.write("/images/grid_images/setpym.png' border='0'/></a>\";\n");
      out.write("\t    str+=\"&nbsp;&nbsp;<a href='javascript:void(0)' title='不能设置离职'\\\"><img src='");
      out.print(contextPath);
      out.write("/images/grid_images/seta_.png' border='0'/></a>\";\n");
      out.write("\t}else{\n");
      out.write("\t    str=\"<a href='javascript:void(0)' title='编辑' onclick=\\\"update('\"+rowObj.primaryKey+\"')\\\"><img src='");
      out.print(contextPath);
      out.write("/images/grid_images/rowedit.png' border='0'/></a>\";\n");
      out.write("\t    str+=\"&nbsp;&nbsp;<a href='javascript:void(0)' title='设置拼音码' onclick=\\\"setPYM('\"+rowObj.primaryKey+\"')\\\"><img src='");
      out.print(contextPath);
      out.write("/images/grid_images/setpym.png' border='0' /></a>\";\n");
      out.write("\t    str+=\"&nbsp;&nbsp;<a href='javascript:void(0)' title='设置离职' onclick=\\\"separation('\"+rowObj.primaryKey+\"')\\\"><img src='");
      out.print(contextPath);
      out.write("/images/grid_images/seta.png' border='0'/></a>\";\n");
      out.write("\t}\n");
      out.write("\treturn str;\n");
      out.write("}\n");
      out.write("\n");
      out.write("//列显示替换方法\n");
      out.write("function repleaSex(rowObj){\n");
      out.write("\tvar str=\"\";\n");
      out.write("\tif(rowObj.hrmEmployeeSex ==");
      out.print(EnumUtil.HRM_EMPLOYEE_SEX.Man.value);
      out.write("){\n");
      out.write("\t\tstr= \"<font style='color:blue'>");
      out.print(EnumUtil.HRM_EMPLOYEE_SEX
							.valueOf(EnumUtil.HRM_EMPLOYEE_SEX.Man.value));
      out.write("</font>\"\n");
      out.write("\t}else{\n");
      out.write("\t\tstr= \"<font style='color:red'>");
      out.print(EnumUtil.HRM_EMPLOYEE_SEX
							.valueOf(EnumUtil.HRM_EMPLOYEE_SEX.Woman.value));
      out.write("</font>\"\n");
      out.write("\t}\n");
      out.write("\treturn str;\n");
      out.write("}\n");
      out.write("\n");
      out.write("function repAction(rowObj){\n");
      out.write("\tvar str=\"\";\n");
      out.write("\tif(rowObj.hrmEmployeeActive == ");
      out.print(EnumUtil.SYS_ISACTION.Vaild.value);
      out.write("){\n");
      out.write("\t\tstr =\"<font color='green'>");
      out.print(EnumUtil.SYS_ISACTION.valueOf(EnumUtil.SYS_ISACTION.Vaild.value));
      out.write("</font>\";\n");
      out.write("\t}else{\n");
      out.write("\t\tstr =\"<font color='red'>");
      out.print(EnumUtil.SYS_ISACTION.valueOf(EnumUtil.SYS_ISACTION.No_Vaild.value));
      out.write("</font>\";\n");
      out.write("\t}\n");
      out.write("\treturn str;\n");
      out.write("}\n");
      out.write("\n");
      out.write("//部门树选择\n");
      out.write("function treeclick(code){\n");
      out.write("    \n");
      out.write("\tdocument.getElementById(\"upcode\").value =code;\n");
      out.write("\tqueryData();\n");
      out.write("}\n");
      out.write("\n");
      out.write("function setPYM(id){\n");
      out.write("\tconfirmmsg(\"确定要设置拼音码?\",\"setPYMOK('\"+id+\"')\");\n");
      out.write("}\n");
      out.write("\n");
      out.write("function setPYMOK(id){\n");
      out.write("\tvar ids = new Array();\n");
      out.write("\tids[0] = id;\n");
      out.write("\tdwrHrmEmployeeService.setPinYinMaByIds(ids,delcallback);\n");
      out.write("}\n");
      out.write("\n");
      out.write("function setBatchPYM(){\n");
      out.write("\tif(getAllRecordArray() != false){\n");
      out.write("\t\tconfirmmsg(\"确定要批量设置拼音码吗?\",\"setBatchPYMOK()\");\n");
      out.write("\t}else{\n");
      out.write("\t\talertmsg(\"请选择要设置拼音码的人员...\");\n");
      out.write("\t}\n");
      out.write("}\n");
      out.write("\n");
      out.write("function setBatchPYMOK(){\n");
      out.write("\tvar ids = getAllRecordArray();\n");
      out.write("\tdwrHrmEmployeeService.setPinYinMaByIds(ids,delcallback);\n");
      out.write("}\n");
      out.write("\n");
      out.write("//导出\n");
      out.write("function exportEmployee(){\n");
      out.write("\tconfirmmsg(\"确定要导出列表中的人员信息吗?\",\"exportok()\");\n");
      out.write("}\n");
      out.write("\n");
      out.write("function exportok(){\n");
      out.write("\tuseLoadingMassage();\n");
      out.write("\tvar employee = getQueryParam();\n");
      out.write("\tlocation.href= \"");
      out.print(contextPath );
      out.write("/exportEmployee.do?hrmEmployeeSex=\"+employee.hrmEmployeeSex;\n");
      out.write("}\n");
      out.write("\n");
      out.write("/*\n");
      out.write(" * 打印报表的方法\n");
      out.write("*/\n");
      out.write("function print(){\n");
      out.write("\tif(getAllRecordArray() != false){\t\n");
      out.write("\t\tif(getAllRecordArray().length > 1){\n");
      out.write("\t\t   alertmsg(\"每次只能选择一条数据打印！\");\n");
      out.write("\t\t   return;\n");
      out.write("\t\t}\n");
      out.write("\t\topenMDITab('");
      out.print(contextPath);
      out.write("/bams/report_show.jsp?raq=employee.raq&macrozgh=\\\\\\'' + getAllRecordArray()[0] + '\\\\\\'');\n");
      out.write("\t} else {\n");
      out.write("\t\talertmsg(\"请选择要打印的人员...\");\n");
      out.write("\t}\n");
      out.write("}\n");
      out.write("</script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" height=\"100%\">\n");
      out.write("\t\t<tr>\n");
      out.write("\t\t\t<td id=\"split_l\">\n");
      out.write("\t\t\t\t<div class=\"div_title\">选择部门</div> \n");
      out.write("\t\t\t\t<div class=\"div_content\">\n");
      out.write("\t\t\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "departmentxmlshow.jsp" + (("departmentxmlshow.jsp").indexOf('?')>0? '&': '?') + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("ischeck", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("true", request.getCharacterEncoding()), out, false);
      out.write("</div>\n");
      out.write("\t\t\t</td>\n");
      out.write("\t\t\t<td>\n");
      out.write("\t\t\t\t");

					SysGrid bg = new SysGrid(request);
					bg.setTableTitle("部门人员");

					//设置附加信息
					bg.setQueryFunction("queryData"); //查询的方法名
					bg.setDblFunction("dblCallback"); //双击列的方法名，又返回值，为列对象
					bg.setDblBundle("primaryKey"); //双击列的绑定的列值

					//放入按钮
					ArrayList<SysGridBtnBean> btnList = new ArrayList<SysGridBtnBean>();
					btnList.add(new SysGridBtnBean("批量设置离职", "deletebatch()", "close.png"));
					btnList.add(new SysGridBtnBean("批量设置名字拼音码", "setBatchPYM()", "pinyinmabatch.png"));
					btnList.add(new SysGridBtnBean("导出EXCEL", "exportEmployee()", "exp_excel.gif"));
					btnList.add(new SysGridBtnBean("打印信息", "print()", "printimg.png"));
					bg.setBtnList(btnList);

					bg.setHelpList(UtilTool.getGridTitleList(this.getServletContext(), request));

					//放入列
					ArrayList<SysColumnControl> sccList = new ArrayList<SysColumnControl>();
					sccList.add(new SysColumnControl("hrmEmployeeName", "姓名", 1, 1, 1, 0));
					sccList.add(new SysColumnControl("hrmEmployeeCode", "工号", 1, 1, 1, 0));
					sccList.add(new SysColumnControl("hrmDepartment.hrmDepName", "部门", 1, 2, 2, 0));
					sccList.add(new SysColumnControl("hrmEmployeeSex", "性别", 1, 2, 1, 0));
					sccList.add(new SysColumnControl("hrmEmployeeBirthday", "出生日期", 1, 2, 1, 0));
					sccList.add(new SysColumnControl("hrmEmployeeInTime", "入职日期", 1, 2, 1, 0));
					sccList.add(new SysColumnControl("hrmEmployeeActive", "员工状态", 1, 2, 1, 0));
					ArrayList<SysGridColumnBean> colList = UtilTool.getGridColumnList(sccList);
					//进行高级查询显示处理
					for (int i = 0; i < colList.size(); i++) {
						SysGridColumnBean bc = colList.get(i);
						if (bc.isShowAdvanced() || bc.isShowColumn()) {
							if ("hrmEmployeeInTime".equalsIgnoreCase(bc.getDataName())) {
								DateType date = new DateType();
								bc.setColumnTypeClass(date);
								bc.setColumnStyle("padding-left:15px;");
							}
							if ("hrmEmployeeBirthday".equalsIgnoreCase(bc.getDataName())) {
								DateType date = new DateType();
								bc.setColumnTypeClass(date);
								bc.setColumnStyle("padding-left:15px;");
							}
							if ("hrmEmployeeCode".equalsIgnoreCase(bc.getDataName())) {
								bc.setColumnStyle("padding-left:15px;text-align: left");
							}
							if ("hrmEmployeeSex".equalsIgnoreCase(bc.getDataName())) {
								SelectType select = new SelectType(EnumUtil.HRM_EMPLOYEE_SEX.getSelectAndText("-1,-请选择人员性别-"));
								select.setCustomerFunction(new String[] { "onchange=\"queryData();\"" });
								bc.setColumnTypeClass(select);
								bc.setColumnReplace("repleaSex");
								bc.setColumnStyle("text-align:center;");
							}

							if ("hrmEmployeeActive".equalsIgnoreCase(bc.getDataName())) {
								SelectType select = new SelectType(EnumUtil.SYS_ISACTION.getSelectAndText("-1,-请选择是否有效-"));
								select.setCustomerFunction(new String[] { "onchange=\"queryData();\"" });
								bc.setColumnTypeClass(select);

								bc.setColumnReplace("repAction");
							}
						}
					}

					bg.setColumnList(colList);
					//设置列操作对象
					bg.setShowProcess(true);//默认为false 为true请设置processMethodName
					bg.setProcessMethodName("createProcessMethod");//生成该操作图标的js方法,系统默认放入数据行对象

					//设置图片显示信息
					//bg.setImgShowNum(6);//不指定默认5个
					bg.setImgShowUrl("hrmEmployeeImageInfoId");//显示img的属性字段，没有填写-1
					bg.setImgShowText("hrmEmployeeName");
					bg.setImgNoDefaultPath(absPath + "/images/noimages/employee.png");//可以不指定，系统采用默认暂无图片
					bg.setImgheight("64");//不设置为自动
					//开始创建
					out.print(bg.createTable());
				
      out.write("</td>\n");
      out.write("\t\t</tr>\n");
      out.write("\t</table>\n");
      out.write("\t<input type=\"hidden\" id=\"upcode\">\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else log(t.getMessage(), t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
