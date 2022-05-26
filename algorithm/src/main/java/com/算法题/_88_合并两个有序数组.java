package com.算法题;

import com.helper.AlgorithmUtils;

public class _88_合并两个有序数组 {

    public static void main(String[] args) {
        int[] num1 = {4, 5, 6, 0, 0, 0};
        int[] num2 = {1, 2, 3};
        merge(num1, 3, num2, 3);
        System.out.println(AlgorithmUtils.integerArrayToString(num1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null) {
            return;
        }
        // 有3个索引，分别标识nums1有效数组右边索引、num2右边索引、num排序的索引
        int i1 = m - 1;
        int i2 = n - 1;
        int index = m + n - 1;
        while (i2 >= 0) {
            if (i1 >= 0 && nums2[i2] < nums1[i1]) {
                nums1[index--] = nums1[i1--];
            } else {
                nums1[index--] = nums2[i2--];
            }
        }
    }

    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null) {
            return;
        }
        // 有3个索引，分别标识nums1有效数组右边索引、num2右边索引、num排序的索引
        int i1 = m - 1;
        int i2 = n - 1;
        int index = m + n - 1;
        while (i2 >= 0 || i1 >= 0) {
            if (i2 < 0) {
                break;
            }
            if (i1 < 0) {
                nums1[index--] = nums2[i2--];
            } else {
                if (nums2[i2] > nums1[i1]) {
                    nums1[index--] = nums2[i2--];
                } else {
                    nums1[index--] = nums1[i1--];
                }
            }
        }
    }

}
