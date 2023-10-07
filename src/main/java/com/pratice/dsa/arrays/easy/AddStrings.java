package com.pratice.dsa.arrays.easy;

public class AddStrings {

    /**
     *
     * 1. Start from end of both of string
     * 2. Convert, add the values, add the carry if any, get the unit value.
     * 3. Again check if carry is greater than 10 then 1:0
     * @param args
     */

    public static void main(String[] args) {

        String s1 = "9";
        String s2 = "1";
        System.out.println(addStrings(s1, s2));


    }

    public static String addStrings(String num1, String num2) {

        int i = num1.length() - 1;
        int j = num2.length() - 1;

        int carry = 0;
        StringBuilder builder = new StringBuilder();

        while (i >= 0 || j >= 0 || carry > 0) {

            int digit1 = 0;
            int digit2 = 0;

            if (i >= 0) {
                digit1 = num1.charAt(i) - '0';
                i--;

            }

            if (j >= 0) {
                digit2 = num2.charAt(j) - '0';
                j--;
            }

            int digitCal = (digit1 + digit2 + carry) % 10;
            carry = (digit1 + digit2 + carry) >= 10 ? 1 : 0;
            builder.append(digitCal);

        }

        return builder.reverse().toString();


    }
}
