package com._03_数据结构._2_链表;

import com.helper.AlgorithmUtils;
import com.helper.ListNode;

public class 链表基本知识 {
    /**
     * 链表的创建返回
     */
    public ListNode createNode() {
        ListNode headNode = new ListNode(0);
        ListNode tailNode = headNode;
        return headNode.next;
    }

    /**
     * 链表节点的插入
     */
    public void insertNode(ListNode node) {
        node.next = new ListNode(0);
        node = node.next;
    }

    /**
     * 链表节点的删除
     */
    public void deleteNode(ListNode node, int val) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    /**
     * 链表的反转
     * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
     * 思路：反转链表有两种思路，一种是递归，另一种是非递归。
     * 主要学会非递归的方法
     */


    /**
     * 链表的反转-非递归
     * 1、创建 reverseHead
     * 2、将head节点的next指向reverseHead，然后将reverseHead更改为head。
     */
    public ListNode reverseList(ListNode head) {
        ListNode reverseHead = null;
        while (head != null) {
            //因为head.next在下一步会被更改，所以我们首先要将head.next记录下来
            ListNode tmp = head.next;
            head.next = reverseHead;
            reverseHead = head;
            head = tmp;
        }
        return reverseHead;
    }


    /**
     * 递归
     * 首先我们先理解：递归方法，已经实现了我们的需求。
     * 然后基于已经实现我们想要的基础上，再去操作。
     */
    public static ListNode reverseList2(ListNode head) {
        //当链表是最后一个节点或者为null，暂停迭代。
        if (head == null || head.next == null) {
            //此时意味着：链表数量为1或0；
            return head;
        }
        //head.next已经反转完成
        ListNode newHead = reverseList2(head.next);
        //接下来只需要对head和head.next进行反转就可以了
        head.next.next = head;
        head.next=null;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode l1 = AlgorithmUtils.stringToListNode("[3,2,1]");
        AlgorithmUtils.nodeToString(reverseList2(l1));
    }


    /**
     * 快慢指针求中心节点
     */
    public static ListNode findMidNode(ListNode node){
        ListNode fast=node;
        ListNode slow=node;
        while (fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }



    /**
     * 计算链表长度
     */

}
