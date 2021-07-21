package com.moshCode;

import java.util.Scanner;

public class Scan {
    public static double number(String prompt, double min, double max) {
        Scanner scan = new Scanner(System.in);
        System.out.print(prompt);
        int value = scan.nextInt();
        while (value < min || value > max) {
            System.out.println("Enter an integer between " + min + " and " + max);
            value = scan.nextInt();
        }
        return value;
    }
}
