package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import exception.SystemException;

public class DBUtil {

	static Connection conn;
	
	static {
		//step 1
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static Connection obtainConnection()throws SystemException{
		
		// design pattern - singleton design pattern
		
		//step 2
		String connectionUrl = "jdbc:postgresql://localhost:5432/bms";
		String userName = "postgres";
		String password = "root";
		
		if(conn == null) {
			try {
				conn = DriverManager.getConnection(connectionUrl, userName, password);
			} catch (SQLException e) {
				throw new SystemException();
			}	
		}
		
		return conn;
	}
	
	static void closeConnection()throws SystemException {
		try {
			conn.close();
		} catch (SQLException e) {
			throw new SystemException();
		}
	}
}
