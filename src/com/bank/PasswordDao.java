package com.bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PasswordDao {
    public static boolean checkLoginPwd(String loginPwd){
        Connection con=DBConnection.getConnect();
        boolean b=true;
        int accNo = LoginDao.accNo;
        try{
            PreparedStatement pstmt=con.prepareStatement("select login_pwd from customers where account_no=?");
            pstmt.setInt(1, accNo);
            ResultSet results=pstmt.executeQuery();
                if(!results.next()) {
                   b=false;
                   return b;
               }
              else {
                       String login1 = results.getString(1);
                       if(login1.equals(loginPwd))
                           return b;
                       else {
                           b=false;
                           return b;
                       }
                   }
        }catch(SQLException e){
            e.printStackTrace();
        }
       // System.out.print(b);
   
        return b;
    }
    
    public static void updateLoginPwd(String newLogin,String curloginPwd){
        Connection con=DBConnection.getConnect();
        int accNo = LoginDao.accNo;
        int cid = LoginDao.cid;
        try{
            PreparedStatement pstmt=con.prepareStatement("update password_details set old_login_pwd=? and new_login_pwd =? where account_no=?");
            pstmt.setString(1, curloginPwd);
            pstmt.setString(2, newLogin);
            pstmt.setInt(3, accNo);
            ResultSet results=pstmt.executeQuery();
           
            PreparedStatement pstmt1=con.prepareStatement("update customers set login_pwd=? where customer_id=?");
            pstmt1.setString(1, newLogin);
            pstmt1.setInt(2, cid);
            ResultSet result1=pstmt1.executeQuery();
            
            System.out.println("Login Password changed successfully");
             
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
