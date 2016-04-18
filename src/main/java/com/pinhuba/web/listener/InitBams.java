package com.pinhuba.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.apache.log4j.Logger;
import com.pinhuba.common.util.file.FileTool;
import com.pinhuba.common.util.file.properties.SystemConfig;

public class InitBams implements ServletContextListener {
	private Logger logger = Logger.getLogger(this.getClass());

	public void contextDestroyed(ServletContextEvent sce) {
		logger.info("系统被关闭。。。");
	}

	public void contextInitialized(ServletContextEvent event) {
		try {
			logger.info("加载配置文件......");
			SystemConfig tCimsSystemConfig = SystemConfig.getInstance();
			if (tCimsSystemConfig == null) {
				logger.error("====初始化 [配置文件] 失败=======");
			}
			logger.info("创建系统所需目录及文件....");
			this.createDirAndFile(event.getServletContext());
		} catch (Exception e) {
			logger.error("[init system error]:" + e.getMessage());
			e.printStackTrace();
		}
		logger.info("[success]Project init has been finished...");
	}

	private void createDirAndFile(javax.servlet.ServletContext servletContext) throws Exception {
		boolean bl = FileTool.checkDirAndCreate(SystemConfig.getParam("bams.upload.fileSavePath"));
		if (bl) {
			logger.info("创建:" + SystemConfig.getParam("bams.upload.fileSavePath"));
		}

		bl = FileTool.checkDirAndCreate(SystemConfig.getParam("bams.upload.imgSavePath"));
		if (bl) {
			logger.info("创建:" + SystemConfig.getParam("bams.upload.imgSavePath"));
		}

		String defaultNoImgPath = SystemConfig.getParam("bams.upload.imgSavePath") + "noimg.gif";
		if (!FileTool.getIsFile(defaultNoImgPath)) {
			String systemImg = servletContext.getRealPath("/images/noimg.gif");
			FileTool.saveFileToFile(systemImg, defaultNoImgPath);
			logger.info("复制暂无图片文件...");
		}
	}

}
