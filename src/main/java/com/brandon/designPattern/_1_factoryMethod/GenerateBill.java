package com.brandon.designPattern._1_factoryMethod;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GenerateBill {
    public static void main(String[] args) throws IOException {
        GetPlanFactory getPlanFactory = new GetPlanFactory();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter the name of plan which the bill will be generated:");
        String planName = br.readLine();
        System.out.println(String.format("planName = %s", planName));

        Plan plan = getPlanFactory.getPlan(planName);
        System.out.println(plan.getClass().getName());

        System.out.println("Enter the number of units for bill will be calculated:");
        int units = Integer.parseInt(br.readLine().trim());

        System.out.println(String.format("Bill amount for %s of %d units is : ", planName, units));
        plan.calculateBill(units);

    }
}
