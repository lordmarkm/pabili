package com.pabili.postings.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.pabili.commons.comments.Commentable;
import com.pabili.commons.comments.CommentableType;
import com.pabili.core.model.user.UserProfile;

/**
 * Postings are buyer-initiated transactions
 * @author mbmartinez
 */
@Entity(name = "posting")
public class Posting implements Commentable {

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private UserProfile buyer;

    @ManyToOne
    @JoinColumn(name = "gopher_id")
    private UserProfile gopher;

    @Override
    public CommentableType getCommentableType() {
        return CommentableType.POSTING;
    }

    public UserProfile getBuyer() {
        return buyer;
    }

    public void setBuyer(UserProfile buyer) {
        this.buyer = buyer;
    }

    public UserProfile getGopher() {
        return gopher;
    }

    public void setGopher(UserProfile gopher) {
        this.gopher = gopher;
    }

}
