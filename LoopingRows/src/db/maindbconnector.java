package db;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

import tables.Movie;

public class maindbconnector {

	static final String DRIVE_NAME = "com.mysql.jdbc.Driver";
	static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/imdb";
	static final String DB_CONNECTION_USERNAME = "root";
	static final String DB_CONNECTION_PASSWORD = "336699888";
	
	public static void main(String[] args) throws SQLException {
		
		// Class.forName("com.mysql.jdbc.Driver");
		// java.sql.Connection conn = null;
		// Statement stmt = null;
		// ResultSet rs = null;
		
		try (
			java.sql.Connection conn = DriverManager.getConnection(CONNECTION_URL, DB_CONNECTION_USERNAME, DB_CONNECTION_PASSWORD);

			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery("SELECT * FROM movies");
			
			) {


			Movie.displayData(rs);
			
			
		} catch (SQLException e) {
			System.err.println(e);
		}		

	}
	
}
