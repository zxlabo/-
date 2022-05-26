package com.算法题;

import com.helper.ListNode;

public class _19_删除链表倒数 {

    public static void main(String[] args) {

    }


    public static ListNode removeNthFromEnd(ListNode head, int n) {
        //1、将链表反转
        head = reverseListNode(head);
        ListNode deleteNode = head;
        //2、删除第n个节点，找到前一个节点。判断 前一个节点的next是不是null
        if (n==1){
            head=head.next;
        }else {
            int i = 1;
            while (i < n-1) {
                deleteNode = deleteNode.next;
                i++;
            }
            if (deleteNode.next==null){
                deleteNode.next=null;
            }else {
                deleteNode.next=deleteNode.next.next;
            }
        }

        //3、再反转
        head = reverseListNode(head);
        return head;
    }

    public static ListNode reverseListNode(ListNode head) {
        ListNode rH = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = rH;
            rH = head;
            head = tmp;
        }
        return rH;
    }

}
