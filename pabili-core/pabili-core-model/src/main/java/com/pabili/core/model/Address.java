package com.pabili.core.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author mbmartinez
 */
@Embeddable
public class Address {

    @Column(name = "alias")
    private String alias;

    @Column(name = "addr_line1")
    private String addressLine1;

    @Column(name = "addr_line2")
    private String addressLine2;

    @Column(name = "addr_city")
    private String city;

    @Column(name = "addr_province")
    private String province;

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

}
