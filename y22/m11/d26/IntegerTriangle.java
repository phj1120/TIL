package m11.d26;

import java.util.Arrays;

public class IntegerTriangle {
    public static void main(String[] args) {
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        int correctAnswer = 30;

        Solution solution = new Solution();
        int answer = solution.solution(triangle);

        System.out.println(correctAnswer == answer);
        System.out.println(answer);
    }

    static class Solution {
        public int solution(int[][] triangle) {
            int[][] dp = new int[triangle.length][triangle[triangle.length - 1].length];

            dp[0][0] = triangle[0][0];
            for (int i = 0; i < triangle.length - 1; i++) {
                for (int j = 0; j < triangle[i].length; j++) {
                    dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j] + triangle[i + 1][j]);
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i][j] + triangle[i + 1][j + 1]);
                }
            }

            return Arrays.stream(dp[dp.length - 1]).max().getAsInt();
        }
    }
}

