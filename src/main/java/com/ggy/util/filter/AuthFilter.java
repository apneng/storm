package com.ggy.util.filter;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

public class AuthFilter extends AuthorizationFilter{
	public boolean isAccessAllowed(ServletRequest req, ServletResponse resp, Object mappedValue) throws IOException {
		Subject subj = SecurityUtils.getSubject();
		String url = ((HttpServletRequest) req).getServletPath();
		boolean isPerm = subj.isPermitted(url);
		if (!isPerm) {
			System.out.println("未授权页面:" + url);
		}

		return isPerm;
	}


}
