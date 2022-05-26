package com._03_数据结构._11_并查集.union;

/**
 * 并查集Base抽象类
 * 并查集处理的数据都是整型，那么可以用整型数组来存储数据。
 * 并查集是可以用数组实现的树形结构（二叉堆、优先级队列也是可以用数组实现的树形结构）
 */
public abstract class UnionFind {
	protected int[] parents;

	/**
	 * 对数据初始化
	 * 我们用整形数组来存储并查集
	 * 初始化时，每个元素各属于一个集合。
	 * 索引是元素，值对应元素所在的集合。
	 */
	public UnionFind(int capacity) {
		if (capacity < 0) {
			throw new IllegalArgumentException("capacity must be >= 1");
		}
		parents = new int[capacity];
		for (int i = 0; i < parents.length; i++) {
			parents[i] = i;
		}
	}
	
	/**
	 * 查找v所属的集合（根节点）
	 */
	public abstract int find(int v);

	/**
	 * 合并v1、v2所在的集合
	 * 将v1合并到v2
	 */
	public abstract void union(int v1, int v2);
	
	/**
	 * 检查v1、v2是否属于同一个集合
	 */
	public boolean isSame(int v1, int v2) {
		return find(v1) == find(v2);
	}
	
	protected void rangeCheck(int v) {
		if (v < 0 || v >= parents.length) {
			throw new IllegalArgumentException("v is out of bounds");
		}
	}

}
