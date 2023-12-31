package com.pratice.dsa.recurssion;

public class myPow {

    public static void main(String[] args){

        System.out.println(myPow(3,10));
    }

    public static double myPow(double x, int n) {

        if (n == 0) return 1.0;
        // even power
        if (n % 2 == 0)
            return myPow(x * x, n / 2);
        // odd power
        if (n % 2 == 1)
            return x * myPow(x, n - 1);
        // negative power
        return 1/myPow(x, -n);

    }
}
