package y22.m04.d01;

import java.util.Scanner;
import java.util.Stack;

public class Q1918Sol {
    static int precedence(char ch) {
        if(ch=='(') return 0;
        if(ch=='+' || ch=='-') return 1;
        else return 2;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
//        String s = "A*(B+C)";

        String ans = "";
        Stack<Character> ops = new Stack<>();
        for (char ch : s.toCharArray()) {
//            System.out.println("ops " + ops + "   ch = " + ch + " ans = " + ans);
            if ('A' <= ch && 'Z' >= ch) {
                ans += ch;
            } else if (ch == '(') {
                ops.push(ch);
            } else if (ch == ')') {
                while (!ops.isEmpty()) {
                    char op = ops.pop();
                    if (op =='(') break;
                    ans += op;
                }
            } else {
                while (!ops.isEmpty() && precedence(ops.peek()) >= precedence(ch)) {
//                    System.out.println("s.peek() = " + ops.peek() +" ch = " + ch);
                    ans += ops.pop();
                }
                ops.push(ch);
            }
        }
        while (!ops.isEmpty()) {
            ans += ops.pop();
        }
        System.out.println(ans);
    }
}
