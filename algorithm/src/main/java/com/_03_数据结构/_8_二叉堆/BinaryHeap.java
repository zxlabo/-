package com._03_数据结构._8_二叉堆;

import com.helper.utils.printer.BinaryTreeInfo;

import java.util.Comparator;


/**
 * 二叉堆（最大堆）
 * 二叉堆是一个完全二叉树，二叉堆的元素必须具备可比较性。
 * 堆中的每一个节点的值都必须大于等于（或小于等于）其子树中每个节点的值。
 * 用数组来存储完全二叉树是非常节省存储空间的。
 * 因为我们不需要存储左右子节点的指针，单纯地通过数组的下标，就可以找到一个节点的左右子节点和父节点。
 * 索引i的规律，n是元素数量
 *  如果i==0，它的根节点；
 *  i的父节点：floor((i-1)/2)
 *  i的左子树 2i+1，前提是 2i+1<n-1;n是元素数量
 *  i的右子树 2i+2，前提是 2i+2<n-1;n是元素数量
 * @param <E>
 */
@SuppressWarnings("unchecked")
public class BinaryHeap<E> extends AbstractHeap<E> implements BinaryTreeInfo {

    //用数组来存储完全二叉树是非常节省存储空间的。
    private E[] elements;
    private static final int DEFAULT_CAPACITY = 10;

    public BinaryHeap(E[] elements, Comparator<E> comparator) {
        super(comparator);
        if (elements == null || elements.length == 0) {
            this.elements = (E[]) new Object[DEFAULT_CAPACITY];
        } else {
            size = elements.length;
            int capacity = Math.max(elements.length, DEFAULT_CAPACITY);
            this.elements = (E[]) new Object[capacity];
            for (int i = 0; i < elements.length; i++) {
                this.elements[i] = elements[i];
            }
            heapify();
        }
    }

    public BinaryHeap(E[] elements) {
        this(elements, null);
    }

    public BinaryHeap(Comparator<E> comparator) {
        this(null, comparator);
    }

    public BinaryHeap() {
        this(null, null);
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    /**
     * 添加元素
     * 1、将数据添加到数组最后
     * 2、将最后的元素进行上滤
     * @param element
     */
    @Override
    public void add(E element) {
        elementNotNullCheck(element);
        ensureCapacity(size + 1);
        elements[size++] = element;
        //将当前节点上滤
        siftUp(size - 1);
    }

    /**
     * 获取最大值
     * @return
     */
    @Override
    public E get() {
        emptyCheck();
        return elements[0];
    }

    /**
     * 删除最大值
     * 1、获取索引0的数据，也就是最大值；
     * 2、将索引lastIndex=size-1，也就是最后面的元素覆盖索引0；
     * 3、将索引lastIndex的数据置为null；
     * 4、将索引0下滤
     * @return
     */
    @Override
    public E remove() {
        emptyCheck();
        int lastIndex = --size;
        E root = elements[0];
        elements[0] = elements[lastIndex];
        elements[lastIndex] = null;
        //将索引0下滤
        siftDown(0);
        return root;
    }

    /**
     * 替换：替换的是索引0的元素，然后将将索引0下滤
     * @param element
     * @return
     */
    @Override
    public E replace(E element) {
        elementNotNullCheck(element);
        E root = null;
        if (size == 0) {
            elements[0] = element;
            size++;
        } else {
            root = elements[0];
            elements[0] = element;
            siftDown(0);
        }
        return root;
    }

    /**
     * 批量建堆
     */
    private void heapify() {
        // 自上而下的上滤
//		for (int i = 1; i < size; i++) {
//			siftUp(i);
//		}
        // 自下而上的下滤
        //最下面一层都是叶子结点，没有子节点。所以不需要下滤。从倒数第二层开始下滤；
        for (int i = (size >> 1) - 1; i >= 0; i--) {
            siftDown(i);
        }
    }

    /**
     * 让index位置的元素下滤
     * 循环执行以下操作：
     *    如果当前元素node<最大子节点，那么与最大子节点交换位置；
     *    else：如果node>=最大子节点or没有子节点，退出循环；
     * @param index
     */
    private void siftDown(int index) {
        E element = elements[index];
        /**
         * 根据完全二叉树规则，size除以2的那个索引是第一个叶子结点的索引。
         * 如果index< 第一个叶子节点的索引half，那么它有子节点，需要下滤。
         * else:index>=half,也就是当前节点是叶子结点，不需要下滤。
         */
        int half = size >> 1;
        while (index < half) {
            /**
             * 此时index是非叶子节点
             * index的节点有2种情况
             * 1.只有左子节点
             * 2.同时有左右子节点
             */
            //左子节点
            int childIndex = (index << 1) + 1;
            //默认左子节点为最大子节点
            E child = elements[childIndex];
            // 右子节点=左子节点+1;
            int rightIndex = childIndex + 1;
            // 最大子节点：选出左右子节点最大的那个，
            // 注意只有 rightIndex < size，才有右子结点。否则就数组索引越界了。
            if (rightIndex < size && compare(elements[rightIndex], child) > 0) {
                //将右子结点设置为最大子节点
                child = elements[childIndex = rightIndex];
            }
            //如果node>=最大子节点,退出循环；
            if (compare(element, child) >= 0) break;
            //将子节点存放到index位置
            elements[index] = child;
            // 重新设置index
            index = childIndex;
        }
        elements[index] = element;
    }

    /**
     * 让index位置的元素上滤
     *
     * @param index
     */
    private void siftUp(int index) {
//		E e = elements[index];
//		while (index > 0) {
//			int pindex = (index - 1) >> 1;
//			E p = elements[pindex];
//			if (compare(e, p) <= 0) return;
//			
//			// 交换index、pindex位置的内容
//			E tmp = elements[index];
//			elements[index] = elements[pindex];
//			elements[pindex] = tmp;
//			
//			// 重新赋值index
//			index = pindex;
//		}
        E element = elements[index];
        while (index > 0) {
            int parentIndex = (index - 1) >> 1;
            E parent = elements[parentIndex];
            if (compare(element, parent) <= 0) break;

            // 将父元素存储在index位置
            elements[index] = parent;

            // 重新赋值index
            index = parentIndex;
        }
        elements[index] = element;
    }

    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) return;

        // 新容量为旧容量的1.5倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }

    private void emptyCheck() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Heap is empty");
        }
    }

    private void elementNotNullCheck(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element must not be null");
        }
    }

    @Override
    public Object root() {
        return 0;
    }

    @Override
    public Object left(Object node) {
        int index = ((int) node << 1) + 1;
        return index >= size ? null : index;
    }

    @Override
    public Object right(Object node) {
        int index = ((int) node << 1) + 2;
        return index >= size ? null : index;
    }

    @Override
    public Object string(Object node) {
        return elements[(int) node];
    }
}
