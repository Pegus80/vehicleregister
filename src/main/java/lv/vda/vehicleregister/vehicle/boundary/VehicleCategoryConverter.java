package lv.vda.vehicleregister.vehicle.boundary;

import lv.vda.vehicleregister.vehicle.model.VehicleCategoryEntity;
import lv.vda.vehicleregister.vehicle.model.VehicleModelEntity;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

@FacesConverter("lv.vda.register.categoryConverter")
public class VehicleCategoryConverter implements Converter {

    @Inject
    private VehicleCategoryBean vehicleCategoryBean;


    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }
        return vehicleCategoryBean.loadVehicleCategoryByID(Long.valueOf(s));
    }


    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        if (!(o instanceof VehicleCategoryEntity)) {
            return null;
        }

        return String.valueOf(((VehicleCategoryEntity) o).getId());
    }
}
