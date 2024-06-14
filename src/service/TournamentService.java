/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domain.Tournament;
import java.sql.SQLException;
import java.util.List;
import repository.TournamentRepository;

/**
 *
 * @author Gazi
 */
public class TournamentService {

    private static TournamentService instance;
    private final TournamentRepository tournamentRepository;

    private TournamentService() {
        this.tournamentRepository = TournamentRepository.getInstance();
    }

    public static TournamentService getInstance() {
        if (instance == null) {
            instance = new TournamentService();
        }
        return instance;
    }

    // public Tournament getById(int id) {
    // return (Tournament) this.tournamentRepository.findBy();
    // }

    public void createTournament(Tournament tournament) throws SQLException {
        tournamentRepository.save(tournament);
    }

    public List<Tournament> findTournament(List<Tournament> tournaments, Object value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Tournament> loadTournamentsList(Tournament tournament) throws SQLException {
        return tournamentRepository.getAll(tournament);
    }

    public Tournament loadTournament(Tournament tournament) throws SQLException {
        return (Tournament) tournamentRepository.getById(tournament);
    }

    public void updateTournament(Tournament tournament) throws SQLException {
        tournamentRepository.update(tournament);
    }

    public void deleteTournament(Tournament tournament) throws SQLException {
        tournamentRepository.delete(tournament);
    }

}
