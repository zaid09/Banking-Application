package com.oracle;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.AccountDao;
import com.bank.LoginDao;
import com.bank.TransPasswordDao;
import com.bank.TransStatementDao;
import com.bank.TransactionDao;
import com.bank.TransactionDetails;

/**
 * Servlet implementation class TransferServlet
 */
@SuppressWarnings("serial")
@WebServlet("/TransferServlet")
public class TransferServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int toaccNo =  Integer.parseInt(request.getParameter("benAcc"));
		int amt =  Integer.parseInt(request.getParameter("amt"));
		String transPwd = request.getParameter("tpwd");
		LoginDao dao = new LoginDao();
		int acc = dao.accNo;
		TransactionDao tpd = new TransactionDao();
		boolean status = tpd.confirmTransPwd(transPwd, acc);
		int msg=0;
		if(status==true){
			int bal1 = AccountDao.getBalance(acc);
	        int bal2 = AccountDao.getBalance(toaccNo);
	        if(amt>bal1){
	           msg=0;
	           int custId = dao.cid;
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
	        else{
	        	bal2 = bal2 + amt;
	            bal1 = bal1 - amt;
				tpd.updateTransactionTable(bal1, bal2, acc, toaccNo, amt);
				msg=1;
				int custId = dao.cid;
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
		else{
			msg=0;
			int custId = dao.cid;
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


}
