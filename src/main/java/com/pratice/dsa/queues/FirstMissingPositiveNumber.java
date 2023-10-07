package com.pratice.dsa.queues;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class FirstMissingPositiveNumber {

    public static void main(String[] args) {
        int nums[] = new int[]{3,4,-1,1};
        System.out.println(firstMissingPositiveNumber(nums));
    }

    private static Integer firstMissingPositiveNumber(int[] nums) {

        PriorityQueue<Integer> missingNumbers = new PriorityQueue();

        for (int i: nums) {
            if (i > 0) {
                missingNumbers.add(i);
            }
        }

        int missingNum = 1;
        while (!missingNumbers.isEmpty()) {
            int element = missingNumbers.poll();
            if (missingNum == element) {
                missingNum++;
            } else if (element>missingNum){
                break;
            }
        }
        return missingNum;
    }
}
