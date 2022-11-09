package tests;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.*;
import java.util.NoSuchElementException;
import stack_queue.*;

public class TestStack {

	@Test
	void test_stack_constructor() {
		StringStackImpl s1 = new StringStackImpl();
		StringStackImpl s2 = new StringStackImpl("foo");
		
		assertTrue(s1.size() == 0);
		assertTrue(s2.peek().equals("foo"));
		assertTrue(s2.size() == 1);
	}
	
	@Test
	void test_stack_push() {
		StringStackImpl s1 = new StringStackImpl("foo");
		StringStackImpl s2 = new StringStackImpl("bar");
		
		s2.push("foo");
		assertTrue(s2.size() == 2);
		assertTrue(s1.peek().equals(s2.peek()));
	}
	
	@Test
	void test_stack_pop() {
		StringStackImpl s1 = new StringStackImpl();
		StringStackImpl s2 = new StringStackImpl("foo");
		
		assertThrows(NoSuchElementException.class, () -> s1.pop());
		assertTrue(s2.pop().equals("foo"));
		s1.push("first");
		s1.push("second");
		s1.push("third");
		s1.pop();
		assertTrue(s1.peek().equals("second"));
		assertTrue(s1.size() == 2);
		assertTrue(s1.pop().equals("second"));
		s1.pop();
		assertThrows(NoSuchElementException.class, () -> s1.pop());
	}
}
