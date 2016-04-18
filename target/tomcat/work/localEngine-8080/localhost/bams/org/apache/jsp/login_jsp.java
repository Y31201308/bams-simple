package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.pinhuba.common.util.file.properties.SystemConfig;
import java.util.List;
import com.pinhuba.common.util.ConstWords;
import com.pinhuba.common.util.EnumUtil;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import com.pinhuba.web.controller.dwr.DwrSysProcessService;
import com.pinhuba.common.util.UtilWork;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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


String path = request.getContextPath();
boolean blCode =Boolean.parseBoolean(SystemConfig.getParam("bams.sys.codeIsview"));//是否显示验证码
String msg = request.getAttribute(ConstWords.TempStringMsg)==null?"":(String)request.getAttribute(ConstWords.TempStringMsg);
String ptname = SystemConfig.getParam("bams.sys.name");

      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("<title>");
      out.print(ptname );
      out.write("</title>\n");
      out.write("<link rel='Shortcut Icon' href='");
      out.print(path );
      out.write("/favicon.ico' />\n");
      out.write("<link rel='Bookmark' href='");
      out.print(path );
      out.write("/favicon.ico' />\n");
      out.write("<link rel='stylesheet' type='text/css' href='");
      out.print(path );
      out.write("/css/login.css' />\n");
      out.write("<script type='text/javascript' src=\"");
      out.print(path );
      out.write("/js/cookie.js\"></script>\n");
      out.write("<script type='text/javascript' src='");
      out.print(path );
      out.write("/js/login.js'></script>\n");
      out.write("<script type='text/javascript' src='");
      out.print(path );
      out.write("/js/jquery-1.7.2.min.js'></script>\n");
      out.write("<script type='text/javascript' src='");
      out.print(path );
      out.write("/js/jquery.hotkeys.js'></script>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("function addFavorite(url,title){\n");
      out.write("    var fav_url = url;\n");
      out.write("\tvar fav_title = title;\n");
      out.write("\tif (document.all && window.external){\n");
      out.write("\t  window.external.AddFavorite(fav_url,fav_title);\n");
      out.write("\t}else if (window.sidebar){\n");
      out.write("\t  window.sidebar.addPanel(fav_title,fav_url,\"\");\n");
      out.write("\t}else{\n");
      out.write("\t  alert(\"浏览器不支持，请手动加入收藏夹\");\n");
      out.write("\t}\n");
      out.write("}\n");
      out.write("</script>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body style=\"height: 100%;background-image:url(");
      out.print(path );
      out.write("/images/login_bg.png);background-repeat: repeat-x;background-color: #7eb9e9\">\n");
      out.write("<form method=\"post\" name=\"loginform\" action=\"");
      out.print(path );
      out.write("/login.do\">\n");
      out.write("<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\"center\"  width=\"923\">\n");
      out.write("<tr height=\"88\">\n");
      out.write("\t<td width=\"527\" background=\"images/1.png\"></td>\n");
      out.write("\t<td width=\"320\" background=\"images/2.png\"></td>\n");
      out.write("\t<td width=\"76\" background=\"images/3.png\"></td>\n");
      out.write("</tr>\n");
      out.write("<tr height=\"73\">\n");
      out.write("\t<td width=\"527\" background=\"images/4.png\" valign=\"top\" nowrap=\"nowrap\">\n");
      out.write("\t\t<div style=\"font-size:28px;text-indent:120px;color:#247bce;font-weight:bold;margin-top:8px\">");
      out.print(ptname);
      out.write("</div>\n");
      out.write("\t</td>\n");
      out.write("\t<td width=\"320\" valign=\"top\" background=\"images/6.png\" rowspan=\"2\" style=\"background-color: #ffffff;background-repeat: no-repeat;background-position: right bottom;\">\n");
      out.write("\t\t<br/><br/><br/>\n");
      out.write("\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" height=\"30\">\n");
      out.write("\t\t<tr>\n");
      out.write("\t\t\t<td valign=\"bottom\"><div id=\"msgbox\" style=\"color: red;padding-left: 15px;font-size: 13px;\"></div></td>\n");
      out.write("\t\t</tr>\n");
      out.write("\t\t</table>\n");
      out.write("\t\t\n");
      out.write("\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" height=\"200\" style=\"padding-left: 18px\">\n");
      out.write("\t\t<tr>\n");
      out.write("\t\t<td style=\"color:#167FC8\">用户名</td>\n");
      out.write("\t\t<td style=\"padding-left:10px;\" nowrap><input type=\"text\" value=\"dxj\" class=\"niceform\" id=\"username\" name=\"username\" style=\"ime-mode:disabled;background:url('");
      out.print(request.getContextPath() );
      out.write("/images/userimg.gif') no-repeat 1px;padding-left:20px; font-size:12px;width:155px;\"/></td>\n");
      out.write("\t\t</tr>\n");
      out.write("\t\t<tr>\n");
      out.write("\t\t<td style=\"color:#167FC8\">密码</td>\n");
      out.write("\t\t<td style=\"padding-left:10px;position:relative;\" nowrap>\n");
      out.write("\t\t\t<div id=\"tipsdiv\" style=\"padding:4px;background-color:#fefefe;border:1px solid #aa540b;position:absolute;z-index:1;display:none;left:200px;\">\n");
      out.write("\t\t\t\t<table border='0' cellpadding='3' cellspacing='0'>\n");
      out.write("\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t<td rowspan='2'>\n");
      out.write("\t\t\t\t\t\t<img src =\"");
      out.print(path );
      out.write("/images/tipsimg.png\" border='0'/>\n");
      out.write("\t\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t\t\t<td style ='padding-left:3px;'  nowrap='nowrap'>大写锁定键<font color='#003366'>[CAPS LOCK]</font>被按下</td>\n");
      out.write("\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t<tr><td style ='padding-left:3px;'nowrap='nowrap'>请注意密码大小写</td></tr>\n");
      out.write("\t\t\t\t</table>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t<input type=\"password\" value=\"111111\" class=\"niceform\" id=\"userpwd\" name=\"userpwd\" onkeypress=\"detectCapsLock();\" onblur=\"hiddenTipsDiv();\"  style=\"background:url('");
      out.print(request.getContextPath() );
      out.write("/images/userpwdimg.gif') no-repeat 1px;padding-left:20px;font-size:12px;width:155px;\"/>\n");
      out.write("\t\t</td>\n");
      out.write("\t\t</tr>\n");
      out.write("\t\t\n");
      out.write("\t\t");
if(blCode==true){ 
      out.write("<tr>\n");
      out.write("\t\t<td style=\"color:#167FC8;\">验证码</td>\n");
      out.write("\t\t<td style=\"padding-left:10px;\" nowrap>\n");
      out.write("\t\t<input type=\"text\" id=\"code\" name=\"code\" class=\"niceform\" maxlength=\"4\" style=\"width: 90px;ime-mode:disabled;text-align:center; font-size:14px;font-variant: small-caps\"/>\n");
      out.write("\t\t&nbsp;&nbsp;<img border=0  src=\"");
      out.print(request.getContextPath() );
      out.write("/images/codeload.gif\" onclick=\"changecode(this)\"  title=\"点击切换验证码\" style=\"vertical-align:bottom;cursor: pointer;\" alt=\"点击重新加载\" id=\"codeimg\">\n");
      out.write("\t\t</td>\n");
      out.write("\t\t</tr>\n");
      out.write("\t\t");
} 
      out.write("<tr>\n");
      out.write("\t\t<td></td>\n");
      out.write("\t\t<td style=\"padding-left:10px;padding-top: 5px;\">\n");
      out.write("\t\t<input type=\"checkbox\"  id=\"usname\" name=\"usname\" style=\"vertical-align: middle;\"/><label for=\"usname\" style=\"color:#666666; padding-right:10px;\">记住用户名</label>\n");
      out.write("\t\t</td>\n");
      out.write("\t\t</tr>\n");
      out.write("\t\t<tr>\n");
      out.write("\t\t<td></td>\n");
      out.write("\t\t<td style=\"padding-top:10px; padding-left:10px;\" valign=\"top\">\n");
      out.write("\t\t<div id=\"loginbtndiv\">\n");
      out.write("\t\t<input type=\"button\" class=\"btn\" value=\" 登  录 \" onclick=\"loginCheck('");
      out.print(path );
      out.write("');\"/>&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("\t\t<input type=\"button\" class=\"btn_reg\" value=\"清  空\" onclick=\"clearinput()\"/>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div id=\"loginloadingdiv\" style=\"display: none;color: #006699;font-size: 13px;height: 36px\">\n");
      out.write("\t\t\t<img src =\"");
      out.print(path );
      out.write("/images/loginloading.gif\" border=\"0\" style=\"vertical-align: middle;\">&nbsp;&nbsp;&nbsp;&nbsp;系统登录中,请稍候...\n");
      out.write("\t\t</div>\n");
      out.write("\t\t</td>\n");
      out.write("\t\t</tr>\n");
      out.write("\t\t</table>\n");
      out.write("\t</td>\n");
      out.write("\t<td width=\"76\" background=\"images/5.png\"></td>\n");
      out.write("</tr>\n");
      out.write("<tr height=\"315\">\n");
      out.write("\t<td width=\"527\" background=\"images/7.png\"></td>\n");
      out.write("\t<td width=\"76\" background=\"images/8.png\"></td>\n");
      out.write("</tr>\n");
      out.write("<tr height=\"51\">\n");
      out.write("\t<td width=\"527\" background=\"images/9.png\"></td>\n");
      out.write("\t<td width=\"320\" background=\"images/10.png\"></td>\n");
      out.write("\t<td width=\"76\" background=\"images/11.png\"></td>\n");
      out.write("</tr>\n");
      out.write("</table>\n");
      out.write("\n");
      out.write("</form>\n");
      out.write("<center>\n");
      out.write("<table>\n");
      out.write("<tr>\n");
      out.write("<td style=\"color:#ffffff;font-size: 12px;\" align=\"center\">版权所有: 品互网络 Pinhuba (c)2008-2014</td>\n");
      out.write("</tr>\n");
      out.write("<tr>\n");
      out.write("<td style=\"color:#ffffff;font-size: 12px;\" align=\"center\">网址：<a href=\"http://www.pinhuba.com\">http://www.pinhuba.com</a></td>\n");
      out.write("</tr>\n");
      out.write("</table>\n");
      out.write("</center>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("if('");
      out.print(msg);
      out.write("'!=''){\n");
      out.write("\tdocument.getElementById(\"loginbtndiv\").style.display=\"block\";\n");
      out.write("\tdocument.getElementById(\"loginloadingdiv\").style.display=\"none\";\n");
      out.write("\tdocument.getElementById(\"msgbox\").innerHTML = '");
      out.print(msg);
      out.write("';\n");
      out.write("}\n");
      out.write("function changecode(obj){\n");
      out.write("\tif(obj != null)\n");
      out.write("\t\tobj.src = \"");
      out.print(path );
      out.write("/validcode.do?t=\"+Math.random();\n");
      out.write("}\n");
      out.write("</script>\n");
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
