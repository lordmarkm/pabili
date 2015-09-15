package com.pabili.commons.dto;

import org.joda.time.DateTime;
import org.springframework.core.style.ToStringCreator;

public class BaseDto {

    protected Long id;
    protected DateTime dateCreated;
    protected DateTime dateUpdated;

    public ToStringCreator tsc() {
        return new ToStringCreator(this)
            .append("id", id)
            .append("created", dateCreated)
            .append("updated", dateCreated);
    }

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
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

}
