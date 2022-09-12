package y22.m09.d13;

import java.util.*;

public class CorrectBracket {
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean correctAnswer = false;
        boolean result = solution.solution("(()(");

        System.out.println(result == correctAnswer);
    }


}


class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else {
                if (stack.size() == 0) {
                    return false;
                }
                stack.pop();
            }
        }
        if (stack.size() > 0) {
            return false;
        }
        return true;
    }
}