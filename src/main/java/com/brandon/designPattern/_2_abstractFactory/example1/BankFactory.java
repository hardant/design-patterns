package com.brandon.designPattern._2_abstractFactory.example1;

import com.brandon.designPattern._2_abstractFactory.example1.banks.Bank;
import com.brandon.designPattern._2_abstractFactory.example1.banks.HDFCBank;
import com.brandon.designPattern._2_abstractFactory.example1.banks.ICICBank;
import com.brandon.designPattern._2_abstractFactory.example1.banks.SBIBank;
import com.brandon.designPattern._2_abstractFactory.example1.loan.Loan;

public class BankFactory extends AbstractFactory {
    public Bank getBank(String bank){
        if(bank == null){
            return null;
        }
        if(bank.equalsIgnoreCase("HDFC")){
            return new HDFCBank();
        } else if(bank.equalsIgnoreCase("ICICI")){
            return new ICICBank();
        } else if(bank.equalsIgnoreCase("SBI")){
            return new SBIBank();
        }
        return null;
    }

    public Loan getLoan(String loan) {
        return null;
    }
}
