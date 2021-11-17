package com.codewithsohan;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int principal = 0;
        float annulInterest = 0;
        byte years = 0;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Principal: ");
            principal = scanner.nextInt();
            if (principal >= 1000 && principal <= 1_000_000)
                break;
            System.out.println("Enter a value between 1000 and 1000000");

        }

        while (true){
            System.out.print("Annul_Interest_Rate : ");
            annulInterest = scanner.nextFloat();
            if (annulInterest >= 1 && annulInterest <= 30)
                break;
            System.out.println("Enter a value between 1 and 30");
        }

        while (true){
            System.out.print("Periods (Years) :");
            years = scanner.nextByte();
            if ( years >= 1 && years<= 30)
                break;
            System.out.println("Enter a year between 1 and 30");
        }


        double mortgage = calculateMortgage(principal , annulInterest , years );

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);

        }
        public static double calculateMortgage(int principal , float annulInterest , byte years ){
            final byte  MONTHS_IN_YEAR = 12;
            final byte PERCENT = 100;
            short  numberOfPayments = (short) (years * MONTHS_IN_YEAR);
            float monthlyInterest = annulInterest / PERCENT / MONTHS_IN_YEAR;
            double mortgage = principal
                    *(monthlyInterest * Math.pow(1 + monthlyInterest , numberOfPayments))
                    / (Math.pow(1 + monthlyInterest,numberOfPayments) - 1);
            return mortgage;

        }
    }

