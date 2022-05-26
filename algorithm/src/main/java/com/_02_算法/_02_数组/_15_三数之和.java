package com._02_算法._02_数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15_三数之和 {
    public static void main(String[] args) {

        int[] nums ={0,0,0};
        threeSum(nums);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        //1、进行边界检查
        if (nums == null) {
            return null;
        }
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length < 3) {
            return list;
        }
        //2、进行排序
        Arrays.sort(nums);
        /**
         * 1、暴力法 复杂度 n的三次方
         * 2、采用三指针的方法。
         * 当前指针 i、左指针l，有指针 r
         * 当 i+l+r==0，正好，记录下来。然后 l++，r--；
         * 当 i+l+r<0,说明l小了。l要加一
         * 否则，是r大了，r要减一。
         * 3、注意过滤重复值
         */
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            if (i>0&&nums[i]==nums[i-1]){
                continue;
            }
            int l = i + 1;
            int r = len - 1;
            while (l < r) {
                if (nums[l]+nums[r]==-nums[i]){
                    list.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (nums[l]==nums[l+1]&&l<r){
                        l++;
                    }
                    while (nums[r]==nums[r-1]&&l<r){
                        r--;
                    }
                    l++;
                    r--;
                }else if (nums[l]+nums[r]<-nums[i]){
                    while (nums[l]==nums[l+1]){
                        l++;
                    }
                    l++;
                }else {
                    while (nums[r]==nums[r-1]){
                        r--;
                    }
                    r--;
                }
            }
        }


        return list;
    }

}
