package com.serivce;

public final class ImmutableQueue<T> implements Queue<T> {

	private final Stack<T> backwards;
	private final Stack<T> forwards;

	private ImmutableQueue(Stack<T> forwards, Stack<T> backwards) {
		this.forwards = forwards;
		this.backwards = backwards;
	}

	public final Queue<T> enQueue(T t) {
		return new ImmutableQueue<T>(forwards, backwards.push(t));
	}

	@SuppressWarnings("unchecked")
	public final Queue<T> deQueue() throws Exception {
		Stack<T> f = forwards.pop();
		if (!f.isEmpty()) {
			return new ImmutableQueue<T>(f, backwards);
		} else if (backwards.isEmpty()) {
			return ImmutableQueue.getEmptyQueue();
		} else {
			return new ImmutableQueue<T>(ImmutableQueue.reverseStack(backwards), ImmutableStack.getEmptyStack());
		}
	}

	public final T head() throws Exception {
		return forwards.head();
	}

	public final boolean isEmpty() {
		return forwards.isEmpty();
	}

	@SuppressWarnings({ "rawtypes" })
	public final static Queue getEmptyQueue() {
		return EmptyQueue.getInstance();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private final static Stack reverseStack(Stack stack) throws Exception {
		Stack r = ImmutableStack.getEmptyStack();
		while (!stack.isEmpty()) {
			r = r.push(stack.head());
			stack = stack.pop();
		}

		return r;
	}

	private static final class EmptyQueue<T> implements Queue<T> {

		@SuppressWarnings("rawtypes")
		private final static EmptyQueue emptyQueue = new EmptyQueue();

		@SuppressWarnings("rawtypes")
		public final static EmptyQueue getInstance() {
			return emptyQueue;
		}

		@SuppressWarnings("unchecked")
		public final Queue<T> enQueue(T t) {
			return new ImmutableQueue<T>(ImmutableStack.getEmptyStack().push(t), ImmutableStack.getEmptyStack());
		}

		public final Queue<T> deQueue() throws Exception {
			throw new Exception("Queue is empty.");
		}

		public final T head() throws Exception {
			throw new Exception("Queue is empty.");
		}

		public final boolean isEmpty() {
			return true;
		}
	}

}
