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
    public boolean remove(Object o) {
        return super.remove(o);
    }
    E unlink(Node<E> x) {
        final E element = x.item;
        final Node<E> next = x.next;
        final Node<E> prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
        }

        x.item = null;
        size--;
        modCount++;
        return element;
    }
}
