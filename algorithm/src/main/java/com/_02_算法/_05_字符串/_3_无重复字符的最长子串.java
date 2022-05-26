package com._02_算法._05_字符串;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class _3_无重复字符的最长子串 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        //1、安全边界检查
        //2、将字符串转为数组，进行遍历
        //3、统计以每个字符结束的最长不重复字符串长度，然后求得最大数
        //4、使用两个索引进行比较
        // 1）当前字符的前一个字符的不重复字符开始索引-最左索引  li
        // 2) 获取当前字符上一次出现的索引位置  pi,使用hashMap记录字符出现的索引
        // 3) 比较li和pi,当li大于pi,当前字符的li不变。当li小于等于pi,那么当前字符的li=pi+1;
        //5、求当前索引-li,然后记录最大数
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        char[] sArray = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap();
        int li = 0;
        int maxLen = 0;
        map.put(sArray[0], 0);
        //i从1开始，防止数组越界
        for (int i = 1; i < sArray.length; i++) {
            int pi = map.getOrDefault(sArray[i], -1);
            map.put(sArray[i], i);
            if (li <= pi) {
                li = pi + 1;
            }
            maxLen = Math.max(maxLen, i - li + 1);
        }
        return maxLen;
    }

    public static int lengthOfLongestSubstring2(String s) {
        // 记录字符上一次出现的位置
        int[] last = new int[128];
        for (int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();

        int res = 0;
        int start = 0; // 窗口开始位置
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i);
            System.out.println("index:" + index);
            start = Math.max(start, last[index] + 1);
            System.out.println("start:" + start);
            res = Math.max(res, i - start + 1);

            last[index] = i;
        }
        return res;
    }

}
