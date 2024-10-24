public class Main {
    public static void main(String[] args) {
        try {
            String expression = "3 4 + 2 -"; // Example of a valid expression
            int result = Interpreter.evaluate(expression);
            System.out.println("Result: " + result);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
