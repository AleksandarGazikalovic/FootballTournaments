package service;

import org.mindrot.jbcrypt.BCrypt;
import domain.Administrator;
import repository.AuthenticationRepository;
import session.SessionManager;

public class AuthenticationService {

    private static AuthenticationService instance;
    private final AuthenticationRepository authenticationRepository;

    private AuthenticationService() {
        this.authenticationRepository = AuthenticationRepository.getInstance();
    }

    public static AuthenticationService getInstance() {
        if (instance == null) {
            instance = new AuthenticationService();
        }
        return instance;
    }

    public void register(Administrator administrator)
            throws Exception {
        Administrator foundAdmin = authenticationRepository.getById(administrator);

        if (foundAdmin != null) {
            throw new Exception("Korisnik sa unetim username-om vec postoji!");
        }

        String hashedPassword = BCrypt.hashpw(administrator.getPassword(), BCrypt.gensalt());
        administrator.setPassword(hashedPassword);

        authenticationRepository.register(administrator);
    }

    public Administrator login(Administrator administrator) throws Exception {

        Administrator foundAdmin = authenticationRepository.getById(administrator);
        if (administrator == null || foundAdmin == null) {
            throw new Exception("Korisnik s unetim kredencijalima ne postoji!");
        }

        if (BCrypt.checkpw(administrator.getPassword(), foundAdmin.getPassword())) {
            administrator = foundAdmin;
            administrator.setPassword(null);
            return administrator;
        }

        throw new Exception("Uneli ste pogresnu lozinku!");
    }

    public Administrator getLoggedInUser(String sessionId) {
        return SessionManager.getInstance().getSession(sessionId).getAdmin();
    }

    public void logout(String sessionId) {
        SessionManager.getInstance().invalidateSession(sessionId);
    }

}
