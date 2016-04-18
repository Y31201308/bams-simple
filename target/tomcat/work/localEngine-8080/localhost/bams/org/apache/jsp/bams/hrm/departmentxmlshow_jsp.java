package org.apache.jsp.bams.hrm;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class departmentxmlshow_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

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


response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader("Expires",0);
String contextPath = request.getContextPath();
String ischeck = request.getParameter("ischeck");
String tmp ="";
if(ischeck!=null&&ischeck.length()>0){
	tmp+="&ischeck=true";
}

      out.write("<link type='text/css' rel='stylesheet' href='");
      out.print(contextPath);
      out.write("/css/xtree.css' />\n");
      out.write("<script type='text/javascript' src='");
      out.print(contextPath);
      out.write("/js/treeJs/map.js' charset='UTF-8'></script>\n");
      out.write("<script type='text/javascript' src='");
      out.print(contextPath);
      out.write("/js/treeJs/xtree.js' charset='UTF-8'></script>\n");
      out.write("<script type='text/javascript' src='");
      out.print(contextPath);
      out.write("/js/treeJs/xloadtree.js' charset='UTF-8'></script>\n");
      out.write("<script type='text/javascript' src='");
      out.print(contextPath);
      out.write("/js/treeJs/checkboxTreeItem.js' charset='UTF-8'></script>\n");
      out.write("<script type='text/javascript' src='");
      out.print(contextPath);
      out.write("/js/treeJs/xmlextras.js' charset='UTF-8'></script>\n");
      out.write("<script type='text/javascript' src='");
      out.print(contextPath);
      out.write("/js/treeJs/checkboxXLoadTree.js' charset='UTF-8'></script>\n");
      out.write("<script type='text/javascript' src='");
      out.print(contextPath);
      out.write("/js/treeJs/radioTreeItem.js' charset='UTF-8'></script>\n");
      out.write("<script type='text/javascript' src='");
      out.print(contextPath);
      out.write("/js/treeJs/radioXLoadTree.js' charset='UTF-8'></script>\n");
      out.write("<script type='text/javascript'>webFXTreeConfig.setImagePath('");
      out.print(contextPath);
      out.write("/js/treeJs/images/default/');</script>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("\tfunction setliandong(obj){\n");
      out.write("\t\twebFXTreeConfig.setCascadeCheck(obj.checked); \n");
      out.write("\t}\n");
      out.write("\twebFXTreeConfig.setCascadeCheck(true);\t\n");
      out.write("    var tree = new WebFXLoadTree(\"组织机构树\",\"");
      out.print(request.getContextPath());
      out.write("/bams/tree/departmenttree.jsp?fid=00");
      out.print(tmp);
      out.write("\",\"treeclick('');\");\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("<div class=\"div_tree\">\n");
      out.write("\t");

	if(ischeck!=null && ischeck.length()>0){ 
	
      out.write("<input type=\"checkbox\" id=\"lidong\" onchange=\"setliandong(this)\" checked=\"checked\">\n");
      out.write("\t\t<label for=\"lidong\" style=\"color: #336699\">选择上级自动选中下级</label>\n");
      out.write("\t");

	} 
	
      out.write("<script type=\"text/javascript\">\n");
      out.write("     document.write(tree);\n");
      out.write("     \n");
      out.write("     function getCheckedIds(){\n");
      out.write("\t\tdocument.getElementById(\"upcode\").value =getCheckValues();\n");
      out.write("\t\tqueryData();\n");
      out.write("\t}\n");
      out.write("</script>\n");
      out.write("</div>\n");
      out.write("<input type=\"hidden\" id=\"upcode\">\n");
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
