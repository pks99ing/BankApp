package com.bank.controller;

import java.io.IOException;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.model.LoginDao;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hello");
		String cid = request.getParameter("cust_id");
		String password = request.getParameter("pass");
		
		LoginDao dao=new LoginDao();
		dao.setPassword(password);
		dao.setCust_id(cid);
		boolean status = dao.loginToHomePage();
		String acc_id=dao.getAcc_id();
		if(status) {
			HttpSession session=request.getSession(true);
			session.setAttribute("acc_id", acc_id);
			session.setAttribute("DAO", dao);
			response.sendRedirect("home.jsp");
		}else {
			response.sendRedirect("loginUnSuccessfull.html");;
		}
		
	}

}
