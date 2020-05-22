package lv.vda.vehicleregister.company.boundary;

import lv.vda.vehicleregister.company.model.CompanyEntity;
import lv.vda.vehicleregister.company.model.CountryEntity;
import lv.vda.vehicleregister.vehicle.boundary.VehicleCategoryBean;
import lv.vda.vehicleregister.vehicle.model.VehicleCategoryEntity;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

@FacesConverter("lv.vda.register.countryConverter")
public class CountryConverter implements Converter {

    @Inject
    private CompanyBean companyBean;


    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }
        return companyBean.loadCountryByID(Long.valueOf(s));
    }


    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        if (!(o instanceof CountryEntity)) {
            return null;
        }

        return String.valueOf(((CountryEntity) o).getId());
    }
}
