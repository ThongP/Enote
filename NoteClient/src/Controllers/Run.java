package Controllers;

import Entities.Notes;
import Views.Login;
import java.util.ArrayList;

/**
 *
 * @author gbrid
 */
public class Run {
    public static void main(String[] args) {
        ClientCtr.connectCheck();
        new Login().setVisible(true);
        
    }
}
