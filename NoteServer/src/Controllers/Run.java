package Controllers;

import DAOs.ServerDAO;

/**
 *
 * @author gbrid
 */
public class Run {
    public static void main(String[] args) {
        ServerDAO dao = new ServerDAO();
        dao.connectDB();
        System.out.println(dao.signUp("test","test"));
    }
}
