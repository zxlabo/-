package com.算法题;

import java.util.Stack;

public class _739_每日温度 {
    public int[] dailyTemperatures(int[] temperatures) {
        // 进行安全边界校验
        if (temperatures == null || temperatures.length == 0) {
            return null;
        }
        //这道题的目的是：求当前value的右边第一个比它大的数的索引和它的索引的差值
        //思路：使用栈+数组实现
        // 1、遍历数组，
        // 2、将当前value和栈顶的value进行比较
        //2-1：如果当前value小于栈顶value，将当前索引push到栈
        //2-2：如果当前value大于栈顶value，此时当前value就是：栈顶数据右边第一个比它大的数。
        //栈顶数据的索引对应的就是：当前的索引-栈顶数据的索引
        // 将栈顶数据弹出，继续步骤2
        Stack<Integer> stack = new Stack<>();
        int[] nums = new int[temperatures.length];
        int i = 0;
        while (i < temperatures.length) {
            if (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                nums[stack.peek()] = i - stack.peek();
                stack.pop();
            } else {
                stack.push(i);
                i++;
            }
        }
        return nums;
    }
}
