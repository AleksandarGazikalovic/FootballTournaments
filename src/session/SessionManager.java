/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package session;

/**
 *
 * @author Gazi
 */
import java.util.HashMap;
import java.util.Map;

public class SessionManager {
    private static final Map<String, Session> sessions = new HashMap<>();

    public static String createSession() {
        String sessionId = generateSessionId();
        Session session = new Session(sessionId);
        sessions.put(sessionId, session);
        return sessionId;
    }

    public static Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public static void removeSession(String sessionId) {
        sessions.remove(sessionId);
    }

    private static String generateSessionId() {
        return Long.toHexString(Double.doubleToLongBits(Math.random()));
    }
}

