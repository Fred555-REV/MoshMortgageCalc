package com.moshCode;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        final byte monthsInYear = 12;
        int principal = (int) readNumber("Principal ($1K - $1M): ", 1000, 1000000);
        float annualInterest = (float) readNumber("Annual interest rate: ", 1, 30);
        byte years = (byte) readNumber("Period (Years): ", 1, 30);

        double mortgage = calculateMortgage(principal, annualInterest, years);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);

        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly payments = " + mortgageFormatted);
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("--------");
        for (short month = 1; month <= years * monthsInYear; month++) {
            double balance = calculateBalance(principal, annualInterest, years, month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
//        while (principal > 0) {
//            if (principal > mortgage) {
//                principal -= mortgage;
//            } else {
//                principal = 0;
//            }
//            String principalFormatted = NumberFormat.getCurrencyInstance().format(principal);
//            System.out.println(principalFormatted);
//        }

    }

    public static double readNumber(String prompt, double min, double max) {
        Scanner scan = new Scanner(System.in);
        System.out.print(prompt);
        int value = scan.nextInt();
        while (value < min || value > max) {
            System.out.println("Enter an integer between" + min + " and " + max);
            value = scan.nextInt();
        }
        return value;
    }

    public static double calculateBalance(int principal, float annualInterest, byte years, short numOfPaymentsMade) {
        final byte monthsInYear = 12;
        final byte percent = 100;
        float monthlyInterest = annualInterest / percent / monthsInYear;
        short numberOfPayments = (short) (years * monthsInYear);
        double balance = principal
                * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
        return balance;
    }

    public static double calculateMortgage(int principal, float annualInterest, byte years) {
        final byte monthsInYear = 12;
        final byte percent = 100;
        float monthlyInterest = annualInterest / percent / monthsInYear;
        short numberOfPayments = (short) (years * monthsInYear);
        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
        return mortgage;
    }

}
