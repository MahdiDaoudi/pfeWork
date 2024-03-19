package com.example.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import com.example.classes.Pharmacie;

public class PharmacieDao {
    private Vector<Pharmacie> ve;
    private Connection connection;
    private Statement statement;
    private ResultSet result;
    private Pharmacie pharmacie;
    private String query;

    public Vector<Pharmacie> getdataLogin(){
        ve = new Vector<>();
        pharmacie = new Pharmacie();
        try{
            query= "select * from pharmacie";
            connection = dbConnection.getConnection();
            statement = connection.createStatement();
            result = statement.executeQuery(query);
            while(result.next()){
                pharmacie.setLogin(result.getString("login"));
                pharmacie.setPassword(result.getString("password"));
                ve.add(pharmacie);
            }
            return ve;
        }catch(Exception e){
            e.printStackTrace();
        }
        return ve;
    }
}
