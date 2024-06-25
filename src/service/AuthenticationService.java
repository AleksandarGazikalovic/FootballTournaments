package service;

import org.mindrot.jbcrypt.BCrypt;
import domain.Administrator;
import repository.AuthenticationRepository;
import session.SessionManager;

public class AuthenticationService {

    private static AuthenticationService instance;
    private final AuthenticationRepository authenticationRepository;

    private AuthenticationService() throws Exception {
        this.authenticationRepository = AuthenticationRepository.getInstance();
    }

    public static AuthenticationService getInstance() throws Exception {
        if (instance == null) {
            instance = new AuthenticationService();
        }
        return instance;
    }

    public void register(Administrator administrator)
            throws Exception {
        Administrator foundAdmin = authenticationRepository.getById(administrator);

        if (foundAdmin != null) {
            throw new Exception("Administrator with that username already exists!");
        }

        String hashedPassword = BCrypt.hashpw(administrator.getPassword(), BCrypt.gensalt());
        administrator.setPassword(hashedPassword);

        authenticationRepository.register(administrator);
    }

        public Administrator login(Administrator administrator) throws Exception {

        Administrator foundAdmin = authenticationRepository.getById(administrator);
        if (administrator == null || foundAdmin == null) {
            throw new Exception("Administrator with entered credentials does not exist!");
        }

        if (BCrypt.checkpw(administrator.getPassword(), foundAdmin.getPassword())) {
            administrator = foundAdmin;
            administrator.setPassword(null);
            return administrator;
        }

        throw new Exception("Password is incorrect!");
    }

    public Administrator getLoggedInUser(String sessionId) {
        return SessionManager.getInstance().getSession(sessionId).getAdmin();
    }

    public void logout(String sessionId) {
        SessionManager.getInstance().invalidateSession(sessionId);
    }

}
