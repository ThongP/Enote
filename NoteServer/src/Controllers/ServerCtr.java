package Controllers;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author gbrid
 */
public class ServerCtr {
    public static final int NUM_OF_THREAD = 5;
    public final static int SERVER_PORT = 8888;

    public static void startServer() throws IOException {
        ExecutorService executor = Executors.newFixedThreadPool(NUM_OF_THREAD);
        ServerSocket serverSocket = null;
        try {
            System.out.println("Binding to port " + SERVER_PORT + ", please wait  ...");
            serverSocket = new ServerSocket(SERVER_PORT);
            System.out.println("Server started: " + serverSocket);
            System.out.println("Waiting for a client ...");
            while (!serverSocket.isClosed()) {
                try {
                    Socket socket = serverSocket.accept();
                    System.out.println("Client accepted: " + socket);

                    ConnectedThread handler = new ConnectedThread(socket);
                    executor.execute(handler);
                } catch (IOException e) {
                    System.err.println(" Connection Error: " + e);
                }
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}
