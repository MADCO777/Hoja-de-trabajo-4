package Calculadoraaa;
import java.util.*;

public class Calculator {
    private static Calculator instance;

    private Calculator() {}

    public static Calculator getInstance() {
        if (instance == null) {
            instance = new Calculator();
        }
        return instance;
    }

    // Convertir infix a postfix
    public String infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new ArrayListStack<>();
        Map<Character, Integer> precedence = Map.of('+', 1, '-', 1, '*', 2, '/', 2);

        for (char ch : infix.toCharArray()) {
            if (Character.isDigit(ch)) {
                postfix.append(ch).append(" ");
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop()).append(" ");
                }
                stack.pop();
            } else if (precedence.containsKey(ch)) {
                while (!stack.isEmpty() && precedence.getOrDefault(stack.peek(), 0) >= precedence.get(ch)) {
                    postfix.append(stack.pop()).append(" ");
                }
                stack.push(ch);
            }
        }
        while (!stack.isEmpty()) {
            postfix.append(stack.pop()).append(" ");
        }
        return postfix.toString().trim();
    }

    // Evaluar expresión postfix
    public int evaluatePostfix(String postfix) {
        Stack<Integer> stack = new ArrayListStack<>();
        for (String token : postfix.split(" ")) {
            if (Character.isDigit(token.charAt(0))) {
                stack.push(Integer.parseInt(token));
            } else {
                int b = stack.pop();
                int a = stack.pop();
                switch (token.charAt(0)) {
                    case '+': stack.push(a + b); break;
                    case '-': stack.push(a - b); break;
                    case '*': stack.push(a * b); break;
                    case '/': stack.push(a / b); break;
                }
            }
        }
        return stack.pop();
    }
}
