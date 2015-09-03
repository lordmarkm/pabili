package com.pabili.commons.dto.posting;

import java.math.BigDecimal;

import com.pabili.commons.dto.Displayable;
import com.pabili.commons.dto.location.LocationInfo;

/**
 * @author Mark Martinez, created Sep 3, 2015
 */
public class PostingInfo extends Displayable {

    private BigDecimal price;
    private LocationInfo location;

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

}
