package connectSQLDB;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class main {

	static final String DRIVE_NAME = "com.mysql.jdbc.Driver";
	static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/imdb";
	static final String DB_CONNECTION_USERNAME = "root";
	static final String DB_CONNECTION_PASSWORD = "336699888";
	
	public static void main(String[] args) throws SQLException {
		
		// Class.forName("com.mysql.jdbc.Driver");
		java.sql.Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(CONNECTION_URL, DB_CONNECTION_USERNAME, DB_CONNECTION_PASSWORD);
			System.out.println("Connected!");
		} catch (SQLException e) {
			System.err.println(e);
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
		
		
	}
	
}
