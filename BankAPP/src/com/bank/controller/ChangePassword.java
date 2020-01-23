package com.bank.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.model.LoginDao;

@WebServlet("/ChangePassword")
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginDao dao=new LoginDao();
		HttpSession session = request.getSession();
		String acc_no=(String) session.getAttribute("acc_id");
		String newPass=request.getParameter("pass1");
		dao.setPassword(newPass);
		dao.setAcc_id(acc_no);
		boolean status = dao.changePassword();
		if(status) {
			response.sendRedirect("successPwd.html");
		}
		else {
			response.sendRedirect("failurePwd.html");
		}
	}

}
