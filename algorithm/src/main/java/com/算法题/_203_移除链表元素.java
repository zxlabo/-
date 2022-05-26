package com.算法题;

import com.helper.AlgorithmUtils;
import com.helper.ListNode;

public class _203_移除链表元素 {
    public static void main(String[] args) {

        ListNode l1 = AlgorithmUtils.stringToListNode("[5]");
        ListNode  l3= removeElements(l1, 5);
        System.out.println("--------------begin--------------");
        while (l3 != null) {
            System.out.println(l3.val);
            l3 = l3.next;
        }
        System.out.println("--------------end--------------");
    }
    public static ListNode removeElements(ListNode head, int val) {
        ListNode headNode=new ListNode(0);
        ListNode tailNode=headNode;
        while(head!=null){
            if(head.val!=val){
                tailNode.next=new ListNode(head.val);
                tailNode=tailNode.next;
            }
            head=head.next;
        }
        return headNode.next;
    }
}
