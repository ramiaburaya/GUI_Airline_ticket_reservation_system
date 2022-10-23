package com.example.gui_airline_ticket_reservation_system;

public class LinkedList<T extends Comparable<T>> {
    private Node<T> head;


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
}
