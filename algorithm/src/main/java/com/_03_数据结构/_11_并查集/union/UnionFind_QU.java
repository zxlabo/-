package com._03_数据结构._11_并查集.union;

/**
 * Quick Union
 */
public class UnionFind_QU extends UnionFind {

	public UnionFind_QU(int capacity) {
		super(capacity);
	}

	/**
	 * 寻找元素v所属的集合
	 * 通过parent链条不断地向上找，直到找到根节点。根节点的值就是V所属的集合。
	 * 怎么判断是根节点呢？根节点的元素和值相等，也就是 v = parents[v];
	 */
	public int find(int v) {
		rangeCheck(v);
		while (v != parents[v]) {
			//当元素v和值相等时，说明v就是根节点
			v = parents[v];
		}
		return v;
	}

	/**
	 * Quick-Find和Quick-Union的区别
	 * QF:是将v1所在集合的所有元素，都嫁接到v2的父节点上；
	 * QU:是将v1的根节点嫁接到v2的根节点上；
	 * 将v1的根节点嫁接到v2的根节点上
	 */
	public void union(int v1, int v2) {
		//1、找到v1的根节点
		int p1 = find(v1);
		//2、找到v2的根节点
		int p2 = find(v2);
		if (p1 == p2) return;
		//3、将V1的根节点嫁接到V2上。
		parents[p1] = p2;
	}

}
