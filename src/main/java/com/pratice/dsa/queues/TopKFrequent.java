package com.pratice.dsa.queues;

import java.util.*;

public class TopKFrequent {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 1, 2, 3, 2, 4};
        System.out.println(topKfrequent(arr, 2));

    }

    public static List topKfrequent(int[] arr, int k) {

        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int n : arr) {
            freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> priorityQueue = new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));
        for(Map.Entry<Integer,Integer> entry:freqMap.entrySet()){
            priorityQueue.add(entry);
        }
        List<Integer> topKFreqElements= new ArrayList<>();
        while (topKFreqElements.size()<k){
            topKFreqElements.add(priorityQueue.poll().getKey());
        }
        return topKFreqElements;
    }
}
