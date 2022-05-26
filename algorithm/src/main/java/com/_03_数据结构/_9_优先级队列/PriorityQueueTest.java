package com._03_数据结构._9_优先级队列;


public class PriorityQueueTest {

	public static void main(String[] args) {
		PriorityQueue<Person> queue = new PriorityQueue<>();
		queue.enQueue(new Person("Jack", 2));
		queue.enQueue(new Person("Rose", 10));
		queue.enQueue(new Person("Jake", 5));
		queue.enQueue(new Person("James", 15));
		
		while (!queue.isEmpty()) {
			System.out.println(queue.deQueue());
		}

	}

}
