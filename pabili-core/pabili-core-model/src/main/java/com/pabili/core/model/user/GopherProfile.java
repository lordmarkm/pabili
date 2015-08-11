package com.pabili.core.model.user;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class GopherProfile {

    /**
     * Balance pending incomplete transactions
     */
    @Column(name = "goph_pend_bal")
    private BigDecimal pendingBalance;

    @Column(name = "goph_av_bal")
    private BigDecimal availableBalance;

    @Column(name = "goph_total_trans")
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
