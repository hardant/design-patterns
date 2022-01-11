package com.brandon.designPattern._2_abstractFactory.example1.banks;

public class SBIBank implements Bank {
    private final String BNAME;
    public SBIBank() {
        BNAME = "SBI BANK";
    }

    public String getBankName() {
        return BNAME;
    }
}
