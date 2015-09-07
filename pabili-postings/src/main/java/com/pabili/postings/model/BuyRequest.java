package com.pabili.postings.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.pabili.core.model.base.BaseEntity;

/**
 * @author mbmartinez
 */
@Entity(name = "buy_request")
public class BuyRequest extends BaseEntity {

    @Column(name = "title")
    private String title;
    
    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "posting_id")
    private Posting posting;

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

    public Posting getPosting() {
        return posting;
    }

    public void setPosting(Posting posting) {
        this.posting = posting;
    }

}
