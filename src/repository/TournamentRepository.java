/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domain.Tournament;

/**
 *
 * @author Gazi
 */
public class TournamentRepository extends AbstractRepository<Tournament> {

    private static TournamentRepository instance;

    private TournamentRepository() throws Exception{
    }

    public static TournamentRepository getInstance() throws Exception {
        if (instance == null) {
            instance = new TournamentRepository();
        }
        return instance;
    }
}
