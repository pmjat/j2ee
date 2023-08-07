package pmj.jee.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PrepStatementTester1 {
	public static void main(String[] args) {
		try {

			Connection con = DBCon.getConnection();
			con.setSchema( "books" );

			try {
				String sql = "SELECT * FROM book WHERE isbn = ?";
				PreparedStatement stmt = con.prepareStatement( sql );
				stmt.setString(1, "1001" );
				ResultSet rs = stmt.executeQuery();
				if ( rs.next() ) {
					String isbn = rs.getString("isbn");
					String title = rs.getString("title");
					double price = rs.getDouble("price");
					int qty = rs.getInt("stock");
					System.out.println( isbn + ", " +  title 
							+ ", " + price
							+ ", " + qty );
				}            
			}
			catch(SQLException e) {
				System.out.println( e.getMessage() );
			}
		}
		catch(Exception e) {
			System.out.println( e.getMessage() );
		}
	}
}