package com.pabili.commons.util;

public enum Bank {

    BDO("Banco de Oro (BDO)"),
    BPI("BPI"),
    SECURITY_BANK("Security Bank");

    private String name;
    private Bank(String name) {
        this.name = name;
    }
    public String getName() {
        // TODO Auto-generated method stub
        return name;
    }

}
