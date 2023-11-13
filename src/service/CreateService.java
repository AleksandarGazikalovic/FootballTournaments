/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domain.Quiz;
import domain.Tournament;

/**
 *
 * @author Gazi
 */
public interface CreateService {
    void createQuiz(Quiz quiz);
    void createTournament(Tournament tournament);
}
