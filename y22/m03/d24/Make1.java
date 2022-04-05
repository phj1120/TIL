package y22.m03.d24;

import java.util.Scanner;

public class Make1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n];

        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int inf = 30001;
            if (n % 5 == 0) {
                inf = Math.min(inf, dp[i / 5] + 1);
            }
            if (n % 3 == 0) {
                inf = Math.min(inf, dp[i / 3] + 1);
            }
            if (n % 2 == 0) {
                inf = Math.min(inf, dp[i / 2] + 1);
            }
            inf = Math.min(inf, dp[i - 1] + 1);

            dp[i] = inf;
        }
        System.out.println(dp[n-1]);
    }
}
