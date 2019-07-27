package com.ue;

import com.serivce.ImmutableQueue;
import com.serivce.Queue;

public class App {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Queue<Integer> queue = ImmutableQueue.getEmptyQueue();
		try {
			queue = queue.enQueue(1);
			print(queue);
			queue = queue.enQueue(2);
			print(queue);
			queue = queue.enQueue(3);
			print(queue);
			queue = queue.deQueue();
			print(queue);
			queue = queue.deQueue();
			print(queue);
			System.out.println("Is queue empty ? " + queue.isEmpty());
			queue = queue.deQueue();
			System.out.println("Is queue empty ? " + queue.isEmpty());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void print(Queue<Integer> queue) throws Exception {
		while (queue != null && !queue.isEmpty()) {
			System.out.print(queue.head() + " -> ");
			queue = queue.deQueue();
		}
		System.out.println();
	}
}
