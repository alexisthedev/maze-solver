package stack_queue;

public class LinkedListNode<T> {
	private T data;
	private LinkedListNode<T> next;

	public LinkedListNode(T data) {
		this.data = data;
		this.next = null;
	}

	public LinkedListNode(T data, LinkedListNode<T> next) {
		this.data = data;
		this.next = next;
	}

	public T data() {
		return this.data;
	}

	public LinkedListNode<T> next() {
		return this.next;
	}

	public void setNext(LinkedListNode<T> next) {
		this.next = next;
	}
}
