package com._03_数据结构._3_栈;

import java.util.ArrayList;
import java.util.List;

public class Stack<E> {
    private List<E> list = new ArrayList<>();

    public void clear() {
        list.clear();
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void push(E element) {
        list.add(element);
    }


    public E pop() {
        return list.remove(list.size() - 1);
    }


    public E peek() {
        return list.get(list.size() - 1);
    }

}
