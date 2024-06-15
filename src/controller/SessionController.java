/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import connection.DBConnection;
import domain.Entity;
import domain.Administrator;
import dto.DTO;
import dto.LoginSuccessDTO;
import service.UserService;
import service.UserService;
import session.SessionManager;

/**
 *
 * @author Gazi
 */
public class SessionController {

    private static SessionController instance;

    public SessionController() {
    }

    public static SessionController getInstance() {
        if (instance == null) {
            instance = new SessionController();
        }
        return instance;
    }

}
