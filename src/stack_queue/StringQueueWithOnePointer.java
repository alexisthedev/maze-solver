package stack_queue;

import java.util.*;
import java.io.*;

public class StringQueueWithOnePointer<T> implements QueueInterface<T>{
	private CircularLinkedList<T> q = new CircularLinkedList<T>();

	public StringQueueWithOnePointer() {
	}

	public StringQueueWithOnePointer(T item) {
		q.pushBack(item);
	}

	public StringQueueWithOnePointer(List<T> items) {
		for (T item : items) {
			q.pushBack(item);
		}
	}

	@Override
	public void put(T item) {
		q.pushBack(item);
	}

	@Override
	public T get() throws NoSuchElementException {
		return q.popFront();
	}

	@Override
	public T peek() throws NoSuchElementException {
		return q.head();
	}

	@Override
	public int size() {
		return q.size();
	}

	@Override
	public boolean isEmpty() {
		return q.isEmpty();
	}

	@Override
	public void printQueue(PrintStream stream) {
		stream.print(q.toString());
	}
}
