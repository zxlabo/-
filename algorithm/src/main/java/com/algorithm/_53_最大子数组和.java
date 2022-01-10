package com.algorithm;

public class _53_最大子数组和 {
    public static void main(String[] args) {
        int [] nums={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));

    }

    /**
     * 本题，我们可以使用暴力法进行求解。
     * 本题中要求最优解，所以我们要考虑使用动态规划。
     * 动态规划的话：我们要求出f(n)的公式
     * 本题的 f(n)=Math.max(arr[n],f(n-1)+arr[n])
     */
    public static int maxSubArray(int[] nums){
        int[] dp = new int[nums.length];
        int max=nums[0];
        dp[0]=nums[0];
        for (int i=1;i<nums.length;i++){
            dp[i] = Math.max((dp[i - 1] + nums[i]), nums[i]);
            max = Math.max(max, dp[i]);
        }
        return  max;
    }

    public int maxSubArray2(int[] nums) {
        //1、边界检查
        if(nums.length==1){
            return nums[0];
        }
        //暴力法
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            int res=nums[i];
            max=Math.max(max,res);
            for(int j=i+1;j<nums.length;j++){
                res=res+nums[j];
                max=Math.max(max,res);
            }
        }
        return max;
    }

}
