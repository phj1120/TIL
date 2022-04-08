package y22.m04.d08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q4963Sol {
    private static final int[][] cardinalPoints = {{0, 1}, {0, -1}, {1, 0}, {1, 1}, {1, -1}, {-1, 0}, {-1, 1}, {-1, -1}};
    private static boolean[][] islands;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer spec = new StringTokenizer(br.readLine());
            int width = Integer.parseInt(spec.nextToken());
            int height = Integer.parseInt(spec.nextToken());

            if(width == 0 && height == 0) {
                return;
            }

            islands = new boolean[height + 2][width + 2];

            for(int i = 1; i <= height; i++) {
                String s = br.readLine();
                for(int j = 1; j <= width; j++) {
                    islands[i][j] = s.charAt((j - 1) * 2) > '0';
                }
            }
            int result = 0;
            for(int i = 1; i <= height; i++) {
                for(int j = 1; j <= width; j++) {
                    if(islands[i][j]) {
                        result++;
                        dfs(i, j, islands);
                    }
                }
            }
            System.out.println(result);
        }
    }

    private static void dfs(int height, int width, boolean[][] islands) {
        for(int[] cardinalPoint : cardinalPoints) {
            int nextHeight = height + cardinalPoint[0];
            int nextWidth = width + cardinalPoint[1];

            if(islands[nextHeight][nextWidth]) {
                islands[nextHeight][nextWidth] = false;
                dfs(nextHeight, nextWidth, islands);
            }
        }
    }

}