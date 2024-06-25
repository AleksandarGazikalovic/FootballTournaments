/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domain.Quiz;
import java.util.List;
import service.QuizService;

/**
 *
 * @author Gazi
 */
public class QuizController implements AbstractController<Quiz> {

    private static QuizController instance;
    private final QuizService quizService;

    private QuizController() throws Exception {
        this.quizService = QuizService.getInstance();
    }

    public static QuizController getInstance() throws Exception {
        if (instance == null) {
            instance = new QuizController();
        }
        return instance;
    }

    public List<Quiz> findQuiz(List<Quiz> quizzes, int value) throws Exception {
        return quizService.findQuiz(quizzes, value);
    }

    @Override
    public void save(Quiz quiz) throws Exception {
        quizService.createQuiz(quiz);
    }

    @Override
    public void update(Quiz quiz) throws Exception {
        quizService.updateQuiz(quiz);
    }

    @Override
    public void delete(Quiz quiz) throws Exception {
        quizService.deleteQuiz(quiz);
    }

    @Override
    public List<Quiz> getAll(Quiz quiz) throws Exception {
        return quizService.loadQuizzesList(quiz);
    }

}
