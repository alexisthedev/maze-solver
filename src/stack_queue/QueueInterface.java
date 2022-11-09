package stack_queue;

import java.util.NoSuchElementException;
import java.io.PrintStream;

public interface QueueInterface<T> {
	public void put(T item);

	public T get() throws NoSuchElementException;

	public T peek() throws NoSuchElementException;

	public int size();

	public boolean isEmpty();

	public void printQueue(PrintStream stream);
}
