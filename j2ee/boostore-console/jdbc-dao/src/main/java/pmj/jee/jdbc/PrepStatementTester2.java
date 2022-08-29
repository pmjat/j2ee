package pmj.jee.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PrepStatementTester2 {
	public static void main(String[] args) {
		try {

			Connection con = DBCon.getConnection();
			con.setSchema( "company3" );

			try {
				String sql = "INSERT INTO works_on VALUES(?,?,?)";
				PreparedStatement stmt = con.prepareStatement( sql );
				stmt.setInt(1, 101);
				stmt.setInt(2, 10);
				stmt.setDouble(3, 8.5);
				int nrows = stmt.executeUpdate();
				System.out.println( "Rows Affected: " + nrows);
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