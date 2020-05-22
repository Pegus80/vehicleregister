package lv.vda.vehicleregister.vehicle.boundary;

import lv.vda.vehicleregister.other.PrimeFacesMessage;
import lv.vda.vehicleregister.vehicle.control.VehicleDAO;
import lv.vda.vehicleregister.vehicle.model.VehicleModelEntity;
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
public class VehicleModelBean implements Serializable {

    @Inject
    private VehicleDAO vehicleDAO;
    @Inject
    private VehicleTypeBean vehicleTypeBean;
    @Inject
    private VehicleCategoryBean vehicleCategoryBean;

    private List<VehicleModelEntity> vehicleModelList;
    private List<VehicleModelEntity> vehicleModelListByType;

    private VehicleModelEntity selectedVehicleModel;

    private VehicleModelEntity newVehicleModel;

    @PostConstruct
    public void init() {
        vehicleModelList = vehicleDAO.selectAllVehicleModels();
    }

    public VehicleModelEntity getSelectedVehicleModel() {
        return selectedVehicleModel;
    }


    public void setSelectedVehicleModel(VehicleModelEntity selectedVehicleModel) {
        this.selectedVehicleModel = selectedVehicleModel;
    }


    public List<VehicleModelEntity> getVehicleModelList() {
        return vehicleModelList;
    }

    public void setVehicleModelList(List<VehicleModelEntity> vehicleModelList) {
        this.vehicleModelList = vehicleModelList;
    }

    public VehicleModelEntity loadVehicleModelByID(Long id) {
        return vehicleDAO.selectVehicleModelByID(id);
    }


    public void reloadSelectedVehicleModel() {
        selectedVehicleModel = vehicleDAO.selectVehicleModelByID(selectedVehicleModel.getId());
    }

    public void deleteVehicleModel() {
        var modelName = selectedVehicleModel.getModelName();

        try {
            vehicleDAO.deleteVehicleModel(selectedVehicleModel);
            PrimeFacesMessage.showMessage(null, null,
                    null, PrimeFacesMessage.MessageTexType.DELETETEXT);
        } catch (Exception e) {
            PrimeFacesMessage.showMessage(null, null,
                    null, PrimeFacesMessage.MessageTexType.ERRORTEXT);
        }

        selectedVehicleModel = null;
        reloadAllLists();

    }


    public void saveVehicleModelChanges() {
        try {
            vehicleDAO.updateVehicleModel(selectedVehicleModel);
            PrimeFacesMessage.showMessage(null, null,
                    null, PrimeFacesMessage.MessageTexType.UPDATETEXT);

        } catch (Exception e) {
            PrimeFacesMessage.showMessage(null, null,
                    null, PrimeFacesMessage.MessageTexType.ERRORTEXT);}

        reloadAllLists();
    }

    public void addNewVehicleModel() {
        try {
            vehicleDAO.createVehicleModel(newVehicleModel);
            selectedVehicleModel = newVehicleModel;
            PrimeFacesMessage.showMessage(null, null,
                    null, PrimeFacesMessage.MessageTexType.ADDTEXT);
        } catch (Exception e) {
            PrimeFacesMessage.showMessage(null, null,
                    null, PrimeFacesMessage.MessageTexType.ERRORTEXT);}


        newVehicleModel=null;
        reloadAllLists();
    }



    public void reloadAllLists() {
        init();
        vehicleTypeBean.init();
        vehicleCategoryBean.init();

    }

    public void loadVehicleModelListByType() {
        vehicleModelListByType = vehicleDAO.selectVehicleModelsByType(selectedVehicleModel.getVehicleTypeEntity());
    }

    public List<VehicleModelEntity> getVehicleModelListByType() {
        return vehicleModelListByType;
    }


    public VehicleModelEntity getNewVehicleModel() {
        if (newVehicleModel == null) {
            newVehicleModel = new VehicleModelEntity();
            newVehicleModel.setVehicleTypeEntity(new VehicleTypeEntity());
        }

        return newVehicleModel;
    }

    public void setNewVehicleModel(VehicleModelEntity newVehicleModel) {
        this.newVehicleModel = newVehicleModel;
    }
}
