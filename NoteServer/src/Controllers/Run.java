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
        Notes note = new Notes("pepper", "test.txt", "note");
        dao.saveNote(note);
        //System.out.println("");
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
