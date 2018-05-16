package com.revature.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.revature.logs.LogHere;

public class ConnectionUtil {
	
	private ConnectionUtil() {}
	
	public static Connection getConnection() {
		Properties props = new Properties();
		try (InputStream in = ConnectionUtil.class.getClassLoader().getResourceAsStream("db.properties")) {
			props.load(in);
			Class.forName("oracle.jdbc.OracleDriver");
			return DriverManager.getConnection(props.getProperty("jdbc.url"), props.getProperty("jdbc.username"), props.getProperty("jdbc.password"));
		} catch (FileNotFoundException fnfe) {
			LogHere.warn(fnfe.getMessage());
		} catch (IOException ioe) {
			LogHere.warn(ioe.getMessage());
		} catch (SQLException sqle) {
			LogHere.warn(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		} catch (ClassNotFoundException cnfe) {
			LogHere.warn(cnfe.getMessage());
		}
		return null;
	}
	
	public static void main(String[] args) {
		Connection conn = ConnectionUtil.getConnection();
		System.out.println(conn);
		try {
			conn.close();
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQLE State: " + sqle.getSQLState());
			System.err.println("Error code: " + sqle.getErrorCode());
		} 
	}
}
