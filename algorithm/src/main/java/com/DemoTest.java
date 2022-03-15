package com;

import java.util.Arrays;

public class DemoTest {

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        sb.append("hello").append(";");
        if (sb.length()>1){
            String phone = sb.substring(0, sb.length() - 1);
            System.out.println(phone);
        }

        System.out.println("end");


    }



}
