package y22.m04.d14;

import java.util.Scanner;

public class Knight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();
        int x = str.charAt(0) - 'a';
        int y = str.charAt(1) - '0';
        int way = 0;

        int[] dx = {2, 2, -2, -2, -1, 1, -1, 1};
        int[] dy = {1, -1, 1, -1, -2, -2, 2, 2};
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
//            if (nx < 1 || nx > 9 || ny < 1 || ny > 9) continue;
//            way++;

            if (nx >= 1 && nx <= 9 && ny >= 1 && ny <= 9) {
                way++;
            }
        }
        System.out.print(way);
    }
}
