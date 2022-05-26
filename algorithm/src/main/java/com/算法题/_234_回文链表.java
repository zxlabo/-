package com.算法题;

import com.helper.AlgorithmUtils;
import com.helper.ListNode;

public class _234_回文链表 {
    public static void main(String[] args) {

        ListNode l1 = AlgorithmUtils.stringToListNode("[1,1,2,1]");
        isPalindrome(l1);

    }

        public static boolean isPalindrome(ListNode head) {
            // 1、找到中间节点
            // 2、之后的链表进行反转
            // 3、和之前链表进行比对，相等意味着是回文链表
            ListNode midNode=findMidNode(head);
            ListNode reverseHead= reverse(midNode);
            while(reverseHead!=null){
                if(reverseHead.val!=head.val){
                    return false;
                }
                reverseHead=reverseHead.next;
                head=head.next;
            }
            return true;

        }
        public static ListNode findMidNode(ListNode head){
            ListNode fastNode=head;
            ListNode slowNode=head;
            while(slowNode!=null){
                if(fastNode.next==null||fastNode.next.next==null){
                    return slowNode.next;
                }
                fastNode=fastNode.next.next;
                slowNode=slowNode.next;
            }
            return null;
        }

        public static ListNode reverse(ListNode node){
            ListNode reverseHead=null;
            while(node!=null){
                ListNode tmp=node.next;
                reverseHead=node.next;
                reverseHead=node;
                node=tmp;
            }
            return reverseHead;
        }

}
