/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domain.TournamentRound;

/**
 *
 * @author Gazi
 */
public class TournamentRoundRepository extends AbstractRepository<TournamentRound> {

    private static TournamentRoundRepository instance;

    private TournamentRoundRepository() throws Exception{
    }

    public static TournamentRoundRepository getInstance() throws Exception {
        if (instance == null) {
            instance = new TournamentRoundRepository();
        }
        return instance;
    }
}
