package com.pinhuba.web.filter.dwrRemoter;

import javax.servlet.http.HttpServletRequest;
import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.extend.Calls;
import org.directwebremoting.extend.Replies;
import org.directwebremoting.impl.DefaultRemoter;
import org.directwebremoting.proxy.dwr.Util;
import com.pinhuba.common.util.LoginContext;

/**
 * 调用dwr方法时验证用户信息
 * 
 * @author peng.ning
 * @date Apr 28, 2010
 */
public class DWRRemoter extends DefaultRemoter {
	public Replies execute(Calls calls) {
		HttpServletRequest request = WebContextFactory.get().getHttpServletRequest();// 获取request对象
		Object obj = LoginContext.getSessionValueByLogin(request);
		
		if (obj == null) {
			this.loginOut("loginOut()");//执行页面方法
			return super.execute(new Calls());
		}
		return super.execute(calls);
	}

	private void loginOut(String jsmethod) {
		WebContext wct = WebContextFactory.get();
		Util util = new Util(wct.getScriptSession());
		util.addScript(new ScriptBuffer(jsmethod));
	}
}
