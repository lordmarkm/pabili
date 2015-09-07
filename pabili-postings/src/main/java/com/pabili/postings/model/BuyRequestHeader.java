package com.pabili.postings.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.pabili.core.model.base.BaseEntity;
import com.pabili.core.model.user.UserProfile;

/**
 * @author mbmartinez
 */
@Entity(name = "buy_request_header")
public class BuyRequestHeader extends BaseEntity {

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    private UserProfile creator;

    public UserProfile getCreator() {
        return creator;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreator(UserProfile creator) {
        this.creator = creator;
    }

}
