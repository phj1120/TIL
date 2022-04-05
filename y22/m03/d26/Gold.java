package y22.m03.d26;

import java.util.Scanner;

public class Gold {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        값에 제한을 두기 위해서
        int[][] dp = new int[20][20];

        int testCase = sc.nextInt();
        for (int tc = 0; tc < testCase; tc++) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    dp[i][j] = sc.nextInt();
                }
            }
            for (int i = 1; i < m; i++) {
                for (int j = 0; j < n; j++) {
//                  SOL
//                    int leftUp, leftDown, left;
//                    if(i==0) leftUp = 0;
//                    else leftUp = dp[j - 1][i - 1];
//
//                    if(i==n-1) leftDown = 0;
//                    else leftDown = dp[j + 1][i - 1];
//
//                    left = dp[j][i - 1];
//                    dp[j][i] = Math.max(leftDown, Math.max(left, leftUp));

//                  MY
                    if (j == 0)
                        dp[j][i] = dp[j][i] + Math.max(dp[j][i - 1], dp[j + 1][i - 1]);
                    else if (j == n - 1) {
                        dp[j][i] = dp[j][i] + Math.max(dp[j][i - 1], dp[j - 1][i - 1]);
                    }else {
                        dp[j][i] = dp[j][i] + Math.max(dp[j - 1][i - 1], Math.max(dp[j][i - 1], dp[j + 1][i - 1]));
                    }
                }
            }

            int result = 0;
            for (int i = 0; i < n; i++) {
                result = Math.max(result, dp[i][m - 1]);
            }
            System.out.println(result);
        }
    }
}
