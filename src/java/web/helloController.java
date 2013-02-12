package web;

import dao.IPersonneDAO;
import dao.PersonneDAO;
import domain.personne;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import org.springframework.web.servlet.view.RedirectView;

public class helloController extends MultiActionController {

    ResourceBundleMessageSource prop;

    public ResourceBundleMessageSource getProp() {
        return prop;
    }

    public void setProp(ResourceBundleMessageSource prop) {
        this.prop = prop;
    }

    public ModelAndView affichage(HttpServletRequest req, HttpServletResponse res) throws Exception {

        String langue = req.getParameter("langue");
        logger.info(langue);
        if (langue != null) {
            if (langue.equals("fr")) {
                prop.setBasename("messagesFR");
            } else {
                prop.setBasename("messagesEN");
            }
        }
        Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("nomV","reussi");
        myModel.put("nom","reussi");
        myModel.put("prenomV","reussi");
        myModel.put("prenom","reussi");
        myModel.put("cinV","reussi");
        myModel.put("cin","reussi");
        myModel.put("cbV","reussi");
        myModel.put("cb","reussi");
        myModel.put("email","reussi");
        myModel.put("emailV","reussi");
        myModel.put("loginV","reussi");
        myModel.put("login","reussi");
        myModel.put("passwordV","reussi");
        myModel.put("password","reussi");
        myModel.put("telV","reussi");
        myModel.put("tel","reussi");
        return new ModelAndView("hello", "mymodel", myModel);
    }

    public ModelAndView inscription(HttpServletRequest req, HttpServletResponse res) throws Exception {

        personne p = new personne();
        p.setNom(req.getParameter("nom"));
        p.setPrenom(req.getParameter("prenom"));
        p.setCin(req.getParameter("cin"));
        p.setCb(req.getParameter("cb"));
        p.setEmail(req.getParameter("email"));
        p.setTel(req.getParameter("tel"));
        p.setLogin(req.getParameter("login"));
        p.setPassword(req.getParameter("password"));

        IPersonneDAO pdao = new PersonneDAO();
        boolean test = false;

        HashMap h = p.validate();

        try {
            test = pdao.Verif(p.getLogin());
        } catch (SQLException ex) {
            logger.info(ex);
        }
        if (test) {
            h.put("login", "Le login que vous avez choisi existe déjà! Veuillez saisir un autre!");
        }
        if (h.isEmpty()) {
            try {
                pdao.inscrire(p);
            } catch (SQLException ex) {
                System.out.println(ex);
            }
            logger.info("SUCCES : inscription");
            Map model = new HashMap<String, Object>();
            return new ModelAndView("hello", "mymodel", model);
        } else {
            logger.info("ECHEC : inscription");
            Map model = new HashMap<String, Object>();
            model.putAll(h);
            return new ModelAndView("hello", "mymodel", model);
        }
    }

    public ModelAndView login(HttpServletRequest req, HttpServletResponse res) throws Exception {

        String log = req.getParameter("login");
        String pass = req.getParameter("password");
        Map model = new HashMap<String, Object>();
        if (log.isEmpty() || pass.isEmpty()) {
            if (log.isEmpty()) {
                model.put("Clogin", "Veuillez saisir votre login!");
            }
            if (pass.isEmpty()) {
                model.put("Cpass", "Veuillez saisir votre mot de passe!");
            }
            return new ModelAndView("hello", "model", model);
        }
        PersonneDAO pdao = new PersonneDAO();
        personne p = new personne();
        p = pdao.authentifier(log, pass);
        if (p == null) {
            model.put("error", "Le login ou le mot de passe est invalide! Veuillez vérifier !");
            return new ModelAndView("hello", "model", model);
        } else {
            HttpSession s = req.getSession(true);
            s.setAttribute("personne", p);
            return new ModelAndView(new RedirectView("confirmation.htm"));
        }
    }
}