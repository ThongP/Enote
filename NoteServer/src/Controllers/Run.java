package Controllers;

import DAOs.ServerDAO;
import Entities.Notes;
import java.util.ArrayList;

/**
 *
 * @author gbrid
 */
public class Run {
    public static void main(String[] args) {
        ServerDAO dao = new ServerDAO();
        dao.connectDB();
        Notes note = dao.getNote("pepper", 1);
        System.out.println(note.getUser());
        System.out.println(note.getPath());
        System.out.println(note.getType());
//        ArrayList<Notes> note = dao.getNotes("pepper");
//        for(Notes temp : note){
//            System.out.println(temp.getUser());
//            System.out.println(temp.getId());
//            System.out.println(temp.getPath());
//            System.out.println(temp.getType());
//            System.out.println();
//        }
//        System.out.println(note);
    }
}
