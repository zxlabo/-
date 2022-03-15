package com.数据结构.二叉搜索树;

import com.数据结构.IBinarySearchTree;

/**
 * 二叉搜索树，英文简称为 BST
 * 二叉搜索树又被称为：二叉查找树、二叉排序树
 * 特性：
 * 任意一个节点的值都大于其左子树所有节点的值
 * 任意一个节点的值都小于其右子树所有节点的值
 * 二叉搜索树存储的元素必须具备可比较性
 * 如果是自定义类型，需要指定比较方式。
 * 不允许为 null
 *
 * @author zhouxin
 * 1、创建树TreeNode节点，包含当前element、leftNode、rightNode、parentNode
 * 2、创建size变量，实现size方法、isEmpty方法。
 * 3、实现add方法
 * 1）创建根节点root
 * 2）判断root是否为null，如果为null，那么添加的节点为root。else
 * 3）如果比当前节点小，那么往左边查找。如果比当前节点大，那么往右边查找。
 */
public class BinarySearchTree<E> implements IBinarySearchTree<E> {

    /**
     * 二叉搜索树的大小
     */
    private int size;

    /**
     * 根节点
     */
    private Tree root;


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public void add(E element) {
        if (element == null) {
            return;
        }
        if (root == null) {
            root = new Tree<E>(element, null);
            size++;
            return;
        }
        Tree<E> parent = root;
        Tree<E> node = root;
        int cmp = 0;
        while (node != null) {
            cmp = compare(element, node.element);
            parent = node;
            if (cmp > 0) {
                //插入的节点大于当前节点，右子树
                node = node.right;
            } else if (cmp < 0) {
                //插入的节点小于当前节点，左子树
                node = node.left;
            } else {// 相等,则覆盖
                node.element = element;
            }
        }
        //此时，已经查到要插入节点的父节点了。
        Tree insertNode = new Tree<E>(element, parent);
        if (cmp > 0) {
            //插入的节点大于当前节点，右子树
            parent.right=insertNode;
        }else {
            parent.left=insertNode;
        }
        size++;
    }

    @Override
    public void remove(E element) {

    }

    @Override
    public boolean contains(E element) {
        return false;
    }

    private int compare(E e1, E e2) {
        int result = (Integer) e1 - (Integer) e2;
        return result;
    }

    /**
     * 创建树节点
     */
    private static class Tree<E> {
        E element;
        Tree<E> left;
        Tree<E> right;
        Tree<E> parent;

        public Tree(E e, Tree p) {
            this.element = e;
            this.parent = p;
        }
    }

}
