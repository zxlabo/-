package com.数据结构.链表;

import com.数据结构.list.abs.AbstractList;

/**
 * desc：单向链表
 * @param <E>
 */
public class SingleLinkedList<E> extends AbstractList<E> {

    private Node<E> first;//头结点

    /**
     * 获取index位置对应的节点对象
     */
    private Node<E> node(int index) {
        //index安全边界检查 if (index < 0 || index >= size)
        rangeCheck(index);
        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    /**
     * 获取index节点对应的数据
     * 时间复杂度：最好：O(1)、最坏：O(n)、平均：O(n)
     */
    @Override
    public E get(int index) {
        return node(index).element;
    }

    /**
     * 时间复杂度：最好：O(1)、最坏：O(n)、平均：O(n)
     */
    @Override
    public E set(int index, E element) {
        Node<E> node = node(index);
        E old = node.element;
        node.element = element;
        return old;
    }

    /**
     * desc：在索引index处，添加元素；
     * 1、获取当前索引的上一个节点prev，
     * 2、将prev的原next设为新节点的next；
     * 3、将prev的next设为新节点；
     * 注意：索引为0的情况；因为索引为0，没有前驱结点；
     * 时间复杂度：最好：O(1)、最坏：O(n)、平均：O(n)
     */
    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        //注意index=0的情况，因为index - 1为-1，会抛异常。
        if (index == 0) {
            first = new Node<>(element, first);
        } else {
            Node<E> prev = node(index - 1);
            prev.next = new Node<>(element, prev.next);
        }
        size++;
    }

    /**
     * desc：删除index处的元素
     * 1、获取当前索引的上一个节点prev；
     * 2、删除的节点就是node= prev.next;
     * 3、将prev的next设为 prev.next.next,也就是node.next;
     * 注意：索引为0的情况；因为索引为0，没有前驱结点；
     * 时间复杂度：最好：O(1)、最坏：O(n)、平均：O(n)
     */
    @Override
    public E remove(int index) {
        rangeCheck(index);
        Node<E> node = first;
        if (index == 0) {
            first = first.next;
        } else {
            Node<E> prev = node(index - 1);
            node = prev.next;
            prev.next = node.next;
        }
        size--;
        return node.element;
    }

    /**
     * 清空链表
     */
    @Override
    public void clear() {
        size = 0;
        first = null;
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
        StringBuilder sb = new StringBuilder();
        sb.append("size=").append(size).append(", [");
        Node<E> node = first;
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                sb.append(", ");
            }
            sb.append(node.element);
            node = node.next;
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * 单向链表节点：Node
     *
     * @param <E>
     */
    private static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

}
