package DAOs;

import Entities.Notes;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author gbrid
 */

public class ServerDAO {
    public static Connection conn = null;
    public static PreparedStatement statement;
    
    public Connection connectDB() {
        Driver myDriver = new com.microsoft.sqlserver.jdbc.SQLServerDriver();
        try {
            DriverManager.registerDriver(myDriver);
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Enote;user=sa;password=123;trustServerCertificate=true";
            conn = DriverManager.getConnection(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        if(conn != null) {
            System.out.println("ok");
        }
        return conn;
    }
    
    
    
    public static String signUp(String user, String pass) {
        String res = "";
        String sql = "";
        
        try {
            sql = "select * from USERS where USERNAME=?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, user);
            ResultSet rs = statement.executeQuery();
            
            if(rs.next()) {
                res = "user taken";
            }else {
                sql = "insert into dbo.USERS(username, pass) values(?, ?)";
                statement = conn.prepareStatement(sql);
                statement.setString(1, user);
                statement.setString(2, pass);
                statement.executeUpdate();
                res = "success";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return res;
    }
    
    public static String logIn(String user, String pass) {
        String res = "";
        String sql = "";
        
        try {
            sql = "select * from USERS where USERNAME=? and PASS=?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, user);
            statement.setString(2, pass);
            ResultSet rs = statement.executeQuery();
           
            if(rs.next()) {
                res = "success";
            }else {
                sql = "select * from USERS where USERNAME=?";
                statement = conn.prepareStatement(sql);
                statement.setString(1, user);
                rs = statement.executeQuery();
           
                if(rs.next()) {
                    res = "wrong password";
                }else {
                    res = "user not exist";
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return res;
    }
    
    public static Notes getNote(String user, int noteID) {
        Notes note = null;
        String sql = "";
        
        try {
            sql = "select * from NOTES where USERNAME=? and NOTE_ID=?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, user);
            statement.setInt(2, noteID);
            ResultSet rs = statement.executeQuery();
            
            while(rs.next()) {
                note = new Notes(rs.getInt("NOTE_ID"), user, rs.getString("FILES_PATH"), rs.getString("FILES_TYPE"));
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return note;
    }
    
    public static String saveNote(Notes note) {
        String res = "";
        String sql = "";
        
        try {
            sql = "insert into NOTES(username, files_path, files_type) values(?, ?, ?)";
            statement = conn.prepareStatement(sql);
            statement.setString(1, note.getUser());
            statement.setString(2, note.getPath());
            statement.setString(3, note.getType());
            statement.executeUpdate();
            
            res = "success";
        } catch (Exception e) {
            e.printStackTrace();
            res = "error";
        }
        
        return res;
    }
    
    public static ArrayList<Notes> getNotes(String user) {
        String sql = "";
        ArrayList<Notes> list = new ArrayList<Notes>();
        
        try {
            sql = "select * from NOTES where USERNAME=?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, user);
            ResultSet rs = statement.executeQuery();
            
            if(rs != null) {
                while(rs.next()) {
                    list.add(
                        new Notes(
                            rs.getInt("NOTE_ID"),
                            rs.getString("USERNAME"),
                            rs.getString("FILES_PATH"),
                            rs.getString("FILES_TYPE")
                        )
                    );
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list;
    }
}
