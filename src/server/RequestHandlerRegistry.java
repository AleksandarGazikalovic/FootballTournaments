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
import requests.RequestType;

public class RequestHandlerRegistry {
    private static final Map<RequestType, RequestHandler> handlers = new HashMap<>();

    static {
        handlers.put(RequestType.ADD, createSaveHandler());
        handlers.put(RequestType.UPDATE, createUpdateHandler());
        handlers.put(RequestType.DELETE, createDeleteHandler());
        handlers.put(RequestType.GET_ALL, createFindAllHandler());
        handlers.put(RequestType.LOGIN, createLoginHandler());
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
            Class<? extends Entity> className = ((Entity) request.getData()).getClass();
            response.setData(FrontController.getInstance().getAll(className));
        };
    }

    private static RequestHandler createLoginHandler() {
        return (request, response) -> {
            AuthenticationController.getInstance().login((Administrator) request.getData());
        };
    }

    public static RequestHandler getHandler(RequestType requestType) {
        return handlers.get(requestType);
    }
}
