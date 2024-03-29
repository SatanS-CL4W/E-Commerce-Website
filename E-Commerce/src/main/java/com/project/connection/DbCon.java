package com.project.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbCon {
	private static Connection con = null;
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		if (con==null) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/e_commerce", "root","root");
			System.out.println("Connection Done Successfully!!!");
		}
		
		return con;
	}
}
