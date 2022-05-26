package com._02_算法._01_排序算法;

public class _08_计数排序 extends Sort<Integer> {
	/**
	 * 计数排序的思想是：
	 * 1、统计每个整数在序列中的次数，然后根据索引和次数进而推导出整数在有序序列的索引。
	 * 2、计数排序不是比较排序。
	 * 3、适应场景：适合对一定范围内的整数进行排序；
	 * 思路
	 * 1、求出序列array的最大值和最小值，根据最值，计算统计数组的大小 len=max-min+1。
	 * 2、为统计数组开辟内存空间：int[] counts = new int[max - min + 1];
	 * 3、遍历序列array，统计array中每个整数出现的次数。整数对应统计数组的索引：index= array[i] - min；
	 * 4、为了保证计数排序算法的稳定性，我们需要计算当前整数在有序序列的索引。怎么实现呢？
	 * 5、计算小于等于当前整数在array中出现的次数，也就是counts从头开始累加。
	 * 6、假设array[i]的值为k，那么k在有序数组的索引是：counts[array[i]-min]-1；
	 * 7、给有序数组赋值：newArray[--counts[array[i] - min]] = array[i];
	 */
	@Override
	protected void sort() {
		// 为了节省内存空间，我们需要找到array的最大值和最小值。
		int max = array[0];
		int min = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
			if (array[i] < min) {
				min = array[i];
			}
		}
		// 通过array的最大值和最小值，为统计数组counts开辟内存空间。
		int[] counts = new int[max - min + 1];
		// 统计每个整数出现的次数：值减去最小值作为索引。
		for (int i = 0; i < array.length; i++) {
			counts[array[i] - min]++;
		}
		/**
		 * desc：累加小于等于当前整数在array中出现的次数次数
		 * 为了保证计数排序算法的稳定性，我们需要计算当前整数在有序序列的索引。怎么实现呢？
		 * 计算小于等于当前整数在array中出现的次数，也就是counts从头开始累加。
		 * 比如：counts[2]=counts[2]+counts[2-1];
		 */
		for (int i = 1; i < counts.length; i++) {
			counts[i] += counts[i - 1];
		}
		/**
		 * 接下来我们根据array的元素k(k表示值)，找到k在序列中的次数。
		 * 通过次数，就能计算出k在有序序列的索引。
		 * 实现
		 * 1、创建新数组 newArray 作为有序数组；
		 * 2、对原数组 array，从后往前遍历。
		 * 3、假设array[i]的值为k，那么k在统计数组的索引值：array[i]-min
		 * 4、counts[array[i]-min]表示小于等于k出现的次数。
		 * 5、我们是倒序，那么k在有序数组的索引counts[array[i]-min]-1；
		 * 为什么要-1呢？因为索引=次数-1；
		 * 6、--counts[array[i]-min]，为什么要--操作呢？
		 * 因为等于k的值，可能有多个。所以他们的索引要-1；
		 */
		//创建新数组 newArray 作为有序数组；
		int[] newArray = new int[array.length];
		// 为了保证稳定性，从后往前遍历元素，将它放到有序数组中的合适位置
		for (int i = array.length - 1; i >= 0; i--) {
			newArray[--counts[array[i] - min]] = array[i];
		}
		// 将有序数组赋值到array
		for (int i = 0; i < newArray.length; i++) {
			array[i] = newArray[i];
		}
	}
	
	protected void sort0() {
		// 找出最大值
		int max = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		} // O(n)
		
		// 开辟内存空间，存储每个整数出现的次数
		int[] counts = new int[1 + max];
		// 统计每个整数出现的次数
		for (int i = 0; i < array.length; i++) {
			counts[array[i]]++;
		} // O(n)
		
		// 根据整数的出现次数，对整数进行排序
		int index = 0;
		for (int i = 0; i < counts.length; i++) {
			while (counts[i]-- > 0) {
				array[index++] = i;
			}
		} // O(n)
	}	
	
	public static void main(String[] args) {
		Person[] persons = new Person[] {
				new Person(20, "A"),
				new Person(-13, "B"),
				new Person(17, "C"),
				new Person(12, "D"),
				new Person(-13, "E"),
				new Person(20, "F")
		};
		
		// 找出最值
		int max = persons[0].age;
		int min = persons[0].age;
		for (int i = 1; i < persons.length; i++) {
			if (persons[i].age > max) {
				max = persons[i].age;
			}
			if (persons[i].age < min) {
				min = persons[i].age;
			}
		}
		
		// 开辟内存空间，存储次数
		int[] counts = new int[max - min + 1];
		// 统计每个整数出现的次数
		for (int i = 0; i < persons.length; i++) {
			counts[persons[i].age - min]++;
		}
		// 累加次数
		for (int i = 1; i < counts.length; i++) {
			counts[i] += counts[i - 1];
		}
		
		// 从后往前遍历元素，将它放到有序数组中的合适位置
		Person[] newArray = new Person[persons.length];
		for (int i = persons.length - 1; i >= 0; i--) {
			newArray[--counts[persons[i].age - min]] = persons[i];
		}
		
		// 将有序数组赋值到array
		for (int i = 0; i < newArray.length; i++) {
			persons[i] = newArray[i];
		}
		
		for (int i = 0; i < persons.length; i++) {
			System.out.println(persons[i]);
		}
	}
	
	private static class Person {
		int age;
		String name;
		Person(int age, String name) {
			this.age = age;
			this.name = name;
		}
		@Override
		public String toString() {
			return "Person [age=" + age 
					+ ", name=" + name + "]";
		}
	}
}
