package com.pratice.dsa.queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseKChallenge {

    public static void main(String[] args){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);
        queue.add(7);
        queue.add(8);
        queue.add(9);
        queue.add(10);
        System.out.println(reverseK(queue, 5));
    }

    //1.Push first k elements in queue in a stack.
    //2.Pop Stack elements and enqueue them at the end of queue
    //3.Dequeue queue elements till "k" and append them at the end of queue
    //4.Dequeue the remaining elements and enqueue them again to append them at end of the queue
    public static <V> Object reverseK(Queue<V> queue, int k) {
        if (queue.isEmpty() || k <= 0)
            return null;
        Stack<V> stack = new Stack<>();

        while(stack.size()<k)
            stack.push(queue.poll());

        while(!stack.isEmpty())
            queue.add(stack.pop());

        int size = queue.size();
        for(int i = 0; i < size - k; i++)
            queue.add(queue.poll());
        return queue;
    }


}
