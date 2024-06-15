/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domain.Administrator;
import domain.Entity;
import domain.Quiz;
import domain.Tournament;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

/**
 *
 * @author Gazi
 */
public class FrontController {

    private static FrontController instance;
    private Map<Class<? extends Entity>, AbstractController<? extends Entity>> controllers = new HashMap<>();

    private FrontController() {
        // Register controllers
        controllers.put(Tournament.class, TournamentController.getInstance());
        controllers.put(Quiz.class, QuizController.getInstance());
        controllers.put(Administrator.class, AuthenticationController.getInstance());
    }

    public static FrontController getInstance() {
        if (instance == null) {
            instance = new FrontController();
        }
        return instance;
    }

    @SuppressWarnings("unchecked")
    private <T extends Entity> AbstractController<Entity> getController(Class<T> className) {
        AbstractController<? extends Entity> controller = controllers.get(className);
        if (controller == null) {
            throw new IllegalArgumentException("Controller not found for class: " + className.getName());
        }
        return (AbstractController<Entity>) controller;
    }

    public <T extends Entity> void add(T entity) {
        getController(entity.getClass()).save(entity);
    }

    public <T extends Entity> void update(T entity) {
        getController(entity.getClass()).update(entity);
    }

    public <T extends Entity> void delete(T entity) {
        getController(entity.getClass()).delete(entity);
    }

    public <T extends Entity> List<Entity> getAll(Class<T> className) {
        return getController(className).getAll();
    }

}
