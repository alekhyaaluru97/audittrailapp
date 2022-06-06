package com.mcc.audittrailapp.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnection {
	
	public static Connection connection;
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");	
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/config_test4", "root", "");
			//System.out.println("Conn successful");
			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//System.out.println("Conn failed");
		return null;
	}

	public static void main(String[] args) {
		getConnection();
	}
	
}
