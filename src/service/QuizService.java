/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domain.Quiz;
import java.util.List;

/**
 *
 * @author Gazi
 */
public interface QuizService {

    void createQuiz(Quiz quiz);

    void deleteQuiz(Quiz quiz);

    List<Quiz> findQuiz(List<Quiz> quizzes, Object value);

    List<Quiz> loadQuizzesList(List<Quiz> quizzes);

    Quiz loadQuiz(Quiz quiz);

    void updateQuiz(Quiz quiz);

}
