package d220402;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Ex11_4 {
    static int MAX_SIZE = 5;
    static Queue q = new LinkedList();

    static public void save(String s) {
        if (q.size() >= MAX_SIZE) {
            q.poll();
        }
        q.offer(s);
    }

    public static void main(String[] args) {
        System.out.println("help 입력시 도움말");

        while (true) {
            System.out.print(">> ");
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine().trim();
            if (s.isEmpty()) continue;
            if ("help".equalsIgnoreCase(s)) {
                System.out.println("help - 도움말");
                System.out.println("q - 프로그램 종료");
                System.out.println("history - 최근 입력한 명령어 수 "+ MAX_SIZE + "개 출력");
            } else if ("q".equalsIgnoreCase(s)) {
                System.exit(0);
            } else if ("history".equalsIgnoreCase(s)) {
                save(s);
                LinkedList list = (LinkedList) q;

                final int SIZE = list.size();
                for (int i = 0; i < SIZE; i++) {
                    System.out.println(i+1 + " : " + list.get(i));
                }
            } else {
                save(s);
            }
        }
    }
}
