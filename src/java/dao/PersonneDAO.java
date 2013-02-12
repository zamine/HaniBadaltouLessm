package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import domain.personne;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.validation.Errors;

public class PersonneDAO implements IPersonneDAO {

    protected final Log logger = LogFactory.getLog(getClass());
    private DB_Connection bd = null;

    public DB_Connection getBd() {
        return bd;
    }

    public void setBd(DB_Connection bd) {
        this.bd = bd;
    }

    @Override
    public boolean inscrire(personne p) throws SQLException {
        HashMap h = p.validate();
        if (h.isEmpty()) {
            try {
                bd = new DB_Connection();
                PreparedStatement ps = bd.GetConection().prepareStatement("INSERT INTO ROOT.PERSONNES (\"NOM\", \"PRENOM\", \"CIN\", \"CB\", \"EMAIL\", \"TEL\", \"LOGIN\", \"PASSWORD\", \"id\", \"client\") values (" + p.getNom() + "," + p.getPrenom() + "," + p.getCin() + "," + p.getCb() + "," + p.getEmail() + "," + p.getTel() + "," + p.getLogin() + "," + p.getPassword() + "," + p.getClient() + ")");
                ps.executeUpdate();
                logger.info("SUCCES : Personne inscrite");
                return true;
            } catch (Exception e) {
                logger.info(e);
            }
        }
        return false;
    }
    
    @Override
    public boolean Verif (String login) throws SQLException
    {
        bd = new DB_Connection();
        PreparedStatement ps = bd.GetConection().prepareStatement("select * from ROOT.PERSONNES where PERSONNES.\"LOGIN\"='" + login + "'");
        ResultSet rs = ps.executeQuery();
        if (rs.next())
        {
            return true;
        }
        else
            return false;
    }
    
    @Override
    public personne authentifier(String login, String password) throws SQLException {
        bd = new DB_Connection();
        PreparedStatement ps = bd.GetConection().prepareStatement("select * from ROOT.\"PERSONNES\" where (LOGIN=" + login + " and PASSWORD=" + password + ")");
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            personne p = new personne();
            p.setCin(rs.getString("CIN"));
            p.setCb(rs.getString("CB"));
            p.setClient(rs.getString("CLIENT"));
            p.setEmail(rs.getString("EMAIL"));
            p.setLogin(rs.getString("LOGIN"));
            p.setNom(rs.getString("NOM"));
            p.setPassword(rs.getString("PASSWORD"));
            p.setTel(rs.getString("TEL"));
            p.setPrenom(rs.getString("PRENOM"));
            return p;
        } else {
            return null;
        }
    }
}