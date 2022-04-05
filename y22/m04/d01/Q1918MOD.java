package y22.m04.d01;

import java.util.Scanner;
import java.util.Stack;

public class Q1918MOD {
//    preIn 이 newIn 보다 우선 순위가 낮나요?
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
//        char t = 'B';
//        System.out.println("'B' = " + (int)'B'); // 66
//        System.out.println("'Z' = " + (int)'Z'); // 90
//        System.out.println("t <= 'A' && t <= 'Z' = " + (t <= 'A' && t <= 'Z')); // A ~ Z 를 제외한 값
//        System.out.println("t >= 'A' && t >= 'Z' = " + (t >= 'A' && t >= 'Z'));
//        System.out.println("t <= 'A' && t >= 'Z' = " + (t <= 'A' && t >= 'Z'));
//        System.out.println("t >= 'A' && t <= 'Z' = " + (t >= 'A' && t <= 'Z')); // A ~ Z 사이의 값

        Scanner sc = new Scanner(System.in);
        String exp = sc.nextLine();
//        String exp = "A*(B+C)";
//        String exp = "A+B*C-D/E";
//        String exp = "A+B-C+D-E";
        Stack<Character> s = new Stack<>();
        String result = "";
        for (char ch: exp.toCharArray()) {
//            System.out.println("s = " + s + "   ch = " + ch + " result = " + result);
            if ('('==ch) {
                s.push(ch);
            } else if (')' == ch) {
                while (!s.isEmpty()) {
                    char op = s.pop();
                    if ('(' == op) break; //  '(' == ch 로 비교 했으나 ch 에서 비교할 것이 아니라 stack 에서 비교했어야함
                    result += op;
                }
            } else if (ch>='A' && ch<='Z') {
                result += ch;
            } else {
//              while (!isRowRank(s.peek(), ch) && !s.empty()) { // 이렇게 하면 s.peek 로 꺼내 올 것이 없어서 오류 발생
                while (!s.empty() && !isRowRank(s.peek(), ch)) { // s.empty 로 s.peek 가 존재하는지 확인 // 이것도 순서가 있나보네
//                while (!s.isEmpty() && precedence(s.peek()) >= precedence(ch)) {
//                    System.out.println("s.peek() = " + s.peek() +" ch = " + ch);
                    result += s.pop();
                }
                s.push(ch);
            }
        }
//        여기에 왜 pop 을 하나 했는데 exp 만큼 다 돌고나면 stack 안에 남아있는 op 를 빼주기 위함이 었음
        while (!s.isEmpty()) {
            result += s.pop();
        }
        System.out.println(result);
    }
}
