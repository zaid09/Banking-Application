package com.bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import java.util.ArrayList;

public class ViewBankDao {
    public ArrayList<Bank> readAllBank(){
        Connection con=DBConnection.getConnect();
            ArrayList<Bank>  bankList=new ArrayList<Bank> ();
                try {
                    PreparedStatement pstmt=con.prepareStatement("select * from bank");
                    ResultSet resultSet=pstmt.executeQuery(); //fire query in Database
                    while(resultSet.next()){
                        Bank b1=new Bank();
                        int id=resultSet.getInt("bank_id");
                        String b_name=resultSet.getString("bank_name");
                        String ifsc= resultSet.getString("ifsc");
                        String branch= resultSet.getString("branch");
                        int cust=resultSet.getInt("no_of_customers");
                        b1.setBankId(id);
                        b1.setBankName(b_name);
                        b1.setIfsc(ifsc);
                        b1.setBranch(branch);
                        b1.setNoOfCust(cust);
                        bankList.add(b1);
                    }
                } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
                return bankList;
    }
}
