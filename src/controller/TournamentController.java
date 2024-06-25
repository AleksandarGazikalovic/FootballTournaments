/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domain.Tournament;
import java.util.List;
import service.TournamentService;

/**
 *
 * @author Gazi
 */
public class TournamentController implements AbstractController<Tournament> {

    private static TournamentController instance;
    private final TournamentService tournamentService;

    private TournamentController() throws Exception {
        this.tournamentService = TournamentService.getInstance();
    }

    public static TournamentController getInstance() throws Exception {
        if (instance == null) {
            instance = new TournamentController();
        }
        return instance;
    }

    public List<Tournament> findTournament(List<Tournament> tournaments, Object value) {
        return tournamentService.findTournament(tournaments, value);
    }

    @Override
    public void save(Tournament tournament) throws Exception {
        tournamentService.createTournament(tournament);

    }

    @Override
    public void update(Tournament tournament) throws Exception {
        tournamentService.updateTournament(tournament);
    }

    @Override
    public void delete(Tournament tournament) throws Exception {
        tournamentService.deleteTournament(tournament);
    }

    @Override
    public List<Tournament> getAll(Tournament tournament) throws Exception {
        return tournamentService.loadTournamentsList(tournament);
    }

}
