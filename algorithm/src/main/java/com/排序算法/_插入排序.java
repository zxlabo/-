package com.排序算法;

import java.util.Arrays;

public class _插入排序 {
    /**
     * 将数组分成已排好序和未排好序的区间，前面是已排好序的，后面是未排好序的。
     * 取未排好序的第一个value，然后和已排好序的最后一个开始比较。
     * 当value比当前数值大的时候，
     */
    public static void main(String[] args) {
        int[] array = new int[10];
        for (int i = 0; i < 10; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        System.out.println(Arrays.toString(array));
        insertSort(array);
        System.out.println(Arrays.toString(array));

    }

    private static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            //未排好序的前一个，就是已排好序的。
            int value = array[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (value > array[j]) {

                    break;
                } else {
                    array[j + 1] = array[j];
                }
            }
            array[j + 1] = value;
        }
    }
}
