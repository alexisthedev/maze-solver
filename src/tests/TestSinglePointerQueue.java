package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.*;
import stack_queue.*;

/**
 *
 * @author Alex Papadopoulos
 */
class TestSinglePointerQueue {
	private StringQueueWithOnePointer<String> q = new StringQueueWithOnePointer<>();

	@BeforeAll
	public static void setUp() {
		System.out.println("[Running StringQueueWithOnePointer Tests]");
	}

	@AfterAll
	public static void tearDown() {
		System.out.println("[Successfuly ran StringQueueWithOnePointer Tests]");
	}

	@Test
	public void test_constructor() {
		System.out.println("constructor");
		StringQueueWithOnePointer<Integer> temp = new StringQueueWithOnePointer<Integer>(Arrays.asList(1,2,3,4,5));
		assertTrue(temp.size() == 5);
		assertTrue(temp.get() == 1);
	}

	@Test
	public void test_is_empty() {
		System.out.println("isEmpty");
		assertTrue(q.isEmpty());
	}

	@Test
	public void test_is_empty_2() {
		System.out.println("isEmpty");
		q.put("foo");
		assertFalse(q.isEmpty());
	}

	@Test
	public void test_dequeue() {
		System.out.println("dequeue");
		q.put("bar");
		assertEquals("bar", q.get());
	}

	@Test
	public void test_dequeue_exception() {
		System.out.println("dequeue");
		assertThrows(NoSuchElementException.class, () -> q.get());
	}

	@Test
	public void test_enqueue() {
		System.out.println("enqueue");
		q.put("buzz");
		assertEquals(q.peek(), "buzz");
	}

	@Test
	public void test_peek() {
		System.out.println("peek");
		q.put("fizz");
		assertEquals("fizz", q.peek());
	}

	@Test
	public void test_peek_2() {
		System.out.println("peek");
		q.put("fizz");
		q.put("buzz");
		q.get();
		assertEquals("buzz", q.peek());
	}
}