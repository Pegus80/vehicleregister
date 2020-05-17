package lv.vda.vehicleregister.vehicle.control;


import lv.vda.vehicleregister.vehicle.model.VehicleCategoryEntity;
import lv.vda.vehicleregister.vehicle.model.VehicleModelEntity;
import lv.vda.vehicleregister.vehicle.model.VehicleTypeEntity;

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



    public List<VehicleTypeEntity> selectAllVehicleTypes() {
        return em.createQuery("select b from VehicleTypeEntity b", VehicleTypeEntity.class)
                .getResultList();

    }

    public List<VehicleCategoryEntity> selectAllVehicleCategories() {
        return em.createQuery("select b from VehicleCategoryEntity b", VehicleCategoryEntity.class)
                .getResultList();

    }



    public List<VehicleModelEntity> selectVehicleModelsByType(VehicleTypeEntity vehicleTypeEntity) {
        return em.createQuery("select b from VehicleModelEntity b where " +
                "b.vehicleTypeEntity = :vehicleTypeEntity", VehicleModelEntity.class)
                .setParameter("vehicleTypeEntity", vehicleTypeEntity )
                .getResultList();

    }


    public List<VehicleTypeEntity> selectVehicleTypesByCategory(VehicleCategoryEntity vehicleCategoryEntity) {
        return em.createQuery("select b from VehicleTypeEntity b where " +
                "b.vehicleCategoryEntity = :vehicleCategoryEntity", VehicleTypeEntity.class)
                .setParameter("vehicleCategoryEntity", vehicleCategoryEntity )
                .getResultList();

    }


    public VehicleModelEntity selectVehicleModelByID(Long id) {
        return em.find(VehicleModelEntity.class, id);
    }

    public VehicleTypeEntity selectVehicleTypeByID(Long id) {
        return em.find(VehicleTypeEntity.class, id);
    }

    public VehicleCategoryEntity selectVehicleCategoryByID(Long id) {
        return em.find(VehicleCategoryEntity.class, id);
    }



    public void updateVehicleModel(VehicleModelEntity vehicleModelEntity) {
        em.merge(vehicleModelEntity);
    }

    public void deleteVehicleModel(VehicleModelEntity vehicleModelEntity) {
        em.remove(em.merge(vehicleModelEntity));
    }

    public void deleteVehicleType(VehicleTypeEntity vehicleTypeEntity) {
        em.remove(em.merge(vehicleTypeEntity));
    }

    public void deleteVehicleCategory(VehicleCategoryEntity vehicleCategoryEntity) {
        em.remove(em.merge(vehicleCategoryEntity));
    }


}


