package com.bank.controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/ChangePassword")
public class ChangePasswordFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String pass1 = request.getParameter("pass1");
		String pass2 = request.getParameter("pass2");
		if (pass1.equals(pass2)) {
			chain.doFilter(request, response);
		}
		else {
			((HttpServletResponse) response).sendRedirect("error.html");
		}
	}

}
