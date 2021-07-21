package com.moshCode;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    final static byte monthsInYear = 12;
    final static byte percent = 100;

    public static void main(String[] args) {
        int principal = (int) Scan.number("Principal ($1K - $1M): ", 1000, 1000000);
        float annualInterest = (float) Scan.number("Annual interest rate: ", 1, 30);
        byte years = (byte) Scan.number("Period (Years): ", 1, 30);

        Print.mortgage(principal, annualInterest, years);
        Print.paymentSchedule(principal, annualInterest, years);
    }

}
