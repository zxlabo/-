package com.排序算法;

import java.util.ArrayList;
import java.util.List;

/**
 1、根据数组长度，计算步长序列。（希尔：数组长度一直除以2，直到1）；
 2、遍历步长序列，假设当前遍历值为cols。
 3、把数组分成cols列，然后对每一列进行插入排序。（因为希尔排序就是逆序对不断减少的过程，也可以认为希尔排序是对插入排序的优化）
 注意：当数组分成1列的时候，排序之后，肯定保证是有序的。前面的列数是为了减少逆序对，提升插入排序的效率。
 希尔排序是原地排序，是不稳定排序。
 希尔排序空间复杂度O(1),空间复杂度和步长序列有关。
 */
class _希尔排序 extends Sort{
    @Override
    protected void sortImpl(Integer[] arr) {
        shellSort(arr);
    }

    /**
     * 希尔排序
     * 1、首先根据数组长度，计算步长序列（倒序 从大到小）；
     * 2、遍历步长序列，依次对每一列进行排序。
     */
    private void shellSort(Integer[] arr) {
        //1、根据数组长度，计算倒序的步长序列。
        List<Integer> stepList=getStepList(arr.length);
        System.out.println(stepList);
        //2、遍历步长序列，依次对每一列进行插入排序。因为是逆序对
        for (int i=0;i<stepList.size();i++){
            //当前数组要分成几列:columns列
            Integer columns = stepList.get(i);
            sort(columns, arr);
        }
    }

    /**
     * 1、将数组分成cols列
     * 2、然后对每一列进行排序
     * 3、步长step=列数
     */
    private void sort(Integer cols, Integer[] arr) {
        int step = cols;
        //对每一列进行排序
        for (int col=0;col<cols;col++){
           sortSingleCol(arr, step, col);
        }
    }

    /**
     * 对当前列的元素进行插入排序
     * @param arr
     * @param step 步长=列数
     * @param col  当前列
     * 那当前列的元素有哪些呢
     * 第0行第col列：col
     * 第1行第col列：col+step
     * 第2行第col列：col+step*2
     */
    private void sortSingleCol(Integer[] arr, int step, int col) {
        for (int begin = col + step; begin< arr.length; begin+= step){
            int cur=begin;
            /**
             * 插入排序：取出未排好序的第一个，依次和已经排好序的进行比较。
             * 如果当前元素小于前面的元素，和前面的元素交换位置
             */
            while(cur> col && arr[cur]< arr[cur- step]){
                swap(arr,cur,cur- step);
                cur-= step;
            }
        }
    }

    private void swap(Integer[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private List<Integer> getStepList(int length) {
        ArrayList<Integer> list = new ArrayList<>();
        while ((length=(length>>1))>0){
//        while ((length >>= 1)>0){
            list.add(length);
        }
        return list;

    }
}
