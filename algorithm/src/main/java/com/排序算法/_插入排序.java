package com.排序算法;

import java.util.Arrays;

public class _插入排序 {

    public static void main(String[] args) {
        int[] array = {79, 80, 94, 43, 79, 40};
        System.out.println("排序前"+Arrays.toString(array));
        insertSort(array);
        System.out.println("排序后"+Arrays.toString(array));
    }
    /**
     * 将数组分为已排序和未排序，将未排序的第一个，从已排序的末尾开始比较，选择合适的位置插入。
     */
    private static void insertSort(int[] array){
        //表示未排好序的
        for (int i=1;i<array.length;i++){
            int value = array[i];
            int j=i-1;
            for (;j>=0;j--){
                //如果value比当前数小，那么当前数要后移一位。否则将value插入到当前数的后面。
                if (value<array[j]){
                    array[j + 1] = array[j];
                }else{
                    break;
                }
            }
            array[j+1]=value;
        }
    }



}
