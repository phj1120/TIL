package y22.m04.d11;

import java.util.ArrayList;
import java.util.Scanner;

public class MazeDfs {
    public static int minDistance = Integer.MAX_VALUE;
    public static ArrayList<Integer> distances = new ArrayList<>();
    public static int m, n;

    public static void dfs(int[][] maze, int distance, int x, int y){
        if (x <= -1 || x >= m || y <= -1 || y >= n) {
            return;
        }
        if (x == m - 1 && y == n - 1) {
            minDistance = Math.min(distance, minDistance);
            distances.add(distance);
            return;
        }

        if (distance >= minDistance) {
            return;
        }

        if (maze[x][y] == 1) {
            maze[x][y] = 0;
            dfs(maze, distance + 1, x, y - 1);
            dfs(maze, distance + 1, x, y + 1);
            dfs(maze, distance + 1, x -1, y);
            dfs(maze, distance + 1, x +1, y);
            maze[x][y] = 1; // 이전 분기점 까지 값 원위치
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 줄
        m = sc.nextInt(); // 칸
        sc.nextLine();

        int[][] maze = new int[m][n];

        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < m; j++) {
                maze[j][i] = str.charAt(j) - '0';
            }
        }
        dfs(maze, 1 ,0 ,0);
        System.out.print(minDistance);
    }
}

/*

4 6
100000
111100
100111
111101

 */