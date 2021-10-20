package com.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/two-sum/
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 */
public class _1_两数之和 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 18;
        int[] array = getIndex(nums, target);
        if (array != null) {
            System.out.println(Arrays.toString(array));
        }
    }

    private static int[] getIndex(int[] nums, int target) {
        if (nums == null) {
            return null;
        }
        // 用来存放之前扫描过的元素
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int temp = target - num;
            Integer index = (Integer) map.get(temp);
            if (index != null) {
                return new int[]{index, i};
            } else {
                map.put(num, i);
            }
        }
        return null;
    }

}
