package com.pabili.commons.dto.profile;

import java.math.BigDecimal;

import org.springframework.core.style.ToStringCreator;

import com.pabili.commons.dto.AddressInfo;
import com.pabili.commons.dto.BankAccountInfo;

/**
 * @author Mark Martinez, created Sep 3, 2015
 */
public class BuyerProfileInfo {

    private boolean active;
    private AddressInfo shippingAddress;
    private BankAccountInfo reimbursementAccount;
    private BigDecimal pendingBalance = BigDecimal.ZERO;
    private BigDecimal availableBalance = BigDecimal.ZERO;
    private long totalTransactions = 0l;

    @Override
    public String toString() {
        return new ToStringCreator(this)
            .append("active", active)
            .append("ship addr", shippingAddress)
            .append("reimbursement", reimbursementAccount)
            .append("pending bal", pendingBalance)
            .append("avail bal", availableBalance)
            .append("total transactions", totalTransactions)
            .toString();
    }

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
    public AddressInfo getShippingAddress() {
        return shippingAddress;
    }
    public void setShippingAddress(AddressInfo shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
    public BankAccountInfo getReimbursementAccount() {
        return reimbursementAccount;
    }
    public void setReimbursementAccount(BankAccountInfo reimbursementAccount) {
        this.reimbursementAccount = reimbursementAccount;
    }

}
