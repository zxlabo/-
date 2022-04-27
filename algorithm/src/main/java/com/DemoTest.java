package com;

import java.util.LinkedList;
import java.util.Queue;

public class DemoTest {

    public static void main(String[] args) {


        Queue<String> queue = new LinkedList<>();
        queue.offer("");//入队
        String msg=queue.poll();//出队
        String msg2=queue.peek();//获取队头元素


    }



}
