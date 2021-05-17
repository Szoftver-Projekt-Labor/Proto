package com.panzerkampfwagen;

import java.util.LinkedList;

public class OurLinkedList<E> extends LinkedList<E> {
	private static class Node<E> {
		E item;
		Node<E> next;
		Node<E> prev;
	}

	transient int size = 0;
	transient Node<E> first;
	transient Node<E> last;

	E unlink(Node<E> x) {
		final E element = x.item;

		if (x.prev == null) {
			first = x.next;
		} else {
			x.prev.next = x.next;
		}

		if (x.prev == null) {
			last = x.prev;
		} else {
			x.prev.prev = x.prev;
		}

		size--;
		modCount++;
		return element;
	}
}
