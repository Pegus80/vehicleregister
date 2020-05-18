package lv.vda.vehicleregister.vehicle.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "VehicleModels")
public class VehicleModelEntity implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    @Column(length = 100, nullable = false, unique = true)
    private String modelName;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @NotNull
    @JoinColumn(name = "vehicleType_id", nullable = false)
    private VehicleTypeEntity vehicleTypeEntity;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public VehicleTypeEntity getVehicleTypeEntity() {
        return vehicleTypeEntity;
    }

    public void setVehicleTypeEntity(VehicleTypeEntity vehicleTypeEntity) {
        this.vehicleTypeEntity = vehicleTypeEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehicleModelEntity that = (VehicleModelEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }





}
