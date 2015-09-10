package com.pabili.commons.dto;

import com.pabili.commons.util.Bank;

/**
 * @author Mark Martinez, create Sep 10, 2015
 */
public class BankInfo {

    private String code;
    private String name;
    
    public BankInfo(Bank bank) {
        this.code = bank.name();
        this.name = bank.getName();
    }
    
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
