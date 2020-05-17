package lv.vda.vehicleregister.vehicle.boundary;

import lv.vda.vehicleregister.other.PrimeFacesMessage;
import lv.vda.vehicleregister.vehicle.control.VehicleDAO;
import lv.vda.vehicleregister.vehicle.model.VehicleCategoryEntity;
import lv.vda.vehicleregister.vehicle.model.VehicleModelEntity;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;


@Named
@ViewScoped
public class VehicleCategoryBean implements Serializable {

    @Inject
    private VehicleDAO vehicleDAO;
    private List<VehicleCategoryEntity> vehicleCategoryList ;


    @PostConstruct
    public void init() {
        vehicleCategoryList = vehicleDAO.selectAllVehicleCategories();
    }

    public VehicleCategoryEntity loadVehicleCategoryByID(Long id) {
        return vehicleDAO.selectVehicleCategoryByID(id);
    }

    public List<VehicleCategoryEntity> getVehicleCategoryList() {
        return vehicleCategoryList;
    }

    public void setVehicleCategoryList(List<VehicleCategoryEntity> vehicleCategoryList) {
        this.vehicleCategoryList = vehicleCategoryList;
    }



}
