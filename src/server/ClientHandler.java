package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import requests.Request;
import requests.Response;
import requests.ResponseStatus;

public class ClientHandler implements Runnable {

    private final Socket clientSocket;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try (
                 ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());  ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream())) {
            Request request = (Request) in.readObject();

            Response response = handleRequest(request);
            out.writeObject(response);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private Response handleRequest(Request request) {

        Response response = new Response(null, null, ResponseStatus.Success);
        try {
            RequestHandler handler = RequestHandlerRegistry.getHandler(request.getRequestType());
            if (handler != null) {
                handler.handle(request, response);
            } else {
                response.setResponseStatus(ResponseStatus.Error);
                response.setException(
                        new UnsupportedOperationException("Unsupported operation: " + request.getRequestType()));
            }
        } catch (Exception e) {
            response.setResponseStatus(ResponseStatus.Error);
            response.setException(e);
        }
        return response;
    }

}
