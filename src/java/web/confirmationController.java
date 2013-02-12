package web;

import domain.personne;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class confirmationController extends MultiActionController{
    
    ResourceBundleMessageSource prop;

    public ResourceBundleMessageSource getProp() {
        return prop;
    }

    public void setProp(ResourceBundleMessageSource prop) {
        this.prop = prop;
    }
    
    public ModelAndView affichage(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {

        String langue = hsr.getParameter("langue");
        logger.info(langue);
        if (langue != null) {
            if (langue.equals("fr")) {
                prop.setBasename("messagesFR");
            } else {
                prop.setBasename("messagesEN");
            }
        }
        HttpSession s=hsr.getSession(false);
        personne p=(personne) s.getAttribute("personne");
        Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("p", p);
        return new ModelAndView("confirmation", "model", myModel);

    }
    
}
