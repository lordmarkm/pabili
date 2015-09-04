package com.pabili.commons.dto.location;

import org.springframework.core.style.ToStringCreator;

/**
 * @author Mark Martinez, created Sep 3, 2015
 */
public class LocationInfo {

    private String name;
    private long latitude;
    private long longitude;

    @Override
    public String toString() {
        return new ToStringCreator(this)
            .append("name", name)
            .append("lat", latitude)
            .append("long", longitude)
            .toString();
    }

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
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
