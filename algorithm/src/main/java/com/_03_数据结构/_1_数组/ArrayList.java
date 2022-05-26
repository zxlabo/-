package com._03_数据结构._1_数组;

import com._03_数据结构._1_数组.abs.AbstractList;

/**
 * 动态数组 ArrayList
 * @param <E>
 */
@SuppressWarnings("unchecked")
public class ArrayList<E> extends AbstractList<E> {
    /**
     * 所有的元素
     */
    private E[] elements;
    private static final int DEFAULT_CAPACITY = 10;

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayList(int capaticy) {
        capaticy = (capaticy < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capaticy;
        elements = (E[]) new Object[capaticy];
    }

    /**
     * 清除所有元素
     */
    public void clear() {
        /**
         * 为什么不把 elements 置为null呢？
         * 因为elements 置为null，那么elements的内存也会被回收；
         * 当再次需要的时候，elements需要重新申请内存，此时是很耗费性能的；
         */
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    /**
     * 获取index位置的元素
     * 时间复杂度：O(1)
     * @param index
     * @return
     */
    public E get(int index) {
        rangeCheck(index);
        return elements[index];
    }

    /**
     * 设置index位置的元素
     * 时间复杂度：O(1)
     * @param index
     * @param element
     * @return 原来的元素ֵ
     */
    public E set(int index, E element) {
        rangeCheck(index);
        E old = elements[index];
        elements[index] = element;
        return old;
    }

    /**
     * 在index位置插入一个元素
     * 时间复杂度：最好：O(1)、最坏：O(n)、平均：O(n)
     * @param index
     * @param element
     */
    public void add(int index, E element) {
        //数组索引越界判断，if (index < 0 || index > size)，抛出异常
        rangeCheckForAdd(index);
        //数组容量判断，动态扩容
        ensureCapacity(size + 1);
        /**
         * 在索引 2 处插入元素，那么从索引2开始（包括索引2）的元素都要后移动一位。
         * 空出索引 2，然后赋值给新element
         * 后移：从最后开始，依次后移一位；
         */
         for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
    }

    /**
     * 删除index位置的元素
     * 时间复杂度：最好：O(1)、最坏：O(n)、平均：O(n)
     * @param index
     * @return
     */
    public E remove(int index) {
        //数组索引越界判断，如果：index < 0 || index >= size，抛出异常。
        rangeCheck(index);
        E old = elements[index];
        /**
         * 删除 索引2的元素，那么从索引2开始（不包括索引2）开始的元素，都要往前移动一位；
         * 前移：从索引3开始，依次将元素向前移动一位；
         */
        for (int i = index + 1; i < size; i++) {
            elements[i - 1] = elements[i];
        }
        //最后一个元素因为往前移了一位，所以最后的元素要置为null。
        elements[--size] = null;
        return old;
    }

    /**
     * 查看元素的索引
     * 遍历数组，if (element.equals(elements[i])) return i;
     * @param element
     * @return
     */
    public int indexOf(E element) {
        // 因为可以存储 null，所以elements可以为null；
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) return i;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(elements[i])) return i;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    /**
     * 自动扩容：保证要有capacity的容量
     * @param capacity：传入数组需要的的容量
     * 比如添加元素：数组需要的容量为：ensureCapacity(size + 1);
     */
    private void ensureCapacity(int capacity) {
        //如果当前数组容量大于等于所需容量，不需要扩容；
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) return;
        // 如果当前数组容量小于所需容量，需要扩容；
        // 新容量为旧容量的1.5倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        //数据迁移，将老数组数据迁移到新数组中；
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
        System.out.println(oldCapacity + "扩容为" + newCapacity);
    }

    @Override
    public String toString() {
        // size=3, [99, 88, 77]
        StringBuilder string = new StringBuilder();
        string.append("size=").append(size).append(", [");
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                string.append(", ");
            }
            string.append(elements[i]);
        }
        string.append("]");
        return string.toString();
    }

}
