package com.github.dfontana;
/**
 * @author Sedgewick, Heineman
 * Modified bag implementation
 */

import java.util.Iterator;

public class Bag<Item> implements Iterable<Item> {
    Node first;
    int size;

    class Node {
        Item    item;
        Node    next;
    }

    public int size() { return size; }
    public void add (Item item) {
        Node oldfirst = first;

        first = new Node();
        first.item = item;
        first.next = oldfirst;
        size++;
    }
    public void remove (Item item) {
        if (first == null) { return; }

        Node prev = null;
        Node n = first;
        while (n != null) {
            if (n.item.equals(item)) {
                if (prev == null) {
                    first = n.next;
                } else {
                    prev.next = n.next;
                }
                size--;
                return;
            }

            prev = n;
            n = n.next;
        }
    }
    public Iterator<Item> iterator()  { return new ListIterator(first); }

    private class ListIterator implements Iterator<Item> {
        private Node current;

        public ListIterator(Node first)  { current = first;        }
        public boolean hasNext()         { return current != null; }
        public void remove()             {                         }

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
