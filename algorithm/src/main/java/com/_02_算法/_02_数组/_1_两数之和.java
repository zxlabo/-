package com._02_算法._02_数组;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/two-sum/
 */
public class _1_两数之和 {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] array = new _1_两数之和().twoSum(nums, target);
        if (array != null) {
            System.out.println(Arrays.toString(array));
        }
    }

    public int[] twoSum(int[] nums, int target) {
        /**
         * 本题思路：
         * 用HashMap存储，key为数值，value是索引
         */
        //1、边界判断
        if (nums==null||nums.length<=1){
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap();
        for (int i=0;i<nums.length;i++){
            int value = nums[i];
            Integer index = map.get(target-value);
            if (index!=null){
                return new int[]{index,i};
            }
            map.put(value, i);
        }
        return null;
    }

}
