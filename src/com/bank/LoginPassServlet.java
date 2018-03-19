package com.bank;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginPassServlet
 */
@SuppressWarnings("serial")
@WebServlet("/LoginPassServlet")
public class LoginPassServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String oldLogin = request.getParameter("lpwd");
		String newLogin = request.getParameter("npwd");
		boolean status = PasswordDao.checkLoginPwd(oldLogin);
		if(status==true){
			PasswordDao.updateLoginPwd(newLogin, oldLogin);
			int custId = LoginDao.cid;
			int acc = LoginDao.accNo;
			AccountDao accDao = new AccountDao();
			int bal = accDao.getBalance(acc);
			String name = accDao.getName(custId);
			String type = accDao.getAccType(acc);
			int msg=4;
			request.setAttribute("balance", bal);
			request.setAttribute("name",name );
			request.setAttribute("type", type);
			request.setAttribute("account", acc);
			TransStatementDao tstdao = new TransStatementDao();
			ArrayList<TransactionDetails> transList=tstdao.readAllTrans();
			request.setAttribute("transDetails", transList);
			request.setAttribute("MSG",msg);
			request.setAttribute("status", status);
			RequestDispatcher reqId = request.getRequestDispatcher("account.jsp");
				reqId.forward(request, response);
		}
		else {
			int custId = LoginDao.cid;
			int acc = LoginDao.accNo;
			AccountDao accDao = new AccountDao();
			int bal = accDao.getBalance(acc);
			String name = accDao.getName(custId);
			String type = accDao.getAccType(acc);
			int msg=5;
			request.setAttribute("balance", bal);
			request.setAttribute("name",name );
			request.setAttribute("type", type);
			request.setAttribute("account", acc);
			TransStatementDao tstdao = new TransStatementDao();
			ArrayList<TransactionDetails> transList=tstdao.readAllTrans();
			request.setAttribute("transDetails", transList);
			request.setAttribute("MSG",msg);
			request.setAttribute("status", status);
			RequestDispatcher reqId = request.getRequestDispatcher("account.jsp");
				reqId.forward(request, response);
		}
	}


}
