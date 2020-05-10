package lv.vda.vehicleregister.other;


import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class PrimeFacesMessage {


    public static void showMessage(FacesMessage.Severity  messageType , String title, String message ) {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, title, message));
    }


}
