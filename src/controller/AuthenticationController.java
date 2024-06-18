package controller;

import java.util.List;

import domain.Administrator;
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

    public Administrator login(Administrator administrator) throws Exception{
            return authenticationService.login(administrator);
    }

    public void logout(String sessionId) throws Exception{
        authenticationService.logout(sessionId);
    }

    @Override
    public void save(Administrator administrator) throws Exception{
            authenticationService.register(administrator);
    }

    @Override
    public void update(Administrator entity) throws Exception{
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Administrator entity) throws Exception{
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public List<Administrator> getAll() throws Exception{
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public Administrator get(Long id) throws Exception{
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");

    }

    public Administrator getLoggedInUser(String sessionId) {
        return authenticationService.getLoggedInUser(sessionId);
    }
}
