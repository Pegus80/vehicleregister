package lv.vda.vehicleregister.vehicle.boundary;

import lv.vda.vehicleregister.other.PrimeFacesMessage;
import lv.vda.vehicleregister.vehicle.control.VehicleDAO;
import lv.vda.vehicleregister.vehicle.model.VehicleModelEntity;
import org.primefaces.event.SelectEvent;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Named
@ViewScoped
public class VehicleModelBean implements Serializable {

    @Inject
    private VehicleDAO vehicleDAO;
    private List<VehicleModelEntity> vehicleModelList ;

    private VehicleModelEntity selectedVehicleModel;


    @PostConstruct
    public void init() {
        vehicleModelList = vehicleDAO.selectAllVehicleModels();
    }


    public VehicleModelEntity getSelectedVehicleModel() {
//        selectedVehicleModel =  vehicleModelList.get(1);
        return selectedVehicleModel;
    }


    public void setSelectedVehicleModel(VehicleModelEntity selectedVehicleModel) {
   //             PrimeFacesMessage.showMessage(FacesMessage.SEVERITY_INFO, "Info:","Selected model is " + selectedVehicleModel.getModelName());
        this.selectedVehicleModel = selectedVehicleModel;
    }


    public List<VehicleModelEntity> loadVehicleModelList(String query) {
        return vehicleModelList;
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

    public void onItemSelect(SelectEvent event) {
        selectedVehicleModel = (VehicleModelEntity) event.getObject();

    }



}
