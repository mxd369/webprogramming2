import java.sql.DriverManager;
import java.sql.*;
import com.mysql.jdbc.Connection;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static Connection getConnection() throws Exception {
		
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/testdb";
			String username = "root";
			String password = "336699888";
			Class.forName(driver);
			
			Connection conn = (Connection) DriverManager.getConnection(url,username,password);
			System.out.println("Connected");
			return conn;
		} catch(Exception e){
			System.out.println(e);
		}
		
		return null;
	}

}
