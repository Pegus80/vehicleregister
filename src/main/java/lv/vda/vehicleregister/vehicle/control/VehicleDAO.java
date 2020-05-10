package lv.vda.vehicleregister.vehicle.control;


import lv.vda.vehicleregister.vehicle.model.VehicleModelEntity;

import javax.ejb.Stateless;
import javax.enterprise.inject.Model;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Stateless
public class VehicleDAO {


    @PersistenceContext
    private EntityManager em;


    public List<VehicleModelEntity> selectAllVehicleModels() {
        return em.createQuery("select b from VehicleModelEntity b", VehicleModelEntity.class)
                .getResultList();
    }


    public VehicleModelEntity selectVehicleModelByID(Long id) {
        return em.find(VehicleModelEntity.class, id);
    }
}


