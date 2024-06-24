/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.SQLException;
import domain.Administrator;

/**
 *
 * @author Gazi
 */
public class AuthenticationRepository extends AbstractRepository<Administrator> {

    private static AuthenticationRepository instance;

    private AuthenticationRepository() throws Exception{
    }

    public static AuthenticationRepository getInstance() throws Exception {
        if (instance == null) {
            instance = new AuthenticationRepository();
        }
        return instance;
    }

    public void register(Administrator administrator) throws SQLException {
        super.save(administrator);
    }

}
