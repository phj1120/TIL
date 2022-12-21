package y22.m12.d21;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new SolutionFaster();
        int n = 3;
        List<String> correctAnswer = List.of("((()))", "(()())", "(())()", "()(())", "()()()");
        List<String> answer = solution.generateParenthesis(n);

        System.out.println(correctAnswer.equals(answer));
        System.out.println(answer);
    }
}

class SolutionFaster extends Solution {
    Stack<Character> stack = new Stack<>();
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrack(0, 0, n);
        return res;
    }

    private void backtrack(int openN, int closedN, int n) {
        if (openN == closedN && closedN == n) {
            Iterator vale = stack.iterator();
            String temp = "";
            while (vale.hasNext()) {
                temp = temp + vale.next();
            }
            res.add(temp);
        }
        if (openN < n) {
            stack.push('(');
            backtrack(openN + 1, closedN, n);
            stack.pop();
        }
        if (closedN < openN) {
            stack.push(')');
            backtrack(openN, closedN + 1, n);
            stack.pop();
        }
    }
}

class Solution {
    List<String> parentheses;
    int n;

    public List<String> generateParenthesis(int n) {
        parentheses = new ArrayList<>();
        this.n = n;
        recursive("", 0, 0);

        List<String> answer = new ArrayList<>();
        for (String parenthesis : parentheses) {
            if (isWellFormed(parenthesis)) {
                answer.add(parenthesis);
            }
        }

        return answer;
    }

    private boolean isWellFormed(String parenthesis) {
        Stack<Character> stack = new Stack<>();
        for (Character ch : parenthesis.toCharArray()) {
            if (ch.equals('(')) {
                stack.add('(');
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            }
            stack.pop();
        }

        return true;
    }

    public void recursive(String str, int openCount, int closeCount) {
        if (str.length() == n * 2) {
            parentheses.add(str);
            return;
        }

        if (openCount < n) {
            recursive(str + "(", openCount + 1, closeCount);
        }

        if (closeCount < n) {
            recursive(str + ")", openCount, closeCount + 1);
        }
    }

}
