package com.算法题;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class list删除指定元素 {
    public static void main(String[] args) {
        //list 删除指定元素
//        ArrayList<String> list = new ArrayList<>();
//        list.add("abc");
//        list.add("abc");
//        list.add("12");
//        list.add("12");
//        list.add("33");
//        list.add("3344");
//        Iterator<String> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            if (iterator.next().equals("12")) {
//                iterator.remove();
//            }
//        }
//        System.out.println(list.toString());

        List<String> list=new ArrayList();
        list.add("11");
        list.add("22");
        list.add("33");
        list.add("44");
        Iterator<String> it=list.iterator();
        while(it.hasNext()){
            if(it.next().equals("22")){
                it.remove();
            }
        }
    }
}
