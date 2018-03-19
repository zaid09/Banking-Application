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
 * Servlet implementation class TransPwdServlet
 */
@SuppressWarnings("serial")
@WebServlet("/TransPwdServlet")
public class TransPwdServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String oldTrans = request.getParameter("tpwd");
		String newTrans = request.getParameter("ntpwd");
		boolean status = TransPasswordDao.checkTransPwd(oldTrans);
		if(status==true){
			TransPasswordDao.updateTransPwd(newTrans, oldTrans);;
			int custId = LoginDao.cid;
			int acc = LoginDao.accNo;
			AccountDao accDao = new AccountDao();
			int bal = accDao.getBalance(acc);
			String name = accDao.getName(custId);
			String type = accDao.getAccType(acc);
			int msg=6;
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
			int msg=7;
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
