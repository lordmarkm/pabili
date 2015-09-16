package com.pabili.postings.util;

/**
 * @author Mark Martinez, created Sep 16, 2015
 */
public enum ShippingChannel {

    HAND_CARRY("Delivered in person"),
    LBC("LBC"),
    AIR_21("Air 21"),
    PONY("Pony Express"),
    PHILIPPINES_POST("Philippine Post"),
    DHL("DHL"),
    FED_EX("FedEx"),
    UPS("UPS");

    private String name;
    private ShippingChannel(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

}
