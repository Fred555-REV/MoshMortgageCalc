package com.moshCode;

public class Calculate {
    public static double balance(int principal, float annualInterest, byte years, short numOfPaymentsMade) {
        float monthlyInterest = annualInterest / Main.percent / Main.monthsInYear;
        short numberOfPayments = (short) (years * Main.monthsInYear);
        double balance = principal
                * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
        return balance;
    }

    public static double mortgage(int principal, float annualInterest, byte years) {
        float monthlyInterest = annualInterest / Main.percent / Main.monthsInYear;
        short numberOfPayments = (short) (years * Main.monthsInYear);
        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
        return mortgage;
    }
}
