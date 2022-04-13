package y22.m04.d13;

import java.util.Scanner;

public class UDLR {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        String strWay = sc.nextLine();
        String[] strList = strWay.split(" ");

        String[] way = {"U", "D", "L", "R"};
        String[][] arr = new String[n][n];

        int x = 1;
        int y = 1;

        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        for (String str : strList) {
            for (int i = 0; i < 4; i++) {
                if (way[i].equals(str)) {
                    x = x + dx[i];
                    y = y + dy[i];
                    System.out.printf("%d %d\n", x, y);
                }
            }
        }
        System.out.printf("%d %d", x, y);
    }
}
