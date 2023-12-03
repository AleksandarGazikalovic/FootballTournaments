/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import connection.DBConnection;
import domain.Tournament;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.TournamentService;

/**
 *
 * @author Gazi
 */
public class TournamentServiceImpl implements TournamentService {

    DBConnection dbConnection;

    public TournamentServiceImpl(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public void createTournament(Tournament tournament) {
        try {
            String query = "INSERT INTO tournament(league,tournamentName) VALUES(?,?)";
            PreparedStatement statement = dbConnection.connection.prepareStatement(query);
            statement.setString(1, tournament.getLeague());
            statement.setString(2, tournament.getTournamentName());
            statement.executeUpdate();
            System.out.println("Sistem je zapamtio turnir");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Sistem ne može da zapamti turnir");
        }
    }

    @Override
    public List<Tournament> findTournament(List<Tournament> tournaments, Object value) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Tournament> loadTournamentsList(List<Tournament> tournaments) {
        try {
            tournaments = new ArrayList<>();
            String query = "SELECT * FROM tournament";
            Statement statement = dbConnection.connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Tournament tournament = makeTournament(rs);
                if (tournament != null) {
                    tournaments.add(tournament);
                }
            }
            return tournaments;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Tournament loadTournament(Tournament tournament) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateTournament(Tournament tournament) {
        try {
            String query = "UPDATE tournament SET tournamentName=?, league=? WHERE tournamentID=?";
            PreparedStatement statement = dbConnection.connection.prepareStatement(query);
            statement.setString(1, tournament.getTournamentName());
            statement.setString(2, tournament.getLeague());
            statement.setLong(3, tournament.getTournamentID());
            statement.executeUpdate();
            System.out.println("Sistem je zapamtio turnir");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Sistem ne može da zapamti turnir");
        }
    }

    @Override
    public void deleteTournament(Tournament tournament) {
        try {
            String query = "DELETE FROM tournament WHERE tournamentID=?";
            PreparedStatement statement = dbConnection.connection.prepareStatement(query);
            statement.setLong(1, tournament.getTournamentID());
            statement.executeUpdate();
            System.out.println("Sistem je obrisao kviz");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Sistem ne može da obriše kviz");
        }
    }

    private Tournament makeTournament(ResultSet rs) {
        try {
            Tournament tournament = new Tournament();
            tournament.setTournamentID(rs.getLong("tournamentID"));
            tournament.setTournamentName(rs.getString("tournamentName"));
            tournament.setLeague(rs.getString("league"));
            return tournament;
        } catch (SQLException ex) {
        }
        return null;
    }
}
