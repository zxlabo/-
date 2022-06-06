package com;

import java.awt.Point;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * author : Naruto
 * date   : 2022/5/21
 * desc   :
 * version:
 */
class _0_每日必看 {
    public static void main(String[] args) {
        // 队列必会
        // 栈必会
        // HashMap必会
        // 链表反转
        // 快慢指针
        // 整数反转
        // 找逆序对
    }

    /**
     * 队列必会
     */
    private void queueStudy(){
        Queue<Integer> queue=new LinkedList();
        queue.offer(1);
        queue.poll();
        queue.peek();
        boolean empty=queue.isEmpty();
        int size=queue.size();
    }

    /**
     * 栈必会
     */
    private void stackStudy(){
        Stack<Integer> stack=new Stack();
        stack.push(1);
        stack.pop();
        stack.peek();
        boolean empty=stack.isEmpty();
        int size=stack.size();
    }

    /**
     * 链表反转
     */
    /**
     * 快慢指针
     */
    /**
     * 整数反转
     */
    /**
     * 找逆序对
     */
    /**
     * 快慢指针求中间节点
     */
    private ListNode findMidNode(ListNode node){
        ListNode slow=node;
        ListNode fast=node;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
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
    /**
     * 1、整数反转
     * 考点：
     * 1、整数反转
     * 2、数组越界
     */
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int v = x % 10;
            int temp = result;
            result = 10 * result + v;
            //判断是否越界，倒回去运算
            if ((result - v) / 10 != temp) {
                return 0;
            }
            x = x / 10;
        }
        return result;
    }

    /**
     * 2、找逆序对
     */
    public int[] subSort(int[] array) {
        //1、边界判断
        if (array == null || array.length < 2) {
            return new int[2];
        }
        //2、从左边开始找右逆序对
        int right = -1;
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            } else {
                right = i;
            }
        }
        //3、从右边开始找左逆序对
        int left = -1;
        int min = array[array.length - 1];
        for (int i = array.length - 2; i >= 0; i--) {
            if (array[i] < min) {
                min = array[i];
            } else {
                left = i;
            }
        }
        return new int[]{left,right};
    }


    private static class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
