package com._02_算法._01_排序算法;

/**
 * 选择排序
 * 从序列中找出最大元素，与末尾元素交换位置。执行完一轮之后，末尾元素就是最大元素。
 * 选择排序的交换次数，要远远少于冒泡排序，平均性能要优于冒泡排序。
 * 选择排序是不稳定排序，是原地排序。
 * 时间复杂度o(n2),空间复杂度o(1)
 */

public class _02_选择排序<T extends Comparable<T>> extends Sort<T> {

    @Override
    protected void sort() {
        for (int end = array.length - 1; end > 0; end--) {
            //从未排好序的数组中，找到最大值，和end交换位置
            int max = 0;
            for (int begin = 1; begin <= end; begin++) {
                if (cmp(max, begin) < 0) {
                    max = begin;
                }
            }
            swap(max, end);
        }
    }

}
