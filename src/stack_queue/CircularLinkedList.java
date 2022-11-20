package stack_queue;

import java.util.NoSuchElementException;

public class CircularLinkedList<T> implements LinkedListInterface<T> {
	private int size = 0;
	private LinkedListNode<T> tail = null;
	// Head is tail.next (circular list)

	public CircularLinkedList() {
	}

	public CircularLinkedList(LinkedListNode<T> node) {
		tail = node;
		tail.setNext(node);
		size++;
	}

	public CircularLinkedList(T val) {
		tail = new LinkedListNode<T>(val);
		tail.setNext(tail);
		size++;
	}

	@Override
	public void pushFront(T data) {
		LinkedListNode<T> node = new LinkedListNode<T>(data);
		if (isEmpty()) {
			tail = node;
			tail.setNext(tail);
		} else {
			node.setNext(tail.next());
			tail.setNext(node);
		}
		size++;
	}

	@Override
	public void pushBack(T data) {
		LinkedListNode<T> node = new LinkedListNode<T>(data);
		if (isEmpty()) {
			tail = node;
			tail.setNext(tail);
		} else {
			node.setNext(tail.next());
			tail.setNext(node);
			tail = node;
		}
		size++;
	}

	@Override
	public T popFront() throws NoSuchElementException {
		if (isEmpty()) throw new NoSuchElementException("ERROR: List is empty.");

		T item = tail.next().data();
		if (size == 1) {
			tail = null;
		} else {
			tail.setNext(tail.next().next());
		}
		size--;
		return item;
	}

	@Override
	public T popBack() throws NoSuchElementException {
		if (isEmpty()) throw new NoSuchElementException("ERROR: List is empty.");

		T item = tail.data();
		if (size == 1) {
			tail = null;
		} else {
			LinkedListNode<T> curr = tail.next();
			while (curr.next() != tail) {
				curr = curr.next();
			}
			curr.setNext(curr.next().next());
			tail = curr;
		}
		size--;
		return item;
	}

	public T head() {
		return !isEmpty() ? tail.next().data() : null;
	}

	public LinkedListNode<T> headNode() {
		return tail.next();
	}

	public T tail() {
		return tail != null ? tail.data() : null;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public String toString() {
		if (isEmpty()) return "LinkedList: empty";
		LinkedListNode<T> curr = tail.next();
		StringBuilder res = new StringBuilder("LinkedList: ");
		while (curr != tail) {
			res.append(curr.data().toString() + " -> ");
			curr = curr.next();
		}
		res.append(tail.data() + " -> NULL");
		return res.toString();
	}
}
