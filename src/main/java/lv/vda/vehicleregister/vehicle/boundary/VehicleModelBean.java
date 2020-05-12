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
        return selectedVehicleModel;
    }


    public void setSelectedVehicleModel(VehicleModelEntity selectedVehicleModel) {
        this.selectedVehicleModel = selectedVehicleModel;
    }

    public List<VehicleModelEntity> getVehicleModelList(String query) {
        return vehicleModelList;
    }


    public VehicleModelEntity LoadVehicleModelByID (Long id) {
        return vehicleDAO.selectVehicleModelByID(id);
    }

    public void onItemSelect(SelectEvent event) {
        var selectedVehicleModel = (VehicleModelEntity) event.getObject();
        PrimeFacesMessage.showMessage(FacesMessage.SEVERITY_INFO, "Info:","Selected model is " + selectedVehicleModel.getModelName());
    }



}
