package com.数据结构.tree;

import java.util.Comparator;

/**
 * AVL树
 * @param <E>
 */
public class AVLTree<E> extends BST<E> {
	public AVLTree() {
		this(null);
	}
	
	public AVLTree(Comparator<E> comparator) {
		super(comparator);
	}

	/**
	 * 当添加完节点之后，会调用afterAdd方法，
	 * 对二叉树进行更新高度或恢复平衡的操作。
	 * @param node 新添加的节点
	 */
	@Override
	protected void afterAdd(Node<E> node) {
		/**
		 * 开启while循环，从插入的节点开始，依次往上查找它的父节点，
		 * 一直到找到新增节点node最近的失衡节点。
		 */
		while ((node = node.parent) != null) {
			//判断当前节点是否平衡，也就是左子树和右子树高度差<=1；
			if (isBalanced(node)) {
				// 更新高度：当前节点的高度=1+Math.max(左子树高度，右子树高度)
				updateHeight(node);
			} else {
				/**
				 * 此时，当前节点，就是距离新增节点最近的失衡节点
				 * 我们调用 reBalance 方法，将此节点恢复平衡。
				 *此节点恢复平衡之后，当前子树的高度并没有因为新增节点而变化，
				 * 所以此时可以跳出循环，不需要再更新父节点的高度。
				 */
				reBalance(node);
				break;
			}
		}
	}
	
	@Override
	protected void afterRemove(Node<E> node) {
		while ((node = node.parent) != null) {
			if (isBalanced(node)) {
				// 更新高度
				updateHeight(node);
			} else {
				// 恢复平衡，因为可能会导致整颗二叉树都失衡，要调整。
				reBalance(node);
			}
		}
	}
	
	@Override
	protected Node<E> createNode(E element, Node<E> parent) {
		return new AVLNode<>(element, parent);
	}

	/**
	 * 恢复平衡
	 * grand 是高度最低的那个失衡节点，我们只需要将 以grand 为根节点的二叉树恢复平衡，
	 * 那么整颗二叉树就会恢复平衡。
	 * 1、找到 grand 左右子树最高的那颗树，记为 parent；
	 * 2、找到 parent 左右子树最高的那棵树，记为 node；
	 * 3、然后判断从 grand 到 node 的方向是什么
	 *  如果是LL,就将grand右旋；LR:先将parent左旋，然后再将grand右旋；
	 *  如果是RL:先将parent右旋，然后将grand左旋；RR:将grand左旋。
	 * 4、此时恢复二叉树平衡。
	 */
	private void reBalance(Node<E> grand) {
		Node<E> parent = ((AVLNode<E>)grand).tallerChild();
		Node<E> node = ((AVLNode<E>)parent).tallerChild();
		if (parent.isLeftChild()) { // L
			if (node.isLeftChild()) { // LL
				rotateRight(grand);
			} else { // LR
				rotateLeft(parent);
				rotateRight(grand);
			}
		} else { // R
			if (node.isLeftChild()) { // RL
				rotateRight(parent);
				rotateLeft(grand);
			} else { // RR
				rotateLeft(grand);
			}
		}
	}


	private void reBalance2(Node<E> grand) {
		//
		//parent：判断新节点是插入在grade的哪边，parent是第一棵树
		//tallerChild:判断左右子树哪个高度更高
		Node<E> parent = ((AVLNode<E>)grand).tallerChild();
		//判断新节点是插入在那颗树下
		Node<E> node = ((AVLNode<E>)parent).tallerChild();
		if (parent.isLeftChild()) { // L
			if (node.isLeftChild()) { // LL 右旋
				rotate(grand, node, node.right, parent, parent.right, grand);
			} else { // LR
				rotate(grand, parent, node.left, node, node.right, grand);
			}
		} else { // R
			if (node.isLeftChild()) { // RL
				rotate(grand, grand, node.left, node, node.right, parent);
			} else { // RR
				rotate(grand, grand, parent.left, parent, node.left, node);
			}
		}
	}
	
	private void rotate(
			Node<E> r, // 子树的根节点
			Node<E> b, Node<E> c,
			Node<E> d,
			Node<E> e, Node<E> f) {
		// 让d成为这棵子树的根节点
		d.parent = r.parent;
		if (r.isLeftChild()) {
			r.parent.left = d;
		} else if (r.isRightChild()) {
			r.parent.right = d;
		} else {
			root = d;
		}
		
		//b-c
		b.right = c;
		if (c != null) {
			c.parent = b;
		}
		updateHeight(b);
		
		// e-f
		f.left = e;
		if (e != null) {
			e.parent = f;
		}
		updateHeight(f);
		
		// b-d-f
		d.left = b;
		d.right = f;
		b.parent = d;
		f.parent = d;
		updateHeight(d);
	}
	
	private void rotateLeft(Node<E> grand) {
		Node<E> parent = grand.right;
		Node<E> child = parent.left;
		grand.right = child;
		parent.left = grand;
		afterRotate(grand, parent, child);
	}
	
	private void rotateRight(Node<E> grand) {
		Node<E> parent = grand.left;
		Node<E> child = parent.right;
		grand.left = child;
		parent.right = grand;
		afterRotate(grand, parent, child);
	}
	
	private void afterRotate(Node<E> grand, Node<E> parent, Node<E> child) {
		// 让parent称为子树的根节点
		parent.parent = grand.parent;
		if (grand.isLeftChild()) {
			grand.parent.left = parent;
		} else if (grand.isRightChild()) {
			grand.parent.right = parent;
		} else { // grand是root节点
			root = parent;
		}
		
		// 更新child的parent
		if (child != null) {
			child.parent = grand;
		}
		
		// 更新grand的parent
		grand.parent = parent;
		
		// 更新高度
		updateHeight(grand);
		updateHeight(parent);
	}
	
	private boolean isBalanced(Node<E> node) {
		return Math.abs(((AVLNode<E>)node).balanceFactor()) <= 1;
	}
	
	private void updateHeight(Node<E> node) {
		((AVLNode<E>)node).updateHeight();
	}
	
	private static class AVLNode<E> extends Node<E> {
		int height = 1;
		
		public AVLNode(E element, Node<E> parent) {
			super(element, parent);
		}
		
		public int balanceFactor() {
			int leftHeight = left == null ? 0 : ((AVLNode<E>)left).height;
			int rightHeight = right == null ? 0 : ((AVLNode<E>)right).height;
			return leftHeight - rightHeight;
		}
		
		public void updateHeight() {
			int leftHeight = left == null ? 0 : ((AVLNode<E>)left).height;
			int rightHeight = right == null ? 0 : ((AVLNode<E>)right).height;
			height = 1 + Math.max(leftHeight, rightHeight);
		}

		/**
		 * 判断左右子树哪个高度更高
		 * 如果相等，就返回和当前节点同方向的树
		 * @return
		 */
		public Node<E> tallerChild() {
			int leftHeight = left == null ? 0 : ((AVLNode<E>)left).height;
			int rightHeight = right == null ? 0 : ((AVLNode<E>)right).height;
			if (leftHeight > rightHeight) return left;
			if (leftHeight < rightHeight) return right;
			return isLeftChild() ? left : right;
		}
		
		@Override
		public String toString() {
			String parentString = "null";
			if (parent != null) {
				parentString = parent.element.toString();
			}
			return element + "_p(" + parentString + ")_h(" + height + ")";
		}
	}
}
