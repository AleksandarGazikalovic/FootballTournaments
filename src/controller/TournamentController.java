/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domain.Tournament;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.TournamentService;

/**
 *
 * @author Gazi
 */
public class TournamentController implements AbstractController<Tournament> {

    private static TournamentController instance;
    private final TournamentService tournamentService;

    private TournamentController() {
        this.tournamentService = TournamentService.getInstance();
    }

    public static TournamentController getInstance() {
        if (instance == null) {
            instance = new TournamentController();
        }
        return instance;
    }

    // public List<Tournament> loadTournamentsList(List<Tournament> tournaments){
    // return tournamentService.loadTournamentsList(tournaments);
    // }
    public List<Tournament> findTournament(List<Tournament> tournaments, Object value) {
        return tournamentService.findTournament(tournaments, value);
    }

    // public Tournament loadTournament(Tournament tournament) {
    // try {
    // return tournamentService.loadTournament(tournament);
    // } catch (SQLException ex) {
    // Logger.getLogger(TournamentController.class.getName()).log(Level.SEVERE,
    // null, ex);
    // }
    // }


    @Override
    public void save(Tournament tournament) {
        try {
            tournamentService.createTournament(tournament);
        } catch (SQLException ex) {
            Logger.getLogger(TournamentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void update(Tournament tournament) {
        try {
            tournamentService.updateTournament(tournament);
        } catch (SQLException ex) {
            Logger.getLogger(TournamentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Tournament tournament) {
        try {
            tournamentService.deleteTournament(tournament);
        } catch (SQLException ex) {
            Logger.getLogger(TournamentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Tournament> getAll(Tournament tournament) {
        try {
            return tournamentService.loadTournamentsList(tournament);
        } catch (SQLException ex) {
            Logger.getLogger(TournamentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Tournament get(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
