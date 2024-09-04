package MODEL;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/gym";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static Connection conn = null;

    DbConnection(){
        try{
            this.conn= DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public static Connection getConnection() {
        try {
            if(conn == null){
                 new DbConnection();
            }
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
