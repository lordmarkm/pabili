package com.pabili.core.model.user;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

import org.hibernate.annotations.Type;

import com.pabili.core.model.Address;

@Embeddable
public class BuyerProfile {

    @Column(name = "buy_active")
    @Type(type = "yes_no")
    private boolean active;

    @Embedded
    private Address shippingAddress;

    /**
     * Balance pending incomplete transactions
     */
    @Column(name = "buy_pend_bal")
    private BigDecimal pendingBalance = BigDecimal.ZERO;
    
    @Column(name = "buy_av_bal")
    private BigDecimal availableBalance = BigDecimal.ZERO;

    @Column(name = "buy_total_trans")
    private long totalTransactions = 0l;

    public BigDecimal getPendingBalance() {
        return pendingBalance;
    }

    public void setPendingBalance(BigDecimal pendingBalance) {
        this.pendingBalance = pendingBalance;
    }

    public BigDecimal getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(BigDecimal availableBalance) {
        this.availableBalance = availableBalance;
    }

    public long getTotalTransactions() {
        return totalTransactions;
    }

    public void setTotalTransactions(long totalTransactions) {
        this.totalTransactions = totalTransactions;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

}
