/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.implementation;

import connection.DBConnection;
import domain.Quiz;
import domain.Tournament;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import service.UpdateService;

/**
 *
 * @author Gazi
 */
public class UpdateServiceImplementation implements UpdateService{
    
    DBConnection dbConnection;

    public UpdateServiceImplementation(DBConnection dbBroker) {
        this.dbConnection = dbBroker;
    }
    @Override
    public void updateQuiz(Quiz quiz) {
        try {
            String query = "UPDATE quiz SET topic=?, quizName=? WHERE quizID=?";
            PreparedStatement statement = dbConnection.connection.prepareStatement(query);
            statement.setString(1, quiz.getTopic());
            statement.setString(2, quiz.getQuizName());
            statement.setLong(3, quiz.getQuizID());
            statement.executeUpdate();
            System.out.println("Sistem je zapamtio kviz");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Sistem ne može da zapamti kviz");
        }
    }

    @Override
    public void updateTournament(Tournament tournament) {
        try {
            String query = "UPDATE tournament SET tournamentName=?, league=? WHERE tournamentID=?";
            PreparedStatement statement = dbConnection.connection.prepareStatement(query);
            statement.setString(1, tournament.getTournamentName());
            statement.setString(2, tournament.getLeague());
            statement.setLong(3, tournament.getTournamentID());
            statement.executeUpdate();
            System.out.println("Sistem je zapamtio turnir");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Sistem ne može da zapamti turnir");
        }
    }
    
}
