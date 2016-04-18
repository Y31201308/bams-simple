package com.pinhuba.web.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pinhuba.common.module.SessionUser;
import com.pinhuba.common.util.ConstWords;
import com.pinhuba.common.util.LoginContext;
import com.pinhuba.common.util.file.properties.SystemConfig;
import com.pinhuba.core.iservice.IUserLoginService;
import com.pinhuba.core.pojo.SysMethodInfo;
import com.pinhuba.core.pojo.SysUserInfo;
import com.pinhuba.web.servlet.ServletServiceController;

public class UserLoginServlet extends ServletServiceController {
		
	private static final long serialVersionUID = 2560424066821933328L;
	public UserLoginServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); 
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path ="login.jsp";
		response.setContentType("text/html");
		IUserLoginService userLoginservice =this.getUserLoginService();
		String userName =request.getParameter("username");
		String userPwd =request.getParameter("userpwd");
		String code = request.getParameter("code");//验证码
		
		//根据配置文件  是否对验证码 进行判断
		if(Boolean.parseBoolean(SystemConfig.getParam("bams.sys.codeIsview"))){
			if (request.getSession().getAttribute(ConstWords.ValidCodeTempSession)==null) {
				request.setAttribute(ConstWords.TempStringMsg, "验证码失效，请重新登录！");
				request.getRequestDispatcher(path).forward(request, response);
				return;
			}
			
			String sessioncode = (String) request.getSession().getAttribute(ConstWords.ValidCodeTempSession);
			if (!sessioncode.equalsIgnoreCase(code)) {
				request.setAttribute(ConstWords.TempStringMsg, "验证码输入错误！");
				request.getRequestDispatcher(path).forward(request, response);
				return;
			}
		}
		
		SysUserInfo userInfo = userLoginservice.vaildityUserInfo(userName, userPwd);
		if (userInfo == null) {
			request.setAttribute(ConstWords.TempStringMsg, "用户名或密码输入错误！");
			request.getRequestDispatcher(path).forward(request, response);
		}else{
			//创建平台session
			SessionUser sUser = userLoginservice.packageUserInfo(userName);
			
			//用户是否包含权限
			if (sUser.getUserMethodsSet().size()==0) {
				request.setAttribute(ConstWords.TempStringMsg, "用户没有权限，请联系管理员！");
				request.getRequestDispatcher(path).forward(request, response);
				return;
			}
			
			LoginContext.SetSessionValueByLogin(request, sUser);
		
			//进行转向
			SysMethodInfo forwardMethodInfo = sUser.getUserModuleMethods().get(0);
			response.sendRedirect("bams/index.jsp?mid="+forwardMethodInfo.getPrimaryKey());
		}
	}

	public void init() throws ServletException {
		super.init();
		super.setContext(this.getServletContext());
	}
}
