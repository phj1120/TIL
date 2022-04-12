package y22.m04.d12;

import java.util.*;

public class MazeBfsMix {
    static Map<String, Integer> map;
    static Queue q;
    static int[][] maze;
    static boolean[][] visited;
    static int n, m;

    static void bfs(int startX, int startY) {

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

            // 주위 탐색
            int[] xList = {x, x, x - 1, x + 1};
            int[] yList = {y - 1, y + 1, y, y};
            distance = maze[y][x];
            for (int i = 0; i < xList.length; i++) {
                x = xList[i];
                y = yList[i];
                // 해당 범위를 벗어날 경우 무시
                if (x >= m || x < 0 || y >= n || y < 0) continue;

                // 벽인 경우 무시
                if(maze[y][x] == 0) continue;

                // 처음 방문 하는 경우
                if (maze[y][x] == 1) {
//                    printMaze();
                    map = new HashMap<String, Integer>();
                    map.put("x", x);
                    map.put("y", y);
                    q.offer(map);
                    maze[y][x] = distance + 1;
                }
            }
        }
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

//        printMaze();
        bfs(0, 0);
        System.out.println(maze[n - 1][m - 1]);
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