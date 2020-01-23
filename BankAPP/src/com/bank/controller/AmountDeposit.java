package com.bank.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.model.LoginDao;

@WebServlet("/amountDeposit")
public class AmountDeposit extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int amount=Integer.parseInt(request.getParameter("amount"));
		HttpSession session = request.getSession();
		String acc_no = (String) session.getAttribute("acc_id");
		LoginDao dao=new LoginDao();
		dao.setAcc_id(acc_no);
		dao.setAmount(amount);
		boolean status=dao.amountDeposit();
		if(status) {
			response.sendRedirect("withdrawalSuccess.html");
		}
		else {
			response.sendRedirect("error.html");
		}
	}

}
