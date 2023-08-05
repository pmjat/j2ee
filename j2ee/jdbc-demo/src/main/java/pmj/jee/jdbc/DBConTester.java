package pmj.jee.jdbc;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConTester1 {
	public static void main(String[] args) {
		try {

			Connection con = DBCon.getConnection();
			con.setSchema( "company" );

			Statement stmt = con.createStatement();
			String str_sql = "SELECT * FROM Employee AS e JOIN Employee AS s "
					+ " ON (e.super_eno=s.eno) WHERE e.dno=4";
			ResultSet rs = stmt.executeQuery( str_sql );
			while ( rs.next() ) {
				String name = rs.getString("ename");
				String ss = rs.getString("super_eno");
				String sname = rs.getString( 9 );
				//if ( ss == null ) ss = "Null";
				System.out.println( name +" " +  ss + " " + sname);
			}
		}
		catch (SQLException e) {
			System.out.println("Error Executing SQL statement: " + e.getMessage());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}