package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DB_Connection {

    private Connection c;
    private Statement stmt;
    private ResultSet rs;
    private String driver = "org.apache.derby.jdbc.ClientDriver";
    private String url = "jdbc:derby://localhost:1527/AgenceDeLocation";
    private String login = "root";
    private String pass = "root";

    public DB_Connection() 
    {
        try 
        {
            Class.forName(driver);
            c = DriverManager.getConnection(url, login, pass);
            stmt = c.createStatement();
        } 
        catch (ClassNotFoundException ex) {} 
        catch (SQLException ex) {System.out.println("1  " + ex.toString());}
    }
    
    public Connection GetConection() {
        return c;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}