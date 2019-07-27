package com.serivce;

public interface Queue<T> {
	public Queue<T> enQueue(T t);

	// Removes the element at the beginning of the immutable queue, and returns the
	// new queue.
	public Queue<T> deQueue() throws Exception;

	public T head() throws Exception;

	public boolean isEmpty();
}