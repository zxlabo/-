package com.algorithm;

/**
 * author : Naruto
 * date   : 2021/9/26
 * desc   :
 * https://leetcode-cn.com/problems/move-zeroes/
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */
public class _283_移动零 {

    public static void main(String[] args) {
        int[] arrays = new int[]{1, 10, 2, 0, 3, 5, 0, 6, 9};
        for (int i=0;i<arrays.length;i++){
            System.out.print(arrays[i] + ",");
        }
        moveZero(arrays);
        System.out.println("移动后");
        for (int i=0;i<arrays.length;i++){
            System.out.print(arrays[i] + ",");
        }
    }

    /**
     * 1、将所有的0移动到数组的末尾，我们通过互斥思想。将所有的非0元素移动到前面就可以了
     * 2、创建变量zeroIndex,标识左边第一个0的索引。
     * 3、当碰到非0元素的时候，和零元素交换位置。
     */
    private static void moveZero(int[] arrays) {
        if (arrays.length == 0) return;
        for (int i = 0, cur = 0; i < arrays.length ; i++) {
            if (arrays[i] == 0) {
                continue;
            }
            if (cur != i) {
                arrays[cur] = arrays[i];
                arrays[i] = 0;
            }
            cur++;
        }
    }

}
