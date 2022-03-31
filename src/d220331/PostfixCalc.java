package d220331;

import java.util.Scanner;

public class PostfixCalc {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String ex = sc.nextLine();
        String ex = "5 2 * 4 + 7 *";
        String exp[] = ex.split(" ");
        Stack s = new Stack();
        int in, x, y = 0;
        String ch;

        for (int i = 0; i < exp.length; i++) {
            ch = exp[i];
            if ("*".equals(ch) || "/".equals(ch) || "+".equals(ch) || "-".equals(ch)) {
                y = (int) s.pop();
                x = (int) s.pop();
                switch (ch) {
                    case "*":
                        s.push(y * x);
                        break;
                    case "/":
                        s.push(y / x);
                        break;
                    case "+":
                        s.push(y + x);
                        break;
                    case "-":
                        s.push(y - x);
                        break;
                }
            } else {
                in = Integer.parseInt(exp[i]);
                s.push(in);
            }
        }
        System.out.println(s.pop());
    }
}
