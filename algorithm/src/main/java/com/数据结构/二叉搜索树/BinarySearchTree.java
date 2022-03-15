package com.数据结构.二叉搜索树;

import com.数据结构.二叉搜索树.printer.BinaryTreeInfo;
import com.数据结构.二叉搜索树.printer.BinaryTrees;

import java.util.Comparator;

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
 * 4、设计Comparator
 * <p>
 * 打印二叉树
 */
public class BinarySearchTree<E> implements IBinarySearchTree<E>, BinaryTreeInfo {

    public static void main(String[] args) {
        /**
         * 打印二叉搜索树
         *   ┌──7──┐
         *   │     │
         * ┌─4─┐ ┌─9─┐
         * │   │ │   │
         * 2─┐ 5 8   11
         *   │
         *   3
         */
        int[] array = new int[]{7, 4, 9, 2, 5, 8, 11, 3};
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int i : array) {
            bst.add(i);
        }
        //添加 1和12
        bst.add(1);
        bst.add(2);
        BinaryTrees.print(bst);
    }

    /**
     * 实现BinaryTreeInfo接口，实现打印二叉树功能
     * 打印--begin
     */
    @Override
    public Object root() {
        return root;
    }

    @Override
    public Object left(Object node) {
        return ((TreeNode) node).left;
    }

    @Override
    public Object right(Object node) {
        return ((TreeNode) node).right;
    }

    @Override
    public Object string(Object node) {
        return ((TreeNode) node).element;
    }
    /**
     * 实现BinaryTreeInfo接口，实现打印二叉树功能
     * 打印--end
     */

    /**
     * 二叉搜索树的大小
     */
    private int size;

    /**
     * 根节点
     */
    private TreeNode root;
    private Comparator<E> comparator;

    public BinarySearchTree() {
    }

    public BinarySearchTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    /**
     * 设计Comparator
     */
    private int compare(E e1, E e2) {
        if (comparator!=null){
           return comparator.compare(e1, e2);
        }
        return ((Comparable) e1).compareTo(e2);
    }

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
            root = new TreeNode<E>(element, null);
            size++;
            return;
        }
        TreeNode<E> parent = root;
        TreeNode<E> node = root;
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
        TreeNode insertNode = new TreeNode<E>(element, parent);
        if (cmp > 0) {
            //插入的节点大于当前节点，右子树
            parent.right = insertNode;
        } else {
            parent.left = insertNode;
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




    /**
     * 创建树节点
     */
    private static class TreeNode<E> {
        E element;
        TreeNode<E> left;
        TreeNode<E> right;
        TreeNode<E> parent;

        public TreeNode(E e, TreeNode p) {
            this.element = e;
            this.parent = p;
        }
    }

}
