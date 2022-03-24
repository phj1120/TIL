package d220324;

import java.util.Scanner;

public class AntWarriorSol {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        int[] f = new int[cnt];
        int[] dp = new int[cnt];

        for (int i = 0; i < cnt; i++) {
            f[i] = sc.nextInt();
        }

        dp[0] = f[0];
        dp[1] = Math.max(f[0], f[1]);
        for (int i = 2; i < cnt; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + f[i]);
        }
        System.out.print(dp[cnt - 1]);
    }
}
