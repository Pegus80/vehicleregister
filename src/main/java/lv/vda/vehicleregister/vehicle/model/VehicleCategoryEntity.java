package lv.vda.vehicleregister.vehicle.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;


@Entity
@Table(name = "VehicleCategories")
public class VehicleCategoryEntity implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    @Column(length = 100, nullable = false)
    private String categoryName;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
