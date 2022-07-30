package Controllers;

import DAOs.ServerDAO;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

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
//                String filename;
//                File file;
//                byte[] bytes;
//                int noteId;
//                String absPath = "D:\\MMT\\file\\";
//
//                String url = "jdbc:sqlserver://localhost:1433;databaseName=Enote;user=sa;password=1;trustServerCertificate=true";
//                Connection conn = connectDB(url);
                dao = new ServerDAO();
                dao.connectDB();
                switch (flag) {
                    case "Login":
                        user = in.readUTF();
                        pass = in.readUTF();
                        
                        out.writeUTF(dao.logIn(user,pass));

                        break;
//
//
                    case "Signup":
                        user = in.readUTF();
                        pass = in.readUTF();
                        
                        out.writeUTF(dao.signUp(user,pass));

                        break;
//
//                    case "getNote":
//                        username = dis.readUTF();
//                        noteId = dis.readInt();
//                        Enote note = DB.getEnote(username, noteId);
//                        file = new File(note.getFilePath());
//                        bytes = Files.readAllBytes(file.toPath());
//                        dos.writeInt(bytes.length);
//                        dos.write(bytes);
//                        dos.writeUTF(note.getFilePath());
//
//                        dos.writeUTF("success");
//                        break;
//
//                    case "getNoteList":
//                        username = dis.readUTF();
//                        ArrayList<Enote> list = getEnoteList(username);
//                        ListIterator<Enote> iterate = list.listIterator();
//
//                        dos.writeInt(list.size());
//
//                        while(iterate.hasNext()){
//                            Enote temp = iterate.next();
//                            dos.writeUTF(temp.getUsername());
//                            dos.writeInt(temp.getId());
//                            dos.writeUTF(temp.getFilePath());
//                            dos.writeUTF(temp.getFileType());
//                        }
//
//
//                        //dos.writeUTF("success");
//                        break;
//                    case "saveNote":
//                        username = dis.readUTF();
//                        filename = dis.readUTF();
//                        bytes = null;
//                        int length = dis.readInt();
//                        if(length > 0) {
//                            bytes = new byte[length];
//                            dis.readFully(bytes);
//                        }
//
//                        FileUtils.writeByteArrayToFile(new File(absPath+filename), bytes);
//
//
//                        saveEnote(new Enote(username,absPath+filename,filename.substring(filename.indexOf(".")+1).trim()));
//
//                        dos.writeUTF("success");
//                        break;
//
                }
            }
        } catch (IOException e) {
            System.err.println("Request Processing Error: " + e);
        }
        System.out.println("Complete processing: " + mySocket);
    }
    
}
