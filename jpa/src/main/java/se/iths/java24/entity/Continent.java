package se.iths.java24.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "continent", schema = "demo")
public class Continent {
    @Id
    @Column(name = "continent_code", nullable = false)
    private String continentCode;

    @Column(name = "continent_name")
    private String continentName;

    public String getContinentCode() {
        return continentCode;
    }

    public void setContinentCode(String continentCode) {
        this.continentCode = continentCode;
    }

    public String getContinentName() {
        return continentName;
    }

    public void setContinentName(String continentName) {
        this.continentName = continentName;
    }

}
