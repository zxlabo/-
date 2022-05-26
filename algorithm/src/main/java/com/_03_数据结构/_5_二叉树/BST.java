package com._03_数据结构._5_二叉树;

import java.util.Comparator;

/**
 * 二叉搜索树
 * 1、二叉搜索树的元素必须具备可比较性。
 * 2、元素的比较方案设计
 * a：允许外界传入Comparator，自定义比较方案
 * b: 如果没有传入Comparator，强制默认元素实现了Comparable接口；
 * 注意：二叉树没有索引的概念；
 */
@SuppressWarnings("unchecked")
public class BST<E> extends BinaryTree<E> {

    private Comparator<E> comparator;

    public BST() {
        this(null);
    }

    public BST(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    /**
     * 根据元素查找对应的节点
     * 注意：二叉树没有索引的概念；
     */
    private Node<E> node(E element) {
        Node<E> node = root;
        while (node != null) {
            int cmp = compare(element, node.element);
            if (cmp == 0) return node;
            if (cmp > 0) {
                node = node.right;
            } else { // cmp < 0
                node = node.left;
            }
        }
        return null;
    }

    /**
     * 添加元素
     * 思路：找到父节点，创建新节点newNode。然后与parent进行比较，判断是左子树or右子树；
     */
    public void add(E element) {
        elementNotNullCheck(element);
        //1、判断root是否为null，如果为null，则添加的为root
        //添加第一个节点
        if (root == null) {
            root = createNode(element, null);
            size++;
            // 新添加节点之后的处理
            afterAdd(root);
            return;
        }
        // 2、添加的不是第一个节点，我们需要先找到parent父节点；
        Node<E> parent = root;
        Node<E> node = root;
        int cmp = 0;
        //为什么使用do-while，不使用while。
        // 原因：为了提升效率，因为第一次node=root，一定不为null，减少一次判断；
        do {
            //设置父节点，因为node会被重新赋值；
            parent = node;
            cmp = compare(element, node.element);
            if (cmp > 0) {
                node = node.right;
            } else if (cmp < 0) {
                node = node.left;
            } else { // 相等
                //如果相等，自行设计方案。默认是覆盖；
                node.element = element;
                return;
            }
        } while (node != null);
        //创建新节点
        Node<E> newNode = createNode(element, parent);
        //与父节点进行比较，判断左、右子树；
        if (cmp > 0) {
            parent.right = newNode;
        } else {
            parent.left = newNode;
        }
        size++;
        // 新添加节点之后的处理
        afterAdd(newNode);
    }

    /**
     * 添加node之后的调整
     *
     * @param node 新添加的节点
     */
    protected void afterAdd(Node<E> node) {
    }

    public void remove(E element) {
        remove(node(element));
    }

    /**
     * 删除节点
     * 删除节点分三种情况
     * 1、叶子结点(度为0)：直接删除；
     * 2、度为1的节点：用子节点替代原节点的位置；
     * 3、度为2的节点：用前驱结点or后继节点覆盖原节点的值，然后删除相应的前驱结点or后继节点；
     * @param node
     */
    private void remove(Node<E> node) {
        if (node == null) return;
        size--;
        /**
         * 1、先判断度为2的节点
         *  a：找到node的后继节点；
         *  b：用后继节点的值覆盖node节点的值；
         *  c：删除后继节点
         */
        if (node.hasTwoChildren()) { // 度为2的节点
            // 找到后继节点
            Node<E> s = successor(node);
            // 用后继节点的值覆盖度为2的节点的值
            node.element = s.element;
            // 删除后继节点
            node = s;
        }
        /**
         * 删除node节点（此时node的度必然是1或者0）
         * 1、node的度为1：用子节点替代原节点的位置；
         * 2、node的度为0，直接删除；
         */
        //找到node的子节点
        Node<E> replacement = node.left != null ? node.left : node.right;
        if (replacement != null) { // node是度为1的节点
            // 更改parent
            replacement.parent = node.parent;
            // 更改parent的left、right的指向
            if (node.parent == null) { // node是度为1的节点并且是根节点
                root = replacement;
            } else if (node == node.parent.left) {
                node.parent.left = replacement;
            } else { // node == node.parent.right
                node.parent.right = replacement;
            }
            afterRemove(replacement);
        } else if (node.parent == null) { // node是叶子节点并且是根节点
            root = null;
            // 删除节点之后的处理
            afterRemove(node);
        } else { // node是叶子节点，但不是根节点
            if (node == node.parent.left) {
                node.parent.left = null;
            } else { // node == node.parent.right
                node.parent.right = null;
            }
            // 删除节点之后的处理
            afterRemove(node);
        }
    }

    /**
     * 删除node之后的调整
     *
     * @param node 被删除的节点 或者 用以取代被删除节点的子节点（当被删除节点的度为1）
     */
    protected void afterRemove(Node<E> node) {
    }

    public boolean contains(E element) {
        return node(element) != null;
    }


    /**
     * @return 返回值等于0，代表e1和e2相等；返回值大于0，代表e1大于e2；返回值小于于0，代表e1小于e2
     */
    private int compare(E e1, E e2) {
        if (comparator != null) {
            return comparator.compare(e1, e2);
        }
        return ((Comparable<E>) e1).compareTo(e2);
    }

    private void elementNotNullCheck(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element must not be null");
        }
    }

}
