package se.iths.java24.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "currency", schema = "demo")
public class Currency {
    @Id
    @Column(name = "currency_code", nullable = false)
    private String currencyCode;

    @Column(name = "currency_name", nullable = false)
    private String currencyName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "country_code", nullable = false)
    private Country countryCode;

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public Country getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(Country countryCode) {
        this.countryCode = countryCode;
    }

}
