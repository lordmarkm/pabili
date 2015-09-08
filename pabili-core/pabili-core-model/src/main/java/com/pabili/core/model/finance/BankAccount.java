package com.pabili.core.model.finance;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.pabili.core.model.enums.Bank;

@Embeddable
public class BankAccount {

    @Enumerated(EnumType.STRING)
    @Column(name = "bank")
    private Bank bank;

    @Column(name = "ba_alias")
    private String alias;

    @Column(name = "acct_name")
    private String accountName;

    @Column(name = "acct_no")
    private String accountNumber;

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

}
