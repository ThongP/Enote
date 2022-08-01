package Controllers;

/**
 *
 * @author gbrid
 */
public class Run {
    public static void main(String[] args) {
        ClientCtr.connectCheck();
        ClientCtr.logIn("test", "test");
    }
}
