package com._00_必会;

import com._03_数据结构._1_数组.abs.List;

/**
 * author : Naruto
 * date   : 2022/5/19
 * desc   :
 * version:
 */
class _01_链表必会 {
    public static void main(String[] args) {

    }

    /**
     * 快慢指针求中间节点
     */
    private ListNode findMidNode(ListNode node) {
        ListNode slow = node;
        ListNode fast = node;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode firstNode = new ListNode(0);
        ListNode temp = firstNode;
        while (head != null) {
            if (head.val != val) {
                temp.next = new ListNode(head.val);
                temp = temp.next;
            }
            head = head.next;
        }
        return firstNode.next;
    }

    /**
     * 链表反转
     */
    private ListNode reverseNode(ListNode node) {
        ListNode reverseNode = null;
        while (node != null) {
            ListNode temp = node.next;
            node.next = reverseNode;
            reverseNode = node;
            node = temp;
        }
        return reverseNode;
    }

    private static class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
