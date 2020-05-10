package lv.vda.vehicleregister.vehicle.boundary;


import jdk.swing.interop.SwingInterOpUtils;
import lv.vda.vehicleregister.vehicle.model.VehicleModelEntity;

import javax.enterprise.inject.Model;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

@Model
@FacesConverter("lv.vda.register.converter")
public class IDConverterBean implements Converter {

    @Inject
    private VehicleModelBean vehicleModelBean;


    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }

        return vehicleModelBean.LoadVehicleModelByID(Long.valueOf(s));
    }


    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        if (!(o instanceof VehicleModelEntity)) {
            return null;
        }

        return String.valueOf(((VehicleModelEntity) o).getId());
    }
}
