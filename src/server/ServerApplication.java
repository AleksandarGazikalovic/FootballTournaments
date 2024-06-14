package server;

import connection.DBConnection;
import controller.FrontController;
import domain.Administrator;
import domain.Tournament;
import form.MainForm;

public class ServerApplication {

    public static void run() {
        new MainForm().setVisible(true);
        DBConnection.getInstance().connect();
        FrontController.getInstance().add(new Tournament());
        Server server = new Server();
        server.start();
    }
}
