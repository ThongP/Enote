package Controllers;

import DAOs.ServerDAO;
import Entities.Notes;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.file.Files;
import java.util.ArrayList;

/**
 *
 * @author gbrid
 */
public class ConnectedThread extends Thread {
    private Socket mySocket;
    private ServerDAO dao;

    public static DataInputStream in = null;
    public static DataOutputStream out = null;

    public ConnectedThread(Socket mySocket) {
        this.mySocket = mySocket;
    }
    
    public void run() {
        System.out.println("Processing: " + mySocket);
        try {
            in = new DataInputStream(mySocket.getInputStream());
            out = new DataOutputStream(mySocket.getOutputStream());

            while (!mySocket.isClosed()) {
                String flag = in.readUTF();
                String user;
                String pass;
                String filename;
                File file;
                byte[] bytes;
                int noteID;
                String absPath = "C:\\Notes\\files\\";
                dao = new ServerDAO();
                dao.connectDB();
                switch (flag) {
                    case "Login":
                        user = in.readUTF();
                        pass = in.readUTF();
                        
                        out.writeUTF(dao.logIn(user,pass));

                        break;
//
                    case "Signup":
                        user = in.readUTF();
                        pass = in.readUTF();
                        
                        out.writeUTF(dao.signUp(user,pass));

                        break;
//
                    case "Getnote":
                        user = in.readUTF();
                        noteID = in.readInt();
                        Notes note = dao.getNote(user, noteID);
                        file = new File(absPath + note.getPath());
                        bytes = Files.readAllBytes(file.toPath());
                        out.writeInt(bytes.length);
                        out.write(bytes);
                        out.writeUTF(note.getPath());

                        out.writeUTF("success");
                        break;
//
                    case "Savenote":
                        user = in.readUTF();
                        filename = in.readUTF();
                        bytes = null;
                        int length = in.readInt();
                        if(length > 0) {
                            bytes = new byte[length];
                            in.readFully(bytes);
                        }

                        try (FileOutputStream fos = new FileOutputStream(absPath+filename)){
                            fos.write(bytes);
                            fos.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        dao.saveNote(new Notes(user, user+"\\"+filename, filename.substring(filename.indexOf(".")+1).trim()));

                        out.writeUTF("success");
                        break;
//                        
                    case "Getnotes":
                        user = in.readUTF();
                        ArrayList<Notes> list = dao.getNotes(user);

                        out.writeInt(list.size());

                        for(Notes temp : list){
                            out.writeUTF(temp.getUser());
                            out.writeInt(temp.getId());
                            out.writeUTF(temp.getPath());
                            out.writeUTF(temp.getType());
                        }

                        out.writeUTF("success");
                        break;
                }
            }
        } catch (IOException e) {
            System.err.println("Request Processing Error: " + e);
        }
        System.out.println("Complete processing: " + mySocket);
    }
    
}
