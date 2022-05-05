package com.排序算法;

import java.util.Arrays;

/**
 * 选择排序
   从序列中找出最大元素，与末尾元素交换位置。执行完一轮之后，末尾元素就是最大元素。
   选择排序的交换次数，要远远少于冒泡排序，平均性能要优于冒泡排序。
   选择排序是不稳定排序，是原地排序。
   时间复杂度o(n2),空间复杂度o(1)
 */
public class _选择排序 {

    public static void main(String[] args) {
        int[] array = {79, 80, 94, 43, 79, 40, 40, 40, 40,94,94,94};
        System.out.println(Arrays.toString(array));
        selectSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void selectSort(int[] array) {
        for (int end = array.length -1; end > 0; end--) {
            //从未排好序的数组中，找到最大值，和end交换位置
            int maxIndex = 0;
            for (int begin = 1; begin <=end; begin++) {
                if (array[begin]>=array[maxIndex]){
                    maxIndex = begin;
                }
            }
            swap(array, maxIndex, end);
        }
    }

    private static void swap(int[] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
