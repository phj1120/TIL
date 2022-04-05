package y22.m03.d22;

import java.io.*;
import java.util.Scanner;

public class Make1 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        int[] dp = new int[num+1];
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;
        dp[5] = 1;

        int cnt;
        for (int i = 1; i <= num; i++) {
            if(dp[i] != 0){
                continue;
            }
            cnt = 300001;
            if (i % 5 == 0 && dp[i / 5] + 1 < cnt) {
                cnt = dp[i / 5] + 1;
            }
            if (i % 3 == 0 && dp[i / 3] + 1 < cnt) {
                cnt = dp[i / 3] + 1;
            }
            if (i % 2 == 0 && dp[i / 2] + 1 < cnt) {
                cnt = dp[i / 2] + 1;
            }
            if (dp[i - 1 ] + 1 < cnt) {
                cnt = dp[i - 1] + 1;
            }
            dp[i] = cnt;
        }
        bw.write(String.valueOf(dp[num]));

        br.close();
        bw.flush();
        bw.close();
    }
}
class Make12 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] dp = new int[1000001];
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;
        dp[5] = 1;

        int cnt;
        for (int i = 1; i <= num; i++) {
            if(dp[i] != 0){
                continue;
            }
            cnt = 300001;
            if (i % 5 == 0 && dp[i / 5] + 1 < cnt) {
                cnt = dp[i / 5] + 1;
            }
            if (i % 3 == 0 && dp[i / 3] + 1 < cnt) {
                cnt = dp[i / 3] + 1;
            }
            if (i % 2 == 0 && dp[i / 2] + 1 < cnt) {
                cnt = dp[i / 2] + 1;
            }
            if (dp[i - 1 ] + 1 < cnt) {
                cnt = dp[i - 1] + 1;
            }
            dp[i] = cnt;
        }
        System.out.println(dp[num]);
    }
}
