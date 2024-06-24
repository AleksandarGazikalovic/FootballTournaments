/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domain.Question;
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

    private QuestionService() throws Exception {
        this.questionRepository = QuestionRepository.getInstance();
    }

    public static QuestionService getInstance() throws Exception {
        if (instance == null) {
            instance = new QuestionService();
        }
        return instance;
    }

    public void createQuestion(Question question) throws SQLException {
        questionRepository.save(question);
    }

    public void updateQuestion(Question question) throws SQLException {
        questionRepository.update(question);
    }

    public List<Question> loadQuizQuestions(Question question) throws SQLException {
        return questionRepository.findBy(question, question.getNewKey_Where());
    }
}
