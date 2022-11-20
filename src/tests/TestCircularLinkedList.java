package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.*;
import stack_queue.*;

class TestCircularLinkedList {

	@Test
	void test_linked_list_constructor() {
		CircularLinkedList<String> l1 = new CircularLinkedList<String>();

		LinkedListNode<String> n = new LinkedListNode<String>("foo");
		CircularLinkedList<String> l2 = new CircularLinkedList<String>(n);
		l1.pushBack("foo");
		assertTrue(l1.head() == l2.head());
		assertTrue(l1.size() == 1);
		assertTrue(l2.size() == 1);
	}

	@Test
	void test_linked_list_push_front() {
		CircularLinkedList<String> l1 = new CircularLinkedList<String>();
		l1.pushFront("foo");
		assertTrue(l1.tail() == l1.head());
		assertTrue(l1.head().equals("foo"));
	}

	@Test
	void test_linked_list_push_front_2() {
		CircularLinkedList<String> l1 = new CircularLinkedList<String>("foo");
		l1.pushFront("bar");
		assertTrue(l1.size() == 2);
		assertTrue(l1.tail().equals("foo"));
	}

	@Test
	void test_linked_list_push_back() {
		CircularLinkedList<String> l1 = new CircularLinkedList<String>("foo");
		l1.pushBack("bar");
		assertTrue(l1.size() == 2);
		assertTrue(l1.head().equals("foo"));
	}

	@Test
	void test_linked_list_pop_front() {
		CircularLinkedList<String> l1 = new CircularLinkedList<String>("foo");
		String item = l1.popFront();
		assertTrue(item.equals("foo"));
		assertTrue(l1.isEmpty());
		assertTrue(l1.head() == null && l1.tail() == null);
	}

	@Test
	void test_linked_list_pop_front_2() {
		CircularLinkedList<String> l1 = new CircularLinkedList<String>("foo");
		l1.pushBack("bar");
		l1.popFront();
		assertTrue(l1.head() == "bar");
		assertTrue(l1.tail() == "bar");
		assertTrue(l1.size() == 1);
	}

	@Test
	void test_linked_list_pop_back() {
		CircularLinkedList<String> l1 = new CircularLinkedList<String>("foo");
		String item = l1.popBack();
		assertTrue(item.equals("foo"));
		assertTrue(l1.isEmpty());
		assertTrue(l1.head() == null && l1.tail() == null);
	}

	@Test
	void test_linked_list_pop_back_2() {
		CircularLinkedList<String> l1 = new CircularLinkedList<String>("foo");
		l1.pushFront("bar");
		l1.popBack();
		assertTrue(l1.head() == "bar");
		assertTrue(l1.tail() == "bar");
		assertTrue(l1.size() == 1);
	}

	@Test
	void test_linked_list_exception() {
		CircularLinkedList<String> l1 = new CircularLinkedList<String>();
		assertTrue(l1.isEmpty());
		assertThrows(NoSuchElementException.class, () -> l1.popBack());
	}
}
