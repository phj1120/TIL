package y22.m03.d25;

import java.util.Arrays;
import java.util.Scanner;

public class MoneySol {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int INF = 10001;
        int n = sc.nextInt();
        int m = sc.nextInt();
        int arr[] = new int[n];
        int d[] = new int[m + 1];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.fill(d, INF);
        d[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = arr[i]; j <= m; j++) {
                if (d[j-arr[i]] != INF) {
                    d[j] = Math.min(d[j - arr[i]] + 1, d[j]);
                }
            }
        }
        if (d[m]==INF) System.out.println(-1);
        else System.out.println(d[m
                ]);
    }

}
