/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domain.Question;
import domain.Quiz;
import repository.QuizRepository;
import java.sql.SQLException;
import java.util.List;
import service.QuizService;

/**
 *
 * @author Gazi
 */
public class QuizService {

    private static QuizService instance;
    private QuizRepository quizRepository;
    private QuestionService questionService;

    private QuizService() {
        this.quizRepository = QuizRepository.getInstance();
        this.questionService = QuestionService.getInstance();
    }

    public static QuizService getInstance() {
        if (instance == null) {
            instance = new QuizService();
        }
        return instance;
    }

    public void createQuiz(Quiz quiz) throws SQLException {
        Long quizId = quizRepository.save(quiz);
        quiz.setQuizID(quizId);
        List<Question> questions = quiz.getQuestions();
        for (int i = 0; i < questions.size(); i++) {
            questions.get(i).setQuiz(quiz);
            questionService.createQuestion(questions.get(i));
        }
    }

    public List<Quiz> findQuiz(List<Quiz> quizs, Object value) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
        // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<Quiz> loadQuizzesList(Quiz quiz) throws SQLException {
        return quizRepository.getAll(quiz);
    }

    public Quiz loadQuiz(Quiz quiz) throws SQLException {
        return (Quiz) quizRepository.getById(quiz);
    }

    public void updateQuiz(Quiz quiz) throws SQLException {
        quizRepository.update(quiz);
        List<Question> questions = quiz.getQuestions();
        for (int i = 0; i < questions.size(); i++) {
            questions.get(i).setQuiz(quiz);
            questionService.updateQuestion(questions.get(i));
        }
    }

    public void deleteQuiz(Quiz quiz) throws SQLException {
        quizRepository.delete(quiz);
    }

}
