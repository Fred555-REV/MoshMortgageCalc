package com.moshCode;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        final byte monthsInYear = 12;
        final byte percent = 100;

        System.out.print("Principal ($1K - $1M): ");
        int principal = scan.nextInt();
        while (principal < 1000 || principal > 1000000) {
            System.out.println("Enter an integer between 1,000 and 1,000,000");
            principal = scan.nextInt();
        }

        System.out.print("Annual interest rate: ");
        float annualInterest = scan.nextFloat();
        while (annualInterest <= 0 || annualInterest > 30) {
            System.out.println("Enter an integer greater than 0 and less than or equal to 30");
            annualInterest = scan.nextFloat();
        }

        float monthlyInterest = annualInterest / percent / monthsInYear;

        System.out.print("Period (Years): ");
        byte years = scan.nextByte();
        while (years < 1 || years > 30) {
            System.out.println("Enter an integer between 1 and 30");
            years = scan.nextByte();
        }

        int numberOfPayments = years * monthsInYear;

        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
    }

}
