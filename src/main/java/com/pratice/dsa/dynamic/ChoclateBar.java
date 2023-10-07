package com.pratice.dsa.dynamic;

public class ChoclateBar {

    private static int ways;
    public static void main(String[] args){

        //System.out.println(waysToEatChoclateBar(45,0));
        System.out.println(climbStairs(45));
        System.out.println(climbStairsNew(45));

    }


    public static Integer waysToEatChoclateBar(int n, int cnt) {

       if(n==0) return 1;
       ways = ways + cnt + waysToEatChoclateBar(n-1,cnt+1);
       return ways;
    }

    public static int climbStairs(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);

    }
    public static int climbStairsNew(int n) {
        if(n==1) return 1;

        if(n==2) return 2;

        int[] a =  new int[n];
        a[0]=1;
        a[1]=2;

        for(int i=2;i<n;i++){
            a[i]=a[i-1]+a[i-2];
        }
        return a[n-1];
    }
}
