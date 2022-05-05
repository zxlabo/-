package com.排序算法;

import java.util.Arrays;

/**
 * 插入排序类似玩扑克牌
 * 1、将序列分为2部分，前面的是已排好序的，后面的是待排序的。
 * 2、从头遍历待排序序列，取出元素。然后从已排好序的序列中找到合适位置，插入。
 * 插入排序的时间复杂度与逆序对数量成正比关系。
 * 插入排序是稳定排序，是原地排序。
 * 时间复杂度o(n2),空间复杂度o(1)
 * 二分搜索：只能减少了比较次数，时间复杂度仍然是o(n2)；
 */
public class _插入排序 {

    public static void main(String[] args) {
        int[] array = {79, 80, 94, 43, 79, 40, 40, 40, 40};
        System.out.println("排序前" + Arrays.toString(array));
        insertSort(array);
        System.out.println("排序后" + Arrays.toString(array));
    }

    /**
     * 插入排序
     * 将数组分为未排好序和已排好序两部分。
     * 取出未排好序的第一个元素，和已排好序的元素进行比价。找到合适的位置插入。
     */
    private static void insertSort(int[] array) {
        if (array == null || array.length < 2) return;
        for (int begin = 1; begin < array.length; begin++) {
            //从[0,begin)找到元素的插入位置
            int insertIndex = binarySearch(array, begin);
            //将begin的数据插入到insertIndex位置
            insertValue(array, begin, insertIndex);
        }
    }

    private static void insertValue(int[] array, int begin, int insertIndex) {
        int currentValue = array[begin];
        //将[searchIndex,begin)的元素后移
        for (int j = begin - 1; j >= insertIndex; j--) {
            array[j + 1] = array[j];
        }
        //将值插入到待插入位置
        array[insertIndex] = currentValue;
    }

    /**
     * 1、先采用普通的搜索进行搜索
     * 普通搜索，就是从index前面一个位置开始遍历。找到第一个<=它的索引。那么插入位置就是索引+1；
     */
    private static int search(int[] array, int index) {
        //普通搜索，就是从index前面一个位置开始遍历。找到第一个<=它的索引。那么插入位置就是索引+1；
        int current = index - 1;
        while (current >= 0 && (array[current] > array[index])) {
            current--;
        }
        return current + 1;

    }

    /**
     * 采用二分搜索进行搜索
     * int v=array[index];
     * 从[begin,end)去搜索第一个比v大的索引；
     * 先计算mid，
     * 如果v<array[mid],就从[begin,mid)找
     * 否则，也就是v>=array[mid],就从[mid+1,end)
     */
    private static int binarySearch(int[] array, int index) {
        int begin = 0;
        int end = index;
        while (begin < end) {
            int mid = (begin + end) >> 1;
            if (array[index] < array[mid]) {
                end = mid;
            } else {
                begin = mid + 1;
            }
        }
        //此时begin==end
        return begin;
    }

}
