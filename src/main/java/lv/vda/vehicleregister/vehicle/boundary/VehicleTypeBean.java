package lv.vda.vehicleregister.vehicle.boundary;

import lv.vda.vehicleregister.other.PrimeFacesMessage;
import lv.vda.vehicleregister.vehicle.control.VehicleDAO;
import lv.vda.vehicleregister.vehicle.model.VehicleCategoryEntity;
import lv.vda.vehicleregister.vehicle.model.VehicleTypeEntity;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;


@Named
@ViewScoped
public class VehicleTypeBean implements Serializable {

    @Inject
    private VehicleDAO vehicleDAO;
    @Inject
    private VehicleModelBean vehicleModelBean;

    private List<VehicleTypeEntity> vehicleTypeList ;
    private List<VehicleTypeEntity> vehicleTypeListByCategory;
    private VehicleTypeEntity newVehicleType;



    @PostConstruct
    public void init() {
        vehicleTypeList = vehicleDAO.selectAllVehicleTypes();
    }


    public VehicleTypeEntity loadVehicleTypeByID(Long id){
        return vehicleDAO.selectVehicleTypeByID(id);
    }


    public List<VehicleTypeEntity> getVehicleTypeList() {
        return vehicleTypeList;
    }

    public void setVehicleTypeList(List<VehicleTypeEntity> vehicleTypeList) {
        this.vehicleTypeList = vehicleTypeList;
    }

    public List<VehicleTypeEntity> getVehicleTypeListByCategory() {
        return vehicleTypeListByCategory;
    }

    public void loadVehicleTypeListByCategory() {
        vehicleTypeListByCategory = vehicleDAO.selectVehicleTypesByCategory(vehicleModelBean.
                getSelectedVehicleModel().
                getVehicleTypeEntity().
                getVehicleCategoryEntity());
    }


    //For ComboBox (Autocomplete)
    public List<VehicleTypeEntity> loadVehicleTypeList (String query) {
        return vehicleTypeList;
    }


    public VehicleTypeEntity getNewVehicleType() {
        if (newVehicleType == null) {
            newVehicleType = new VehicleTypeEntity();
            newVehicleType.setVehicleCategoryEntity(new VehicleCategoryEntity());
        }
        return newVehicleType;
    }

    public void setNewVehicleType(VehicleTypeEntity newVehicleType) {
        this.newVehicleType = newVehicleType;
    }

    public void addNewVehicleType() {
        try {
            vehicleDAO.createVehicleType(newVehicleType);
            PrimeFacesMessage.showMessage(null, null,
                    null, PrimeFacesMessage.MessageTexType.ADDTEXT);
        } catch (Exception e) {
            PrimeFacesMessage.showMessage(null, null,
                    null, PrimeFacesMessage.MessageTexType.ERRORTEXT);}

        newVehicleType = null;
        vehicleModelBean.reloadAllLists();
    }
}

