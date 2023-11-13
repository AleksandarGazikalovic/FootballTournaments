/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author Gazi
 */
public class Tournament {
    private Long tournamentID;
    private String tournamentName;
    private String league;

    public Tournament(String tournamentName, String league) {
        this.tournamentName = tournamentName;
        this.league = league;
    }

    public Tournament() {
    }

    public Long getTournamentID() {
        return tournamentID;
    }

    public void setTournamentID(Long tournamentID) {
        this.tournamentID = tournamentID;
    }

    public String getTournamentName() {
        return tournamentName;
    }

    public void setTournamentName(String tournamentName) {
        this.tournamentName = tournamentName;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

}
