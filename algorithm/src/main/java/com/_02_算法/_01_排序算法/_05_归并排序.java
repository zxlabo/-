package com._02_算法._01_排序算法;

/**
  归并排序，使用递归
  1、不断的将当前数组平均切割成2个子序列，直到不能切割，也就是只剩一个元素；
  切割完之后
  2、不断的将两个子序列合并成一个有序数组，直到只剩下一个数组
  时间复杂度o(nLogn)，空间复杂度 O(n)；是稳定排序，不是原地排序。
  空间复杂度是 O( n/2 + logn )= O(n),n/2 用于临时存放左侧数组，logn 是因为递归调用
 */
@SuppressWarnings("unchecked")
public class _05_归并排序<T extends Comparable<T>> extends Sort<T> {
    private T[] leftArray;

    /**
     * 归并排序
     * 1、不断的将当前数组平均切割成2个子序列，直到不能切割，也就是只剩一个元素；
     * 切割完之后
     * 2、不断的将两个子序列合并成一个有序数组，直到只剩下一个数组
     */

    @Override
    protected void sort() {
        leftArray = (T[]) new Comparable[array.length >> 1];
        sort(0, array.length);
    }

    // T(n) = T(n/2) + T(n/2) + O(n)

    /**
     * 对 [begin, end) 范围的数据进行归并排序
     */
    private void sort(int begin, int end) {
        if (end - begin < 2) return;
        int mid = (begin + end) >> 1;
        sort(begin, mid);
        sort(mid, end);
        merge(begin, mid, end);
    }

    /**
     * 将 [begin, mid) 和 [mid, end) 范围的序列合并成一个有序序列
     */
    private void merge(int begin, int mid, int end) {
        int li = 0, le = mid - begin;
        int ri = mid, re = end;
        int ai = begin;

        // 备份左边数组，因为左边的数组会被覆盖。
        for (int i = li; i < le; i++) {
            leftArray[i] = array[begin + i];
        }
        // 如果左边还没有结束
        while (li < le) {
            if (ri < re && cmp(array[ri], leftArray[li]) < 0) {
                array[ai++] = array[ri++];
            } else {
                array[ai++] = leftArray[li++];
            }
        }
    }
}
