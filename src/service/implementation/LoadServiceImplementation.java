/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.implementation;

import connection.DBConnection;
import domain.Quiz;
import domain.Tournament;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.LoadService;

/**
 *
 * @author Gazi
 */
public class LoadServiceImplementation implements LoadService{
    
    DBConnection dbConnection;

    public LoadServiceImplementation(DBConnection dbBroker) {
        this.dbConnection = dbBroker;
    }
    
    @Override
    public List<Quiz> loadQuizzesList(List<Quiz> quizzes) {
        try {
            quizzes = new ArrayList<>();
            String query = "SELECT * FROM quiz";
            Statement statement = dbConnection.connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                Quiz quiz = makeQuiz(rs);
                if(quiz!=null){
                quizzes.add(quiz);
                }
            }
            return quizzes;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Quiz loadQuiz(Quiz quiz) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Tournament> loadTournamentsList(List<Tournament> tournaments) {
                try {
            tournaments = new ArrayList<>();
            String query = "SELECT * FROM tournament";
            Statement statement = dbConnection.connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                Tournament tournament = makeTournament(rs);
                if(tournament!=null){
                tournaments.add(tournament);
                }
            }
            return tournaments;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Tournament loadTournament(Tournament tournament) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private Quiz makeQuiz(ResultSet rs) {
        try {
            Quiz quiz = new Quiz();
            quiz.setQuizID(rs.getLong("quizID"));
            quiz.setQuizName(rs.getString("quizName"));
            quiz.setTopic(rs.getString("topic"));
            return quiz;
        } catch (SQLException ex) {
            Logger.getLogger(LoadServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
                
    }

    private Tournament makeTournament(ResultSet rs) {
                try {
            Tournament tournament = new Tournament();
            tournament.setTournamentID(rs.getLong("tournamentID"));
            tournament.setTournamentName(rs.getString("tournamentName"));
            tournament.setLeague(rs.getString("league"));
            return tournament;
        } catch (SQLException ex) {
            Logger.getLogger(LoadServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }    
}
