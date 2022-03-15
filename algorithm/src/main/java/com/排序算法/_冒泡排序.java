package com.排序算法;

import java.util.Arrays;

public class _冒泡排序 {
    /**
     * 从头开始依次比较相邻两个元素，经过一轮比较，最大元素排到了末尾。
     */
    public static void main(String[] args) {
        int[] array = {79, 80, 94, 43, 40};
        System.out.println(Arrays.toString(array));
        bubbleSort(array);
        System.out.println(Arrays.toString(array));

    }

    private static void bubbleSort(int[] nums) {
        //1、外层循环控制循环的次数
        for (int i = 0; i < nums.length; i++) {
            //2、内层循环控制 两个数依次进行比较
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }


}
