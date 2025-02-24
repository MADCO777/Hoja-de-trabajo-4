package Calculadoraaa;
import java.io.*;
import java.util.Scanner;

public class InfixCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = Calculator.getInstance();

        System.out.println("Seleccione la implementación de la pila (arraylist, vector, lista):");
        String stackType = scanner.nextLine();
        Stack<Character> stack = StackFactory.getStack(stackType);

        System.out.println("Ingrese la ruta del archivo con la expresión infix:");
        String filePath = scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String infix = reader.readLine();
            System.out.println("Expresión infix: " + infix);

            String postfix = calculator.infixToPostfix(infix);
            System.out.println("Expresión postfix: " + postfix);

            int result = calculator.evaluatePostfix(postfix);
            System.out.println("Resultado: " + result);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
        }
    }
}
