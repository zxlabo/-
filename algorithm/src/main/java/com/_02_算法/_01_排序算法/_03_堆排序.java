package com._02_算法._01_排序算法;

/**
 * 堆排序可以认为是对选择排序的一种优化；
 * 执行流程：
 * 1、对序列进行原地建堆；
 * 2、重复执行以下步骤，直到heapSize为1；
 * a：交换堆顶与末尾元素；b：堆的heapSize-1；c：siftDown(0)
 * 堆排序是不稳定排序，是原地排序。
 * 时间复杂度o(nLogn),空间复杂度o(1)
 */
public class _03_堆排序<T extends Comparable<T>> extends Sort<T> {

    private int heapSize;

    /**
     * 思路
     * 1、对数组进行原地建堆
     * 2、重复以下操作，知道heapSize==1
     * 1）交换0和heapSize-1 元素，此时最大值到了末尾
     * 2）heapSize--；
     * 3）对当前0位置的元素进行下滤
     */
    @Override
    protected void sort() {
        this.heapSize = array.length;
        //1、对数组原地建堆，从非叶子节点开始，从后往前依次下滤
        for (int i = (heapSize >> 1) - 1; i >= 0; i--) {
            siftDown(i);
        }
        while (heapSize != 1) {
            swap(0, heapSize - 1);
            heapSize--;
            siftDown(0);
        }
    }

    private void siftDown(int index) {
        //1、只有非叶子节点才需要下滤
        int leaf=heapSize>>1;
        T element = array[index];
        while(index<leaf){
            //找到当前节点的最大子节点
            int leftIndex=(index<<1)+1;
            T max=array[leftIndex];
            int rightIndex=leftIndex+1;
            int maxIndex=leftIndex;
            if (rightIndex<heapSize&&cmp(rightIndex,leftIndex)>0){
                max = array[rightIndex];
                maxIndex=rightIndex;
            }
            if (cmp(element,max)>0){
                break;
            }
            array[index]=max;
            index=maxIndex;
        }
        array[index]=element;
    }

}
