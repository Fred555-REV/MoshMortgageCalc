package com.moshCode;

public class Calculate {
    public static double balance(int principal, float annualInterest, byte years, short numOfPaymentsMade) {
        final byte monthsInYear = 12;
        final byte percent = 100;
        float monthlyInterest = annualInterest / percent / monthsInYear;
        short numberOfPayments = (short) (years * monthsInYear);
        double balance = principal
                * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
        return balance;
    }

    public static double mortgage(int principal, float annualInterest, byte years) {
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
