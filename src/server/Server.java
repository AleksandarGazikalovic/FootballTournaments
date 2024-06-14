package server;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
        private static final int PORT = 9000;
        private static final int THREAD_POOL_SIZE = 10;

        private final ExecutorService executorService;

        public Server() {
            this.executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        }

        public void start() {
            try (ServerSocket serverSocket = new ServerSocket(PORT)) {
                System.out.println("Server is listening on port " + PORT);

                while (true) {
                    Socket clientSocket = serverSocket.accept();
                    System.out.println("Accepted connection from " + clientSocket.getInetAddress());

                    executorService.submit(new ClientHandler(clientSocket));
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                executorService.shutdown();
            }
        }
}


