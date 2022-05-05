package com.排序算法;

import java.util.Arrays;

/**
 * 基数排序
 * 基数排序非常适合整数排序，尤其是非负整数。
 * 执行流程：
 * 1、依次对个位数、十位数、百位数、千位数、、、进行排序，从低位到高位；
 * 2、个位数、十位数的取值范围是[0,9)，可以使用计数排序对它们进行排序；
 * 是稳定排序，不是原地排序。
 */
class _基数排序 {
    private static int[] array;

    public static void main(String[] args) {
        int[] a = {126, 69, 593, 23, 6, 89, 54, 8};
        array = a;
        radixSort();
        System.out.println(Arrays.toString(array));
    }

    /**
     * 基数排序
     * 1、先找到最大值
     * 2、依次对array的个位数、十位数、百位数、千位数、、、进行排序
     */

    private static void radixSort() {
        //1、先找到最大值
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        // 1234
        // 个位数 = (1234/1)%10;
        // 十位数 = (1234/10)%10;
        // 百位数 = (1234/100)%10;
        //2、依次对array的个位数、十位数、百位数、千位数、、、进行排序
        for (int divider = 1; divider <= max; divider *= 10) {
            sort(divider);
        }
    }
    /**
     * 计数排序的思想是：
     * 1、统计每个整数在序列中的次数，然后根据索引和次数进而推导出每个整数在有序序列的索引。
     * 2、计数排序不是比较排序。
     * 3、适应场景：适合对一定范围内的整数进行排序；
     * 思路
     * 1、求出序列array的最大值和最小值，根据最值，计算统计数组的大小 len=max-min+1。
     * 2、为统计数组开辟内存空间：int[] counts = new int[max - min + 1];
     * 3、遍历序列array，统计array中每个整数出现的次数。整数对应统计数组的索引：index= array[i] - min；
     * 4、我们需要计算当前整数在有序序列的索引。怎么实现呢？
     * 5、counts累加次数：计算小于等于当前整数在array中出现的次数，也就是counts从头开始累加。
     *    假设：array中的元素 k，在array的索引是i；
     *    那么：k在counts对应的索引是：array[i]-min；
     *    那么：k在有序序列中对应的索引是：counts[k – min] – p，p 代表着是倒数第几个 k
     * 6、倒序遍历array（为什么倒序遍历呢？为了保证计数排序算法的稳定性），
     *    假设array[i]的值为k，那么k在有序数组的索引是：counts[k – min] – p，p 代表着是倒数第几个 k
     * 7、给有序数组赋值：newArray[--counts[array[i] - min]] = array[i];
     * 8、最后把有序数组的值全部赋值给array；
     */
    /**
     * 对数组进行计数排序
     */
    private static void sort(int divider) {
        //1、为统计数组开辟空间，因为是个位数，所以取值范围在[0,9)
        int[] counts = new int[10];
        //2、统计每个整数对应位数出现的次数
        for (int i = 0; i < array.length; i++) {
            //当divider=1，就是求array[i]的个位数，如果是10，就是求的十位数；
            int countIndex = array[i] / divider % 10;
            counts[countIndex]++;
        }
        //3、累加次数
        for (int i = 1; i < counts.length; i++) {
            counts[i] += counts[i - 1];
        }
        //4、创建新数组
        int[] newArray = new int[array.length];
        //5、倒序遍历当前数组，根据数值计算它在有序序列的索引。
        for (int i = array.length - 1; i >= 0; i--) {
            int countIndex = array[i] / divider % 10;
            newArray[--counts[countIndex]]=array[i];
        }
        //6、把newArray全部数据迁移到array
        for (int i=0;i<array.length;i++){
            array[i] = newArray[i];
        }
    }

}
