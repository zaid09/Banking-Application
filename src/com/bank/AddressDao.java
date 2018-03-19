package com.bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class AddressDao {
    public static void updateAddress(String street, String state, String city, int pin ){
    Connection con=DBConnection.getConnect();
   // int accBal=0;
    try{
        PreparedStatement pstmt=con.prepareStatement("update ADDRESS  SET street_name = ?, state=?, city =?, pin=? WHERE  customer_id =?");
        pstmt.setString(1, street);
        pstmt.setString(2, state);
        pstmt.setString(3, city);
        pstmt.setInt(4, pin);
        pstmt.setInt(5, LoginDao.cid);
                
        ResultSet results=pstmt.executeQuery();
        
      /* pstmt=con.prepareStatement("Select * from ADDRESS where  customer_id =?");
        pstmt.setInt(1, LoginDao.cid);
        ResultSet outResults=pstmt.executeQuery();
        ResultSetMetaData rsmd = outResults.getMetaData();
        int columnsNumber = rsmd.getColumnCount();
        System.out.println("Address updated successfully.\nThe upadted details are as follows:");
        while (outResults.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                if (i > 1) System.out.print(",  ");
                String columnValue = outResults.getString(i);
                System.out.print(columnValue + " " + rsmd.getColumnName(i));
            }
            System.out.println("");
        }*/

        
    }catch(SQLException e){
        e.printStackTrace();
    }
    }
}
