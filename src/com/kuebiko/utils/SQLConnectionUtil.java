package com.kuebiko.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnectionUtil {

	private static String driver="com.mysql.jdbc.Driver";
	private static String url="jdbc:mysql://localhost:3306/newDemo?useSSL=false";
	private static String username="root";
	private static String password="Meroname1";

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		// 1.... loading the driver
		// every database has its own driver
		Class.forName(driver);
		// Making connection to the driver
		Connection conn = DriverManager.getConnection(url, username, password);
		if (conn != null) {
			System.out.println("Db connection is established!!!!!!!!");
		}
		return conn;
	}
}
