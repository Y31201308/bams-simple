package org.apache.jsp.bams;

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

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(4);
    _jspx_dependants.add("/bams/common.jsp");
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

SessionUser sessionUser = (SessionUser)LoginContext.getSessionValueByLogin(request);
List<SysMethodInfo> userModuleMethods = sessionUser.getUserModuleMethods();//个人功能模块
int msize = userModuleMethods.size();
int height = ConstWords.getProjectChangeHeight(msize);
String mid = request.getParameter("mid");	//跳转模块代码
String titname = SystemConfig.getParam("bams.sys.name");

      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("\t\t<title>");
      out.print(titname );
      out.write("</title>\r\n");
      out.write("\t\t<link rel='stylesheet' type='text/css' href='");
      out.print(contextPath);
      out.write("/js/tabs/tabs.css' />\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.print(contextPath);
      out.write("/js/tabs/tabs.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\twindow.onload = function(){\r\n");
      out.write("\t\t\topenMDITab(\"");
      out.print(contextPath);
      out.write("/bams/hrm/employee.jsp\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$(function(){\r\n");
      out.write("\t\t\tprojectOpen(\"");
      out.print(mid);
      out.write("\");\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t$('#config').contextMenu('configMenu', {\r\n");
      out.write("\t\t\t\tbindings : {\r\n");
      out.write("\t\t\t\t\t'viewemployee' : function(t) {\r\n");
      out.write("\t\t\t\t\t\tvar box = new Sys.msgbox('个人信息','");
      out.print(contextPath );
      out.write("/bams/employee_info.jsp','700','500');\r\n");
      out.write("\t\t\t\t\t\tbox.msgtitle=\"个人信息\";\r\n");
      out.write("\t\t\t\t\t\tbox.show();\r\n");
      out.write("\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t'editname' : function(t) {\r\n");
      out.write("\t\t\t\t\t\tvar box = new Sys.msgbox('修改登录用户名','");
      out.print(contextPath );
      out.write("/bams/editUserNameMsg.jsp','700','400');\r\n");
      out.write("\t\t\t\t\t\tbox.msgtitle=\"<b>修改用户名</b><br/>修改登录用户名后再次登录将生效!\";\r\n");
      out.write("\t\t\t\t\t\tvar butarray = new Array();\r\n");
      out.write("\t\t\t\t\t\tbutarray[0] = \"ok|updateName();\";\r\n");
      out.write("\t\t\t\t\t\tbutarray[1] = \"cancel\";\r\n");
      out.write("\t\t\t\t\t\tbox.buttons = butarray;\r\n");
      out.write("\t\t\t\t\t\tbox.show();\r\n");
      out.write("\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t'editpass' : function(t) {\r\n");
      out.write("\t\t\t\t\t\tvar box = new Sys.msgbox('修改登录密码','");
      out.print(contextPath );
      out.write("/bams/editUserPwdMsg.jsp','700','450');\r\n");
      out.write("\t\t\t\t\t\tbox.msgtitle=\"<b>修改密码</b><br/>修改登录密码后再次登录将生效!\";\r\n");
      out.write("\t\t\t\t\t\tvar butarray = new Array();\r\n");
      out.write("\t\t\t\t\t\tbutarray[0] = \"ok|updatepassword();\";\r\n");
      out.write("\t\t\t\t\t\tbutarray[1] = \"cancel\";\r\n");
      out.write("\t\t\t\t\t\tbox.buttons = butarray;\r\n");
      out.write("\t\t\t\t\t\tbox.show();\r\n");
      out.write("\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t'exit' : function(t) {\r\n");
      out.write("\t\t\t\t\t\tif(window.confirm(\"确定要退出系统吗？\")){\r\n");
      out.write("\t\t\t\t\t\t\tlocation.href=\"");
      out.print(contextPath );
      out.write("/checkSession.do\";\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\tmenuStyle : {\r\n");
      out.write("\t\t\t\t\twidth : '100px'\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\titemStyle: {\r\n");
      out.write("\t\t\t\t      padding: '3px 10px'\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\tallowMouseOver : true,\r\n");
      out.write("\t\t\t\toffsetx : 80\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t})\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tfunction projectOpen(id){\r\n");
      out.write("\t\t\tdocument.getElementById(\"methodleftfrm\").src = \"");
      out.print(contextPath );
      out.write("/bams/index_left.jsp?mid=\"+id;\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tfunction updatepasswordback(data){\r\n");
      out.write("\t\t\tif(data.success){\r\n");
      out.write("\t\t\t\tconfirmmsg(\"密码修改成功，点击确定重新登录!\",\"repload()\");\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tfunction updatenamedback(data){\r\n");
      out.write("\t\t\tif(data.success){\r\n");
      out.write("\t\t\t\tconfirmmsg(\"用户名修改成功，点击确定重新登录!\",\"repload()\");\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tfunction repload(){\r\n");
      out.write("\t\t\tlocation.href=\"");
      out.print(contextPath );
      out.write("/login.jsp\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t</head>\r\n");
      out.write("\r\n");
      out.write("\t<body style=\"overflow:hidden;\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<table width=\"100%\" height=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td height=\"55\" style=\"background:url('");
      out.print(contextPath );
      out.write("/images/top-5.png') repeat-x;\">\r\n");
      out.write("\t\t\t\t<!-- 首页顶部开始 -->\r\n");
      out.write("\t\t\t\t<table width=\"100%\" height=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td style=\"padding-left:5px;padding-right:5px\" valign=\"middle\">\r\n");
      out.write("\t\t\t\t\t<img border=\"0\" alt=\"公司logo\" src=\"");
      out.print(contextPath );
      out.write("/images/syslogin.png\" style=\"height:35px;\">\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td valign=\"top\" width=\"100%\" align=\"right\">\r\n");
      out.write("\t\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td align=\"right\" height=\"30\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<table border=\"0\" style=\"margin-right:10px;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td style=\"color:#FFFFFF;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t欢迎您：");
      out.print(sessionUser.getEmployeeName() );
      out.write("&nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t[ 部门:");
      out.print(sessionUser.getEmployeeDeptName() );
      out.write("&nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t岗位:");
      out.print(sessionUser.getMainPost() == null ? "管理员" : sessionUser.getMainPost().getHrmPostName() );
      out.write(" ]&nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<a id=\"config\" href=\"javascript:void(0);\"><img src=\"");
      out.print(contextPath );
      out.write("/images/logout.png\" /></a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td height=\"27\">\r\n");
      out.write("\t\t\t\t\t            <table style=\"width: 100%; table-layout: fixed;\" cellSpacing=\"0\" border=\"0\" cellPadding=\"0\">\r\n");
      out.write("\t\t\t\t\t              <tr>\r\n");
      out.write("\t\t\t\t\t                <td id=\"tab_left\" class=\"pre\"><a class=\"hidden\" title=\"向前\" href=\"javascript:onLefttab();\">向前</a></td>\r\n");
      out.write("\t\t\t\t\t                <td><iframe id=\"tabFrame\" src=\"");
      out.print(contextPath );
      out.write("/js/tabs/systabs.html\" frameBorder=\"0\" \r\n");
      out.write("\t\t\t\t\t\t                 width=\"100%\" height=\"27\"  name=\"tabs\" marginWidth=\"0\" marginHeight=\"0\" scrolling=\"no\" allowTransparency=\"true\"></iframe></td>\r\n");
      out.write("\t\t\t\t\t                <td id=\"tab_right\" class=\"next\"><a class=\"hidden\" title=\"向后 \" href=\"javascript:onRighttab();\">向后</a></td>\r\n");
      out.write("\t\t\t\t\t              </tr>\r\n");
      out.write("\t\t\t\t\t\t        </table>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<div style=\"display:none;\" id='configMenu'>\r\n");
      out.write("\t\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t\t<li id='viewemployee'>查看个人信息</li>\r\n");
      out.write("\t\t\t\t\t\t\t<li id='editname'>修改用户名</li>\r\n");
      out.write("\t\t\t\t\t\t\t<li id='editpass'>修改密码</li>\r\n");
      out.write("\t\t\t\t\t\t\t<li id='exit'><font color=\"red\">退出系统</font></li>\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t<!-- 首页顶部结束 -->\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t<!-- 首页中间开始 -->\r\n");
      out.write("\t\t\t<table width=\"100%\" height=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td id=\"split_l\" style=\"width:200px;\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"div_title\">功能菜单</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"div_content_top\">\r\n");
      out.write("\t\t\t\t\t\t\t<iframe frameborder=\"0\" allowTransparency=\"true\" id=\"methodleftfrm\" width=\"100%\" height=\"100%\" scrolling=\"no\" marginheight=\"0\"></iframe>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"div_title\">模块切换</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"div_content_bottom\" style=\"height:");
      out.print(height);
      out.write("px;\">\r\n");
      out.write("\t\t\t\t\t\t\t<!-- 个人模块切换开始 -->\r\n");
      out.write("\t\t\t\t\t\t\t<table cellspacing=\"0\" cellpadding=\"5\" align=\"center\" border=\"0\">\r\n");
      out.write("\t\t\t\t\t\t\t");

							int row = Integer.parseInt(SystemConfig.getParam("bams.show.projectchange"));
							for(int i=0;i<msize;i++){
								SysMethodInfo sysMethod =userModuleMethods.get(i);
								int counttd=0;
								if(i%row==0){
								
      out.write("<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t");
}
      out.write("<td valign=\"middle\" align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<a href=\"javascript:projectOpen('");
      out.print(sysMethod.getPrimaryKey());
      out.write("');\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<img src=\"");
      out.print(contextPath+"/images/projectimg/"+sysMethod.getImageSrc() );
      out.write("\"/><br/>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t");
      out.print( StringTool.textCut(sysMethod.getMethodInfoName(), 4, "") );
      out.write("</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t");

								counttd++;
								if((i%row ==0&&counttd%row==0)||i==userModuleMethods.size()-1){
								
      out.write("</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t");
}
} 
      out.write("</table>\r\n");
      out.write("\t\t\t\t\t\t\t<!-- 个人模块切换结束 -->\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t        <iframe height=\"100%\" width=\"100%\" marginHeight=\"0\" frameBorder=\"0\"\r\n");
      out.write("\t\t\t\t            name=\"mainframe\" id=\"mainframe\" marginWidth=\"0\" scrolling=\"no\"></iframe>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\t<!-- 首页中间结束 -->\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td height=\"30\" style=\"background:#1C77AC;\">\r\n");
      out.write("\t\t\t\t<!-- 首页底部开始 -->\t\r\n");
      out.write("\t\t\t\t<table width=\"100%\" height=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td style=\"padding-left:10px;\">\r\n");
      out.write("\t\t\t\t\t\t\t<font color=\"#ffffff\">\r\n");
      out.write("\t\t\t\t\t\t\t(c)2008-2014 Pinhuba BAMS精简版 Version 1.0\r\n");
      out.write("\t\t\t\t\t\t\t</font>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</table>\t\t\t\t\t\r\n");
      out.write("\t\t\t\t<!-- 首页底部结束 -->\t\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t</body>\r\n");
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
