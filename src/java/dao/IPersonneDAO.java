package dao;
import java.util.List;
import domain.personne;
import java.sql.SQLException;

public interface IPersonneDAO {
    
    public abstract boolean inscrire(personne p)throws SQLException;
    public abstract personne authentifier(String login,String password)throws SQLException;
    public boolean Verif (String motClef) throws SQLException;
}