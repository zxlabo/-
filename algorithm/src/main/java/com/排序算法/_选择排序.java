package com.排序算法;

import java.util.Arrays;

public class _选择排序 {
    /**
     * 分成已排序和未排序，后面是已排好序的。
     * 从未排序数组中找到最大数，和未排序最后位置进行交换
     */
    public static void main(String[] args) {
        int[] array = new int[10];
        for (int i = 0; i < 10; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        System.out.println(Arrays.toString(array));
        selectSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void selectSort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            int maxIdx = 0;
            for (int j = 1; j <= i; j++) {
                if (array[j] > array[maxIdx]) {
                    maxIdx = j;
                }
            }
            int temp = array[maxIdx];
            array[maxIdx] = array[i];
            array[i] = temp;
        }
    }
}
