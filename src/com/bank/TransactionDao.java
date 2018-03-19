package com.bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.time.LocalDateTime;

import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class TransactionDao {
    public static void updateTransactionTable(int bal1,int bal2,int fromAcc,int toAcc, int amt){
        Connection con=DBConnection.getConnect();
        int min =10003;
        int max =19999;
        int transId1 = ThreadLocalRandom.current().nextInt(min, max + 1);
        int transId2 = ThreadLocalRandom.current().nextInt(min, max + 1);
        String ref = randomAlphaNumeric(6);
        String type1 = "DEBIT";
        String type2 = "CREDIT";
        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        int bankId = 101;
        String ifsc = "ABC000101";
        
        try{
            PreparedStatement pstmt=con.prepareStatement("insert into TRANSACTIONDETAILS values (?,?,?,?,?,?,?,?)");
            pstmt.setInt(1, transId1);
            pstmt.setString(2, ref);
            pstmt.setInt(3, fromAcc);
            pstmt.setString(4, type1);
            pstmt.setDate(5, sqlDate);
            pstmt.setInt(6, bankId);
            pstmt.setString(7, ifsc);
            pstmt.setInt(8, amt);        
            ResultSet result1=pstmt.executeQuery();
            
        PreparedStatement pstmt1=con.prepareStatement("insert into TRANSACTIONDETAILS values (?,?,?,?,?,?,?,?)");
        pstmt1.setInt(1, transId2);
        pstmt1.setString(2, ref);
        pstmt1.setInt(3, toAcc);
        pstmt1.setString(4, type2);
        pstmt1.setDate(5, sqlDate);
        pstmt1.setInt(6, bankId);
        pstmt1.setString(7, ifsc);
        pstmt1.setInt(8, amt);        
        ResultSet result2=pstmt1.executeQuery();
            
        PreparedStatement pstmt2=con.prepareStatement("update accounts set account_balance = ? where account_no=?");
        pstmt2.setInt(1, bal1);
        pstmt2.setInt(2, fromAcc);
        ResultSet result3=pstmt2.executeQuery();
        
        PreparedStatement pstmt3=con.prepareStatement("update accounts set account_balance = ? where account_no=?");
        pstmt3.setInt(1, bal2);
        pstmt3.setInt(2, toAcc);
        ResultSet result4=pstmt3.executeQuery();            
        
    }
    catch(SQLException e){
            e.printStackTrace();
        }
}
    public static String randomAlphaNumeric(int count) {
    String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    StringBuilder builder = new StringBuilder();
    while (count-- != 0) {
    int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
    builder.append(ALPHA_NUMERIC_STRING.charAt(character));
    }
    return builder.toString();
    }
    
    public static boolean confirmTransPwd(String trans, int accNo){
        
        Connection con=DBConnection.getConnect();
        boolean b = true;
        try{
            PreparedStatement pstmt=con.prepareStatement("select trans_pwd from accounts where account_no=?");
            pstmt.setInt(1, accNo);
            ResultSet results=pstmt.executeQuery();
                if(!results.next()) {
                   b=false;
                   return b;  
               }
              else {
                       String trans1 = results.getString(1);
                       if(trans.equals(trans1))
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
    
}