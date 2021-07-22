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
        int year = 1;
        for (short month = 1; month <= years * Main.monthsInYear; month++) {
            double balance = Calculate.balance(principal, annualInterest, years, month);
//            System.out.println(year + "-year : years-" + years);
            if (month % 12 == 0 && years > year) {
                year++;
                System.out.println("\nYear: " + year);
                System.out.println();
            }
            System.out.println("Month: " + month + " Balance: " + NumberFormat.getCurrencyInstance().format(balance));
        }
    }
}
