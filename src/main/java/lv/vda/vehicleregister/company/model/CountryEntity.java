package lv.vda.vehicleregister.company.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;


@Entity
@Table(name = "Countries")
public class CountryEntity {


    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    @Column(length = 255, nullable = false)
    private String countryName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

}






