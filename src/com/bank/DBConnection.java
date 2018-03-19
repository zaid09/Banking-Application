package com.bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static void main(String[] args) {
		getConnect();
	}
public static Connection getConnect(){
	Connection con=null;
	
	try {
		//STEP 1 Loading the Driver
		//Class.forName("com.mysql.jdbc.Driver");
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//STEP 2 Estabilish connection 
		//con=DriverManager.getConnection("jdbc:mysql://localhost:3306/oracle_29_8_17","root","root");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","zaid","eden10");
		//System.out.println("done//");
	} catch (SQLException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	return con;
}
}

