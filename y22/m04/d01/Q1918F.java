package y22.m04.d01;

import java.util.Scanner;
import java.util.Stack;

public class Q1918F {
    public static boolean isRowRank(char preIn, char newIn) {
        if ('(' == preIn) {
            return true;
        }
        if ('*' == newIn || '/' == newIn) {
            if ('+' == preIn || '-' == preIn) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String exp = sc.nextLine();
        Stack<Character> s = new Stack<>();
        String result = "";
        for (char ch: exp.toCharArray()) {
            if ('('==ch) {
                s.push(ch);
            } else if (')' == ch) {
                while (!s.isEmpty()) {
                    char op = s.pop();
                    if ('(' == op) break;
                    result += op;
                }
            } else if (ch>='A' && ch<='Z') {
                result += ch;
            } else {
                while (!s.empty() && !isRowRank(s.peek(), ch)) {
                    result += s.pop();
                }
                s.push(ch);
            }
        }
        while (!s.isEmpty()) {
            result += s.pop();
        }
        System.out.println(result);
    }
}
