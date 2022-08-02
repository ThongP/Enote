package Controllers;

import Entities.Notes;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.net.Socket;
import java.nio.file.Files;
import java.util.ArrayList;

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
    
    public static Notes getNote(String user, int noteID) {
        try {
            out.writeUTF("Getnote");
            
            out.writeUTF(user);
            out.writeInt(noteID);
            
            byte[] bytes = null;
            int length = in.readInt();
            if(length > 0) {
                bytes = new byte[length];
                in.readFully(bytes);
            }
            String filesname = in.readUTF();
            String res = in.readUTF();
            
            System.out.println(res);
            return new Notes(filesname,bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null; 
    }
    
    public static Notes saveNote(String user, String filesName, String filePath) {
        try {
            out.writeUTF("Savenote");
            
            File file = new File(filePath);
            byte[] bytes = Files.readAllBytes(file.toPath());
            out.writeUTF(user);
            out.writeUTF(filesName);
            out.writeInt(bytes.length);
            out.write(bytes);
            
            String res = in.readUTF();
            System.out.println(res);
            return new Notes(filesName, bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    public static ArrayList<Notes> getNotes(String user) {
        ArrayList<Notes> list = new ArrayList<Notes>();
        
        try {
            out.writeUTF("Getnotes");
            
            out.writeUTF(user);
            int lenght = in.readInt();
            for(int i = 0; i < lenght; i++) {
                String name = in.readUTF();
                int noteID = in.readInt();
                String filesPath = in.readUTF();
                String filesType = in.readUTF();
                
                list.add(new Notes(noteID, name, filesPath, filesType));
            }
            String res = in.readUTF();
            System.out.println(res);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
