package lv.vda.vehicleregister.vehicle.model;


import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;


@Entity
@Table(name = "Vehicles")
public class VehicleEntity implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    @Column(length = 12, nullable = false)
    private String number;

    @Digits(integer = 4, fraction = 0)
    @Column(nullable = false)
    private int manufactureYear;

    @ManyToOne
    @NotBlank
    @JoinColumn(name = "vehicleModel_id")
    private VehicleModelEntity vehicleModelEntity;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getManufactureYear() {
        return manufactureYear;
    }

    public void setManufactureYear(int manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

    public VehicleModelEntity getVehicleModelEntity() {
        return vehicleModelEntity;
    }

    public void setVehicleModelEntity(VehicleModelEntity vehicleModelEntity) {
        this.vehicleModelEntity = vehicleModelEntity;
    }




}
