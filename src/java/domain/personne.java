package domain;

import java.util.HashMap;
import java.util.regex.Pattern;

public class personne {
    
    private String nom;
    private String prenom;
    private String cin;
    private String cb;
    private String email;
    private String tel;
    private String client = "1";
    private String login;
    private String password;

    public HashMap validate ()
    {
        HashMap <String,String> errors = new HashMap <String, String> ();
        if (nom.trim().length() == 0)
            errors.put("nomV", "nomV");
        else
            errors.put("nomV", "reussi");
        if (!Pattern.matches("[A-Za-z]*", nom.trim()))
            errors.put("nom", "nom");
        else
            errors.put("nom", "reussi");
        if (!Pattern.matches("[A-Za-z]*", prenom.trim()))
            errors.put("prenom", "prenom");
        else
            errors.put("prenom", "reussi");
        if (prenom.trim().length() == 0)
            errors.put("prenomV", "prenomV");
        else
            errors.put("prenomV", "reussi");
        if (cin.length()>8 || (cin.length()<8 && cin.length()>0) || !Pattern.matches("[0-9]*", cin))
            errors.put("cin", "cin");
        else
            errors.put("cin", "reussi");
        if (cin.length() == 0)
            errors.put("cinV", "cinV");
        else
            errors.put("cinV", "reussi");
        if (cb.length()>12 || (cb.length()<12 && cb.length()>0) || !Pattern.matches("[0-9]*", cb))
            errors.put("cb", "cb");
        else
            errors.put("cb", "reussi");
        if (cb.length() == 0)
            errors.put("cbV", "cbV");
        else
            errors.put("cbV", "reussi");
        if (!email.isEmpty() && (email.contains("[") || email.contains("&") || email.contains("$") || email.contains("#") || email.contains("{") || email.contains("}") || email.contains("+") || email.contains("(") || email.contains(")") || email.contains("]") || email.contains("%") || email.contains("<") || email.contains(">") || email.contains("'") || email.lastIndexOf(".")<email.lastIndexOf("@") || !email.contains("@") || !email.contains(".") || email.lastIndexOf("@")!=email.indexOf("@") || email.lastIndexOf(".")>=email.length()-1))
            errors.put("email", "email");
        else
            errors.put("email", "reussi");
        if (email.length() == 0)
            errors.put("emailV", "emailV");
        else
            errors.put("emailV", "reussi");
        if (tel.length()>8 || (tel.length()<8 && tel.length()>0)|| !Pattern.matches("[0-9]*", tel))
            errors.put("tel", "tel");
        else
            errors.put("tel", "reussi");
        if (tel.length() == 0)
            errors.put("telV", "telV");
        else
            errors.put("telV", "reussi");
        if (password.length() == 0)
            errors.put("passwordV", "passwordV");
        else
            errors.put("passwordV", "reussi");
        if (login.length() == 0)
            errors.put("loginV", "loginV");
        else
            errors.put("loginV", "reussi");
        if (!Pattern.matches("[A-Za-z1-9]*", login))
            errors.put("login", "login");
        else
            errors.put("login", "reussi");
        if (!Pattern.matches("[A-Za-z1-9]*", password))
            errors.put("password", "password");
        else
            errors.put("password", "reussi");
        return errors;
    }
    
    public String getCb() {
        return cb;
    }

    public void setCb(String cb) {
        this.cb = cb;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}