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

    private List<VehicleModelEntity> vehicleModelList ;
    private List<VehicleModelEntity> vehicleModelListByType ;

    private VehicleModelEntity selectedVehicleModel;

    @PostConstruct
    public void init() {
        vehicleModelList = vehicleDAO.selectAllVehicleModels();
    }


    public VehicleModelEntity getSelectedVehicleModel() {
        if (!(selectedVehicleModel== null) )
        {System.out.println("Get: " +  selectedVehicleModel.getModelName());}

        return selectedVehicleModel;
    }


    public void setSelectedVehicleModel(VehicleModelEntity selectedVehicleModel) {
        if (!(selectedVehicleModel== null) )
        {System.out.println("Set: " +  selectedVehicleModel.getModelName());}

        this.selectedVehicleModel = selectedVehicleModel;
    }

    ////For ComboBox (Autocomplete)
//    public List<VehicleModelEntity> loadVehicleModelList (String query) {
//        return vehicleModelList;
//    }

    public List<VehicleModelEntity> getVehicleModelList() {
        return vehicleModelList;
    }

    public void setVehicleModelList(List<VehicleModelEntity> vehicleModelList) {
        this.vehicleModelList = vehicleModelList;
    }

    public VehicleModelEntity loadVehicleModelByID(Long id) {
        return vehicleDAO.selectVehicleModelByID(id);
    }

    public void deleteVehicleModel(){
        var modelName = selectedVehicleModel.getModelName();
        vehicleDAO.deleteVehicleModel(selectedVehicleModel);
        reloadAllLists();
        selectedVehicleModel = null;

        PrimeFacesMessage.showMessage(FacesMessage.SEVERITY_INFO, "Info:",
                "Modelis " +modelName+ " tika dzēsts! ");
    }



    public void save() {
        System.out.println("Save: " +  selectedVehicleModel.getModelName());


        vehicleDAO.updateVehicleModel(selectedVehicleModel);
        PrimeFacesMessage.showMessage(FacesMessage.SEVERITY_INFO, "Info:",
                "Modeļa " +selectedVehicleModel.getModelName()+ " izmaiņas ir saglabātas! ");

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
}
