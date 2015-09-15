package com.pabili.postings.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.pabili.core.model.base.BaseEntity;
import com.pabili.core.model.user.UserProfile;

/**
 * @author Mark Martinez, create Sep 14, 2015
 */
@Entity
@Table(name = "buy_request_msg")
public class BuyRequestMessage extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "buy_request_header_id", nullable = false)
    private BuyRequestHeader buyRequestHeader;

    /**
     * If this is null, it's a system generated message
     */
    @ManyToOne
    @JoinColumn(name = "sender_id")
    private UserProfile sender;

    @ManyToOne
    @JoinColumn(name = "gopher_id", nullable = false)
    private UserProfile gopher;

    @Column(name = "message", nullable = false)
    @Type(type = "text")
    private String message;

    public BuyRequestHeader getBuyRequestHeader() {
        return buyRequestHeader;
    }

    public void setBuyRequestHeader(BuyRequestHeader buyRequestHeader) {
        this.buyRequestHeader = buyRequestHeader;
    }

    public UserProfile getSender() {
        return sender;
    }

    public void setSender(UserProfile sender) {
        this.sender = sender;
    }

    public UserProfile getGopher() {
        return gopher;
    }

    public void setGopher(UserProfile gopher) {
        this.gopher = gopher;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
