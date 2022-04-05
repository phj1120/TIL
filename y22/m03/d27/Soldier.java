package y22.m03.d27;

import java.util.Scanner;

public class Soldier {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[2000];
        int[] dp = new int[2000];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[i - 1]) {
                dp[i] = dp[i - 1];
            } else if (arr[i] > arr[i - 1]) {
                dp[i] = Math.min(dp[i - 2] + 1, dp[i - 1] + 1);
            }
        }
        System.out.println(dp[n - 1]);
    }
}
