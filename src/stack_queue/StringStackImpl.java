package stack_queue;

import java.io.PrintStream;
import java.util.NoSuchElementException;

public class StringStackImpl implements StringStack{
	LinkedListImpl<String> stack = new LinkedListImpl<String>();
	
	public StringStackImpl() {
	}
	
	public StringStackImpl(String head) {
		this.stack.pushFront(head);
	}
	
	@Override
	public boolean isEmpty() {
		return this.stack.isEmpty();
	}
	
	@Override
	public void push(String item) {
		this.stack.pushFront(item);
	}
	
	@Override
	public String pop() throws NoSuchElementException {
		return this.stack.popFront();
	}
	
	@Override
	public String peek() throws NoSuchElementException {
		return this.stack.head();
	}
	
	@Override
	public void printStack(PrintStream stream) {
		stream.print(this.stack.toString());
	}
	
	@Override
	public int size() {
		return this.stack.size();
	}
} 
