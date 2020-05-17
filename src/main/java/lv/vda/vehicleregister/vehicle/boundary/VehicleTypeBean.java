package lv.vda.vehicleregister.vehicle.boundary;

import lv.vda.vehicleregister.other.PrimeFacesMessage;
import lv.vda.vehicleregister.vehicle.control.VehicleDAO;
import lv.vda.vehicleregister.vehicle.model.VehicleCategoryEntity;
import lv.vda.vehicleregister.vehicle.model.VehicleModelEntity;
import lv.vda.vehicleregister.vehicle.model.VehicleTypeEntity;
import org.primefaces.event.SelectEvent;

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
        vehicleTypeListByCategory = vehicleDAO.selectVehicleTypesByCategory(vehicleModelBean.getSelectedVehicleModel()
                        .getVehicleTypeEntity()
                        .getVehicleCategoryEntity());
    }
}

