/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domain.Question;
import domain.Quiz;
import java.sql.SQLException;
import java.util.List;
import repository.QuestionRepository;

/**
 *
 * @author Gazi
 */
public class QuestionService {
    
    private static QuestionService instance;
    private final QuestionRepository questionRepository;
    
    private QuestionService() {
        this.questionRepository = QuestionRepository.getInstance();
    }
    
    public static QuestionService getInstance() {
        if (instance == null) {
            instance = new QuestionService();
        }
        return instance;
    }
    
    public void createQuestion(Quiz quiz) throws SQLException {
        List<Question> questions = quiz.getQuestions();
        for (int i = 0; i < questions.size(); i++) {
            questions.get(i).setQuiz(quiz);
            questionRepository.save(questions.get(i));
        }
    }
}
