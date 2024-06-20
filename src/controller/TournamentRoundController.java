/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domain.TournamentRound;
import java.util.List;
import service.TournamentRoundService;

/**
 *
 * @author Gazi
 */
public class TournamentRoundController implements AbstractController<TournamentRound> {

    private static TournamentRoundController instance;
    private final TournamentRoundService tournamentRoundService;

    private TournamentRoundController() {
        this.tournamentRoundService = TournamentRoundService.getInstance();
    }

    public static TournamentRoundController getInstance() {
        if (instance == null) {
            instance = new TournamentRoundController();
        }
        return instance;
    }

    @Override
    public void save(TournamentRound entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(TournamentRound entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(TournamentRound entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<TournamentRound> getAll(TournamentRound round) throws Exception {
        return tournamentRoundService.loadTournamentRounds(round);
    }

    @Override
    public TournamentRound get(Long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
