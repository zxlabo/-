package com.排序算法;

import java.util.Arrays;

public class _冒泡排序 {
    public static void main(String[] args) {
        int[] array = new int[10];
        for (int i = 0; i < 10; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        System.out.println(Arrays.toString(array));
        bubbleSort2(array);
        System.out.println(Arrays.toString(array));

    }

    private static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j);
                }
            }
        }
    }

    private static void bubbleSort2(int[] array) {
        //外层循环表示，已经排好序的
        for (int i = array.length-1; i > 0; i--) {
            int sorted=1;
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j);
                    sorted=j+1;
                }
            }
            i=sorted;
        }
    }

    private static void swap(int[] array, int j) {
        int temp = array[j];
        array[j] = array[j + 1];
        array[j + 1] = temp;
    }

}
