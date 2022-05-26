package com._02_算法.排序算法;

import java.util.Arrays;

/**
 * 堆排序可以认为是对选择排序的一种优化；
 * 执行流程：
 * 1、对序列进行原地建堆；
 * 2、重复执行以下步骤，直到heapSize为1；
 * a：交换堆顶与末尾元素；b：堆的heapSize-1；c：siftDown(0)
 * 堆排序是不稳定排序，是原地排序。
 * 时间复杂度o(nLogn),空间复杂度o(1)
 */
class _堆排序 {
    private static int[] array;

    public static void main(String[] args) {
        int[] num = {79, 80, 94, 43, 79, 40, 40, 40, 40};
        array = num;
        System.out.println(Arrays.toString(array));
        heapSort();
        System.out.println(Arrays.toString(array));
    }

    /**
     * 堆排序是选择排序的一种优化
     * 选择排序是从未排好序的数组中找到最大的元素和末尾元素进行交换位置；
     * 堆：是先将数组建堆，然后堆顶就是最大的元素。取出堆顶元素，然后进行下滤。
     */
    private static int heapSize;

    private static void heapSort() {
        heapSize = array.length;
        //1、将数组建堆，进行堆化
        //从非叶子节点开始，依次向下下滤。 叶子节点=heapSize>>1;
        for (int i = (heapSize >> 1) - 1; i >= 0; i--) {
            siftDown(i);
        }
        //2、开启while循环，将堆顶元素和末尾元素进行交换位置
        while (heapSize > 1) {
            //将堆顶元素和末尾元素进行交换位置
            swap(array, 0, heapSize - 1);
            heapSize--;
            //对新的堆顶元素进行下滤，重新堆化
            siftDown(0);
        }
    }

    /**
     * 下滤
     */
    private static void siftDown(int index) {
        //1、求出第一个叶子节点，只有非叶子节点才需要下滤。
        int current = array[index];
        int half = heapSize >> 1;
        while (index < half) {
            //比较当前元素和它的子节点。如果当前元素小于子节点，需要交换位置
            int childIndex = (index << 1) + 1;//左子节点
            int child = array[childIndex];
            int rightIndex = childIndex + 1;
            //找到左右子节点最大的节点
            if (rightIndex < heapSize && array[rightIndex] > child) {
                child = array[childIndex = rightIndex];
            }
            //如果当前元素大于子节点，那么break，不需要下滤
            if (current >= child) break;
            /**
             * 当前元素小于子节点，进行下滤。
             * 1、子节点数据赋值给当前元素
             * 2、当前索引下移
             */
            array[index] = child;
            index = childIndex;
        }
        array[index] = current;

    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


}
