package d220331;

import java.util.Scanner;

public class InfixToPostfix {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
//        String ex = sc.nextLine();
        String ex = "( 5 + 2 ) * 3";
        String exp[] = ex.split(" ");

        Stack s = new Stack();
        String result = "";
        int i = 0;
        String ch;

        while (exp.length > 0) {
            ch = exp[i];
            if ("(".equals(ch)) {
                s.push(ch);
            } else if (")".equals(ch)) {
                result += s.pop();
                s.pop();
            } else if ("*".equals(ch) || "/".equals(ch)) {
                result += s.pop();
                s.push(ch);
            } else if ("+".equals(ch) || "-".equals(ch)) {
                if ("*".equals(s.peek()) || "/".equals(s.peek())) {
                    s.push(ch);
                } else {
                    result += s.pop();
                    s.push(ch);
                }
            } else {
                result += ch;
            }
            i++;
            System.out.println(s.data);
        }
    }
}
