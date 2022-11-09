package stack_queue;

import java.io.*;
import java.util.*;

public class StackStruct<T> implements StackInterface<T>{
	LinkedListImpl<T> stack = new LinkedListImpl<T>();

	public StackStruct() {
	}

	public StackStruct(T head) {
		stack.pushFront(head);
	}

	public StackStruct(List<T> items) {
		for(T item : items) {
			stack.pushFront(item);
		}
	}

	@Override
	public boolean isEmpty() {
		return stack.isEmpty();
	}

	@Override
	public void push(T item) {
		stack.pushFront(item);
	}

	@Override
	public T pop() throws NoSuchElementException {
		return stack.popFront();
	}

	@Override
	public T peek() throws NoSuchElementException {
		return stack.head();
	}

	@Override
	public void printStack(PrintStream stream) {
		stream.print(stack.toString());
	}

	@Override
	public int size() {
		return stack.size();
	}
}
