package controller;

import java.sql.SQLException;
import java.util.List;

import domain.Administrator;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.AuthenticationService;

public class AuthenticationController implements AbstractController<Administrator> {
    private static AuthenticationController instance;
    private final AuthenticationService authenticationService;

    private AuthenticationController() {
        this.authenticationService = AuthenticationService.getInstance();
    }

    public static AuthenticationController getInstance() {
        if (instance == null) {
            instance = new AuthenticationController();
        }
        return instance;
    }

    public Administrator login(Administrator administrator) {
        try {
            return authenticationService.login(administrator);
        } catch (SQLException ex) {
            Logger.getLogger(AuthenticationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void logout() {
        // sessionManager.invalidateSession();
    }

    @Override
    public void save(Administrator administrator) {
        try {
            authenticationService.register(administrator);
        } catch (SQLException ex) {
            Logger.getLogger(AuthenticationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Administrator entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Administrator entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public List<Administrator> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }
}
