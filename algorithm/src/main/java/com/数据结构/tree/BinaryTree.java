package com.数据结构.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<E> {
	protected int size;
	protected Node<E> root;
	
	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void clear() {
		root = null;
		size = 0;
	}

	/**
	 * 前序遍历
	 * @param visitor
	 */
	public void preorder(Visitor<E> visitor) {
		if (visitor == null) return;
		preorder(root, visitor);
	}
	
	private void preorder(Node<E> node, Visitor<E> visitor) {
		if (node == null || visitor.stop) return;
		visitor.stop = visitor.visit(node.element);
		preorder(node.left, visitor);
		preorder(node.right, visitor);
	}

	/**
	 * 中序遍历
	 * @param visitor
	 */
	public void inorder(Visitor<E> visitor) {
		if (visitor == null) return;
		inorder(root, visitor);
	}
	
	private void inorder(Node<E> node, Visitor<E> visitor) {
		if (node == null || visitor.stop) return;
		
		inorder(node.left, visitor);
		if (visitor.stop) return;
		visitor.stop = visitor.visit(node.element);
		inorder(node.right, visitor);
	}

	/**
	 * 后序遍历
	 * @param visitor
	 */
	public void postorder(Visitor<E> visitor) {
		if (visitor == null) return;
		postorder(root, visitor);
	}
	
	private void postorder(Node<E> node, Visitor<E> visitor) {
		if (node == null || visitor.stop) return;
		postorder(node.left, visitor);
		postorder(node.right, visitor);
		if (visitor.stop) return;
		visitor.stop = visitor.visit(node.element);
	}

	/**
	 * 层序遍历
	 * @param visitor
	 */
	public void levelOrder(Visitor<E> visitor) {
		if (root == null || visitor == null) return;
		Queue<Node<E>> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			Node<E> node = queue.poll();
			if (visitor.visit(node.element)) return;
			if (node.left != null) {
				queue.offer(node.left);
			}
			if (node.right != null) {
				queue.offer(node.right);
			}
		}
	}
	
	public boolean isComplete() {
		if (root == null) return false;
		Queue<Node<E>> queue = new LinkedList<>();
		queue.offer(root);
		boolean leaf = false;
		while (!queue.isEmpty()) {
			Node<E> node = queue.poll();
			if (leaf && !node.isLeaf()) return false;
			if (node.left != null) {
				queue.offer(node.left);
			} else if (node.right != null) {
				return false;
			}
			if (node.right != null) {
				queue.offer(node.right);
			} else { // 后面遍历的节点都必须是叶子节点
				leaf = true;
			}
		}
		return true;
	}
	
	public int height() {
		if (root == null) return 0;
		
		// 树的高度
		int height = 0;
		// 存储着每一层的元素数量
		int levelSize = 1;
		Queue<Node<E>> queue = new LinkedList<>();
		queue.offer(root);
		
		while (!queue.isEmpty()) {
			Node<E> node = queue.poll();
			levelSize--;
			
			if (node.left != null) {
				queue.offer(node.left);
			}
			
			if (node.right != null) {
				queue.offer(node.right);
			}

			if (levelSize == 0) { // 意味着即将要访问下一层
				levelSize = queue.size();
				height++;
			}
		}
		
		return height;
	}
	
	public int height2() {
		return height(root);
	}
	
	private int height(Node<E> node) {
		if (node == null) return 0;
		return 1 + Math.max(height(node.left), height(node.right));
	}
	
	protected Node<E> createNode(E element, Node<E> parent) {
		return new Node<>(element, parent);
	}

	/**
	 * 前驱结点：中序遍历时，当前节点的前一个节点；
	 * 如果是二叉搜索树，也就是前一个比他小的节点；
	 */
	protected Node<E> predecessor(Node<E> node) {
		if (node == null) return null;
		//case1:node.left!= null，那么前驱节点在左子树当中（left.right.right.right....）
		Node<E> p = node.left;
		if (p != null) {
			while (p.right != null) {
				p = p.right;
			}
			return p;
		}
		/**
		 * case2：从父节点or祖父节点中找前驱结点，前驱节点要满足：当前节点要在前驱结点的右子树中。（因为前驱节点要小于当前节点）
		 * 		  如果不满足，那么前驱结点就是null；
		 * 也就是：此时node满足的条件是：node.parent == null 或者 node == node.parent.right。
		 */
		//只要不满足上述条件，node就一直寻找parent。
		while (node.parent != null && node == node.parent.left) {
			node = node.parent;
		}
		// 此时node.parent 有两种情况：
		// 1、node.parent == null
		// 2、node == node.parent.right
		return node.parent;
	}

	/**
	 * 后继节点：中序遍历的时候，当前节点的下一个结点。
	 * 如果是二叉搜索树，也就是后一个比他大的节点；
	 */
	protected Node<E> successor(Node<E> node) {
		if (node == null) return null;
		//case1：node.right！=null，当前节点有右子树，那么后继节点在：(right.left.left.left....），终止条件：left为null；
		Node<E> p = node.right;
		if (p != null) {
			while (p.left != null) {
				p = p.left;
			}
			return p;
		}
		/**
		 * case2：从父节点、祖父节点中寻找后继节点。后继节点要满足：当前节点要在后继节点的左子树中，因为后继节点要大于当前节点；
		 * 		如果不满足，那么后继节点就为null；
		 * 	也就是：此时node满足的条件是：node.parent == null 或者 node == node.parent.left。
		 */
		//只要不满足上述条件，node就一直寻找parent。
		while (node.parent != null && node == node.parent.right) {
			node = node.parent;
		}
		// 此时node.parent 有两种情况：
		// 1、node.parent == null
		// 2、node == node.parent.left
		return node.parent;
	}

	public static abstract class Visitor<E> {
		boolean stop;
		/**
		 * @return 如果返回true，就代表停止遍历
		 */
		public abstract boolean visit(E element);
	}
	
	protected static class Node<E> {
		E element;
		Node<E> left;
		Node<E> right;
		Node<E> parent;
		public Node(E element, Node<E> parent) {
			this.element = element;
			this.parent = parent;
		}
		
		public boolean isLeaf() {
			return left == null && right == null;
		}
		
		public boolean hasTwoChildren() {
			return left != null && right != null;
		}
		
		public boolean isLeftChild() {
			return parent != null && this == parent.left;
		}
		
		public boolean isRightChild() {
			return parent != null && this == parent.right;
		}
		
		public Node<E> sibling() {
			if (isLeftChild()) {
				return parent.right;
			}
			
			if (isRightChild()) {
				return parent.left;
			}
			
			return null;
		}
	}
}
