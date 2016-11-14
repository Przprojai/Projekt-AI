package JCP;

import Entity.Lokator;
import JCP.util.JsfUtil;
import JCP.util.JsfUtil.PersistAction;
import SBP.LokatorFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import szyfrowanie.CryptWithSHA256;

@Named("lokatorController")
@SessionScoped
public class LokatorController implements Serializable {

    @EJB
    private SBP.LokatorFacade ejbFacade;
    private List<Lokator> items = null;
    private Lokator selected;
    private boolean zalogowany = false;

    public LokatorController() {
    }

    public Lokator getSelected() {
        return selected;
    }

    public void setSelected(Lokator selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private LokatorFacade getFacade() {
        return ejbFacade;
    }

    public Lokator prepareCreate() {
        selected = new Lokator();
        initializeEmbeddableKey();
        return selected;
    }

    public void create(String haslo) {
        if (selected.getLogin().length() < 6) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login musi zawierać conajmniej 6 znaków", "Login musi zawierać conajmniej 6 znaków"));
        } else if (selected.getLogin().length() < 6) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login musi zawierać conajmniej 6 znaków", "Login musi zawierać conajmniej 6 znaków"));
        } else if (getFacade().sprawdzLogin(selected.getLogin())) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login zajęty", "Login musi zawierać conajmniej 6 znaków"));
        } else if (!selected.getHaslo().equals(haslo)) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Hasła muszą się zgadzać", "Login musi zawierać conajmniej 6 znaków"));
        } else {
            selected.setAktywne(false);
            selected.setHaslo(CryptWithSHA256.sha256(selected.getHaslo()));
            selected.setId(getFacade().id());
            persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("LokatorCreated"));
            if (!JsfUtil.isValidationFailed()) {
                items = null;    // Invalidate list of items to trigger re-query.
            }
        }
    }
    
    public String logowanie(String login, String haslo) {
        if (getFacade().login(login, haslo)!=null) {
            selected=getFacade().login(login, haslo);
            zalogowany = true;
            return "/lokator/zalogowany_lokator.xhtml";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Błędny login lub hasło", "Błędny login lub hasło"));
           selected=getFacade().login(login, haslo);
     return "Login.xhtml";
        }
    }
    public Lokator przekaz(){
        return selected;
    }

    public void create2() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("LokatorCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }


    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("LokatorUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("LokatorDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Lokator> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Lokator getLokator(java.lang.Short id) {
        return getFacade().find(id);
    }

    public List<Lokator> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Lokator> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Lokator.class)
    public static class LokatorControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            LokatorController controller = (LokatorController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "lokatorController");
            return controller.getLokator(getKey(value));
        }

        java.lang.Short getKey(String value) {
            java.lang.Short key;
            key = Short.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Short value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Lokator) {
                Lokator o = (Lokator) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Lokator.class.getName()});
                return null;
            }
        }

    }

}
