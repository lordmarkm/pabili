package com.pabili.postings.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.pabili.commons.comments.Commentable;
import com.pabili.commons.comments.CommentableType;
import com.pabili.core.model.user.GeneralProfile;

/**
 * Postings are buyer-initiated transactions
 * @author mbmartinez
 */
@Entity(name = "posting")
public class Posting implements Commentable {

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private GeneralProfile buyer;

    @ManyToOne
    @JoinColumn(name = "gopher_id")
    private GeneralProfile gopher;

    @Override
    public CommentableType getCommentableType() {
        return CommentableType.POSTING;
    }

    public GeneralProfile getBuyer() {
        return buyer;
    }

    public void setBuyer(GeneralProfile buyer) {
        this.buyer = buyer;
    }

    public GeneralProfile getGopher() {
        return gopher;
    }

    public void setGopher(GeneralProfile gopher) {
        this.gopher = gopher;
    }

}
