package com.algorithm;

class _50_第一个只出现一次的字符 {

    public static void main(String[] args) {
        char[] chars = "abc".toCharArray();
        for(char c:chars){
            System.out.println(c-'a');
        }
        char ch = (char)(1+'a');

        System.out.println(ch);
    }

//    public char firstUniqChar(String s) {
//        /**
//        思路：用数组实现。
//         */
//        char [] arr=s.toCharArray();
//        int [] nums=new int[26];
//        for(char c:arr){
//            nums[c-'a']++;
//        }
//        for(int i=0;i<nums.length;i++){
//            if(nums[i]==1){
//                return (char)i+'a';
//            }
//        }
//        return ' ';
//    }

}