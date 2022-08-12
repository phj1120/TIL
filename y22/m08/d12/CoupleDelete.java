package y22.m08.d12;

import java.util.ArrayList;
import java.util.Stack;

class Start {
    public static void main(String[] args) {
        CoupleDelete coupleDelete = new CoupleDelete();
        String s;
        s = "baabaa";
//        s = "cdcd";
        int result = coupleDelete.solution(s);
        System.out.println("result = " + result);
    }
}

public class CoupleDelete {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!stack.isEmpty() && stack.peek().equals(ch)) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        if (stack.isEmpty()) {
            return 1;
        } else {
            return 0;
        }

    }

    public int solutionFail(String s) {
        char[] arr = s.toCharArray();
        ArrayList<Character> list = new ArrayList<>();
        for (char c : arr) {
            list.add(c);
        }

        int i = 0;
        while (i <= list.size()) {
            for (int j = 0; j < list.size() - 1; j++) {
                if (list.get(j).equals(list.get(j + 1))) {
                    list.remove(j);
                    list.remove(j);
                    break;
                } else {
                    i++;
                }
            }
        }
        if (list.size() == 0) {
            return 1;
        } else {
            return 0;
        }
    }

}
