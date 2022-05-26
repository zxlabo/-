package com._03_数据结构._11_并查集.union;

/**
 * Quick Find
 *
 */
public class UnionFind_QF extends UnionFind {

	public UnionFind_QF(int capacity) {
		super(capacity);
	}

	/**
	 *  Quick Find中父节点就是根节点
	 *  时间复杂度O(1)
	 */
	public int find(int v) {
		rangeCheck(v);
		return parents[v];
	}

	/**
	 * 将v1所在集合的所有元素，都嫁接到v2的父节点上
	 * 时间复杂度O(n)
	 */
	public void union(int v1, int v2) {
		//1、找到v1的根节点
		int p1 = find(v1);
		//2、找到v2的根节点
		int p2 = find(v2);
		//3、如果v1和v2的根节点相等，就说明他们在同一个集合中，不需要合并。
		if (p1 == p2) return;
		//4、将所有根节点是p1的元素，都嫁接到v2的父节点上。
		for (int i = 0; i < parents.length; i++) {
			if (parents[i] == p1) {
				parents[i] = p2;
			}
		}
	}

}
