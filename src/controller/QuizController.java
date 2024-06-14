/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domain.Quiz;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.QuizService;

/**
 *
 * @author Gazi
 */
public class QuizController implements AbstractController<Quiz> {

    private static QuizController instance;
    private final QuizService quizService;

    private QuizController() {
        this.quizService = QuizService.getInstance();
    }

    public static QuizController getInstance() {
        if (instance == null) {
            instance = new QuizController();
        }
        return instance;
    }

    public List<Quiz> findQuiz(List<Quiz> quizzes, int value) {
        return quizService.findQuiz(quizzes, value);
    }

//    public Response loadQuiz(Quiz quiz) {
//        return quizService.loadQuiz(quiz);
//    }

    @Override
    public void save(Quiz quiz) {
        try {
            quizService.createQuiz(quiz);
        } catch (SQLException ex) {
            Logger.getLogger(QuizController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Quiz quiz) {
        try {
            quizService.updateQuiz(quiz);
        } catch (SQLException ex) {
            Logger.getLogger(QuizController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Quiz quiz) {
        try {
            quizService.deleteQuiz(quiz);
        } catch (SQLException ex) {
            Logger.getLogger(QuizController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Quiz> getAll() {
        try {
            return quizService.loadQuizzesList(new Quiz());
        } catch (SQLException ex) {
            Logger.getLogger(QuizController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
