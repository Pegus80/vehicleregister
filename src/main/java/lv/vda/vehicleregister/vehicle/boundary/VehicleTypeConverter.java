package lv.vda.vehicleregister.vehicle.boundary;

import lv.vda.vehicleregister.vehicle.model.VehicleModelEntity;
import lv.vda.vehicleregister.vehicle.model.VehicleTypeEntity;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

@FacesConverter("lv.vda.register.typeConverter")
public class VehicleTypeConverter implements Converter {

    @Inject
    private VehicleTypeBean vehicleTypeBean;


    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }
        return vehicleTypeBean.loadVehicleTypeByID(Long.valueOf(s));
    }


    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        if (!(o instanceof VehicleTypeEntity)) {
            return null;
        }

        return String.valueOf(((VehicleTypeEntity) o).getId());
    }
}
