package lv.vda.vehicleregister.company.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Regions")
public class RegionEntity {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    @Column(length = 255, nullable = false)
    private String regionName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }
}
