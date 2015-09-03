package com.pabili.postings.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.pabili.core.model.Location;
import com.pabili.core.model.base.BaseImageableEntity;
import com.pabili.core.model.user.UserProfile;

/**
 * Postings are buyer-initiated transactions
 * @author mbmartinez
 */
@Entity(name = "leposting")
public class Posting extends BaseImageableEntity {

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private UserProfile owner;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    public UserProfile getOwner() {
        return owner;
    }

    public void setOwner(UserProfile owner) {
        this.owner = owner;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

}
