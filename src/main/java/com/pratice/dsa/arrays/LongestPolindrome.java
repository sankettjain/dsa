package com.pratice.dsa.arrays;

public class LongestPolindrome {

    public static void main(String[] args) {
        System.out.println(longestPolindrome("nitinmalayalam"));
    }

    private static int longestPolindrome(String inputString) {

        int initialLength = inputString.length();

        int max = 0;
        String maxString = "";
        for (int i = 0; i < initialLength; i++) {

            int l = i, r = i;
            while (l >= 0 && r < initialLength && inputString.charAt(l) == inputString.charAt(r)) {
                if (r - l + 1 > max) {
                    max = r - l + 1;
                    maxString = inputString.substring(l, r + 1);
                }
                l--;
                r++;
            }

            l = i;
            r = i + 1;
            while (l >= 0 && r < initialLength && inputString.charAt(l) == inputString.charAt(r)) {
                if (r - l + 1 > max) {
                    max = r - l + 1;
                    maxString = inputString.substring(l, r + 1);
                }
                l--;
                r++;
            }


        }

        System.out.println(maxString);
        return max;
    }
}
