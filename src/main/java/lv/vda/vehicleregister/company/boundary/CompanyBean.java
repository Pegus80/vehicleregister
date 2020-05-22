package lv.vda.vehicleregister.company.boundary;

import lv.vda.vehicleregister.company.control.CompanyDAO;
import lv.vda.vehicleregister.company.model.CompanyEntity;
import lv.vda.vehicleregister.company.model.CountryEntity;
import lv.vda.vehicleregister.vehicle.control.VehicleDAO;
import lv.vda.vehicleregister.vehicle.model.VehicleCategoryEntity;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;


@Named
@ViewScoped
public class CompanyBean  implements Serializable {

    @Inject
    private CompanyDAO companyDAO;

    private CompanyEntity companyEntity;
    private List<CountryEntity> countryEntityList ;


    @PostConstruct
    public void init() {
        countryEntityList = companyDAO.selectAllCountries();
    }


    public CompanyEntity getCompanyEntity() {
        return companyEntity;
    }

    public void setCompanyEntity(CompanyEntity companyEntity) {
        this.companyEntity = companyEntity;
    }

    public CompanyEntity loadCountryByID(Long id) {
        return companyDAO.selectCompanyEntityByID(id);
    }

    public List<CountryEntity> getCountryEntityList() {
        return countryEntityList;
    }

    //For ComboBox (Autocomplete)
    public List<CountryEntity> loadCountryEntityList (String query) {
        return countryEntityList;
    }
}
