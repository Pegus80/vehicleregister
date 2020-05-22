package lv.vda.vehicleregister.company.control;


import lv.vda.vehicleregister.company.boundary.CompanyBean;
import lv.vda.vehicleregister.company.model.CompanyEntity;
import lv.vda.vehicleregister.company.model.CountryEntity;
import lv.vda.vehicleregister.vehicle.model.VehicleCategoryEntity;
import lv.vda.vehicleregister.vehicle.model.VehicleModelEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class CompanyDAO {

    @PersistenceContext
    private EntityManager em;

    public CompanyEntity selectCompanyEntityByID(Long id) {
        return em.find(CompanyEntity.class, id);
    }

    public List<CompanyEntity> selectAllCompanies() {
        return em.createQuery("select b from CompanyEntity b", CompanyEntity.class)
                .getResultList();
    }

    public List<CountryEntity> selectAllCountries() {
        return em.createQuery("select b from CountryEntity b", CountryEntity.class)
                .getResultList();
    }





}
