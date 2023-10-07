package com.pratice.dsa.recurssion;

public class IsPolindrome {

    public static void main(String[] args) {
        String s="A man, a plan, a canal: Panama";
        s = s.toLowerCase();
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        System.out.println(isPolindromeCheck(s, 0,s.length()-1));
    }

    public static boolean isPolindromeCheck(String s, int l, int r){

        if(l>=r){ return true;}
        if(s.charAt(l) != s.charAt(r)){ return false;}
        return isPolindromeCheck(s,l+1,r-1);
    }
}
