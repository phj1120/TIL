package y22.m04.d11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Maze {
    public static ArrayList<Integer> distances = new ArrayList<>();
    public static int m, n;

    public static void dfs(int[][] oriMaze, int distance, int x, int y){
//        System.out.printf("x : %d, y : %d, distance : %d\n",x, y, distance);
        int[][] maze = oriMaze.clone(); // 주소가 아니라 값 넘겨주는거 맞겠지? // 애초에 값 넘겨주는거라 선언 안해도 될 듯?
        // 자바에서 포인터처럼 주소 넘기기 가능했나 -> static 으로 선언하면 공유 가능
        if (x <= -1 || x >= m || y <= -1 || y >= n) {
            return;
        }
        if (x == m - 1 && y == n - 1) {
            distances.add(distance);
            return;
        }
        if (maze[x][y] == 1) {
            maze[x][y] = 0;
//            printMaze(maze, distance, x, y);
            dfs(maze, distance + 1, x, y - 1);
            dfs(maze, distance + 1, x, y + 1);
            dfs(maze, distance + 1, x -1, y);
            dfs(maze, distance + 1, x +1, y);
        }
    }

    private static void printMaze(int[][] maze, int distance, int x, int y) {
        System.out.println("maze = " + maze);
        System.out.printf("x : %d,  y: %d, distance : %d \n", x, y, distance);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(maze[j][i]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 줄
        m = sc.nextInt(); // 칸
        sc.nextLine();

//        n = 5;
//        m = 6;

        int[][] maze = new int[m][n];

//        String[] testMaze ={ "101010", "111111",
//                "000001", "111111", "111111" };
//        String[] testMaze ={ "111111", "000001",
//                "000001", "000001", "111111" };
//        String[] testMaze ={ "111111", "100001",
//                "111111", "100001", "111111" };
//        for (int i = 0; i < n; i++) {
//            String str = testMaze[i];
//            for (int j = 0; j < m; j++) {
//                maze[j][i] = str.charAt(j) - '0';
//            }
//        }
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < m; j++) {
                maze[j][i] = str.charAt(j) - '0';
            }
        }
//        printMaze(maze, 1, 0, 0);
        dfs(maze, 1 ,0 ,0);

//        System.out.println(distances);
        System.out.println(Collections.min(distances));
    }
}

/*

5 6
101010
111111
000001
111111
111111


5 6
111111
001110
111010
100000
111111


4 6
110110
110110
111111
111101

 */