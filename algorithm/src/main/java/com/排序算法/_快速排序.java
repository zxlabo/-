package com.排序算法;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class _快速排序 {
    /**
     * 从数组中，随机找一个点，作为轴点。小于轴点的放左边，大于轴点的放右边。然后递归。
     */
    public static void main(String[] args) {
        int[] array = {79, 80, 94, 43, 79,40};
        System.out.println(Arrays.toString(array));
        quickSort(0,array.length-1,array);
        System.out.println(Arrays.toString(array));
    }
    private static void quickSort(int begin,int end,int[] array){
        if(begin>=end){
            return;
        }
        int pivotIndex=getPivotIndex(begin,end,array);
        quickSort(begin,pivotIndex-1,array);
        quickSort(pivotIndex+1,end,array);
    }
    private static int getPivotIndex(int begin,int end,int[] array){
        //1、先记录轴点数据
        int pivotValue = array[begin];
        //2、开启循环，进行数据验证。小的在左边，大的在右边
        while (begin<end){
            // 先从右边开始，如果右边的数大于 pivotValue，往左走。否则换边
            while (begin<end){
                if (array[end]>=pivotValue){
                    end--;
                }else {
                    array[begin] = array[end];
                    begin++;
                    break;
                }
            }
            while(begin<end){
                if (array[begin]<pivotValue){
                    begin++;
                }else {
                    array[end]=array[begin];
                    end--;
                    break;
                }
            }
        }
        array[begin]=pivotValue;
        return begin;
    }



}
