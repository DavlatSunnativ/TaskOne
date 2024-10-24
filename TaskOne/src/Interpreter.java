import java.util.ArrayList;
import java.util.List;

public class Interpreter {

    public static int evaluate(String expression) {
        List<Expression> list = new ArrayList<>();

        String[] tokens = expression.split(" ");
        for (String token : tokens) {
            if (isOperator(token)) {
                if (list.size() < 2) {
                    throw new IllegalArgumentException("Invalid expression: not enough operands.");
                }

                Expression right = list.remove(list.size() - 1); 
                Expression left = list.remove(list.size() - 1); 
                char operator = token.charAt(0);
                Expression operation = new OperationExpression(left, right, operator);
                list.add(operation); 
            } else {
                Expression number = new NumberExpression(Integer.parseInt(token));
                list.add(number); 
            }
        }

        if (list.size() != 1) {
            throw new IllegalArgumentException("Invalid expression: missing operators or operands.");
        }

        return list.remove(list.size() - 1).interpret(); 
    }

    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-");
    }
}
