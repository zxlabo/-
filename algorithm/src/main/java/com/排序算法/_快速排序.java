package com.排序算法;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class _快速排序 {
    /**
     * 从数组中，随机找一个点，作为轴点。小于轴点的放左边，大于轴点的放右边。然后递归。
     */
    public static void main(String[] args) {
        char[] chars = "".toCharArray();
        int[] array = new int[10];
        for (int i = 0; i < 10; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        System.out.println(Arrays.toString(array));
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void quickSort(int[] array) {



    }

}
