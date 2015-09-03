package com.pabili.commons.dto;

import org.joda.time.DateTime;

public class BaseDto {

    private DateTime dateCreated;
    private DateTime dateUpdated;

    public DateTime getDateCreated() {
        return dateCreated;
    }
    public void setDateCreated(DateTime dateCreated) {
        this.dateCreated = dateCreated;
    }
    public DateTime getDateUpdated() {
        return dateUpdated;
    }
    public void setDateUpdated(DateTime dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

}
