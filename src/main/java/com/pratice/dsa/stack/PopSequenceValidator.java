package com.pratice.dsa.stack;

import java.util.Stack;

public class PopSequenceValidator {
    public static boolean isValidPopSequence(String pushSequence, String popSequence) {
        if (pushSequence.length() != popSequence.length()) {
            return false; // Different lengths mean invalid sequences.
        }

        Stack<Character> stack = new Stack<>();
        int pushIndex = 0; // Index for the push sequence.

        for (char popChar : popSequence.toCharArray()) {
            // Pop until the stack is empty or the top element doesn't match the current pop character.
            while (!stack.isEmpty() && stack.peek() == popChar) {
                stack.pop();
                break;
            }

            // If the stack is empty or the top element doesn't match, push from the push sequence.
            while (pushIndex < pushSequence.length() && pushSequence.charAt(pushIndex) != popChar) {
                stack.push(pushSequence.charAt(pushIndex));
                pushIndex++;
            }

            // If we couldn't find the matching element in the push sequence, it's an invalid sequence.
            if (pushIndex >= pushSequence.length() || stack.peek() != popChar) {
                return false;
            }

            // Move to the next character in the push sequence.
            pushIndex++;
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String pushSequence = "12345";
        String popSequence1 = "32541";
        String popSequence2 = "54321";

        System.out.println(isValidPopSequence(pushSequence, popSequence1)); // true
        System.out.println(isValidPopSequence(pushSequence, popSequence2)); // false
    }
}

