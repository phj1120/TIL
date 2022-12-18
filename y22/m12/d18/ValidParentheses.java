package m12.d18;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "()";
        boolean correctAnswer = true;
        boolean answer = solution.isValid(s);
        System.out.println(answer == correctAnswer);
        System.out.println(answer);
    }
}

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.add(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pop();
                if ((ch == ')' && pop != '(') || (ch == '}' && pop != '{') || (ch == ']' && pop != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
