/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.implementation;

import connection.DBConnection;
import domain.Quiz;
import domain.Tournament;
import service.CreateService;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gazi
 */
public class CreateServiceImplementation implements CreateService{
    
    DBConnection dbConnection;

    public CreateServiceImplementation(DBConnection dbBroker) {
        this.dbConnection = dbBroker;
    }
    @Override
    public void createQuiz(Quiz quiz) {
        
        try {
            String query = "INSERT INTO quiz(topic,quizName) VALUES(?,?)";
            PreparedStatement statement = dbConnection.connection.prepareStatement(query);
            statement.setString(1, quiz.getTopic());
            statement.setString(2, quiz.getQuizName());
            statement.executeUpdate();
            System.out.println("Sistem je zapamtio kviz");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Sistem ne može da zapamti kviz");
        }
        
    }

    @Override
    public void createTournament(Tournament tournament) {
        try {
            String query = "INSERT INTO tournament(league,tournamentName) VALUES(?,?)";
            PreparedStatement statement = dbConnection.connection.prepareStatement(query);
            statement.setString(1, tournament.getLeague());
            statement.setString(2, tournament.getTournamentName());
            statement.executeUpdate();
            System.out.println("Sistem je zapamtio turnir");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Sistem ne može da zapamti turnir");
        }
    }
    
}
