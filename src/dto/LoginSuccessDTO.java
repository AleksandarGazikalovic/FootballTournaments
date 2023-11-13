/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import session.Session;

/**
 *
 * @author Gazi
 */
public class LoginSuccessDTO extends DTO{
    private Session session;

    public LoginSuccessDTO(Session session) {
        this.session = session;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
    
    
    
}
