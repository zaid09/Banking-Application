package com.bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginDao {
    public static int accNo=0,cid=0;
    public boolean validate(int custId, String pwd){
        Connection con=DBConnection.getConnect();
        boolean b = true;
        try{
            PreparedStatement pstmt=con.prepareStatement("select * from customers where customer_id=? and login_pwd=?");
            pstmt.setInt(1, custId);
            pstmt.setString(2,pwd );
            ResultSet results=pstmt.executeQuery();
           
            
            
                   if(!results.next()) {
                       b=false;
                       return b;  
                   }
                   else {
                       cid = results.getInt("CUSTOMER_ID");
                       //System.out.println(cid);
                       PreparedStatement pstmt1=con.prepareStatement("select * from accounts where customer_id=?");
                       pstmt1.setInt(1, cid);
                       ResultSet result2=pstmt1.executeQuery();
                       if(result2.next()){
                       accNo = result2.getInt(1);
                       //System.out.println(accNo);
                       }
                       return b;
                   }
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return b;
    }    
}
