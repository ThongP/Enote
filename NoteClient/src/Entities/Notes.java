package Entities;

/**
 *
 * @author gbrid
 */
public class Notes {
    int id;
    String user;
    String path;
    String type;
    byte[] buffer;
    
    public Notes(int id, String user, String path, String type) {
        this.id = id;
        this.user = user;
        this.path = path;
        this.type = type;
    }

    public Notes(String path, byte[] buffer) {
        this.path = path;
        this.buffer = buffer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getBuffer() {
        return buffer;
    }

    public void setBuffer(byte[] buffer) {
        this.buffer = buffer;
    }
}
