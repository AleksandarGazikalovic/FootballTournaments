/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author Gazi
 */
public class TournamentRound {
    private Long roundID;
    private String roundName;

    public TournamentRound(String roundName) {
        this.roundName = roundName;
    }

    public TournamentRound() {
    }

    public Long getRoundID() {
        return roundID;
    }

    public void setRoundID(Long roundID) {
        this.roundID = roundID;
    }

    public String getRoundName() {
        return roundName;
    }

    public void setRoundName(String roundName) {
        this.roundName = roundName;
    }
    
    
}
