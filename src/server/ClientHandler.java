package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import requests.Request;
import requests.Response;
import requests.ResponseStatus;
import session.SessionManager;

public class ClientHandler implements Runnable {

    private final Socket clientSocket;
    private ObjectOutputStream out;
    private ObjectInputStream in;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            out = new ObjectOutputStream(clientSocket.getOutputStream());
            in = new ObjectInputStream(clientSocket.getInputStream());

            while (!clientSocket.isClosed()) {
                Request request = (Request) in.readObject();
                Response response = handleRequest(request);
                out.writeObject(response);
                out.flush();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
                if (clientSocket != null && !clientSocket.isClosed()) {
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
