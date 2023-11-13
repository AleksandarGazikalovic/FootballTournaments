/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domain.Quiz;
import domain.Tournament;
import java.util.List;

/**
 *
 * @author Gazi
 */
public interface FindService {
    List<Quiz> findQuiz(List<Quiz> quizzes, Object value);
    List<Tournament> findTournament(List<Tournament> tournaments, Object value);
}
