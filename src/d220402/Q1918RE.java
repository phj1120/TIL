package d220402;

import java.util.Scanner;
import java.util.Stack;

public class Q1918RE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        Stack<Character> s = new Stack<>();
        String result = "";
        for (char ch : str.toCharArray()) {
//            System.out.println("ch = "+ch + " s = "+s + " result = "+result);
            if (ch >= 'A' && ch <= 'Z') {
                result += ch;
            } else if(ch=='('){
                s.push(ch);
            } else if (ch == ')') {
                while (!s.isEmpty()) {
                    char op = s.pop();
                    if (op == '(') break;
                    result += op;
                }
            } else {
                while(!s.isEmpty() && !(((s.peek() == '+' || s.peek() == '-') && (ch == '*' || ch == '/')) || (s.peek() == '('))){
//                    System.out.println("s.peek() = " + s.peek() + " ch = " + ch);
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
