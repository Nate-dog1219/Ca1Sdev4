package models;

import io.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Address extends Model {

    @Id
    private String id;
    private String line1 , line2, city, county, country;

    public Address() {
    }

    public Address(String id,String line1, String line2, String city, String county, String country) {
        this.id = id;
        this.line1 = line1;
        this.line2 = line2;
        this.city = city;
        this.county = county;
        this.country = country;
    }

    public String getId(){
        return id;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
