package com.pinhuba.common.util;

import com.pinhuba.common.util.file.properties.SystemConfig;

public class ConstWords {
	public static final String TempStringMsg = "MsgSession"; // 登录临时交换

	public static final String ValidCodeTempSession = "CodeRandSession";// 存放验证码session

	public static final String TempStringRequest = "TempStringRequest";

	public static final String TempStringRequest2 = "TempStringRequest2";

	public static final String METHOD_INFO_ID = "mid";// 左侧功能块ID参数名

	public static final String MEMBER = "member";
	
	// 个人文件目录名称
	public static final String septor = "/";
	
	public static final String UserName = "person";

	public static final String DOWNLOADFILE = "downloadfile";

	public static final String DOWNLOADFILE_PATH = septor + DOWNLOADFILE + septor;

	public static int getProjectChangeHeight(int methodCount) throws Exception {
		int height = 60;
		int row = Integer.parseInt(SystemConfig.getParam("bams.show.projectchange"));

		if (methodCount > row) {
			if (methodCount % row == 0) {
				height = methodCount / row;
			} else {
				height = methodCount / row + 1;
			}

			return height * 60;
		} else {
			return height;
		}
	}
}
