package com.排序算法;

import java.util.Arrays;

/**
 * desc：从头开始依次比较相邻两个元素，如果前面的比后面的大就交换他们的位置。
 * 经过一轮比较，最大元素排到了末尾。
 * 冒泡排序是稳定排序，是原地排序。
 * 时间复杂度o(n2),空间复杂度o(1)
 */
public class _冒泡排序 {

    public static void main(String[] args) {
        int[] array = {79, 80, 94, 43, 79, 40, 40, 40, 40, 94, 94, 94};
        System.out.println(Arrays.toString(array));
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void bubbleSort(int[] nums) {
        for (int end = nums.length - 1; end > 0; end--) {
            int sortIndex = 0;//记录上一次已经排好序的索引
            //从头开始依次比较相邻两个元素，经过一轮比较，最大元素排到了末尾。
            for (int begin = 0; begin < end; begin++) {
                if (nums[begin + 1] < nums[begin]) {
                    swap(nums, begin, begin + 1);
                    sortIndex = begin + 1;
                }
            }
            end = sortIndex;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
