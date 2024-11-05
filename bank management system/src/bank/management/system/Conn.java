package ASimulatorSystem;

import java.sql.*;  

public class Conn {
    Connection c;
    Statement s;

    // Constructor to establish a database connection and create a statement
    public Conn() {  
        try {  
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");  
            
            // Establish a connection to the 'bankmanagementsystem' database
            // "root" is the username, and "Athitya@123" is the password
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "Athitya@123");    
            
            // Create a statement object to execute SQL queries
            s = c.createStatement(); 
        } catch (Exception e) { 
            // Print any exceptions encountered
            System.out.println(e);
        }  
    }  
}  
