package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.*;
import stack_queue.*;

class TestLinkedList {

	@Test
	void test_linked_list_constructor() {
		LinkedListImpl<String> l1 = new LinkedListImpl<String>();

		LinkedListNode<String> n = new LinkedListNode<String>("foo");
		LinkedListImpl<String> l2 = new LinkedListImpl<String>(n);
		l1.pushBack("foo");
		assertTrue(l1.head() == l2.head());
		assertTrue(l1.size() == 1);
		assertTrue(l2.size() == 1);
	}

	@Test
	void test_linked_list_constructor_2() {
		LinkedListImpl<String> l1 = new LinkedListImpl<String>();
		l1.pushFront("foo");
		l1.pushBack("bar");
		l1.pushBack("buzz");
		LinkedListImpl<String> l2 = new LinkedListImpl<String>(l1.headNode());
		assertTrue(l2.size() == 3);
		assertTrue(l2.head() == "foo");
		assertTrue(l2.tail() == "buzz");
	}

	@Test
	void test_linked_list_push_front() {
		LinkedListImpl<String> l1 = new LinkedListImpl<String>();
		l1.pushFront("foo");
		assertTrue(l1.tail() == l1.head());
		assertTrue(l1.head().equals("foo"));
	}

	@Test
	void test_linked_list_push_front_2() {
		LinkedListImpl<String> l1 = new LinkedListImpl<String>("foo");
		l1.pushFront("bar");
		assertTrue(l1.size() == 2);
		assertTrue(l1.tail().equals("foo"));
	}

	@Test
	void test_linked_list_push_back() {
		LinkedListImpl<String> l1 = new LinkedListImpl<String>("foo");
		l1.pushBack("bar");
		assertTrue(l1.size() == 2);
		assertTrue(l1.head().equals("foo"));
	}

	@Test
	void test_linked_list_pop_front() {
		LinkedListImpl<String> l1 = new LinkedListImpl<String>("foo");
		String item = l1.popFront();
		assertTrue(item.equals("foo"));
		assertTrue(l1.isEmpty());
		assertTrue(l1.head() == null && l1.tail() == null);
	}

	@Test
	void test_linked_list_pop_front_2() {
		LinkedListImpl<String> l1 = new LinkedListImpl<String>("foo");
		l1.pushBack("bar");
		l1.popFront();
		assertTrue(l1.head() == "bar");
		assertTrue(l1.tail() == "bar");
		assertTrue(l1.size() == 1);
	}

	@Test
	void test_linked_list_pop_back() {
		LinkedListImpl<String> l1 = new LinkedListImpl<String>("foo");
		String item = l1.popBack();
		assertTrue(item.equals("foo"));
		assertTrue(l1.isEmpty());
		assertTrue(l1.head() == null && l1.tail() == null);
	}

	@Test
	void test_linked_list_pop_back_2() {
		LinkedListImpl<String> l1 = new LinkedListImpl<String>("foo");
		l1.pushFront("bar");
		l1.popBack();
		assertTrue(l1.head() == "bar");
		assertTrue(l1.tail() == "bar");
		assertTrue(l1.size() == 1);
	}

	@Test
	void test_linked_list_exception() {
		LinkedListImpl<String> l1 = new LinkedListImpl<String>();
		assertTrue(l1.isEmpty());
		assertThrows(NoSuchElementException.class, () -> l1.popBack());
	}
}
