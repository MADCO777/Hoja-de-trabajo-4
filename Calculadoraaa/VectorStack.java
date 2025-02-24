package Calculadoraaa;

import java.util.Vector;

public class VectorStack<T> implements Stack<T> {
    private Vector<T> stack = new Vector<>();

    public void push(T item) { stack.add(item); }
    public T pop() { return stack.isEmpty() ? null : stack.remove(stack.size() - 1); }
    public T peek() { return stack.isEmpty() ? null : stack.get(stack.size() - 1); }
    public boolean isEmpty() { return stack.isEmpty(); }
}
