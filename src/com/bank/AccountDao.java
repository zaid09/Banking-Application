package com.bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDao {
    public static int getBalance(int acc){
    Connection con=DBConnection.getConnect();
    int accBal=0;
    try{
        PreparedStatement pstmt=con.prepareStatement("select account_balance from accounts where account_no=?");
        pstmt.setInt(1, acc);
        ResultSet results=pstmt.executeQuery();
        if(results.next()) {
         accBal = results.getInt(1);
        }
    }catch(SQLException e){
        e.printStackTrace();
    }
        return accBal;
    }
    
    public static String getName(int cid){
        Connection con=DBConnection.getConnect();
        String name="";
        try{
            PreparedStatement pstmt=con.prepareStatement("select name from customers where customer_id=?");
            pstmt.setInt(1, cid);
            ResultSet results=pstmt.executeQuery();
            if(results.next()) {
             name = results.getString(1);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
            return name;
    }
    
    public static String getAccType(int accNo){
        Connection con=DBConnection.getConnect();
        String type="";
        try{
            PreparedStatement pstmt=con.prepareStatement("select account_type from accounts where account_no=?");
            pstmt.setInt(1, accNo);
            ResultSet results=pstmt.executeQuery();
            if(results.next()) {
             type = results.getString(1);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
            return type;
    }
}
