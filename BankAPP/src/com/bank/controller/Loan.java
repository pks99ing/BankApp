package com.bank.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.model.LoginDao;

@WebServlet("/loan")
public class Loan extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String loanType = request.getParameter("loan");
		int amt = Integer.parseInt(request.getParameter("amt"));
		int time = Integer.parseInt(request.getParameter("time"));
		int si;
		int rate;
		HttpSession session2 = request.getSession();
		HttpSession session = session2;
		session.setAttribute("pri", amt);
		session.setAttribute("time", time);
		
		if (loanType.equals("homeLoan")) {
			rate = 5;
			si = (amt * time * rate) / 100;
			session.setAttribute("si", si);
			session.setAttribute("rate", rate);
		} else if (loanType.equals("carLoan")) {
			rate = 3;
			si = (amt * time * rate) / 100;
			session.setAttribute("si", si);
			session.setAttribute("rate", rate);
		} else if (loanType.equals("eduLoan")) {
			rate = 2;
			si = (amt * time * rate) / 100;
			session.setAttribute("si", si);
			session.setAttribute("rate", rate);

		} else if (loanType.equals("marLoan")) {
			rate = 3;
			si = (amt * time * rate) / 100;
			session.setAttribute("si", si);
			session.setAttribute("rate", rate);

		} else {
			rate = 7;
			si = (amt * time * rate) / 100;
			session.setAttribute("si", si);
			session.setAttribute("rate", rate);
		}
		LoginDao dao=new LoginDao();
		String acc_id=(String)session.getAttribute("acc_id");
		dao.setAcc_id(acc_id);
		dao.setAmount(amt);
		dao.setInterest(si+amt);
		dao.setLoanType(loanType);
		boolean status = dao.updateLoan();
		if(status)
		response.sendRedirect("loan-process.jsp");
		else
			response.sendRedirect("loan-fail.jsp");
	}

}
