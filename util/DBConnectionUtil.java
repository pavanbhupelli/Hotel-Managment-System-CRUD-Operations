package com.codegnan.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionUtil {
	static final String url = "jdbc:mysql://localhost:3306/jfs30_32";
	static final String username = "root";
	static final String pass = "root";
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url,username,pass);
	}

	public static Connection getConnection1() {
		// TODO Auto-generated method stub
		return null;
	}

}
