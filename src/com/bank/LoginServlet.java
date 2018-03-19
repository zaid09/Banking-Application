package com.bank;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cid =  Integer.parseInt(request.getParameter("cid"));
		String password = request.getParameter("pwd");
		LoginDao dao = new LoginDao();
		boolean status = dao.validate(cid, password);
		if(status==true){
			int acc = dao.accNo;
			int custId = dao.cid;
			AccountDao accDao = new AccountDao();
			int bal = accDao.getBalance(acc);
			String name = accDao.getName(custId);
			String type = accDao.getAccType(acc);
			int msg=2;
			request.setAttribute("balance", bal);
			request.setAttribute("name",name );
			request.setAttribute("type", type);
			request.setAttribute("account", acc);
			TransStatementDao tstdao = new TransStatementDao();
			ArrayList<TransactionDetails> transList=tstdao.readAllTrans();
			request.setAttribute("transDetails", transList);
			request.setAttribute("MSG",msg);
			RequestDispatcher reqId = request.getRequestDispatcher("account.jsp");
				reqId.forward(request, response);
		}
		else {
			RequestDispatcher reqId = request.getRequestDispatcher("index.html");
		//	alert("Invalid Customer Id or Password");
			reqId.forward(request, response);
		}
	}	

}
