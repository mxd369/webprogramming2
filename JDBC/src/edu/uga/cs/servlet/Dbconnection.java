package edu.uga.cs.servlet;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class Dbconnection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver found");
		} catch (ClassNotFoundException e) {
			//e.printStackTrace();
			System.out.println("Driver not found"+e);
		}
		
		String url = "jdbc:mysql://localhost/imbd";
		String user="root";
		String password="336699888";
		
		java.sql.Connection con=null;
		
		try {
			con=DriverManager.getConnection(url, user, password);
			
			System.out.println("Connect successfully");
		} catch (SQLException e) {
			//e.printStackTrace();
			System.out.println("Something went wrong inthe conenction string");
		}
	}

}
