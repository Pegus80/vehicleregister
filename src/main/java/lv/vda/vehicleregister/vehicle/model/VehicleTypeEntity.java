package lv.vda.vehicleregister.vehicle.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "VehicleTypes")
public class VehicleTypeEntity implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    @Column(length = 100, nullable = false)
    private String typeName;

    @ManyToOne
    @NotBlank
    @JoinColumn(name = "vehicleCategory_id")
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
}
