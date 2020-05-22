package lv.vda.vehicleregister.company.model;


import lv.vda.vehicleregister.vehicle.boundary.VehicleModelBean;
import lv.vda.vehicleregister.vehicle.model.VehicleTypeEntity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Companies")
public class CompanyEntity {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    @Column(length = 255, nullable = false)
    private String companyName;

    @NotBlank
    @Size(min = 11, max = 11, message = "Uzņēmuma reģistrācijas numura garumam jābūt 11 simboliem!")
    @Column(length = 11, nullable = false)
    private String regNrLV;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @NotNull (message = "Lauks 'Valsts' nevar būt tušs")
    @JoinColumn(name = "countryEntity_id", nullable = false)
    private CountryEntity countryEntity;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "regionEntity_id", nullable = false)
    private RegionEntity regionEntity; //Novads

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "districtEntity_id", nullable = false)
    private DistrictEntity districtEntity; //Pagasts

    @Size(max = 100)
    private String city;

    @Size(max = 100)
    private String street;

    @Size(max = 10)
    private String houseNr;

    @Size(max = 30)
    private String postcode;

    @Size(max = 100)
    private String email;

    @Size(max = 100)
    private  String phoneLV;

    @Size(max = 100)
    private  String phoneLV2;

    @Size(max = 100)
    private  String phoneNoLV;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getRegNrLV() {
        return regNrLV;
    }

    public void setRegNrLV(String regNrLV) {
        this.regNrLV = regNrLV;
    }

    public CountryEntity getCountryEntity() {
        return countryEntity;
    }

    public void setCountryEntity(CountryEntity countryEntity) {
        this.countryEntity = countryEntity;
    }

    public RegionEntity getRegionEntity() {
        return regionEntity;
    }

    public void setRegionEntity(RegionEntity regionEntity) {
        this.regionEntity = regionEntity;
    }

    public DistrictEntity getDistrictEntity() {
        return districtEntity;
    }

    public void setDistrictEntity(DistrictEntity districtEntity) {
        this.districtEntity = districtEntity;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }


    public String getHouseNr() {
        return houseNr;
    }

    public void setHouseNr(String houseNr) {
        this.houseNr = houseNr;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneLV() {
        return phoneLV;
    }

    public void setPhoneLV(String phoneLV) {
        this.phoneLV = phoneLV;
    }

    public String getPhoneLV2() {
        return phoneLV2;
    }

    public void setPhoneLV2(String phoneLV2) {
        this.phoneLV2 = phoneLV2;
    }

    public String getPhoneNoLV() {
        return phoneNoLV;
    }

    public void setPhoneNoLV(String phoneNoLV) {
        this.phoneNoLV = phoneNoLV;
    }
}

