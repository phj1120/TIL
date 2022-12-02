package m12.d02;

import java.util.Stack;

public class CorrectBracket {
    public static void main(String[] args) {

    }

    class Solution {
        char OPEN_BRACKET = '(';
        char CLOSE_BRACKET = ')';

        boolean solution(String s) {
            Stack<Character> brackets = new Stack<>();

            for (int i = 0; i < s.length(); i++) {
                char bracket = validBracket(s.charAt(i));

                if (bracket == OPEN_BRACKET) {
                    brackets.add(bracket);
                    continue;
                }

                if (brackets.isEmpty()) {
                    return false;
                }

                brackets.pop();
            }
            return brackets.isEmpty();
        }

        private char validBracket(char character) {
            if (isOtherCharacter(character)) {
                throw new RuntimeException();
            }
            return character;
        }

        private boolean isOtherCharacter(char bracket) {
            return bracket != OPEN_BRACKET && bracket != CLOSE_BRACKET;
        }
    }


    class PrevSolution {
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
}
