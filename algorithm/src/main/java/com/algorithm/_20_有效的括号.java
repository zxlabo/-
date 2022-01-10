package com.algorithm;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 */
public class _20_有效的括号 {
    public static void main(String[] args) {
       System.out.println( isValid( "{[]}"));
    }

    public static boolean isValid(String s) {
        //1、安全检查
        if (s == null || s.length() == 0) {
            return false;
        }
        Stack<Character> stack = new Stack();
        char[] arr = s.toCharArray();
        for (int i=0;i<arr.length;i++){
            char ch=arr[i];
            switch (ch){
                case '(':
                    stack.push(')');
                    break;
                case '{':
                    stack.push('}');
                    break;
                case '[':
                    stack.push(']');
                    break;
                default:
                    if (stack.isEmpty()||ch!=stack.pop()){
                        return false;
                    }
                    break;
            }
        }
        if (stack.isEmpty()){
            return true;
        }else {
            return false;
        }
    }

}
