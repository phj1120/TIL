package y22.m12.d12;

import java.util.Arrays;

public class TreasureMap {
    public static void main(String[] args) {
        Solution solution = new Solution();

//        int n = 4;
//        int m = 4;
//        int[][] hole = {{2, 3}, {3, 3}};
//        int correctAnswer = 5;

        int n = 1000;
        int m = 1000;
        int[][] hole = {};
        int correctAnswer = 2000;
        int answer = solution.solution(n, m, hole);

        System.out.println(answer == correctAnswer);
        System.out.println(answer);
    }
}

class Solution {
    int JUMP_MAX_COUNT = 1;
    int n;
    int m;
    int[][] map;
    int minDistance = Integer.MAX_VALUE;
    int maxDistance = Integer.MIN_VALUE;
    int[] dn = {1, -1, 0, 0};
    int[] dm = {0, 0, 1, -1};
    int[] d2n = {2, -2, 0, 0};
    int[] d2m = {0, 0, 2, -2};

    public int solution(int n, int m, int[][] hole) {
        this.n = n;
        this.m = m;

        // n : 가로 / m : 세로
        map = new int[m][n];
        for (int[] ints : map) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }
        map[0][0] = 0;

        for (int[] data : hole) {
            map[data[1] - 1][data[0] - 1] = -1;
        }
        dfs(0, 0, 0);

        if (minDistance == Integer.MAX_VALUE) {
            return -1;
        }
        return minDistance;
    }

    private void dfs(int nowN, int nowM, int jumpCount) {
        if (nowN == this.n - 1 && nowM == this.m - 1) {
            minDistance = Math.min(minDistance, map[nowM][nowN]);
            maxDistance = Math.max(maxDistance, map[nowM][nowN]);
            return;
        }

        if (jumpCount < JUMP_MAX_COUNT) {
            // 2단 점프
            for (int i = 0; i < d2m.length; i++) {
                int nextN = nowN + d2n[i];
                int nextM = nowM + d2m[i];
                if (nextM < this.m && nextM >= 0 && nextN < this.n && nextN >= 0 && map[nextM][nextN] == Integer.MAX_VALUE) {
                    int beforeValue = map[nextM][nextN];
                    if (beforeValue != Integer.MAX_VALUE && beforeValue >= nextM * nextN) continue;
                    map[nextM][nextN] = map[nowM][nowN] + 1;
                    dfs(nextN, nextM, ++jumpCount);
                    jumpCount--;
                    map[nextM][nextN] = beforeValue;
                }
            }
        }
        // 1단 점프
        for (int i = 0; i < dm.length; i++) {
            int nextN = nowN + dn[i];
            int nextM = nowM + dm[i];
            if (nextM < this.m && nextM >= 0 && nextN < this.n && nextN >= 0 && map[nextM][nextN] == Integer.MAX_VALUE) {
                int beforeValue = map[nextM][nextN];
                if (beforeValue != Integer.MAX_VALUE && beforeValue >= nextM * nextN) continue;
                map[nextM][nextN] = map[nowM][nowN] + 1;
                dfs(nextN, nextM, jumpCount);
                map[nextM][nextN] = beforeValue;
            }
        }
    }

    private void printMap() {
        for (int[] ints : map) {
            System.out.println(Arrays.toString(ints));
        }
    }
}