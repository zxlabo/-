package com.算法题;

public class MinStack2 {
    private static class ListNode {
        public int val;
        public int min;
        public ListNode next;

        public ListNode(int val, int min, ListNode next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    private ListNode head;

    public MinStack2() {
        head = new ListNode(0, Integer.MAX_VALUE, null);
    }

    public void push(int val) {
        head = new ListNode(val, Math.min(val, head.min), head);
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }
}
