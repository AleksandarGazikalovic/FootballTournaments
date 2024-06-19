/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domain.TournamentRound;
import java.sql.SQLException;
import java.util.List;
import repository.TournamentRoundRepository;

/**
 *
 * @author Gazi
 */
public class TournamentRoundService {

    private static TournamentRoundService instance;
    private final TournamentRoundRepository tournamentRoundRepository;

    private TournamentRoundService() {
        this.tournamentRoundRepository = TournamentRoundRepository.getInstance();
    }

    public static TournamentRoundService getInstance() {
        if (instance == null) {
            instance = new TournamentRoundService();
        }
        return instance;
    }

    public void createTournamentRound(TournamentRound tournamentRound) throws SQLException {
        tournamentRoundRepository.save(tournamentRound);
    }

    public void updateTournamentRound(TournamentRound tournamentRound) throws SQLException {
        tournamentRoundRepository.update(tournamentRound);
    }

    public List<TournamentRound> loadQuizTournamentRounds(TournamentRound tournamentRound) throws SQLException {
        return tournamentRoundRepository.findBy(tournamentRound, tournamentRound.getNewKey_Where());
    }
}
