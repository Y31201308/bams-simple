package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import com.pinhuba.core.pojo.SysMethodInfo;
import com.pinhuba.common.util.ConstWords;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import com.pinhuba.core.iservice.ISysProcessService;
import com.pinhuba.common.module.SessionUser;
import com.pinhuba.common.util.LoginContext;
import com.pinhuba.core.pojo.SysException;
import com.pinhuba.common.util.UtilWork;
import com.pinhuba.common.util.UtilTool;
import com.pinhuba.common.util.EnumUtil;

public final class error_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    Throwable exception = org.apache.jasper.runtime.JspRuntimeLibrary.getThrowable(request);
    if (exception != null) {
      response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
    }
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


if(exception != null){
	WebApplicationContext webAppContext = 
			WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
	ISysProcessService sysProcessService = 
			(ISysProcessService)webAppContext.getBean("sysProcessService");
	
	SessionUser sessionUser =(SessionUser)LoginContext.getSessionValueByLogin(request);
	SysException sException =new SysException();
	int userId =-1;
	if(sessionUser != null){
		userId = Integer.parseInt(sessionUser.getUserInfo().getPrimaryKey()+"");
	}
	sException.setUserId(userId);
	sException.setExceptionClass(exception.getClass().getName());
	sException.setExceptionDate(UtilWork.getNowTime());
	sException.setExceptionMsg(exception.getMessage());
	StringBuffer sb =new StringBuffer(); 
	for(int i=0;i<exception.getStackTrace().length;i++){
		sb.append(exception.getStackTrace()[i]);
	}
	sException.setExceptionContext(sb.toString());
	sException.setExceptionStatus(EnumUtil.SYS_EXCEPTION_STATUS.Vaild.value);
	sysProcessService.saveSysException(sException);
}

      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("<title>错误页面</title>\n");
      out.write("<link rel='stylesheet' type='text/css' href='");
      out.print(request.getContextPath());
      out.write("/css/normal.css' />\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t<div style=\"width:600px;margin:0 auto;border:1px solid #d1d1d1;margin-top:150px;padding:20px;\">\n");
      out.write("\t\t<table cellSpacing=\"5\" width=\"90%\" align=\"center\" border=\"0\" cepadding=\"0\" style=\"line-height: 25px;\">\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t\t<td valign=\"top\" align=\"middle\"><img border=\"0\" id=\"errimg\" src=\"");
      out.print(request.getContextPath()+"/images/404.png" );
      out.write("\">\n");
      out.write("\t\t\t\t<td>\n");
      out.write("\t\t\t\t<td>\n");
      out.write("\t\t\t\t\t<h1 style=\"color: red;font-size:20px;\">操作错误</h1> \n");
      out.write("\t\t\t\t\t<label style=\"color: #001150\"> \n");
      out.write("\t\t\t\t\tHTTP 错误 404/500：<br />\n");
      out.write("\t\t\t\t\t您正在搜索的页面可能暂时不可用,也可能您的访问权限不够, <br /> \n");
      out.write("\t\t\t\t\t或者您在系统的认证已经过期，无法继续使用系统。 \n");
      out.write("\t\t\t\t\t</label>\n");
      out.write("\t\t\t\t\t<hr style=\"color:#c1c1c1;\">\n");
      out.write("\t\t\t\t\t<p>\n");
      out.write("\t\t\t\t\t\t☉ <b>请尝试以下操作：</b>\n");
      out.write("\t\t\t\t\t</p>\n");
      out.write("\t\t\t\t\t<ul>\n");
      out.write("\t\t\t\t\t\t<li>确保登陆并且有访问该页面的权限成功。</li>\n");
      out.write("\t\t\t\t\t\t<li>确保操作条件或内容的拼写和格式正确无误。</li>\n");
      out.write("\t\t\t\t\t\t<li>如果操作出现未知错误，请与网站管理员联系。</li>\n");
      out.write("\t\t\t\t\t\t<li>建议你尝试： \n");
      out.write("\t\t\t\t\t\t<a href=\"javascript:void(0);\" onclick=\"window.history.go(-1);\"> \n");
      out.write("\t\t\t\t\t\t<font color=\"green\">返回</font> \n");
      out.write("\t\t\t\t\t\t</a> \n");
      out.write("\t\t\t\t\t\t&nbsp;&nbsp;或&nbsp;&nbsp; \n");
      out.write("\t\t\t\t\t\t<a href=\"javascript:void(0);\" onclick=\"forw();\"> \n");
      out.write("\t\t\t\t\t\t<font color=\"green\">重新登录</font> \n");
      out.write("\t\t\t\t\t\t</a>\n");
      out.write("\t\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t\t<hr style=\"color:#c1c1c1;\">\n");
      out.write("\t\t\t\t\t<p>\n");
      out.write("\t\t\t\t\t\t☉ 如果您对系统有任何疑问、建议，请联系管理员 : <a href=\"mailto:service@pinhuba.com\"> <font color=\"#336699\">service@pinhuba.com</font> </a>\n");
      out.write("\t\t\t\t\t</p></td>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t</table>\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("\t<script type=\"text/javascript\">\n");
      out.write("    function forw(){\n");
      out.write("\t\ttop.location.href=\"");
      out.print(request.getContextPath());
      out.write("/login.jsp\";\n");
      out.write("    }\n");
      out.write("\t</script>\n");
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
