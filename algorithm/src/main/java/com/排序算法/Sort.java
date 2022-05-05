package com.排序算法;

/**
 * author : Naruto
 * date   : 2022/5/3
 * desc   :
 * version:
 */
abstract class Sort {
    public void sort(Integer[] arr){
        sortImpl(arr);
    }

    protected abstract void sortImpl(Integer[] arr);

    protected static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
