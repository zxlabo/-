package com._02_算法._01_排序算法;

/**
 * desc：从头开始依次比较相邻两个元素，如果前面的比后面的大就交换他们的位置。
 * 经过一轮比较，最大元素排到了末尾。
 * 冒泡排序是稳定排序，是原地排序。
 * 时间复杂度o(n2),空间复杂度o(1)
 */
public class _01_冒泡排序<T extends Comparable<T>> extends Sort<T> {

    @Override
    protected void sort() {
        for (int end = array.length - 1; end > 0; end--) {
            int sortedIndex = 1;//记录上一次已经排好序的索引
            //从头开始依次比较相邻两个元素，经过一轮比较，最大元素排到了末尾。
            for (int begin = 1; begin <= end; begin++) {
                // if (array[begin] < array[begin - 1]) {
                if (cmp(begin, begin - 1) < 0) {
                    swap(begin, begin - 1);
                    sortedIndex = begin;
                }
            }
            end = sortedIndex;
        }
    }

}
