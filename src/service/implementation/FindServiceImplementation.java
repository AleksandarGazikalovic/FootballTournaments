/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.implementation;

import connection.DBConnection;
import domain.Quiz;
import domain.Tournament;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import service.FindService;

/**
 *
 * @author Gazi
 */
public class FindServiceImplementation implements FindService{
    
    DBConnection dbConnection;

    public FindServiceImplementation(DBConnection dbBroker) {
        this.dbConnection = dbBroker;
    }
    
    @Override
    public List<Quiz> findQuiz(List<Quiz> quizzes, Object value) {
        try {
            quizzes = new ArrayList<>();
            String query = "SELECT * FROM quiz WHERE ";
            Statement statement = dbConnection.connection.createStatement();
            return quizzes;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Tournament> findTournament(List<Tournament> tournaments, Object value) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
