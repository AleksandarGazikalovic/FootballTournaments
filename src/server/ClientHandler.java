package server;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import requests.Request;
import requests.Response;
import requests.ResponseStatus;

public class ClientHandler implements Runnable {

    private final Socket clientSocket;
    private ObjectMapper objectMapper = new ObjectMapper();

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try (
                ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
                ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream())) {
            String jsonRequest = (String) in.readObject();

            String jsonResponse = handleRequestAsJson(jsonRequest);
            out.writeObject(jsonResponse);
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

    private Response handleRequest(String jsonRequest) {
        Response response = new Response(null, null, ResponseStatus.Success);
        try {
            Request request = objectMapper.readValue(jsonRequest, Request.class);

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

    private String handleRequestAsJson(String jsonRequest) {
        Response response = handleRequest(jsonRequest);
        try {
            return objectMapper.writeValueAsString(response);
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"responseStatus\":\"Error\",\"exception\":\"" + e.getMessage() + "\"}";
        }
    }

}
