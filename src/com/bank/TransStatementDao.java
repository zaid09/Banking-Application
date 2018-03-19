package com.bank;

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TransStatementDao {
	public static int count=0;
    public ArrayList<TransactionDetails> readAllTrans(){
            Connection con=DBConnection.getConnect();
            int acc = LoginDao.accNo;
            
        ArrayList<TransactionDetails>  transList=new ArrayList<TransactionDetails> ();
            try {
                    PreparedStatement pstmt=con.prepareStatement("select * from transactiondetails where account_no=?");
                    pstmt.setInt(1, acc);             
                    ResultSet resultSet=pstmt.executeQuery(); //fire query in Database
                    
                    while(resultSet.next()){
                        TransactionDetails t1=new TransactionDetails();
                            int tid=resultSet.getInt("transaction_id");
                            String ref=resultSet.getString("reference_number");
                            int accNo= resultSet.getInt("account_no");
                            String type=resultSet.getString("transaction_type");
                            String date=resultSet.getString("trans_date_time");
                            int amt= resultSet.getInt("transfer_amount");
                        t1.setTranscId(tid);
                        t1.setReferenceNo(ref);
                        t1.setAccNo(accNo);
                        t1.setTranscType(type);
                        t1.setTranscDateTime(date);
                        t1.setTransferAmount(amt);
                    transList.add(t1);
                    ++count;
                   
                    
                }
            } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
            }
            return transList;
    }

}
