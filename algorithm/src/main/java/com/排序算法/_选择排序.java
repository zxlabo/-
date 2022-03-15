package com.排序算法;

import java.util.Arrays;

public class _选择排序 {

    public static void main(String[] args) {
        int[] array = {79, 80, 94, 43, 40};
        System.out.println(Arrays.toString(array));
        selectSort(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 将数组分为未排好序和已排好序，从未排好序的选择最大的数，和最后面一个交换位置
     */
    private static void selectSort(int[] array) {
        for (int i=0;i<array.length;i++){
            int maxIndex=0;
            for(int j=1;j<array.length-i;j++){
                if (array[j]>array[maxIndex]){
                    maxIndex=j;
                }
            }
            int temp = array[maxIndex];
            array[maxIndex]=array[array.length-1-i];
            array[array.length - 1 - i] = temp;
        }
    }

}
