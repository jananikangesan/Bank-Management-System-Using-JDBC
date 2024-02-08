package com.cbc.bank.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBFactory {

public static Connection connection;
	
	public static Connection getDBConnection() {
		
		try {
			ResourceBundle bundle = ResourceBundle.getBundle("oracle");
			
			String url = bundle.getString("db.url");
			String userName = bundle.getString("db.username");
			String password = bundle.getString("db.password");
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			connection = DriverManager.getConnection(url, userName, password);
			//System.out.println("connected");
			
			if (connection != null) {
				connection.setAutoCommit(false);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			
		}
		return connection;
		
	}
	
	public static void closeDBConnection() {
		
		if (connection != null) {
			try {
				connection.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
				
			}
		}
	}
}
