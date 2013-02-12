package domain;

import java.util.Hashtable;
import java.util.regex.Pattern;

public class Voiture {
    
    private String matricule;
    private String couleur;
    private String modele;
    private String dispo;

    public Hashtable validate ()
    {
        Hashtable <String,String> errors = new Hashtable <String, String> ();
        if (matricule.length() == 0)
            errors.put("matricule", "vide");
        if (!Pattern.matches("[A-Za-z1-9]*", matricule))
            errors.put("matricule", "invalide");
        if (couleur.length() == 0)
            errors.put("couleur", "vide");
        if (!Pattern.matches("[A-Za-z]*", couleur))
            errors.put("couleur", "invalide");
        if (modele.length() == 0)
            errors.put("modele", "vide");
        if (!Pattern.matches("[A-Za-z]*", modele))
            errors.put("modele", "invalide");
        if (dispo.length() == 0)
            errors.put("dispo", "vide");
        if (!Pattern.matches("[1-9]*", dispo))
            errors.put("dispo", "invalide");
        return errors;
    }
        
    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getDispo() {
        return dispo;
    }

    public void setDispo(String dispo) {
        this.dispo = dispo;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }
}