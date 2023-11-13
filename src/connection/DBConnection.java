/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;

import java.sql.*;

/**
 *
 * @author Gazi
 */
public class DBConnection {

    private static DBConnection instance=null;
    
    private DBConnection() {
    }
    
    public static DBConnection getInstance(){
        if (instance == null){
            instance = new DBConnection();
        }
        return instance;
    }
    
    public Connection connection = null;
    public void connect(){
        String url = "jdbc:mysql://localhost:3306/quiz_tournaments";
        String user = "root";
        String pass = "";
        try {
            connection = DriverManager.getConnection(url, user, pass);
        } catch (SQLException ex) {
            System.out.println("Greška prilikom konektovanja na bazu!");
        }

    }
}
