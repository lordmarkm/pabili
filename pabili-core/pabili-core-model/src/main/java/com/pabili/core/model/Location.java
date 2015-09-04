package com.pabili.core.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;

import com.pabili.core.model.base.BaseNamedEntity;

/**
 * @author Mark Martinez, created Sep 3, 2015
 */
@Entity(name = "location")
//Make name unique
@AttributeOverride(name = "name", column = @Column(name = "name", unique = true, nullable = false))
public class Location extends BaseNamedEntity {

    @Column(name = "latitude")
    private long latitude = 0l;

    @Column(name = "longitude")
    private long longitude = 0l;

    public long getLatitude() {
        return latitude;
    }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }

    public long getLongitude() {
        return longitude;
    }

    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }

}
