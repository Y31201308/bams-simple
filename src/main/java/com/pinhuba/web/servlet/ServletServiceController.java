package com.pinhuba.web.servlet;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import org.apache.log4j.Logger;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import com.pinhuba.core.iservice.IFileProcessService;
import com.pinhuba.core.iservice.IUserLoginService;

/**
 * 
 * @author Frin
 * @description 定义service实例化方法,通过获取ServletContext来获取spring容器，然后注入service。
 */
public abstract class ServletServiceController extends HttpServlet {
	private Logger logger = Logger.getLogger(ServletServiceController.class);

	private ServletContext context; // servlet容器
	private WebApplicationContext webAppContext; // spring容器

	private IUserLoginService userLoginService;
	private IFileProcessService fileProcessService;
	
	public void setContext(ServletContext context) {
		if(webAppContext == null && this.context == null){
			this.context = context;
		}
	}

	private void checkSpringWebAppContext(ServletContext context) {
		logger.debug("check spring application context...");

		if (context == null) {
			logger.error("please add servlet context to your servlet.setContext(ServletContext)...");
			throw new RuntimeException("please add servlet context to your servlet.setContext(ServletContext)...");
		}
		if (webAppContext == null) {
			webAppContext = WebApplicationContextUtils
					.getWebApplicationContext(context);
		}
	}
	
	public IUserLoginService getUserLoginService(){
		checkSpringWebAppContext(this.context);
		if (userLoginService == null) {
			userLoginService = (IUserLoginService) webAppContext.getBean("userLoginService");
		}
		return userLoginService;
	}
	
	public IFileProcessService getFileProcessService(){
		checkSpringWebAppContext(this.context);
		if (fileProcessService == null) {
			fileProcessService = (IFileProcessService) webAppContext.getBean("fileProcessService");
		}
		return fileProcessService;
	}
}
