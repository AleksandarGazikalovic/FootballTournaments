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
public interface LoadService {
    List<Quiz> loadQuizzesList(List<Quiz> quizzes);
    Quiz loadQuiz(Quiz quiz);
    List<Tournament> loadTournamentsList(List<Tournament> tournaments);
    Tournament loadTournament(Tournament tournament);
}
