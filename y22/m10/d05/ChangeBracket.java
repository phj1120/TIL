package y22.m10.d05;

import java.util.Stack;

class Solution {
    public String solution(String p) {
        // 1. 빈 문자열 일 경우 빈 문자열 반환
        if (p == "")
            return "";
        return step(p);
    }

    private String step(String w) {
        if (w.equals(""))
            return "";

        // 2. 문자열 w 를 u, v 로 구분 (u : 균형 잡힌 문자열로 더이상 분리할 수 없는 문자열)
        String u = "", v = "";
        int leftBracketCount = 0, rightBracketCount = 0;
        for (int i = 0; i < w.length(); i++) {
            char ch = w.charAt(i);
            if (ch == '(') {
                leftBracketCount++;
            } else {
                rightBracketCount++;
            }
            if (leftBracketCount == rightBracketCount) {
                u = w.substring(0, i + 1);
                v = w.substring(i + 1);
                break;
            }
        }

        if (isPerfectBracket(u)) {
            // 3. u 가 올바른 괄호 문자열 이라면 v 에 대해 1 단계 부터 수행
            return u + step(v);
        } else {
            // 4. u 가 올바른 괄후 문자열이 아니라면
            // 4.1 빈 문자열에 (
            String result = "(";
            // 4.2 문자열 v 에 대해 1단계 부터 재귀적으로 수행한 결과 문자열 이어 붙임
            result += step(v);

            // 4.3 위의 문자열 마지막에 ) 붙임
            result += ")";

            // 4.4 u 의 첫번째와 마지막 문자를 제거하고 나머지 문자열의 괄호 방향을 뒤집어 뒤에 붙임
            String reverseAndCut = "";
            for (int i = 0; i < u.length(); i++) {
                if (i == 0 || i == u.length() - 1)
                    continue;
                if (u.charAt(i) == '(') {
                    reverseAndCut += ')';
                } else {
                    reverseAndCut += '(';
                }
            }
            // 4.5 생성된 문자열 반환
            return result + reverseAndCut;
        }
    }

    public boolean isPerfectBracket(String w) {
        Stack<Character> stack = new Stack();
        for (char ch : w.toCharArray()) {
            if (ch == '(') {
                stack.push('(');
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
}


public class ChangeBracket {
    public static void main(String[] args) {
        Solution solution = new Solution();

//        String p = "(()())()";
//        String correctAnswer = "(()())()";

//        String p = ")(";
//        String correctAnswer = "()";

        String p = "()))((()";
        String correctAnswer = "()(())()";
        String answer = solution.solution(p);
        System.out.println(answer.equals(correctAnswer));
        System.out.println("answer : " + answer);
    }
}

