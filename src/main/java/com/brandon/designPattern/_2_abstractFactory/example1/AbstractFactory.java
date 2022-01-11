package com.brandon.designPattern._2_abstractFactory.example1;

import com.brandon.designPattern._2_abstractFactory.example1.banks.Bank;
import com.brandon.designPattern._2_abstractFactory.example1.loan.Loan;

public abstract class AbstractFactory {
    public abstract Bank getBank(String bank);
    public abstract Loan getLoan(String loan);
}
