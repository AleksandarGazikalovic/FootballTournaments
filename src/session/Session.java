/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package session;

import domain.Administrator;

/**
 *
 * @author Gazi
 */
public class Session {
    private String sessionId;
    private Administrator admin;
    private long creationTime;
    private long lastAccessedTime;

    public Session(String sessionId, Administrator admin) {
        this.sessionId = sessionId;
        this.admin = admin;
        this.creationTime = System.currentTimeMillis();
        this.lastAccessedTime = System.currentTimeMillis();
    }

    public String getSessionId() {
        return sessionId;
    }

    public Administrator getAdmin() {
        return admin;
    }

    public long getCreationTime() {
        return creationTime;
    }

    public long getLastAccessedTime() {
        return lastAccessedTime;
    }

    public void setLastAccessedTime(long lastAccessedTime) {
        this.lastAccessedTime = lastAccessedTime;
    }
}
