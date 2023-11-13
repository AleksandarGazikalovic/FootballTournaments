/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import connection.DBConnection;
import domain.Administrator;
import domain.Quiz;
import domain.Tournament;
import dto.DTO;
import dto.LoginFailedDTO;
import dto.LoginSuccessDTO;
import java.util.List;
import service.implementation.*;
import service.*;
import session.Session;
import session.SessionManager;

/**
 *
 * @author Gazi
 */
public class Controller {
    
    private static Controller instance;
    private final DBConnection dbConnection;
    private final UpdateService updateService;
    private final DeleteService deleteService;
    private final CreateService createService;
    private final LoadService loadService;
    private final FindService findService;
    private final UserService userService;

    private Controller() {
        this.dbConnection = DBConnection.getInstance();
        dbConnection.connect();
        this.updateService = new UpdateServiceImplementation(dbConnection);
        this.deleteService = new DeleteServiceImplementation(dbConnection);
        this.createService = new CreateServiceImplementation(dbConnection);
        this.loadService = new LoadServiceImplementation(dbConnection);
        this.findService = new FindServiceImplementation(dbConnection);
        this.userService =new UserServiceImplementation(dbConnection);
    }
    
    public static Controller getInstance(){
        if(instance==null){
            instance = new Controller();
        }
        return instance;
    }
    
    public DTO login(Administrator administrator){  
        return userService.login(administrator);
    }
    
    public void createQuiz(Quiz quiz){
        createService.createQuiz(quiz);
    }
    
    public List<Quiz> loadQuizzesList(List<Quiz> quizzes){
       return loadService.loadQuizzesList(quizzes);
    }
    
    public List<Quiz> findQuiz(List<Quiz> quizzes, Object value){
       return findService.findQuiz(quizzes, value);
    } 
    
    public Quiz loadQuiz(Quiz quiz){
       return loadService.loadQuiz(quiz);
    }
    
    public void updateQuiz(Quiz quiz){
        updateService.updateQuiz(quiz);
    }
    
    public void deleteQuiz(Quiz quiz){
        deleteService.deleteQuiz(quiz);
    }
    
    public void createTournament(Tournament tournament){
        createService.createTournament(tournament);
    }

    public List<Tournament> loadTournamentsList(List<Tournament> quizzes){
       return loadService.loadTournamentsList(quizzes);
    }
    
    public List<Tournament> findTournament(List<Tournament> tournaments, Object value){
       return findService.findTournament(tournaments, value);
    } 
    
    public Tournament loadTournament(Tournament tournament){
       return loadService.loadTournament(tournament);
    }
    
    public void updateTournament(Tournament tournament){
        updateService.updateTournament(tournament);
    }
    
    public void deleteTournament(Tournament tournament){
        deleteService.deleteTournament(tournament);
    }
    
}
