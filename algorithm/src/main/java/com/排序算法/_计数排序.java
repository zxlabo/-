package com.排序算法;

/**
 * desc：
 * 计数排序不是基于比较的排序，是典型的用空间换时间
 * 计数排序适合对一定范围内的整数进行排序。
 * 计数排序的核心思想是：统计每个整数在序列中的次数，然后根据索引和次数进而推导出每个整数在有序序列的索引。
 * 时间复杂度O(n+k)，空间复杂度O(n+k)。k是序列中整数的取值范围，是稳定排序。
 * 计数排序是稳定排序，不是原地排序。
 */
class _计数排序 extends Sort {
    @Override
    protected void sortImpl(Integer[] arr) {
        countSort(arr);
    }

    /**
     * 计数排序的思想是：
     * 1、统计每个整数在序列中的次数，然后根据索引和次数进而推导出每个整数在有序序列的索引。
     * 2、计数排序不是比较排序。
     * 3、适应场景：适合对一定范围内的整数进行排序；
     * 思路
     * 1、为统计数组开辟内存空间：
     *    求出序列array的最大值和最小值，根据最值，计算统计数组的大小 len=max-min+1。
     *    int[] counts = new int[max - min + 1];
     * 2、统计array中每个整数出现的次数
     *    遍历序列array，每个整数对应统计数组的索引：index= array[i] - min；counts[index]++;
     * 3、counts累加次数：也就是counts从头开始累加。
     *    假设：array中的元素 k，在array的索引是i；
     *         那么：k在counts对应的索引是：array[i]-min；
     *         那么：k在有序序列中对应的索引是：counts[k – min] – p，p 代表着是倒数第几个 k
     *    理解：假设counts[3]：存储的是8出现的次数，我们现在要统计的是 <=8的整数出现的所有次数。
     *         当我们计算出了<=8对应的次数，假设是9次，也就得到了8在有序序列的索引，索引是9-1；-1是因为倒数第1个8；
     * 4、开辟有序序列 newArray，它的作用是：存储排好序的数据；
     * 5、倒序遍历array，根据在counts的次数，计算在有序序列newArray的索引，并给对应的newArray赋值
     *    为什么倒序遍历呢？为了保证计数排序算法的稳定性
     *    newArray[--counts[array[i] - min]] = array[i];
     * 6、最后把有序数组的值全部赋值给array；
     */
    private void countSort(Integer[] arr) {
        //1、计算当前arr的最大值和最小值
        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println("min:" + min + ",max:" + max);
        //2、为统计数组开辟内存空间
        int[] counts = new int[max - min + 1];
        //3、统计每个整数在序列中出现的次数
        for (int i = 0; i < arr.length; i++) {
            //计算当前整数在统计数组对应的索引
            int index = arr[i] - min;
            //counts默认为0，每出现一次，加一。
            counts[index]++;
        }
        //4、累计小于等于当前整数的次数
        for (int i = 1; i < counts.length; i++) {
            // counts[i] = counts[i] + counts[i - 1];
            counts[i] += counts[i - 1];
        }
        //5、根据次数，计算array中整数对应的有序序列的索引
        //6、创建有序序列
        int[] newArray = new int[arr.length];
        //7、倒序遍历array，为了保证稳定性。
        // 假如有两个值相等的数：8a、8b，8b在8a的后面。
        // 倒序遍历计算索引，可以保证在有序数组8b仍然在8a的后面。
        for (int i = arr.length - 1; i >= 0; i--) {
//            //8、计算当前整数在统计数组counts的索引
//            int index=arr[i] - min;
//            //9、从统计数组中获取小于等于当前整数的整数，一共出现的次数
//            int count = counts[index];
//            //10、那么当前整数在有序数组的的索引是 count-1,给有序数组赋值
//            newArray[count - 1] = arr[i];
//            //11、我们需要将次数减一
//            counts[index]--;
            //对上面代码优化为
            newArray[--counts[arr[i] - min]] = arr[i];
        }
        //12、最后将有序数组赋值给arr
        for (int i = 0; i < arr.length; i++) {
            arr[i] = newArray[i];
        }
    }
}
