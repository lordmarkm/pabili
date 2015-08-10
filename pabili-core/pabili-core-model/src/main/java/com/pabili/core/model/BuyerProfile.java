package com.pabili.core.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class BuyerProfile {

    /**
     * Balance pending incomplete transactions
     */
    @Column(name = "BUY_PEND_BAL")
    private BigDecimal pendingBalance;
    
    @Column(name = "BUY_AV_BAL")
    private BigDecimal availableBalance;

    @Column(name = "BUY_TOTAL_TRANS")
    private long totalTransactions;

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

}
