/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domain.Tournament;
import domain.TournamentRound;
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
    private final TournamentRoundService tournamentRoundService;

    private TournamentService() {
        this.tournamentRepository = TournamentRepository.getInstance();
        this.tournamentRoundService = TournamentRoundService.getInstance();
    }

    public static TournamentService getInstance() {
        if (instance == null) {
            instance = new TournamentService();
        }
        return instance;
    }

    public void createTournament(Tournament tournament) throws SQLException {
        Long tournamentID = tournamentRepository.save(tournament);
        tournament.setTournamentID(tournamentID);
        List<TournamentRound> rounds = tournament.getRounds();
        for (int i = 0; i < rounds.size(); i++) {
            rounds.get(i).setTournament(tournament);
            tournamentRoundService.createTournamentRound(rounds.get(i));
        }
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
        List<TournamentRound> rounds = tournament.getRounds();
        for (int i = 0; i < rounds.size(); i++) {
            rounds.get(i).setTournament(tournament);
            rounds.get(i).print();
            tournamentRoundService.updateTournamentRound(rounds.get(i));
        }
    }

    public void deleteTournament(Tournament tournament) throws SQLException {
        tournamentRepository.delete(tournament);
    }

}
