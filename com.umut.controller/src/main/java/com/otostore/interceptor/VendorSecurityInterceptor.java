package com.otostore.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class VendorSecurityInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		String loginUrl = request.getContextPath() + "/login/";
		if (request.getSession().getAttribute("loggedInVendor") == null) {
			response.sendRedirect(loginUrl); /*Login olmayan vendor kullan�c�s�n�n t�m vendors Url adreslerine eri�imi engellenmi�tir.*/
			return false;
		}
		return true;
	}

}
