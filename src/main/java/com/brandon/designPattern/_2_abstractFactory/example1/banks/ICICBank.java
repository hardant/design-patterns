package com.brandon.designPattern._2_abstractFactory.example1.banks;

public class ICICBank implements Bank {
    private final String BNAME;

    public ICICBank() {
        BNAME = "CICI BANK";
    }

    public String getBankName() {
        return BNAME;
    }
}
