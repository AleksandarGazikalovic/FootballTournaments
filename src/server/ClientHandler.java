package server;

import domain.Entity;
import domain.Tournament;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import requests.Request;
import requests.RequestType;
import requests.Response;
import requests.ResponseStatus;
import session.SessionManager;

public class ClientHandler implements Runnable {

    private Server server;
    private final Socket clientSocket;
    private ObjectOutputStream out;
    private ObjectInputStream in;

    public ClientHandler(Socket clientSocket, Server server) {
        this.clientSocket = clientSocket;
        this.server = server;
    }

    @Override
    public void run() {
        try {
            out = new ObjectOutputStream(clientSocket.getOutputStream());
            in = new ObjectInputStream(clientSocket.getInputStream());

            while (!clientSocket.isClosed()) {
                if (server.isShuttingDown()) {
                    break;
                }
                Request request = (Request) in.readObject();
                Response response = handleRequest(request);
                out.writeObject(response);
                out.flush();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                System.out.println("finally");
                if (in != null) {
                    System.out.println("in");
                    in.close();
                }
                if (out != null) {
                    System.out.println("out");
                    out.close();
                }
                if (clientSocket != null && !clientSocket.isClosed()) {
                    System.out.println("socket");
                    clientSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private Response handleRequest(Request request) {
        Response response = new Response(null, null, ResponseStatus.Success);
        try {
            RequestHandler handler = RequestHandlerRegistry.getHandler(request.getRequestType());
            if (SessionManager.getInstance().isSessionValid(request)) {
                if (handler != null) {
                    handler.handle(request, response);
                } else {
                    response.setResponseStatus(ResponseStatus.Error);
                    response.setException(
                            new UnsupportedOperationException("Unsupported operation: " + request.getRequestType()));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.setResponseStatus(ResponseStatus.Error);
            response.setException(e);
        }
        return response;
    }

}
