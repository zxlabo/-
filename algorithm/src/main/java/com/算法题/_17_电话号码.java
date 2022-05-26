package com.算法题;

import java.util.ArrayList;
import java.util.List;

public class _17_电话号码 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        //1、创建集合存储结果
        //2、创建集合存储当前的结果
        //3、调用深度优先算法
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> result=new ArrayList<>();
        dfs(list,result,nums,0);
        return list;
    }

    private void dfs(List<List<Integer>> list,List<Integer> result,int[] nums,int idx){
        if(idx==nums.length){
            list.add(new ArrayList(result));
        }

    }
}
