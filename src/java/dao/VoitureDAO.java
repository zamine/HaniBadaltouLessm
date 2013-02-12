package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import domain.personne;
import domain.Voiture;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.validation.Errors;

public class VoitureDAO implements IVoitureDAO{
    
    private DB_Connection bd;

    public DB_Connection getBd() {
        return bd;
    }

    public void setBd(DB_Connection bd) {
        this.bd = bd;
    }
}