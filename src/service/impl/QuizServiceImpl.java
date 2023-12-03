/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import connection.DBConnection;
import domain.Quiz;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.QuizService;

/**
 *
 * @author Gazi
 */
public class QuizServiceImpl implements QuizService {

    DBConnection dbConnection;

    public QuizServiceImpl(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
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
    public List<Quiz> loadQuizzesList(List<Quiz> quizzes) {
        try {
            quizzes = new ArrayList<>();
            String query = "SELECT * FROM quiz";
            Statement statement = dbConnection.connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Quiz quiz = makeQuiz(rs);
                if (quiz != null) {
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

    private Quiz makeQuiz(ResultSet rs) {
        try {
            Quiz quiz = new Quiz();
            quiz.setQuizID(rs.getLong("quizID"));
            quiz.setQuizName(rs.getString("quizName"));
            quiz.setTopic(rs.getString("topic"));
            return quiz;
        } catch (SQLException ex) {
        }
        return null;

    }

}
