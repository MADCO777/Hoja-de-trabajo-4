package Calculadoraaa;

public class StackFactory {
    public static <T> Stack<T> getStack(String type) {
        return switch (type.toLowerCase()) {
            case "arraylist" -> new ArrayListStack<>();
            case "vector" -> new VectorStack<>();
            case "lista" -> new LinkedListStack<>();
            default -> throw new IllegalArgumentException("Tipo de pila no válido");
        };
    }
}
