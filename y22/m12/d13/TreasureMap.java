package y22.m12.d13;

import java.util.LinkedList;
import java.util.Queue;

public class TreasureMap {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int n = 4;
        int m = 4;
        int[][] hole = {{2, 3}, {3, 3}};
        int correctAnswer = 5;

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
//        // n : 가로 / m : 세로
//        boolean[][] isVisited = new boolean[m][n];
//        boolean[][] map = new boolean[m][n];
//
//        for (int[] data : hole) {
//            map[data[1] - 1][data[0] - 1] = true;
//        }
//        int minDistance = Integer.MAX_VALUE;
//        Queue<Node> queue = new LinkedList<>();
//        queue.add(new Node(0, 0, 0, 0));
//        while (!queue.isEmpty()) {
//            if (nowN == this.n - 1 && nowM == this.m - 1) {
//                minDistance = Math.min(minDistance, map[nowM][nowN]);
//                return;
//            }
//
//            if (jumpCount < JUMP_MAX_COUNT) {
//                // 2단 점프
//                for (int i = 0; i < d2m.length; i++) {
//                    int nextN = nowN + d2n[i];
//                    int nextM = nowM + d2m[i];
//                    if (nextM < this.m && nextM >= 0 && nextN < this.n && nextN >= 0 && map[nextM][nextN] == Integer.MAX_VALUE) {
//                        int beforeValue = map[nextM][nextN];
//                        if (beforeValue != Integer.MAX_VALUE && beforeValue >= nextM * nextN) continue;
//                        map[nextM][nextN] = map[nowM][nowN] + 1;
//                        dfs(nextN, nextM, ++jumpCount);
//                        jumpCount--;
//                        map[nextM][nextN] = beforeValue;
//                    }
//                }
//            }
//            // 1단 점프
//            for (int i = 0; i < dm.length; i++) {
//                int nextN = nowN + dn[i];
//                int nextM = nowM + dm[i];
//                if (nextM < this.m && nextM >= 0 && nextN < this.n && nextN >= 0 && map[nextM][nextN] == Integer.MAX_VALUE) {
//                    int beforeValue = map[nextM][nextN];
//                    if (beforeValue != Integer.MAX_VALUE && beforeValue >= nextM * nextN) continue;
//                    map[nextM][nextN] = map[nowM][nowN] + 1;
//                    dfs(nextN, nextM, jumpCount);
//                    map[nextM][nextN] = beforeValue;
//                }
//            }
//        }
//
//
//        if (minDistance == Integer.MAX_VALUE) {
//            return -1;
//        }
//        return minDistance;
        return 0;
    }

    static class Node {
        int x;
        int y;
        int time;
        int jumpCount;

        public Node(int x, int y, int time, int jumpCount) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.jumpCount = jumpCount;
        }
    }
}