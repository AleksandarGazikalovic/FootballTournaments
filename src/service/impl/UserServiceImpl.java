/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import connection.DBConnection;
import domain.Administrator;
import dto.DTO;
import dto.LoginFailedDTO;
import dto.LoginSuccessDTO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import service.UserService;
import java.sql.*;
import session.Session;
import session.SessionManager;

/**
 *
 * @author Gazi
 */
public class UserServiceImpl implements UserService {

    private DBConnection dbConnection;

    public UserServiceImpl(DBConnection dbBroker) {
        this.dbConnection = dbBroker;
    }

    @Override
    public DTO login(Administrator administrator) {
        try {
            String query = "SELECT * FROM administrator WHERE username=?";
            PreparedStatement statement = dbConnection.connection.prepareStatement(query);
            statement.setString(1, administrator.getUsername());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                if (rs.getString("password").equals(administrator.getPassword())) {
                    System.out.println("Uspešno ste se prijavili na sistem");
                    administrator.setFirstname(rs.getString("firstname"));
                    administrator.setLastname(rs.getString("lastname"));
                    administrator.setPassword(null);
                    String sessionId = SessionManager.createSession();
                    Session session = SessionManager.getSession(sessionId);
                    session.setAttribute("user", administrator);
                    return new LoginSuccessDTO(session);
                }
            }
            return new LoginFailedDTO("Sistem ne može da pronađe administratora na osnovu unetih podataka");
        } catch (SQLException ex) {
            ex.printStackTrace();
            return new LoginFailedDTO("Sistem ne može da pronađe administratora na osnovu unetih podataka");
        }
    }
}
