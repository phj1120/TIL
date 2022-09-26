package y22.m09.d26;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[][] maps) {
        Queue<Node> queue = new LinkedList<>();
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int n = maps.length;
        int m = maps[0].length;

        queue.add(new Node(0, 0));
        while (!queue.isEmpty()) {
            Node newNode = queue.poll();
            int x = newNode.x;
            int y = newNode.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (maps[nx][ny] == 1) {
                        maps[nx][ny] = maps[x][y] + 1;
                        queue.add(new Node(nx, ny));
                    }
                }
            }
        }

        if (maps[n - 1][m - 1] == 1) {
            return -1;
        }
        return maps[n - 1][m - 1];
    }
}

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class GameMap {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] maps = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
        int correctResult = 11;
        int answer = solution.solution(maps);

        System.out.println(answer == correctResult);
        System.out.println(answer);
    }
}

