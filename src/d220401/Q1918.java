package d220401;

import java.util.Scanner;
import java.util.Stack;

public class Q1918 {
    public static boolean isRowRank(Object preIn, Object newIn) {
        if ("(".equals(preIn)) {
            return true;
        }

        if ("*".equals(preIn) || "/".equals(preIn)) {
            if ("+".equals(newIn) || "-".equals(newIn))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String exp = sc.nextLine();
        String exp = "3*(4+1)";
        Stack s = new Stack();
        String result = "";
        String ch;
        int i = 0;
        while (exp.length() > 0 && s.isEmpty()) {
            ch = Character.toString(exp.charAt(i));
            System.out.println("s = " + s);
            System.out.println("ch = " + ch);
            System.out.println("result = " + result);

            if ("(".equals(ch)) {
                s.push(ch);
            } else if (")".equals(ch)) {
                while (true) {
                    if ("(".equals(ch)) break;
                    result += (String) s.pop();
                }
                s.pop();
            }
            else if (Character.isDigit(ch.charAt(0))) {
                result += ch;
            } else {
                if (s.empty()) {
                    s.push(ch);
                } else {
                    if (isRowRank(s.peek(), ch)) {
                        s.push(ch);
                    } else {
                        result += s.pop();
                        s.push(ch);
                    }
                }
            }
            i++;
        }
        System.out.println("result = " + result);
    }
}
