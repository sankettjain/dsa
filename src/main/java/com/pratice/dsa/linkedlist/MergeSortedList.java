package com.pratice.dsa.linkedlist;

public class MergeSortedList {

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

    private ListNode initListNode(int[] arr, ListNode head) {
        ListNode root = new ListNode(-1);
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

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);
        ListNode cur = prehead;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        cur.next = l1 == null ? l2 : l1;
        return prehead.next;
    }

    public static void main(String[] args) {
        ListNode list1 = new MergeSortedList().initListNode(new int[]{1, 2, 4}, null);
        ListNode list2 = new MergeSortedList().initListNode(new int[]{1, 3, 4}, null);
        ListNode list3 = new MergeSortedList().mergeTwoLists(list1, list2);
        System.out.println(list3);
    }
}
