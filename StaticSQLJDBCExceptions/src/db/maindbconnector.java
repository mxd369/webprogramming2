package db;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

public class maindbconnector {

	static final String DRIVE_NAME = "com.mysql.jdbc.Driver";
	static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/imdb";
	static final String DB_CONNECTION_USERNAME = "root";
	static final String DB_CONNECTION_PASSWORD = "336699888";
	
	public static void main(String[] args) throws SQLException {
		
		// Class.forName("com.mysql.jdbc.Driver");
		java.sql.Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(CONNECTION_URL, DB_CONNECTION_USERNAME, DB_CONNECTION_PASSWORD);

			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery("SELECT first_name, last_name FROM actors");
			
			rs.last();
			System.out.println("Number of rows: " + rs.getRow());
			
			
		} catch (SQLException e) {
			System.err.println(e);
		} finally {
			if (rs != null) {		// closing the resources
				rs.close();
				System.out.print("Close Successful");
			}
			if (stmt != null) {		// closing the resources
				stmt.close();
				System.out.print("Close Successful");
			}
			if (conn != null) {		// closing the resources
				conn.close();
				System.out.print("Close Successful");
			}
		}
		
		
	}
	
}
