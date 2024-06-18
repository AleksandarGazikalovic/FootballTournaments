package service;

import java.sql.SQLException;
import org.mindrot.jbcrypt.BCrypt;
import domain.Administrator;
import repository.AuthenticationRepository;
import session.Session;
import session.SessionManager;

public class AuthenticationService {

    private static AuthenticationService instance;
    private final SessionManager sessionManager;
    private final AuthenticationRepository authenticationRepository;

    private AuthenticationService() {
        this.sessionManager = SessionManager.getInstance();
        this.authenticationRepository = AuthenticationRepository.getInstance();
    }

    public static AuthenticationService getInstance() {
        if (instance == null) {
            instance = new AuthenticationService();
        }
        return instance;
    }

    public void register(Administrator administrator)
            throws SQLException {
        Administrator foundAdmin = authenticationRepository.getById(administrator);

        if (foundAdmin != null) {
            return;
        }

        String hashedPassword = BCrypt.hashpw(administrator.getPassword(), BCrypt.gensalt());
        administrator.setPassword(hashedPassword);

        authenticationRepository.register(administrator);
    }

    public Administrator login(Administrator administrator) throws SQLException {

        Administrator foundAdmin = authenticationRepository.getById(administrator);
        if (administrator == null || foundAdmin == null) {
            return null;
        }

        if (BCrypt.checkpw(administrator.getPassword(), foundAdmin.getPassword())) {
            administrator = foundAdmin;
            administrator.setPassword(null);
            return administrator;
        }

        return null;
    }

    public Administrator getLoggedInUser(String sessionId) {
        return SessionManager.getInstance().getSession(sessionId).getUser();
    }

    public void logout(String sessionId) {
        SessionManager.getInstance().invalidateSession(sessionId);
    }

}
