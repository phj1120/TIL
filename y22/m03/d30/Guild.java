package y22.m03.d30;

import java.util.Arrays;
import java.util.Scanner;

public class Guild {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int fear[] = new int[n];
        for (int i = 0; i < n; i++) {
            fear[i] = sc.nextInt();
        }
        Arrays.sort(fear);
        int out = 0, team = 0;
        for (int i = 0; i < n; i++) {
            team += 1;
            if (fear[i] == team) {
                team = 0;
                out += 1;
            }
        }
        System.out.print(out);
    }
}
