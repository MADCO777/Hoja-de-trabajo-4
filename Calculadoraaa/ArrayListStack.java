package Calculadoraaa;

import java.util.ArrayList;

public class ArrayListStack<T> implements Stack<T> {
    private ArrayList<T> stack = new ArrayList<>();

    public void push(T item) { stack.add(item); }
    public T pop() { return stack.isEmpty() ? null : stack.remove(stack.size() - 1); }
    public T peek() { return stack.isEmpty() ? null : stack.get(stack.size() - 1); }
    public boolean isEmpty() { return stack.isEmpty(); }
}
