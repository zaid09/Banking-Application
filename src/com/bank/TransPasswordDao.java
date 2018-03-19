package com.bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransPasswordDao {
    public static boolean checkTransPwd(String transPwd){
        Connection con=DBConnection.getConnect();
        boolean b = true;
        int accNo = LoginDao.accNo;
        try{
            PreparedStatement pstmt=con.prepareStatement("select trans_pwd from customers where account_no=?");
            pstmt.setInt(1, accNo);
            ResultSet results=pstmt.executeQuery();
                if(!results.next()) {
                   b=false;
                   return b;  
               }
              else {
                       String trans1 = results.getString(1);
                       if(trans1.equals(transPwd))
                            return b;
                       else {
                           b=false;
                           return b;
                       }
                   }
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return b;
    }
    
    public static void updateTransPwd(String newTrans,String curTransPwd){
        Connection con=DBConnection.getConnect();
        int accNo = LoginDao.accNo;
        try{
            PreparedStatement pstmt=con.prepareStatement("update password_details set new_trans_pwd=? and old_trans_pwd =? where account_no=?");
            pstmt.setString(1, newTrans);
            pstmt.setString(2, curTransPwd);
            pstmt.setInt(3, accNo);
            ResultSet results=pstmt.executeQuery();
           
            PreparedStatement pstmt1=con.prepareStatement("update accounts set trans_pwd=? where account_no=?");
            pstmt1.setString(1, newTrans);
            pstmt1.setInt(2, accNo);
            ResultSet result1=pstmt1.executeQuery();
            
            System.out.println("Transaction Password changed successfully");
             
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
