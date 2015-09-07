package com.pabili.commons.dto.posting;

import java.math.BigDecimal;

import org.springframework.core.style.ToStringCreator;

import com.pabili.commons.dto.Displayable;
import com.pabili.commons.dto.location.LocationInfo;

/**
 * @author Mark Martinez, created Sep 3, 2015
 */
public class PostingInfo extends Displayable {

    private String owner;
    private BigDecimal price;
    private LocationInfo location;

    @Override
    public String toString() {
        return new ToStringCreator(this)
            .append("owner", owner)
            .append("title", title)
            .append("desc", description)
            .append("price", price)
            .append("location", location)
            .append("imageUrl", imageUrl)
            .append("albumUrl", albumUrl)
            .toString();
    }

    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public LocationInfo getLocation() {
        return location;
    }
    public void setLocation(LocationInfo location) {
        this.location = location;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

}
