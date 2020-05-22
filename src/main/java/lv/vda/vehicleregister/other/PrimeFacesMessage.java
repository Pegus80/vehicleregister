package lv.vda.vehicleregister.other;


import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.nio.file.attribute.UserDefinedFileAttributeView;




public class PrimeFacesMessage {


    public static void showMessage(FacesMessage.Severity  messageType , String title,
                                   String message, String objectValue,  MessageTexType messageTexType) {
        if (messageTexType==MessageTexType.ADDTEXT) {
            messageType = FacesMessage.SEVERITY_INFO;
            title = "Info";
            message = "Vērtība '"+ objectValue +"' ir pievienota!";
        }

        if (messageTexType==MessageTexType.DELETETEXT) {
            messageType = FacesMessage.SEVERITY_INFO;
            title = "Info";
            message = "Vērtība '"+ objectValue +"' ir dzēsta!";
        }

        if (messageTexType==MessageTexType.UPDATETEXT) {
            messageType = FacesMessage.SEVERITY_INFO;
            title = "Info";
            message = "Vērtība '"+ objectValue +"' ir izmainīta!";
        }

        if (messageTexType==MessageTexType.ERRORADDTEXT) {
            messageType = FacesMessage.SEVERITY_ERROR;
            title = "Kļūda";
            message = "Pievienot objektu '"+ objectValue +"' neizdevas!";
        }

        if (messageTexType==MessageTexType.ERRORUPDATETEXT) {
            messageType = FacesMessage.SEVERITY_ERROR;
            title = "Kļūda";
            message = "Objektu '"+ objectValue +"' izmainīt neizdevas!";
        }

        if (messageTexType==MessageTexType.ERRORDELETETEXT) {
            messageType = FacesMessage.SEVERITY_ERROR;
            title = "Kļūda";
            message = "Objektu '"+ objectValue +"' dzēst neizdevas!";
        }

        if (messageTexType==MessageTexType.ERRORTEXT) {
            messageType = FacesMessage.SEVERITY_ERROR;
            title = "Kļūda";
            message = "Darbības veikt neizdevas!";
        }

        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(messageType, title, message));
    }
    
    
    public enum MessageTexType{
        ADDTEXT,
        DELETETEXT,
        UPDATETEXT,
        ERRORADDTEXT,
        ERRORDELETETEXT,
        ERRORUPDATETEXT,
        ERRORTEXT

    } 


}
