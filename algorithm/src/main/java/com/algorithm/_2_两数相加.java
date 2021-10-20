package com.algorithm;

import com.helper.AlgorithmUtils;
import com.helper.ListNode;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 */
public class _2_两数相加 {

    public static void main(String[] args) {
        ListNode l1 = AlgorithmUtils.stringToListNode("[2,4,3]");
        ListNode l2 = AlgorithmUtils.stringToListNode("[5,6,4]");
        ListNode l3 = addTwoNumbers(l1, l2);
        System.out.println("--------------begin--------------");
        while (l3 != null) {
            System.out.println(l3.val);
            l3 = l3.next;
        }
        System.out.println("--------------end--------------");
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(0);
        ListNode cur = temp;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int s = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            carry = s / 10;
            cur.next = new ListNode(s % 10);
            cur = cur.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        return temp.next;
    }


}