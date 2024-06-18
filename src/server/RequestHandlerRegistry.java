/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import controller.AuthenticationController;
/**
 *
 * @author Gazi
 */
import controller.FrontController;
import domain.Administrator;
import domain.Entity;
import java.util.HashMap;
import java.util.Map;
import requests.Request;
import requests.RequestType;
import requests.Response;
import requests.ResponseStatus;
import session.Session;
import session.SessionManager;

public class RequestHandlerRegistry {

    private static final Map<RequestType, RequestHandler> handlers = new HashMap<>();

    static {
        handlers.put(RequestType.ADD, createSaveHandler());
        handlers.put(RequestType.UPDATE, createUpdateHandler());
        handlers.put(RequestType.DELETE, createDeleteHandler());
        handlers.put(RequestType.GET_ALL, createFindAllHandler());
        handlers.put(RequestType.LOGIN, createLoginHandler());
        handlers.put(RequestType.LOGGED_IN, createGetLoggedInHandler());
        handlers.put(RequestType.LOG_OUT, createLogOutHandler());
    }

    private static RequestHandler createSaveHandler() {
        return (request, response) -> {
            FrontController.getInstance().add((Entity) request.getData());
        };
    }

    private static RequestHandler createUpdateHandler() {
        return (request, response) -> {
            FrontController.getInstance().update((Entity) request.getData());
        };
    }

    private static RequestHandler createDeleteHandler() {
        return (request, response) -> {
            FrontController.getInstance().delete((Entity) request.getData());
        };
    }

    private static RequestHandler createFindAllHandler() {
        return (request, response) -> {
            response.setData(FrontController.getInstance().getAll((Entity) request.getData()));
        };
    }

    private static RequestHandler createLoginHandler() {
        return (request, response) -> {
            Administrator admin = AuthenticationController.getInstance().login((Administrator) request.getData());
            System.out.println("nesto");
            if (admin != null) {
                response.setData(admin);
                Session session = SessionManager.getInstance().createSession(admin);
                response.setSessionToken(session.getSessionId());
            }
        };
    }

    private static RequestHandler createGetLoggedInHandler() {
        return (request, response) -> {
            Administrator admin = AuthenticationController.getInstance().getLoggedInUser(request.getSessionToken());
            response.setData(admin);
        };
    }

    private static RequestHandler createLogOutHandler() {
        return (request, response) -> {
            AuthenticationController.getInstance().logout(request.getSessionToken());
        };
    }

    public static RequestHandler getHandler(RequestType requestType) {
        return handlers.get(requestType);
    }

}
