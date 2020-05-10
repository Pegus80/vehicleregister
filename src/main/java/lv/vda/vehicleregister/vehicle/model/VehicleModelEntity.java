package lv.vda.vehicleregister.vehicle.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "VehicleModels")
public class VehicleModelEntity implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    @Column(length = 100, nullable = false)
    private String modelName;

    @ManyToOne
    @NotBlank
    @JoinColumn(name = "vehicleType_id")
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





}
