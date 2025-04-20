package myPackage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    public static Connection connect() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/db";
        String userName = "root";
        String password = "Sanket@123";
        return DriverManager.getConnection(url, userName, password);
    }
}
