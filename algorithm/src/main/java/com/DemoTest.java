package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class DemoTest {

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();


    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        char[] chs = s.toCharArray();
        for (char c : chs) {
            switch (c) {
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
                    if (c != stack.pop()) {
                        return false;
                    }
                    break;
            }

        }
        return stack.isEmpty();
    }

}
