package restaurantsystem.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    public static Connection connect(){
        String url = "jdbc:sqlite:Database/restaurant.sqlite";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Database connected successfully");
        }
        catch (SQLException e){
            System.out.println("Something went wrong in the database connection");
            System.out.println("Reason: " + e.getMessage());
        }
        return conn;
    }
    
    
    
    public static void main(String args[]){
        Connection conn = connect();
    }
    
    
    
}
