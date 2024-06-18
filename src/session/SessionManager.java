/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package session;

/**
 *
 * @author Gazi
 */
import domain.Administrator;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import requests.Request;
import requests.RequestType;
import requests.Response;
import requests.ResponseStatus;

public class SessionManager {

    private static SessionManager instance;
    private Map<String, Session> sessions = new HashMap<>();

    private SessionManager() {
    }

    public static synchronized SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public Session createSession(Administrator admin) {
        String sessionId = UUID.randomUUID().toString();
        Session session = new Session(sessionId, admin);
        sessions.put(sessionId, session);
        return session;
    }

    public Session getSession(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session != null) {
            session.setLastAccessedTime(System.currentTimeMillis());
        }
        return session;
    }

    public void invalidateSession(String sessionId) {
        sessions.remove(sessionId);
        System.out.println("Session with id: " + sessionId + "invalidated");
    }

    public boolean isValidSession(String sessionId) {
        return sessions.containsKey(sessionId);
    }

    public boolean isSessionValid(Request request) throws Exception {
        if (request.getRequestType() == RequestType.LOGIN
                || (request.getRequestType() == RequestType.ADD && request.getData() instanceof Administrator)) {
            return true;
        } else {
            String sessionToken = request.getSessionToken();
            if (SessionManager.getInstance().isValidSession(sessionToken)) {
                return true;
            } else {
                throw new Exception("Invalid session");
            }
        }
    }
}
