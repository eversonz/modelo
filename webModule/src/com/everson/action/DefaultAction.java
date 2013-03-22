package com.everson.action;

import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.octo.captcha.module.servlet.image.SimpleImageCaptchaServlet;
import com.opensymphony.xwork2.ActionSupport;

public class DefaultAction extends ActionSupport {

	private static final long serialVersionUID = 15909823456L;
	
	private HttpServletRequest request = ServletActionContext.getRequest();
	
	/**
	 * @return - validacao do captcha
	 */
	protected boolean isCaptcha(String value) {
		if (value != null) {
			return SimpleImageCaptchaServlet.validateResponse(request, value);
		}
		return false;
	}

	protected Object getBeanEJB(String ejbName) throws Exception {
		InitialContext ctx = new InitialContext();
		return ctx.lookup("earModule/" + ejbName + "/remote");
	}
	
}
