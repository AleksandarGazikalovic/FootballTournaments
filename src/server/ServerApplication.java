package server;

import connection.DBConnection;
import form.MainForm;

public class ServerApplication {

    public static void run() {
        new MainForm().setVisible(true);
        DBConnection.getInstance().connect();
        Server server = new Server();
        server.start();
    }
}
