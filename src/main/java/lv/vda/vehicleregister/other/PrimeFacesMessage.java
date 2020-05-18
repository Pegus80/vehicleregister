package lv.vda.vehicleregister.other;


import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.nio.file.attribute.UserDefinedFileAttributeView;

public class PrimeFacesMessage {


    public static void showMessage(FacesMessage.Severity  messageType , String title, String message, MessageTexType messageTexType) {
        if (messageTexType==MessageTexType.ADDTEXT) {
            message = message + " ir pievienots!";
        }

        if (messageTexType==MessageTexType.DELETETEXT) {
            message = message + " ir dzēsts!";
        }

        if (messageTexType==MessageTexType.UPDATETEXT) {
            message = message + " ir izmainīts!";
        }

        if (messageTexType==MessageTexType.ERRORTEXT) {
            message = "Darbības veikt neizdevas!";
        }

        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(messageType, title, message));
    }
    
    
    public enum MessageTexType{
        ADDTEXT,
        DELETETEXT,
        UPDATETEXT,
        ERRORTEXT

    } 


}
