package com.moshCode;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        final byte monthsInYear = 12;
        final byte percent = 100;

        System.out.print("Principal: ");

        int principal = scan.nextInt();
        scan.nextLine();
        System.out.print("Annual interest rate ");

        float annualInterest = scan.nextFloat();
        float monthlyInterest = annualInterest / percent / monthsInYear;

        System.out.print("Period (Years): ");

        byte years = scan.nextByte();
        int numberOfPayments = years * monthsInYear;
        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
    }

}
