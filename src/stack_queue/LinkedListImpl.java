package stack_queue;

import java.util.*;

public class LinkedListImpl<T> implements LinkedListInterface<T> {
	private int size = 0;
	private LinkedListNode<T> head = null;
	private LinkedListNode<T> tail = null;
	
	public LinkedListImpl(LinkedListNode<T> head) {
		this.head = head;
		
		// Count size until last node and set tail
		while(head != null && head.next() != null) {
			size++;
			head = head.next();
		}
		this.tail = head;
	}
	
	@Override
	public void pushFront(T data) {
		LinkedListNode<T> node = new LinkedListNode<T>(data, this.head);
		
		// If the list is empty both head and tail point to the new node
		this.tail = this.isEmpty() ? node : this.tail;
		this.head = node;
	}
	
	@Override
	public void pushBack(T data) {
		LinkedListNode<T> node = new LinkedListNode<T>(data);
		
		// If the list is empty both head and tail point to the new node
		if (this.isEmpty()) {
			this.head = node;
		} else {
			this.tail.setNext(node);
		}
		this.tail = node;
	}
	
	@Override
	public T popFront() throws NoSuchElementException {
		if (this.isEmpty()) throw new NoSuchElementException();
		
		// If the size is 1 then both head and tail should become null
		if (this.size() == 1) this.tail = null;
		T item = this.head.data();
		this.head = head.next();
		size--;
		return item;
	}
	
	@Override
	public T popBack() throws NoSuchElementException {
		if (this.isEmpty()) throw new NoSuchElementException();
		
		// If the size is 1 then both head and tail should become null
		if (this.size() == 1) {
			T item = this.head.data();
			this.head = null;
			this.tail = null;
			size--;
			return item;
		}
		
		// Store popped element's data
		T item = this.tail.data();
		
		// Traverse the list with a node 'curr' starting at the head
		// Create a dummy node 'prev' that points to our 'curr' node
		LinkedListNode<T> curr = this.head;
		LinkedListNode<T> prev = new LinkedListNode<T>(null, curr);
		while(curr.next() != null) {
			prev = curr;
			curr = curr.next();
		}
		
		// Make 'prev' the new tail and set its next pointer to null
		prev.setNext(null);
		this.tail = prev;
		size--;
		return item;
	}
	
	@Override
	public int size() {
		return this.size;
	}
	
	@Override
	public boolean isEmpty() {
		return this.size() == 0;
	}
	
	@Override
	public String toString() {
		if (this.isEmpty()) return "LinkedList: empty";
		LinkedListNode<T> curr = this.head;
		StringBuilder res = new StringBuilder("LinkedList: ");
		while (curr != null) {
			res.append(curr.data().toString() + " -> ");
		}
		res.append("NULL");
		return res.toString();
	}
}
