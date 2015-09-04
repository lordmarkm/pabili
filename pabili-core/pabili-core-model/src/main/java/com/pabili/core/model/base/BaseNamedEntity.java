package com.pabili.core.model.base;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.Type;

@MappedSuperclass
public abstract class BaseNamedEntity extends BaseEntity {

    @Column(name = "name")
    protected String name;

    @Column(name = "description")
    @Type(type = "text")
    protected String description;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

}
