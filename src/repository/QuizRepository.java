/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domain.Quiz;

/**
 *
 * @author Gazi
 */
public class QuizRepository extends AbstractRepository<Quiz> {

    private static QuizRepository instance;

    private QuizRepository() throws Exception{
    }

    public static QuizRepository getInstance() throws Exception {
        if (instance == null) {
            instance = new QuizRepository();
        }
        return instance;
    }
}
