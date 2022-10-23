package com.example.gui_airline_ticket_reservation_system;

public class Node<T extends Comparable<T>> {
    private T data;
    private Node<T> next;


    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return data + "";
    }
}
