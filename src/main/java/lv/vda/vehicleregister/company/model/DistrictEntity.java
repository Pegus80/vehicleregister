package lv.vda.vehicleregister.company.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Districts")

public class DistrictEntity {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    @Column(length = 255, nullable = false)
    private String districtName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }
}
