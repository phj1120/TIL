package y22.m04.d09;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q4963Mix {
    static boolean[][] arr;
    static int width, height;

    static void dfs(int x, int y) {
        arr[y][x] = false;
        int[] arrX = {x - 1, x, x + 1};
        int[] arrY = {y - 1, y, y + 1};

        for (int i : arrY) {
            for (int j : arrX) {
                if (j == -1 || i == -1 || j == width || i == height) continue;
                if (arr[i][j]) {
                    dfs(j, i);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer spec = new StringTokenizer(br.readLine());
            width = Integer.parseInt(spec.nextToken());
            height = Integer.parseInt(spec.nextToken());

            if(width == 0 && height == 0) {
                return;
            }

            arr = new boolean[height][width];

            for(int i = 0; i < height; i++) {
                String s = br.readLine();
                for(int j = 0; j < width; j++) {
                    arr[i][j] = s.charAt(2*j) > '0';
                }
            }
            int result = 0;
            for(int i = 0; i < height; i++) {
                for(int j = 0; j < width; j++) {
                    if(arr[i][j]) {
                        result++;
                        dfs(j, i);
                    }
                }
            }
            System.out.println(result);
        }
    }
}
//4 5
//00110
//00011
//11111
//00000