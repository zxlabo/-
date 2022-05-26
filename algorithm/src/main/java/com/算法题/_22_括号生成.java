package com.算法题;

import java.util.ArrayList;
import java.util.List;

public class _22_括号生成 {
    public static void main(String[] args) {
        List<String> list=  generateParenthesis(3);
        System.out.println(list.toString());

    }
    public static List<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<>();
        String result = "";
        int lRemain=n;
        int rRemain=n;
        char[] array = new char[n<<1];
        dfs(list,array,lRemain,rRemain,0);
        return list;
    }
    public static void dfs(ArrayList<String> list, char[] result, int lRemain, int rRemain,int idx){
        if (lRemain==0&&rRemain==0){
            list.add(new String(result));
            return;
        }
        //下面是for循环拆开的，选择左边括号、选择右边括号
        //左边括号等于0，就可以选择左边括号
        if (lRemain>0){
            result[idx] ='(';
            dfs(list,result,lRemain-1,rRemain,idx+1);
        }
        //右边括号大于0并且右边剩余数量要大于左边
        if (rRemain>0&&lRemain<rRemain){
            result[idx] =')';
            dfs(list,result,lRemain,rRemain-1,idx+1);
        }
    }
}

