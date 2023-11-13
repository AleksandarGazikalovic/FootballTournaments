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
import service.DeleteService;

/**
 *
 * @author Gazi
 */
public class DeleteServiceImplementation implements DeleteService{
    DBConnection dbConnection;

    public DeleteServiceImplementation(DBConnection dbBroker) {
        this.dbConnection = dbBroker;
    }
    
    @Override
    public void deleteQuiz(Quiz quiz) {
        try {
            String query = "DELETE FROM quiz WHERE quizID=?";
            PreparedStatement statement = dbConnection.connection.prepareStatement(query);
            statement.setLong(1, quiz.getQuizID());
            statement.executeUpdate();
            System.out.println("Sistem je obrisao kviz");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Sistem ne može da obriše kviz");
        }
    }

    @Override
    public void deleteTournament(Tournament tournament) {
        try {
            String query = "DELETE FROM tournament WHERE tournamentID=?";
            PreparedStatement statement = dbConnection.connection.prepareStatement(query);
            statement.setLong(1, tournament.getTournamentID());
            statement.executeUpdate();
            System.out.println("Sistem je obrisao kviz");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Sistem ne može da obriše kviz");
        }
    }
    
}
