package com.bank.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.model.LoginDao;

@WebServlet("/transferAmount")
public class TransferAmount extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int amount=Integer.parseInt(request.getParameter("tamt"));
		String taccno=(String)request.getParameter("tacct");
		HttpSession session=request.getSession();
		String accno=(String)session.getAttribute("acc_id");
		LoginDao dao=new LoginDao();
		dao.setAcc_id(accno);
		dao.setAmount(amount);
		dao.settAcct(taccno);
		boolean status = dao.transferAmount();
		if(status)
			response.sendRedirect("amountTransferSuccess.html");
		else
			response.sendRedirect("amountTransferFail.html");
	}

}
