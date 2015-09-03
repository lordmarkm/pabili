package com.pabili.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.pabili.core.model.base.BaseNamedEntity;

/**
 * @author Mark Martinez, created Sep 3, 2015
 */
@Entity(name = "location")
public class Location extends BaseNamedEntity {

    @Column(name = "lat")
    private long latitude = 0l;

    @Column(name = "long")
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
