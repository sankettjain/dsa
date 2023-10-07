package com.pratice.dsa.interview.atlassian;

public class Solution {
    public static void main(String[] argv) {
        String[] words = {"baby", "referee", "cat", "dada", "dog", "bird", "ax", "baz"};
        String note1 = "ctay";
        String note2 = "bcanihjsrrrferet";
        String note3 = "tbaykkjlga";
        String note4 = "bbbblkkjbaby";
        String note5 = "dad";
        String note6 = "breadmaking";
        String note7 = "dadaa";


//        All Test Cases:
//        find(words, note1) -> "cat"
//        find(words, note2) -> "cat"
//        find(words, note3) -> "-"
//        find(words, note4) -> "baby"
//        find(words, note5) -> "-"
//        find(words, note6) -> "bird"
//        find(words, note7) -> "dada"
        System.out.println(find(words, note1));
        System.out.println(find(words, note2));
        System.out.println(find(words, note3));
        System.out.println(find(words, note4));
        System.out.println(find(words, note5));
        System.out.println(find(words, note6));
        System.out.println(find(words, note7));

    }

    public static String find(String[] words, String note) {
        String tempNote = note;
        // String response = "";
        for (String word : words) {
            if (word.equalsIgnoreCase(tempNote)) {
                return word;
            } else {
                //bcanihjsrrt
                boolean flag = true;
                for (int i = 0; i < word.length(); i++) {
                    if (tempNote.contains(String.valueOf(word.charAt(i)))) {
                        String repla = word.charAt(i) + "";
                        tempNote = tempNote.replaceFirst(repla, "");
                    } else {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return word;
                }
                tempNote = note;

            }


        }


        return "-";
    }
}
