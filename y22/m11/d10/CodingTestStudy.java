package y22.m11.d10;

import java.util.Arrays;

public class CodingTestStudy {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int answer = solution.solution(10, 10, new int[][]{{10, 15, 2, 1, 2}, {20, 20, 3, 3, 4}});
//        System.out.println(answer);
        int answer2 = solution.solution(0, 0, new int[][]{{0, 0, 2, 1, 2}, {4, 5, 3, 1, 2}, {4, 11, 4, 0, 2}, {10, 4, 0, 4, 2}});
        System.out.println(answer2);
    }

    static class Solution {
        public int solution(int alp, int cop, int[][] problems) {
            int algorithmStat = 0;
            int codingStat = 0;
            for (int[] problem : problems) {
                algorithmStat = Math.max(problem[0], algorithmStat);
                codingStat = Math.max(problem[1], codingStat);
            }

            // 알고력, 알파력을 달성하는데 걸리는 최단 시간
            int[][] dp = new int[algorithmStat + 1][codingStat + 1];
            for (int i = 0; i <= algorithmStat; i++) {
                Arrays.fill(dp[i], Integer.MAX_VALUE);
            }

            alp = Math.min(alp, algorithmStat);
            cop = Math.min(cop, codingStat);
            dp[alp][cop] = 0;

            for (int a = alp; a < algorithmStat + 1; a++) {
                for (int c = cop; c < codingStat + 1; c++) {
                    // 알고리즘 1시간 공부
                    if (a < algorithmStat) {
                        dp[a + 1][c] = Math.min(dp[a + 1][c], dp[a][c] + 1);
                    }
                    // 코딩 테스트 1시간 공부
                    if (c < codingStat) {
                        dp[a][c + 1] = Math.min(dp[a][c + 1], dp[a][c] + 1);
                    }
                    // 풀 수 있는 문제 풀이
                    for (int[] problem : problems) {
                        int requiredAlgorithmStat = problem[0];
                        int requiredCodingStat = problem[1];
                        int plusAlgorithmStat = problem[2];
                        int plusCodingStat = problem[3];
                        int spentTime = problem[4];

                        if (requiredAlgorithmStat <= a && requiredCodingStat <= c) {
                            int nowAlgorithmStat = Math.min(algorithmStat, a + plusAlgorithmStat);
                            int nowCodingStat = Math.min(codingStat, c + plusCodingStat);
                            dp[nowAlgorithmStat][nowCodingStat] = Math.min(dp[nowAlgorithmStat][nowCodingStat], dp[a][c] + spentTime);
                            if (dp[nowAlgorithmStat][nowCodingStat] == 14) {
                                System.out.println();
                            }
                        }
                    }
                }
            }
            return dp[algorithmStat][codingStat];
        }
    }

}
