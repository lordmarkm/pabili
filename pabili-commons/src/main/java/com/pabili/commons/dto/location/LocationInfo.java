package com.pabili.commons.dto.location;

import org.springframework.core.style.ToStringCreator;

/**
 * @author Mark Martinez, created Sep 3, 2015
 */
public class LocationInfo {

    private String location;
    private long latitude;
    private long longitude;

    @Override
    public String toString() {
        return new ToStringCreator(this)
            .append("location", location)
            .append("lat", latitude)
            .append("long", longitude)
            .toString();
    }

    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
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

}
