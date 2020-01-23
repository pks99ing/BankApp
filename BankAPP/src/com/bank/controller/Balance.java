package com.bank.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.model.LoginDao;

@WebServlet("/Balance")
public class Balance extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
 
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Creating session of that particular request
		HttpSession session = request.getSession();
		//Getting account number from session object
		String acc_no=(String) session.getAttribute("acc_id");
		//geting DAO object
		LoginDao dao = (LoginDao) session.getAttribute("DAO");
		dao.setAcc_id(acc_no);
		boolean status=dao.checkBalance();
		String balance=dao.getBalance();
		
		if(status) {
			session.setAttribute("Balance",balance);
			response.sendRedirect("checkBalanceSuccess.jsp");
		}
		else {
			response.sendError(404);
		}
	
	}

}
