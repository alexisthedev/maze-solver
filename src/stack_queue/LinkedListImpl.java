package stack_queue;

import java.util.NoSuchElementException;

public class LinkedListImpl<T> implements LinkedListInterface<T> {
	private int size = 0;
	private LinkedListNode<T> head = null;
	private LinkedListNode<T> tail = null;

	public LinkedListImpl() {
	}

	public LinkedListImpl(LinkedListNode<T> head) {
		this.head = head;

		// Count size until last node and set tail
		while(head != null && head.next() != null) {
			size++;
			head = head.next();
		}
		size++;
		tail = head;
	}

	public LinkedListImpl(T val) {
		head = new LinkedListNode<T>(val);
		tail = head;
		size++;
	}

	@Override
	public void pushFront(T data) {
		LinkedListNode<T> node = new LinkedListNode<T>(data, head);

		// If the list is empty both head and tail point to the new node
		tail = isEmpty() ? node : tail;
		head = node;
		size++;
	}

	@Override
	public void pushBack(T data) {
		LinkedListNode<T> node = new LinkedListNode<T>(data);

		// If the list is empty both head and tail point to the new node
		if (isEmpty()) {
			head = node;
		} else {
			tail.setNext(node);
		}
		tail = node;
		size++;
	}

	@Override
	public T popFront() throws NoSuchElementException {
		if (isEmpty()) throw new NoSuchElementException("ERROR: List is empty.");

		// If the size is 1 then both head and tail should become null
		if (size() == 1) tail = null;
		T item = head.data();
		head = head.next();
		size--;
		return item;
	}

	@Override
	public T popBack() throws NoSuchElementException {
		if (isEmpty()) throw new NoSuchElementException("ERROR: List is empty.");

		// If the size is 1 then both head and tail should become null
		if (size() == 1) {
			T item = head.data();
			head = null;
			tail = null;
			size--;
			return item;
		}

		// Store popped element's data
		T item = tail.data();

		// Traverse the list with a node 'curr' starting at the head
		// Create a dummy node 'prev' that points to our 'curr' node
		LinkedListNode<T> curr = head;
		LinkedListNode<T> prev = new LinkedListNode<T>(null, curr);
		while(curr.next() != null) {
			prev = curr;
			curr = curr.next();
		}

		// Make 'prev' the new tail and set its next pointer to null
		prev.setNext(null);
		tail = prev;
		size--;
		return item;
	}

	public T head() {
		return head != null ? head.data() : null;
	}

	public LinkedListNode<T> headNode() {
		return head;
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
		LinkedListNode<T> curr = head;
		StringBuilder res = new StringBuilder("LinkedList: ");
		while (curr != null) {
			res.append(curr.data().toString() + " -> ");
		}
		res.append("NULL");
		return res.toString();
	}
}
