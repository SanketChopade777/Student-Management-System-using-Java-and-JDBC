package myPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class test {
    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost:3306/db"; //select @@port JDBC URL for the MySQL database
            String userName = "root"; // select user() MySQL username
            String password = "Sanket@123"; // MySQL password

            // Establishing the connection to the database
            Connection conn = DriverManager.getConnection(url, userName, password);
            Statement stm = conn.createStatement();

            // Creating a new database named 'db'
            String query = "create table student(sid int,name varchar(20),grade varchar(10))";
            stm.execute(query);
            System.out.println("Table Created Sucessfully!");

            // Closing the connection
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
