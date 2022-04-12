package y22.m04.d12;

import java.util.*;

public class MazeBfsFail {
    static Map<String, Integer> map;
    static Queue q;
    static int[][] maze;
    static boolean[][] visited;
    static int n, m;

    static int bfs(int startX, int startY) {

        // 초기 값 설정
        int distance = 0;
        map = new HashMap<String, Integer>();
        map.put("x", startX);
        map.put("y", startY);
        q.offer(map);
        visited[startY][startX] = true;

        // 반복
        while (!q.isEmpty()) {
            map = (Map<String, Integer>) q.poll();
            int x = map.get("x");
            int y = map.get("y");

            // 종료 조건
            if (x == m - 1 && y == n - 1) {
                break;
            }

            // 주위 탐색
            int[] xList = {x, x, x - 1, x + 1};
            int[] yList = {y - 1, y + 1, y, y};
            for (int i = 0; i < xList.length; i++) {
                x = xList[i];
                y = yList[i];
                // 해당 범위를 벗어날 경우
                if (x >= m || x < 0 || y >= n || y < 0) continue;
                System.out.println("x : " + x + " y : " + y);

                // 방문한 적 없으면서 갈 수 있는 길인 경우
                if (!visited[y][x] && maze[y][x] == 1) {
                    printMaze();
                    map = new HashMap<String, Integer>();
                    map.put("x", x);
                    map.put("y", y);
                    q.offer(map);
                    System.out.println("q = " + q);
                    visited[y][x] = true;
                    distance++;
                }
            }
            System.out.println("distance = " + distance);
            System.out.println();
        }
        return distance;
    }

    public static void main(String[] args) {
        map = new HashMap<String, Integer>();
        q = new LinkedList<Map<String, Integer>>();

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 줄
        m = sc.nextInt(); // 칸
        sc.nextLine();

        maze = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < m; j++) {
                maze[i][j] = str.charAt(j) - '0';
                visited[i][j] = false;
            }
        }

        printMaze();
        System.out.println(bfs(0, 0));

    }

    private static void printMaze() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}

/*

4 6
101111
101010
101011
111011

 */