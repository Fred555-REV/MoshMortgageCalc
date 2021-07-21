package com.moshCode;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int principal = (int) readNumber("Principal ($1K - $1M): ", 1000, 1000000);
        float annualInterest = (float) readNumber("Annual interest rate: ",1,30);
        byte years =(byte) readNumber("Period (Years): ",1,30);

        double mortgage = calculateMortgage(principal, annualInterest, years);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
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
