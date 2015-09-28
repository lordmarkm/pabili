package com.pabili.postings.dto;

import java.math.BigDecimal;

import com.pabili.commons.dto.BaseDto;
import com.pabili.commons.dto.profile.UserProfileInfo;
import com.pabili.postings.util.ProposalStatus;
import com.pabili.postings.util.ShippingChannel;

/**
 * @author Mark Martinez, created Sep 28, 2015
 */
public class ProposalInfo extends BaseDto {

    private BuyRequestHeaderInfo buyRequestHeader;
    private UserProfileInfo gopher;
    private ProposalStatus status;
    private BigDecimal totalItemsAmount;
    private BigDecimal shippingAmount;
    private ShippingChannel shippingChannel;
    private BigDecimal gopherFee;
    private BigDecimal pabiliFee;

    @Override
    public String toString() {
        return tsc()
            .append("header", buyRequestHeader)
            .append("gopher", gopher)
            .append("gopher fee", gopherFee)
            .append("status", status)
            .append("items", totalItemsAmount)
            .append("shipping", shippingAmount)
            .append("channel", shippingChannel)
            .append("pabili fee", pabiliFee)
            .toString();
    }

    public BuyRequestHeaderInfo getBuyRequestHeader() {
        return buyRequestHeader;
    }
    public void setBuyRequestHeader(BuyRequestHeaderInfo buyRequestHeader) {
        this.buyRequestHeader = buyRequestHeader;
    }
    public UserProfileInfo getGopher() {
        return gopher;
    }
    public void setGopher(UserProfileInfo gopher) {
        this.gopher = gopher;
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

}
