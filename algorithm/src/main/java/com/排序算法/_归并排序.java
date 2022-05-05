package com.排序算法;

/**
 使用递归：
    1、不断的将当前序列平均分割成2个子序列，直到序列中元素数量为1；
    2、不断的将2个子序列合并成一个有序序列，直到合并成一个序列。
    时间复杂度o(nLogn)，空间复杂度 O(n)；
    归并排序的空间复杂度是 O( n/2 + logn )= O(n),n/2 用于临时存放左侧数组，logn 是因为递归调用
    是稳定排序，不是原地排序。
 */
class _归并排序 extends Sort {

    /**
     * 归并排序
     * 1、不断的将当前数组平均切割成2个子序列，直到不能切割，也就是只剩一个元素；
     * 切割完之后
     * 2、不断的将两个子序列合并成一个有序数组，直到只剩下一个数组
     */
    private int[] leftArr;

    @Override
    protected void sortImpl(Integer[] arr) {
        leftArr = new int[arr.length >> 1];
        int begin = 0;
        int end = arr.length;
        mergeSort(arr, begin, end);
    }

    /**
     * [begin,end)左闭右开。数组的len=end-begin；
     * 左边[begin,mid),右边[mid,end)
     */
    private void mergeSort(Integer[] arr, int begin, int end) {
        //当数组只剩小于一个元素的时候，退出递归
        if (end - begin <= 1) return;
        int mid = (end + begin) >> 1;
        //不断的将当前数组平均切割成2个子序列，直到不能切割，也就是只剩一个元素；
        mergeSort(arr, begin, mid);
        mergeSort(arr, mid, end);
        //分割完之后，进行合并
        merge(arr, begin, mid, end);
    }

    /**
     * 将2个子序列合并成一个有序的序列
     * leftArr li(索引)、le(结束的索引)
     * rightArr ri、re
     * 有序序列： ai
     * 1、首先计算上面的索引
     * 2、将左子序列复制一份出来
     * 3、比较左右子序列，比较小的插入到有序序列中。
     */
    private void merge(Integer[] arr, int begin, int mid, int end) {
        int li = 0;
        int le = mid - begin;
        int ri = mid;
        int re = end;
        int ai = begin;
        //拷贝左序列
        for (int i = li; i < le; i++) {
            leftArr[i] = arr[begin + i];
        }
        //当左边的序列，没有的时候。退出循环。也就是
        while (li < le) {
            //当左边小于等于右边的时候，将左边的数据插入到有序序列中；
            //为什么是包含等于呢？为了保证有序性。等于的话，左边的插在前面。
//            if (leftArr[li]<=arr[ri]){
//                arr[ai++] = leftArr[li++];
//            }else {
//                //此时需要注意 右边越界 。为了好算，我们转换一下。
//                arr[ai++] = arr[ri++];
//            }
            //保证右边索引不越界 && 右边的小于左边的
            if (ri < re && arr[ri] < leftArr[li]) {
                arr[ai++] = arr[ri++];
            } else {
                arr[ai++] = leftArr[li++];
            }
        }
    }
}
