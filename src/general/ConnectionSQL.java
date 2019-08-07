package general;
import java.sql.*;
public class ConnectionSQL {
	public static Connection conn = null;
	static final String url = "jdbc:sqlite:db/TuriSMA.db";
    
	public static void connect() throws SQLException {
        
        conn = DriverManager.getConnection(url);
    }
	public static void close() throws SQLException {
		conn.close();
	}
}