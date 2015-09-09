package com.pabili.commons.dto;

import com.pabili.commons.util.Bank;

public class BankAccountInfo {

    private Bank bank;
    private String accountName;
    private String accountNumber;

    public Bank getBank() {
        return bank;
    }
    public void setBank(Bank bank) {
        this.bank = bank;
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
