package com.算法题;

/**
 * https://leetcode-cn.com/problems/sort-colors/
 */
public class _75_颜色分类 {
    public void sortColors(int[] nums) {
        // 采用三指针思想
        int l = 0;
        int r = nums.length - 1;
        int i = 0;
        // 如果nums[i]==0，交换i和l，i++,l++
        while (i <= r) {
            if (nums[i] == 0) {
                swap(nums, i++, l++);
            } else if (nums[i] == 1) {
                // 如果nums[i]==1，什么都不做
                i++;
            } else {
                //如果nums[i]==2，交换i和r，r--
                swap(nums, i, r--);
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
