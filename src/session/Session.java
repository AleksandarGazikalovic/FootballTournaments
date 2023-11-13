/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package session;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Gazi
 */
public class Session {
    private final String sessionId;
    private final Map<String, Object> attributes = new HashMap<>();

    public Session(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setAttribute(String key, Object value) {
        attributes.put(key, value);
    }

    public Object getAttribute(String key) {
        return attributes.get(key);
    }

    public void removeAttribute(String key) {
        attributes.remove(key);
    }

}
   
