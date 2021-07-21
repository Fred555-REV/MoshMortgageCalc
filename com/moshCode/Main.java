package com.moshCode;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        final byte monthsInYear = 12;
        int principal = (int) Scan.number("Principal ($1K - $1M): ", 1000, 1000000);
        float annualInterest = (float) Scan.number("Annual interest rate: ", 1, 30);
        byte years = (byte) Scan.number("Period (Years): ", 1, 30);

        double mortgage = Calculate.mortgage(principal, annualInterest, years);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);

        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly payments = " + mortgageFormatted);
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("--------");
        for (short month = 1; month <= years * monthsInYear; month++) {
            double balance = Calculate.balance(principal, annualInterest, years, month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }

}
