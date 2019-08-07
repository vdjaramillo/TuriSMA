package general;
import java.sql.*;
public class ConnectionSQL {
	public static void connect() {
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:D:/sqlite/conexion.db";
            conn = DriverManager.getConnection(url);
            
            System.out.println("Connection to SQLite has been established.");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}