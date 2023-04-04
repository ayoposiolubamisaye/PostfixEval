
import java.util.Scanner;

public class PostfixEvaluator {
    // Array to store operands
    private final double[] operands;

    // empty index in array
    private int operandIndex;

    // operands array
    private static final int operandValue = 100;

    // Postfix constructor
    public PostfixEvaluator() {
        operands = new double[operandValue];
        operandIndex = 0;
    }
    /**
     * Removes the last operand from the operands array and returns it.
     *
     * @return the last operand in the operands array
     */
    private double pop() {
        if (operandIndex == 0) {
            System.out.println("error");
            return 0;
        }
        return operands[--operandIndex];
    }
    /**
     * pushes operand to array
     * @param  value
     * @return the first operand value in the operands array
     */
    private void push(double value) {
        if (operandIndex == operandValue) {
            System.out.println("error");
            return;
        }
        operands[operandIndex++] = value;
    }
    /**
     * checks if stack is empty
     *
     * @return empty array
     */
    //checks if stack is empty
    public boolean isEmpty() {
        return (operandIndex == -1);
    }
    /**
     * checks postfix expression and evaluates, takes string as parameter
     *
     * @return result of evalution
     */
    public double evaluate(String expression) {
        Scanner postFixExpression = new Scanner(expression);

        while (postFixExpression.hasNext()) {
            if (postFixExpression.hasNextDouble()) {
                operands[operandIndex++] = postFixExpression.nextDouble();
            } else {
                String operator = postFixExpression.next();
                double operand2 = pop();
                double operand1 = pop();
                double result;
                switch (operator) {
                    case "+":
                        result = operand1 + operand2;
                        break;
                    case "-":
                        result = operand1 - operand2;
                        break;
                    case "*":
                        result = operand1 * operand2;
                        break;
                    case "/":
                        result = operand1 / operand2;
                        break;

                    default:
                        return 0;
                }

                push(result);
            }
        }

        return pop();
    }

}
