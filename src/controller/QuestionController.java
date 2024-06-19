/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domain.Question;
import java.util.List;
import service.QuestionService;

/**
 *
 * @author Gazi
 */
public class QuestionController implements AbstractController<Question> {

    private static QuestionController instance;
    private final QuestionService questionService;

    private QuestionController() {
        this.questionService = QuestionService.getInstance();
    }

    public static QuestionController getInstance() {
        if (instance == null) {
            instance = new QuestionController();
        }
        return instance;
    }

    @Override
    public void save(Question entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Question entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Question entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Question> getAll(Question question) throws Exception {
        return questionService.loadQuizQuestions(question);
    }

    @Override
    public Question get(Long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
