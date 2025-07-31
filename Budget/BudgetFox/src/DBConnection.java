import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/budgetfox_db";
    private static final String USER = "root";
    private static final String PASSWORD = "root"; // Update if needed

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("❌ Failed to connect to database");
            e.printStackTrace();
            return null;
        }
    }
}
