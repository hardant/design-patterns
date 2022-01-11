package com.brandon.designPattern._2_abstractFactory.example1;

import com.brandon.designPattern._2_abstractFactory.example1.banks.Bank;
import com.brandon.designPattern._2_abstractFactory.example1.loan.BussinessLoan;
import com.brandon.designPattern._2_abstractFactory.example1.loan.EducationLoan;
import com.brandon.designPattern._2_abstractFactory.example1.loan.HomeLoan;
import com.brandon.designPattern._2_abstractFactory.example1.loan.Loan;

public class LoanFactory extends AbstractFactory {
    public Bank getBank(String bank) {
        return null;
    }

    public Loan getLoan(String loan) {
        if(loan == null){
            return null;
        }
        if(loan.equalsIgnoreCase("Home")){
            return new HomeLoan();
        } else if(loan.equalsIgnoreCase("Business")){
            return new BussinessLoan();
        } else if(loan.equalsIgnoreCase("Education")){
            return new EducationLoan();
        }
        return null;
    }
}
