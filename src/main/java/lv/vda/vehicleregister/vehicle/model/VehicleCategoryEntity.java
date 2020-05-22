package lv.vda.vehicleregister.vehicle.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Objects;


@Entity
@Table(name = "VehicleCategories")
public class VehicleCategoryEntity implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "Ritekļa kategorija nevar būt tuša!")
    @Column(length = 100, nullable = false, unique = true)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehicleCategoryEntity that = (VehicleCategoryEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
