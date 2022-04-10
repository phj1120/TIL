package y22.m04.d10;

import java.util.Scanner;

public class Q4963 {
    static int w, h, cnt;
    static int[][] arr = new int[50][50];

    static boolean dfs(int x, int y) {
        if (x <= -1 || x >= w || y <= -1 || y >= h) { // 주어진 범위 벗어나는 경우 종료
            return false;
        }
        int[] arrX = {x - 1, x, x + 1};
        int[] arrY = {y - 1, y, y + 1};

        if (arr[x][y] == 1) {
            arr[x][y] = 0;
            for (int i : arrX) {
                for (int j : arrY) {
                    dfs(i, j);
                }
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            w = sc.nextInt();
            h = sc.nextInt();

            if(w==0 && h == 0) {
                sc.close();
                break;
            }

            sc.nextLine();
            arr = new int[w][h];
            cnt = 0;

            for (int i = 0; i < h; i++) {
                String str = sc.nextLine();
                String[] strArr = str.split(" ");
                for (int j = 0; j < w; j++) {
                    arr[j][i] = Integer.parseInt(strArr[j]);
                }
            }

            for (int i = 0; i < w; i++) {
                for (int j = 0; j < h; j++) {
                    if (dfs(i, j)) {
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }
}