package y22.m12.d12;

import java.util.Arrays;

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
    int JUMP_MAX_COUNT = 1;
    int n;
    int m;
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    int[] d2x = {2, -2, 0, 0};
    int[] d2y = {0, 0, 2, -2};

    public int solution(int n, int m, int[][] hole) {
        this.n = n;
        this.m = m;

        // n : 가로 / m : 세로
        int[][] map = new int[m][n];
        for (int[] ints : map) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }

        for (int[] data : hole) {
            map[data[1] - 1][data[0] - 1] = -1;
        }
        printMap(map);
        dfs(0, 0, 0);

        if (map[m - 1][n - 1] == Integer.MAX_VALUE) {
            return -1;
        }
        return map[m - 1][n - 1];
    }

    private void dfs(int nowN, int nowM, int jumpCount) {

    }

    private void printMap(int[][] map) {
        for (int[] ints : map) {
            System.out.println(Arrays.toString(ints));
        }
    }
}