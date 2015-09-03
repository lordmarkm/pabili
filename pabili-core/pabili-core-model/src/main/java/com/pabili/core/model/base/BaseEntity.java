package com.pabili.core.model.base;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

/**
 * The Grandfather of every entity from now on.
 * @author mbmartinez
 */
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    protected Long id;

    @Column(name = "deleted")
    @Type(type = "yes_no")
    protected boolean deleted = false;

    @Column(name = "created", updatable = false)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    protected DateTime dateCreated;

    @Column(name = "updated")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    protected DateTime dateUpdated;

    @PrePersist
    public void onCreate() {
        dateCreated = DateTime.now();
    }

    @PreUpdate
    public void onUpdate() {
        dateUpdated = DateTime.now();
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public boolean isDeleted() {
        return deleted;
    }
    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
    public DateTime getDateCreated() {
        return dateCreated;
    }
    public DateTime getDateUpdated() {
        return dateUpdated;
    }
}
