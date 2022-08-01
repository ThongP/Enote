package Controllers;

import Entities.Notes;
import java.util.ArrayList;

/**
 *
 * @author gbrid
 */
public class Run {
    public static void main(String[] args) {
        ClientCtr.connectCheck();
        ArrayList<Notes> note = ClientCtr.getNotes("pepper");
        for(Notes temp : note) {
            System.out.println(temp.getUser());
            System.out.println(temp.getPath());
            System.out.println(temp.getType());
            System.out.println();
        }
    }
}
