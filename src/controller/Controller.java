/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import service.impl.FormServiceImpl;
import connection.DBConnection;
import domain.Administrator;
import domain.Quiz;
import domain.Tournament;
import dto.DTO;
import dto.LoginFailedDTO;
import dto.LoginSuccessDTO;
import java.awt.CardLayout;
import java.util.List;
import javax.swing.JPanel;
import service.*;
import session.Session;
import session.SessionManager;
import components.IView;
import service.impl.QuizServiceImpl;
import service.impl.TournamentServiceImpl;

/**
 *
 * @author Gazi
 */
public class Controller {
    
    private static Controller instance;
    private final DBConnection dbConnection;
    private final QuizService quizService;
    private final TournamentService tournamentService;
    private final FormService formService;
    private JPanel container;
    private CardLayout cardLayout;
    private List<IView> openedForms;
    private JPanel activePanel;

    private Controller() {
        this.dbConnection = DBConnection.getInstance();
        dbConnection.connect();
        this.quizService = new QuizServiceImpl(dbConnection);
        this.tournamentService = new TournamentServiceImpl(dbConnection);
        this.formService = new FormServiceImpl();
    }
    
    public static Controller getInstance(){
        if(instance==null){
            instance = new Controller();
        }
        return instance;
    }
        
    
    public void createQuiz(Quiz quiz){
        quizService.createQuiz(quiz);
    }
    
    public List<Quiz> loadQuizzesList(List<Quiz> quizzes){
       return quizService.loadQuizzesList(quizzes);
    }
    
    public List<Quiz> findQuiz(List<Quiz> quizzes, Object value){
       return quizService.findQuiz(quizzes, value);
    } 
    
    public Quiz loadQuiz(Quiz quiz){
       return quizService.loadQuiz(quiz);
    }
    
    public void updateQuiz(Quiz quiz){
        quizService.updateQuiz(quiz);
    }
    
    public void deleteQuiz(Quiz quiz){
        quizService.deleteQuiz(quiz);
    }
    
    public void createTournament(Tournament tournament){
        tournamentService.createTournament(tournament);
    }

    public List<Tournament> loadTournamentsList(List<Tournament> tournaments){
       return tournamentService.loadTournamentsList(tournaments);
    }
    
    public List<Tournament> findTournament(List<Tournament> tournaments, Object value){
       return tournamentService.findTournament(tournaments, value);
    } 
    
    public Tournament loadTournament(Tournament tournament){
       return tournamentService.loadTournament(tournament);
    }
    
    public void updateTournament(Tournament tournament){
        tournamentService.updateTournament(tournament);
    }
    
    public void deleteTournament(Tournament tournament){
        tournamentService.deleteTournament(tournament);
    }
    
    public void addForm(IView form){
        formService.addForm(form);
    }
    
    public void setActivePanel(JPanel panel){
        formService.setActivePanel(panel);
        panel.updateUI();
    }
    
    public JPanel getActivePanel(){
        return formService.getActivePanel();
    }
    
    
    public  JPanel getContainer() {
        return container;
    }

    public void setContainer(JPanel aContainer) {
        container = aContainer;
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public void setCardLayout(CardLayout aCardLayout) {
        cardLayout = aCardLayout;
    }
    
}
