package com.tpe.hb02.embeddable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

//  With @Embeddable, a table for Address won't be created, but fields in the Address class will be added to
// the Student02 table as columns
@Embeddable
public class Address {

    @Column
    private String street;
    @Column
    private String city;
    @Column
    private String country;
    @Column
    private String zipCode;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
