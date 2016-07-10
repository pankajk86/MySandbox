package goal.phase.two.strings;

import java.util.Stack;

public class EvaluateAlgebricString {

    public static void main(String[] args) {

        String expr = "4/(2+4)*3";
        double result = eval(expr);
        System.out.println(expr + ": " + result);
    }

    private static double eval(String expr) {

        String postfix = getPostfixExpr(expr);
        Stack<Double> stack = new Stack<Double>();

        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);

            if (c == '+' || c == '-' || c == '/' || c == '*') {
                double op2 = stack.pop();
                double op1 = stack.pop();
                stack.push(eval(op1, op2, c));
            } else {
                stack.push((double) (c - '0'));
            }
        }

        return stack.pop();
    }

    private static double eval(double op1, double op2, char c) {

        double result = 0;

        switch (c) {
        case '+':
            result = op1 + op2;
            break;
        case '-':
            result = op1 - op2;
            break;
        case '*':
            result = op1 * op2;
            break;
        case '/':
            result = op1 / op2;
            break;
        }

        return result;
    }

    private static String getPostfixExpr(String expr) {
        Stack<Character> stack = new Stack<Character>();
        String postfix = "";

        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);

            if (c == ')') {
                while (stack.peek() != '(') {
                    postfix += stack.pop();
                }
                stack.pop();
            } else if (c == '+' || c == '-' || c == '/' || c == '*' || c == '(') {
                stack.push(c);
            } else {
                postfix += c;
            }
        }

        while (!stack.isEmpty()) {
            postfix += stack.pop();
        }

        return postfix;
    }

}
