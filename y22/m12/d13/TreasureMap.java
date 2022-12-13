package y22.m12.d13;

import java.util.LinkedList;
import java.util.Queue;

public class TreasureMap {
    public static void main(String[] args) {
        Solution solution = new Solution();

//        int n = 4;
//        int m = 4;
//        int[][] hole = {{2, 3}, {3, 3}};
//        int correctAnswer = 5;

        int n = 5;
        int m = 4;
        int[][] hole = {{1, 4}, {2, 1}, {2, 2}, {2, 3}, {2, 4}, {3, 3}, {4, 1}, {4, 3}, {5, 3}};
        int correctAnswer = -1;

        int answer = solution.solution(n, m, hole);
        System.out.println(answer == correctAnswer);
        System.out.println(answer);
    }
}

class Solution {
    int[] dn = {1, -1, 0, 0};
    int[] dm = {0, 0, 1, -1};
    int[] d2n = {2, -2, 0, 0};
    int[] d2m = {0, 0, 2, -2};

    public int solution(int n, int m, int[][] hole) {
        // n : 가로 / m : 세로
        boolean[][][] isVisited = new boolean[m][n][2];
        boolean[][] map = new boolean[m][n];

        for (int[] data : hole) {
            map[data[1] - 1][data[0] - 1] = true;
        }

        isVisited[0][0][1] = true;
        int minDistance = Integer.MAX_VALUE;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 0, 1));
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            int nowM = now.m;
            int nowN = now.n;
            if (nowM == m - 1 && nowN == n - 1) {
                minDistance = Math.min(minDistance, now.time);
            }
            // 1단 점프
            for (int i = 0; i < dm.length; i++) {
                int nextN = nowN + dn[i];
                int nextM = nowM + dm[i];
                if (nextM < m && nextM >= 0 && nextN < n && nextN >= 0
                        && !isVisited[nextM][nextN][now.jumpCount] && !map[nextM][nextN]) {
                    isVisited[nextM][nextN][now.jumpCount] = true;
                    queue.offer(new Node(nextN, nextM, now.time + 1, now.jumpCount));
                }
            }

            // 2단 점프
            if (now.jumpCount > 0) {
                for (int i = 0; i < d2m.length; i++) {
                    int nextN = nowN + d2n[i];
                    int nextM = nowM + d2m[i];
                    if (nextM < m && nextM >= 0 && nextN < n && nextN >= 0 &&
                            !isVisited[nextM][nextN][now.jumpCount - 1] && !map[nextM][nextN]) {
                        isVisited[nextM][nextN][now.jumpCount - 1] = true;
                        queue.offer(new Node(nextN, nextM, now.time + 1, now.jumpCount - 1));
                    }
                }
            }
        }


        if (minDistance == Integer.MAX_VALUE) {
            return -1;
        }
        return minDistance;
    }

    static class Node {
        int n;
        int m;
        int time;
        int jumpCount;

        public Node(int n, int m, int time, int jumpCount) {
            this.n = n;
            this.m = m;
            this.time = time;
            this.jumpCount = jumpCount;
        }
    }
}