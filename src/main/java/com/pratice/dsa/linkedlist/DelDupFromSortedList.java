package com.pratice.dsa.linkedlist;

import java.util.List;

public class DelDupFromSortedList {

    ListNode root;
    ListNode head;

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {

        ListNode head = new DelDupFromSortedList().initListNode();

        System.out.println(deleteDuplicates(head));
    }

    private ListNode initListNode() {
        int[] arr = new int[]{1, 2, 3, 3, 4, 4, 5};
//        int[] arr = new int[]{1,1,1,2,3};
        for (int i : arr) {
            ListNode listNode = new ListNode(i, null);
            if (head == null) {
                head = listNode;
                root = head;
            } else {
                head.next = listNode;
                head = head.next;
            }
        }
        return root;
    }


    public static ListNode deleteDuplicates(ListNode head) {

        ListNode pre = null;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val != cur.next.val) {
                pre = cur;
                cur = cur.next;
            } else {
                while (cur.next != null && cur.next.val == cur.val) {
                    cur = cur.next;
                }
                if (pre != null) {
                    pre.next = cur.next;
                } else {
                    head = cur.next;
                }
                cur = cur.next;
            }
        }
        return head;

    }
}
