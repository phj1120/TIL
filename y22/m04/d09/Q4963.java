package y22.m04.d09;

import java.util.*;

public class Q4963 {
    static int[][] arr;
//    m : X(너비) , n : Y(높이)
    static int cnt, n, m;

//    1 : 땅 / 0 : 바다 
//    땅의 개수
    static void dfs(int x, int y) {
        arr[y][x] = 0;
        int[] arrX = {x - 1, x, x + 1};
        int[] arrY = {y - 1, y, y + 1};

        for (int i : arrY) {
            for (int j : arrX) {
                if (j == -1 || i == -1 || j == m || i == n) continue;
                if (arr[i][j] == 1) {
                    dfs(j, i);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            m = sc.nextInt();
            n = sc.nextInt();
            if(n==0 && m == 0) {
                sc.close();
                break;
            }
            arr = new int[n][m];
            cnt = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
//        for (int[] subArray : arr) {
//            System.out.println(Arrays.toString(subArray));
//        }
//        System.out.println();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] == 1) {
                        dfs(j, i);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }
}
//4 5
//00110
//00011
//11111
//00000