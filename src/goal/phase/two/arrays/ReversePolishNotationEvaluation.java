package goal.phase.two.arrays;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ReversePolishNotationEvaluation {

    public static void main(String[] args) {

        String[] p = { "4", "13", "5", "/", "+" };
        int result = evaluateReversePolish(p);
        System.out.println("Result: " + result);
    }

    private static int evaluateReversePolish(String[] p) {

        Stack<String> stack = new Stack<String>();
        int result = 0;

        Set<String> operatorsSet = new HashSet<String>();
        operatorsSet.add("+");
        operatorsSet.add("-");
        operatorsSet.add("*");
        operatorsSet.add("/");

        for (String c : p) {
            if (operatorsSet.contains(c)) {
                int operand2 = Integer.parseInt(stack.pop());
                int operand1 = Integer.parseInt(stack.pop());

                result = calculateTempResult(operand1, operand2, c);
                stack.push(String.valueOf(result));
            } else {
                stack.push(c);
            }
        }

        return result;
    }

    private static int calculateTempResult(int operand1, int operand2, String c) {
        int result = 0;

        switch (c) {
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
        }

        return result;
    }

}
