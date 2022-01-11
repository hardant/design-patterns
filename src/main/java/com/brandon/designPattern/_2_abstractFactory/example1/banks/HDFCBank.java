package com.brandon.designPattern._2_abstractFactory.example1.banks;

public class HDFCBank implements Bank {
    private final String BNAME;

    public HDFCBank() {
        BNAME = "HDFC BANK";
    }
    public String getBankName() {
        return BNAME;
    }
}
