package com._03_数据结构._2_链表;

import com._03_数据结构._1_数组.abs.AbstractList;

/**
 * 双向链表
 */
public class LinkedList<E> extends AbstractList<E> {

    private Node<E> first;//头结点
    private Node<E> last;//尾结点

    /**
     * 获取index位置的节点
     * 1、因为双向链表，先判断当前索引距离first、last哪个近
     * 2、然后开始遍历，获取index对应的节点
     */
    private Node<E> node(int index) {
        //索引安全边界检查
        rangeCheck(index);
        Node<E> node;
        //因为是双向链表，需要判断是从前往后、还是从后往前更近；
        if (index < (size >> 1)) {
            node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        } else {
            node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
        }
        return node;
    }

    @Override
    public E get(int index) {
        return node(index).element;
    }

    @Override
    public E set(int index, E element) {
        Node<E> node = node(index);
        E old = node.element;
        node.element = element;
        return old;
    }

    /**
     * 在索引index处添加元素
     * 1、有两种情况，一是往最后面添加元素、二是其他位置
     * 2、往最后面添加元素的时候，可能index==size==0，此时头节点，也是尾结点；
     * 3、获取当前索引的node，这个node将变为新节点的next；
     * 4、获取当前节点的prev，此时将变为新节点的prev；
     * 5、创建新节点，传入prev、element、next；
     * 6、更新next的前驱结点、更新prev的next节点。（注意prev可能为null，意味着first）
     */
    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        if (index == size) {
            /**
             * index == size，往最后面添加元素，有2种情况
             * 一是：index==size==0，链表为空，first、last都为null
             * 二是：size！=0；
             */
            Node<E> oldLast = last;
            last = new Node<>(oldLast, element, null);
            if (oldLast == null) {
                //size==0， 这是链表添加的第一个元素
                first = last;
            } else {
                oldLast.next = last;
            }
        } else {
            //获取index索引的node节点，此时这个node将变为新节点的next；
            Node<E> next = node(index);
            //获取新节点的prev：当前索引的节点的前驱结点为新节点的prev；
            Node<E> prev = next.prev;
            //创建新节点
            Node<E> node = new Node<>(prev, element, next);
            //更新next的前驱结点
            next.prev = node;
            //更新prev的后继节点
            if (prev == null) { // index == 0
                first = node;
            } else {
                prev.next = node;
            }
        }
        size++;
    }

    /**
     * 删除索引index处的数据
     * 1、获取index处的节点node；
     * 2、获取node的前驱结点prev；
     * 3、获取node的后继节点next；
     * 4、将prev的后继节点设置为next；
     *    1）如果prev为null，那么node为first节点。删除node，那么fist=next；
     *    2）else， prev.next = next;
     *  5、将next的前驱结点设置为prev
     *    1）如果next为null，那么node为last节点，删除node，那么last=prev；
     *    2）else，next.prev = prev;
     */
    @Override
    public E remove(int index) {
        rangeCheck(index);
        Node<E> node = node(index);
        Node<E> prev = node.prev;
        Node<E> next = node.next;
        //将prev的后继节点设置为next；
        if (prev == null) { // index == 0
            first = next;
        } else {
            prev.next = next;
        }
        //将next的前驱结点设置为prev
        if (next == null) { // index == size - 1
            last = prev;
        } else {
            next.prev = prev;
        }
        size--;
        return node.element;
    }

    @Override
    public void clear() {
        size = 0;
        first = null;
        last = null;
    }

    @Override
    public int indexOf(E element) {
        Node<E> node = first;
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (node.element == null) return i;
                node = node.next;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(node.element)) return i;
                node = node.next;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("size=").append(size).append(", [");
        Node<E> node = first;
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                string.append(", ");
            }
            string.append(node);
            node = node.next;
        }
        string.append("]");
        return string.toString();
    }

    /**
     * 双向链表节点
     * 包括：element、prev前驱结点、next后继节点
     */
    private static class Node<E> {
        E element;
        Node<E> prev;
        Node<E> next;

        public Node(Node<E> prev, E element, Node<E> next) {
            this.prev = prev;
            this.element = element;
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (prev != null) {
                sb.append(prev.element);
            } else {
                sb.append("null");
            }
            sb.append("_").append(element).append("_");
            if (next != null) {
                sb.append(next.element);
            } else {
                sb.append("null");
            }
            return sb.toString();
        }
    }

}
