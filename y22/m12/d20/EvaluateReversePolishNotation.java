package m12.d20;

import java.util.Stack;

// 후위 표기법
public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        String[] tokens = {"2", "1", "+", "3", "*"};
//        int correctAnswer = 9;

//        String[] tokens = {"4", "13", "5", "/", "+"};
//        int correctAnswer = 6;

        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        int correctAnswer = 22;

        int answer = solution.evalRPN(tokens);
        System.out.println(answer == correctAnswer);
        System.out.println(answer);
    }
}

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> numbers = new Stack<>();
        for (String token : tokens) {
            if (isOperator(token)) {
                Integer num1 = numbers.pop();
                Integer num2 = numbers.pop();
                numbers.push(operation(num2, token, num1));
            } else {
                numbers.push(Integer.parseInt(token));
            }
        }

        return numbers.pop();
    }

    private Integer operation(int number1, String operator, int number2) {
        if ("+".equals(operator))
            return number1 + number2;
        if ("-".equals(operator))
            return number1 - number2;
        if ("*".equals(operator))
            return number1 * number2;
        return number1 / number2;
    }

    private boolean isOperator(String token) {
        return "*".equals(token) || "/".equals(token) || "+".equals(token) || "-".equals(token);
    }
}

class SolutionFirst {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if ("*".equals(token) || "/".equals(token) || "+".equals(token) || "-".equals(token)) {
                Integer i1 = stack.pop();
                Integer i2 = stack.pop();
                Integer afterOperation;
                if ("+".equals(token)) {
                    afterOperation = i2 + i1;
                } else if ("-".equals(token)) {
                    afterOperation = i2 - i1;
                } else if ("*".equals(token)) {
                    afterOperation = i2 * i1;
                } else {
                    afterOperation = i2 / i1;
                }
                stack.push(afterOperation);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}