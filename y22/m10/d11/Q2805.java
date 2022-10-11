package y22.m10.d11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");
        int n = Integer.parseInt(line1[0]);
        int m = Integer.parseInt(line1[1]);

        int[] trees = new int[n];
        String[] line2 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(line2[i]);
        }

        int left = 0;
        int right = Arrays.stream(trees).max().getAsInt();

        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (check(mid, m, trees)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        System.out.println(left);
    }

    public static boolean check(int mid, int m, int[] trees) {
        long total = 0;
        for (int tree : trees) {
            if (tree > mid) {
                total += tree - mid;
            }
        }
        return total >= m;
//        if (total >= m) {
//            return true;
//        }
//        return false;
    }
}
