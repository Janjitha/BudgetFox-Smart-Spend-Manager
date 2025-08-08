import java.sql.Connection;              //Connection is the interface used to manage a DB connection.
import java.sql.DriverManager;           //DriverManager is used to get the connection to the database.
import java.sql.SQLException;            // SQLException handles database-related errors.

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/budgetfox_db";
    private static final String USER = "root";
    private static final String PASSWORD = "root"; 

    public static Connection getConnection() {
        try {
            //Attempts to establish a connection using DriverManager, 
            //If successful, it returns the Connection object.
            return DriverManager.getConnection(URL, USER, PASSWORD);    
        } catch (SQLException e) {
            System.out.println("❌ Failed to connect to database");
            e.printStackTrace();
            return null;
        }
    }
}

