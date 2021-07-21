package com.moshCode;

import java.text.NumberFormat;

public class Print {
    public static void mortgage(int principal, float annualInterest, byte years) {
        double mortgage = Calculate.mortgage(principal, annualInterest, years);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);

        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly payments = " + mortgageFormatted);
    }

    public static void paymentSchedule(int principal, float annualInterest, byte years) {
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("--------");
        for (short month = 1; month <= years * Main.monthsInYear; month++) {
            double balance = Calculate.balance(principal, annualInterest, years, month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }
}
