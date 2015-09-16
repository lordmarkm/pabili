package com.pabili.postings.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

import com.pabili.postings.util.ProposalStatus;
import com.pabili.postings.util.ShippingChannel;

/**
 * @author Mark Martinez, created Sep 16, 2015
 */
@Entity(name = "proposal")
public class Proposal {

    @ManyToOne
    @Column(name = "buy_req_header_id")
    private BuyRequestHeader buyRequestHeader;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
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

}
