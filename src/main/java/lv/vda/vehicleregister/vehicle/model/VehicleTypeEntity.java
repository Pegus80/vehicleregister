package lv.vda.vehicleregister.vehicle.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "VehicleTypes")
public class VehicleTypeEntity implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    @Column(length = 100, nullable = false, unique = true)
    private String typeName;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @NotNull
    @JoinColumn(name = "vehicleCategory_id", nullable = false)
    private VehicleCategoryEntity vehicleCategoryEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }


    public VehicleCategoryEntity getVehicleCategoryEntity() {
        return vehicleCategoryEntity;
    }

    public void setVehicleCategoryEntity(VehicleCategoryEntity vehicleCategoryEntity) {
        this.vehicleCategoryEntity = vehicleCategoryEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehicleTypeEntity that = (VehicleTypeEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
