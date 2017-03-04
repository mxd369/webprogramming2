/**
 * Utility Class
 */
package tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;

public class Movie {

	// create statements to process data
	public static void displayData(ResultSet rs) throws SQLException {
		while (rs.next()) {
			StringBuffer buffer = new StringBuffer();
			
			buffer.append("Movie " + rs.getInt("id") + ": ");
			buffer.append(rs.getString("name"));
			
			int rank = rs.getInt("rank");
			NumberFormat nf = NumberFormat.getCurrencyInstance();
			String formattedPrice = nf.format(rank);
			buffer.append(" (" + formattedPrice + ")");
			
			System.out.println(buffer.toString());
			
		}
		
	}
	
}
