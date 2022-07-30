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
    public static DataInputStream in = null;
    public static DataOutputStream out = null;

    public static boolean connectCheck() {
        try {
            socket = new Socket(SERVER_IP, SERVER_PORT); // Connect to server
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            System.out.println("Connected: " + socket);

            return true;
        } catch (Exception e) {
            e.printStackTrace();

            return false;
        }
    }
    
    public static String signUp(String user, String pass) {
        String res = "";
        
        try {
            out.writeUTF("Signup");
            
            out.writeUTF(user);
            out.writeUTF(pass);
            
            res = in.readUTF();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.out.println(res);
        return res;
    }
    
    public static String logIn(String user, String pass) {
        String res = "";
        
        try {
            out.writeUTF("Login");
            
            out.writeUTF(user);
            out.writeUTF(pass);
            
            res = in.readUTF();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.out.println(res);
        return res;
    }
}
