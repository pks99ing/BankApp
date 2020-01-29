package com.bank.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.model.LoginDao;

@WebServlet("/getTransactionDetails")
public class GetTransactionDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String acc_no=(String)session.getAttribute("acc_id");
		LoginDao dao=new LoginDao();
		dao.setAcc_id(acc_no);
		ArrayList<String> transaction = dao.getTransaction();
		session.setAttribute("transactions",transaction );
		response.sendRedirect("transDetails.jsp");
	}

}
