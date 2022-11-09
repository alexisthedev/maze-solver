package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.*;
import stack_queue.*;

public class TestStack {
	private StackStruct<String> s = new StackStruct<String>();

	@BeforeAll
	public static void setUp() {
		System.out.println("[Running StackStruct Tests]");
	}

	@AfterAll
	public static void tearDown() {
		System.out.println("[Successfully ran StackStruct Tests]");
	}

	@Test
	public void test_stack_constructor() {
		System.out.println("constructor");
		StackStruct<Integer> s1 = new StackStruct<Integer>();
		StackStruct<Integer> s2 = new StackStruct<Integer>(1);

		assertTrue(s1.size() == 0);
		assertTrue(s2.peek().equals(1));
		assertTrue(s2.size() == 1);
	}

	@Test
	public void test_stack_is_empty() {
		System.out.println("isEmpty");
		assertTrue(s.isEmpty());
	}

	@Test
	public void test_stack_is_empty_2() {
		System.out.println("isEmpty");
		s.push("foo");
		assertFalse(s.isEmpty());
	}

	@Test
	public void test_stack_push() {
		System.out.println("stack push");
		s.push("new");
		assertTrue(s.peek().equals("new"));
	}

	@Test
	public void test_stack_pop() {
		System.out.println("stack pop");
		s.push("bar");
		assertEquals("bar", s.pop());
	}

	@Test
	public void test_stack_pop_exception() {
		System.out.println("stack pop");
		assertThrows(NoSuchElementException.class, () -> s.pop());
	}

	@Test
	public void test_stack_peek() {
		System.out.println("peek");
		s.push("top");
		assertEquals("top", s.peek());
	}

	@Test
	public void test_stack_peek_2() {
		System.out.println("peek");
		StackStruct<Integer> s1 = new StackStruct<Integer>();

		s1.push(1);
		s1.push(2);
		s1.pop();
		assertEquals(1, s1.peek());
	}
}
