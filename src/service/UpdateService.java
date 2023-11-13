/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domain.Quiz;
import domain.Tournament;

/**
 *
 * @author Gazi
 */
public interface UpdateService {
    void updateQuiz(Quiz quiz);
    void updateTournament(Tournament tournament);
}
