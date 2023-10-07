package com.pratice.dsa.arrays;

public class DecimalToBinary {

    public static String decimalToBinary(int decimal) {
        if (decimal == 0) {
            return "0";
        }

        StringBuilder binary = new StringBuilder();
        while (decimal > 0) {
            int remainder = decimal % 2;
            binary.insert(0, remainder);
            decimal /= 2;
        }

        return binary.toString();
    }

    public static void main(String[] args) {
        int n = 10; // Set the upper limit of integers to print binary representations
        for (int i = 1; i <= n; i++) {
            System.out.println(i + ": " + decimalToBinary(i));
        }
    }
}

