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
 * Servlet implementation class AddressServlet
 */
@SuppressWarnings("serial")
@WebServlet("/AddressServlet")
public class AddressServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String street = request.getParameter("street");
		String state = request.getParameter("state");
		String city = request.getParameter("city");
		int pin =  Integer.parseInt(request.getParameter("pin"));
		AddressDao.updateAddress(street, state, city, pin);
		int msg=3;
		int custId = LoginDao.cid;
		int acc = LoginDao.accNo;
		AccountDao accDao = new AccountDao();
		int bal = accDao.getBalance(acc);
		String name = accDao.getName(custId);
		String type = accDao.getAccType(acc);
		
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

}
