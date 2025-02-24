package Calculadoraaa;

class Node<T> {
    T data;
    Node<T> next;
    public Node(T data) { this.data = data; }
}

public class LinkedListStack<T> implements Stack<T> {
    private Node<T> top;

    public void push(T item) {
        Node<T> newNode = new Node<>(item);
        newNode.next = top;
        top = newNode;
    }
    public T pop() {
        if (top == null) return null;
        T data = top.data;
        top = top.next;
        return data;
    }
    public T peek() { return (top == null) ? null : top.data; }
    public boolean isEmpty() { return top == null; }
}
