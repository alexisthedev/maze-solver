package stack_queue;

import java.io.PrintStream;
import java.util.NoSuchElementException;

public interface LinkedListInterface<T> {	
	public void pushFront(T data);
	
	public void pushBack(T data);
	
	public T popFront() throws NoSuchElementException;
	
	public T popBack() throws NoSuchElementException;
	
	public int size();
	
	public boolean isEmpty();
}
