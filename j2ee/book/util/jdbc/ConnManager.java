package pmj.util.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnManager {

    private ConnManager() throws SQLException {
    	try {
			Class.forName( DBConfig.DB_DRIVER );
		    con = DriverManager.getConnection(
		            DBConfig.DB_URL, 
		            DBConfig.DB_USER, 
		            DBConfig.DB_PWD );
    	}
    	catch(ClassNotFoundException e) {
    		throw new SQLException("JDBC Driver not found!!");
    	}
    }
      
    public static ConnManager getInstance() throws SQLException {
        if (instance == null )
            instance = new ConnManager();
        return instance;
    }

    public static ConnManager getInstance(String dburl, String user, String pwd) 
            throws SQLException {
        instance = new ConnManager();
        return instance;
    }    
    
    public static ConnManager getInstance(String dburl, 
    		String user, 
    		String pwd,
    		String schema) 
            throws SQLException {
        instance = new ConnManager();
        instance.con.setSchema(schema);
        return instance;
    }    

    public Connection getConnection() throws SQLException{
        return con;
    }

    public Connection getConnection(String schema) throws SQLException{
    	con.setSchema(schema);
        return con;
    }

    public void close() throws SQLException{
        con.close();
        instance = null;
    }

    protected void 	finalize() throws Throwable {
        con.close();    	
    }
    
    private final Connection con;
    private static ConnManager instance = null;
    
}