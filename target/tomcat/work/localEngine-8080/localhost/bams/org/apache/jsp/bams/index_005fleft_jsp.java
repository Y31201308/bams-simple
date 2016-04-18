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

public final class index_005fleft_jsp extends org.apache.jasper.runtime.HttpJspBase
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

String mid = request.getParameter("mid");	//跳转项目代码
SysMethodInfo method = UtilTool.getSysMethodInfoByPk(this.getServletContext(),mid);
if(method == null){
	out.print("不能加载用户功能菜单...");
	return;
}
String[] mids = new String[]{"01","02"};//定义需要展开的模块ID
Boolean autoExpand = false;
if(Arrays.asList(mids).contains(mid)) autoExpand = true;

      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("\t\t<link type='text/css' rel='stylesheet' href='");
      out.print(contextPath);
      out.write("/css/xtree.css' />\r\n");
      out.write("\t\t<script type='text/javascript' src='");
      out.print(contextPath);
      out.write("/js/treeJs/map.js' charset='UTF-8'></script>\r\n");
      out.write("\t\t<script type='text/javascript' src='");
      out.print(contextPath);
      out.write("/js/treeJs/xtree.js' charset='UTF-8'></script>\r\n");
      out.write("\t\t<script type='text/javascript' src='");
      out.print(contextPath);
      out.write("/js/treeJs/xloadtree.js' charset='UTF-8'></script>\r\n");
      out.write("\t\t<script type='text/javascript' src='");
      out.print(contextPath);
      out.write("/js/treeJs/checkboxTreeItem.js' charset='UTF-8'></script>\r\n");
      out.write("\t\t<script type='text/javascript' src='");
      out.print(contextPath);
      out.write("/js/treeJs/xmlextras.js' charset='UTF-8'></script>\r\n");
      out.write("\t\t<script type='text/javascript' src='");
      out.print(contextPath);
      out.write("/js/treeJs/checkboxXLoadTree.js' charset='UTF-8'></script>\r\n");
      out.write("\t\t<script type='text/javascript' src='");
      out.print(contextPath);
      out.write("/js/treeJs/radioTreeItem.js' charset='UTF-8'></script>\r\n");
      out.write("\t\t<script type='text/javascript' src='");
      out.print(contextPath);
      out.write("/js/treeJs/radioXLoadTree.js' charset='UTF-8'></script>\r\n");
      out.write("\t\t<script type='text/javascript'>webFXTreeConfig.setImagePath('");
      out.print(contextPath);
      out.write("/js/treeJs/images/default/');</script>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body>\r\n");
      out.write("\t\t<div class=\"div_tree\">\r\n");
      out.write("\t\t\t<style>\r\n");
      out.write("\t\t\t.webfx-tree-item a{\r\n");
      out.write("\t\t\t\tfont-family:微软雅黑;\r\n");
      out.write("\t\t\t\tfont-size:14px;\r\n");
      out.write("\t\t\t\tletter-spacing:0.5px;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t</style>\r\n");
      out.write("\t\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t\tvar action = \"\";\r\n");
      out.write("\t\t\t");
 if (method.getMethodUri() != null && method.getMethodUri().length() > 0){
      out.write("\r\n");
      out.write("\t\t\t\taction = \"treeclick('");
      out.print( method.getMethodRealUri(method.getPrimaryKey()));
      out.write("');\";\r\n");
      out.write("\t\t\t");
}
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t//每个页面值支持一个树 默认采用该目录图片生成树\r\n");
      out.write("\t\t\tvar tree = new WebFXLoadTree(\"");
      out.print(method.getMethodInfoName());
      out.write('"');
      out.write(',');
      out.write('"');
      out.print(contextPath);
      out.write("/bams/tree/usermethods.jsp?code=");
      out.print(method.getPrimaryKey());
      out.write("\" ,action,\"\",\"");
      out.print(contextPath);
      out.write("/images/projectimg/");
      out.print(method.getImageSrc());
      out.write("\");\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\tfunction treeclick(url){openMDITab(url);}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tdocument.write(tree);\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t");
if(autoExpand){
      out.write("//判断哪个模块需要自动该展开\r\n");
      out.write("\t\t\t\tsetTimeout(function(){autoExpand();},500);\r\n");
      out.write("\t\t\t");
}
      out.write("</script>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("   </body>\r\n");
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
