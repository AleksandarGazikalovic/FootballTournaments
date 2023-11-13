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
public interface DeleteService {
    void deleteQuiz(Quiz quiz);
    void deleteTournament(Tournament tournament);
}
