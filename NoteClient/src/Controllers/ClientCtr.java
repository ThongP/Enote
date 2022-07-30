package Controllers;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author gbrid
 */
public class ClientCtr {
    public final static String SERVER_IP = "127.0.0.1";
    public final static int SERVER_PORT = 7;
    public static Socket socket = null;
    public static DataInputStream dis = null;
    public static DataOutputStream dos = null;

    public static boolean connect() {
        try {
            socket = new Socket(SERVER_IP, SERVER_PORT); // Connect to server
            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());
            System.out.println("Connected: " + socket);

            return true;
        } catch (IOException e) {
//            e.printStackTrace();

            return false;
        }
    }
}
