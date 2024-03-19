package com.example.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbConnection {
    private static Connection connection;
    private static String username="root";
    private static String password="root";
    private static String url="jdbc:mysql://localhost:3306/DS";

    public static Connection getConnection(){
        if (connection == null) {
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url, username, password);
                return connection;
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return connection;
    }
}
