package com.example.gui_airline_ticket_reservation_system;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class LinkedList<T extends Comparable<T>> implements List<T> {
    private Node<T> head;
    private Node<T> current;

    public void insert(T data) {
        Node<T> newNode = new Node<>(data);
        if (head != null) {
            newNode.setNext(head);
        }
        head = newNode;
    }

    public void travers() {
        System.out.print("head --> ");
        Node<T> current = head;
        while (current != null) {
            System.out.print(current + " --> ");
            current = current.getNext();
        }
        System.out.print("null");
        System.out.println();
    }

    public void sort() {
        if (head != null) {
            Node<T> current = head;
            Node<T> index;
            T temp;
            while (current != null) {
                index = current.getNext(); // using to get next Node (we use it in Compare)
                while (index != null) {
                    /* if first Node gather than next one , we save the value of first Node in temp
                       then we change the data in current (set in the data in index)
                       and finally we set the data in index (set it with data in temp(current))
                     */
                    if (current.getData().compareTo(index.getData()) > 0) {
                        temp = current.getData();
                        current.setData(index.getData());
                        index.setData(temp);
                    }
                    index = index.getNext();
                }
                current = current.getNext();
            }
        }
    }

    public Node<T> search(T data) {
        if (head == null) {
            return null;
        } else {
            Node<T> curr = head;
            Node<T> newNode = new Node<>(data);
            while (curr != null && !curr.getData().equals(newNode.getData())) {
                curr = curr.getNext();
            }
            return curr;
        }
    }

    @Override
    public int size() {
        return 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new linklistIterator<>();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public void add(int index, T element) {

    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    public Node<T> getHead() {
        return head;
    }

    class linklistIterator<T extends Comparable<T>> implements Iterator<T> {
        Node<T> current;


        public linklistIterator() {
            current = (Node<T>) head;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T data = current.getData();
            current = current.getNext();
            return data;
        }
    }
}
