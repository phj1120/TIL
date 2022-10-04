package y22.m10.d04;

import java.util.Stack;

class Solution {
    public String solution(String p) {
        String answer = "";
        if (p == "")
            return "";
        Stack<Character> stack = new Stack<>();
        stack.push(p.charAt(0));

        String w;
        String u;
        String v;


        return answer;
    }
}

public class ChangeBracket {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String p = "(()())()";
        String correctAnswer = "(()())()";
        String answer = solution.solution(p);
        System.out.println(answer.equals(correctAnswer));
        System.out.println(answer);
    }
}
