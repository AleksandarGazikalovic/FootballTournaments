/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domain.Tournament;
import java.util.List;

/**
 *
 * @author Gazi
 */
public interface TournamentService {

    void createTournament(Tournament tournament);

    void deleteTournament(Tournament tournament);

    List<Tournament> findTournament(List<Tournament> tournaments, Object value);

    List<Tournament> loadTournamentsList(List<Tournament> tournaments);

    Tournament loadTournament(Tournament tournament);

    void updateTournament(Tournament tournament);

}
