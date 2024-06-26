/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domain.Question;

/**
 *
 * @author Gazi
 */
public class QuestionRepository extends AbstractRepository<Question> {

    private static QuestionRepository instance;

    private QuestionRepository() throws Exception{
    }

    public static QuestionRepository getInstance() throws Exception {
        if (instance == null) {
            instance = new QuestionRepository();
        }
        return instance;
    }
}
