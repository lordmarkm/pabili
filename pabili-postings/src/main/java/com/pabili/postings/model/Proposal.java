package com.pabili.postings.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.pabili.core.model.base.BaseEntity;
import com.pabili.core.model.user.GopherProfile;
import com.pabili.core.model.user.UserProfile;
import com.pabili.postings.util.ProposalStatus;
import com.pabili.postings.util.ShippingChannel;

/**
 * @author Mark Martinez, created Sep 16, 2015
 */
@Entity(name = "proposal")
public class Proposal extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "buy_req_header_id")
    private BuyRequestHeader buyRequestHeader;

    @ManyToOne
    @JoinColumn(name = "gopher_id", nullable = false)
    private UserProfile gopher;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ProposalStatus status;

    @Column(name = "items_amt", nullable = false)
    private BigDecimal totalItemsAmount;

    @Column(name = "shipping_amt", nullable = false)
    private BigDecimal shippingAmount;

    @Enumerated(EnumType.STRING)
    @Column(name = "shipping_channel", nullable = false)
    private ShippingChannel shippingChannel;

    @Column(name = "gopher_fee", nullable = false)
    private BigDecimal gopherFee;

    @Column(name = "pabili_fee", nullable = false)
    private BigDecimal pabiliFee;

    public BuyRequestHeader getBuyRequestHeader() {
        return buyRequestHeader;
    }

    public void setBuyRequestHeader(BuyRequestHeader buyRequestHeader) {
        this.buyRequestHeader = buyRequestHeader;
    }

    public ProposalStatus getStatus() {
        return status;
    }

    public void setStatus(ProposalStatus status) {
        this.status = status;
    }

    public BigDecimal getTotalItemsAmount() {
        return totalItemsAmount;
    }

    public void setTotalItemsAmount(BigDecimal totalItemsAmount) {
        this.totalItemsAmount = totalItemsAmount;
    }

    public BigDecimal getShippingAmount() {
        return shippingAmount;
    }

    public void setShippingAmount(BigDecimal shippingAmount) {
        this.shippingAmount = shippingAmount;
    }

    public ShippingChannel getShippingChannel() {
        return shippingChannel;
    }

    public void setShippingChannel(ShippingChannel shippingChannel) {
        this.shippingChannel = shippingChannel;
    }

    public BigDecimal getGopherFee() {
        return gopherFee;
    }

    public void setGopherFee(BigDecimal gopherFee) {
        this.gopherFee = gopherFee;
    }

    public BigDecimal getPabiliFee() {
        return pabiliFee;
    }

    public void setPabiliFee(BigDecimal pabiliFee) {
        this.pabiliFee = pabiliFee;
    }

    public UserProfile getGopher() {
        return gopher;
    }

    public void setGopher(UserProfile gopher) {
        this.gopher = gopher;
    }

}
