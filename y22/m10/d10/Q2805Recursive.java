package y22.m10.d10;

import java.io.*;
import java.util.Arrays;

public class Q2805Recursive {
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
        System.out.println(binarySearch(left, right, m, trees));
    }

    public static int binarySearch(int left, int right, int m, int[] trees) {
        if (left > right) {
            System.out.println("[return] left = " + left + ", right = " + right);
            return right;
        }

        long total = 0;
        int mid = (left + right) / 2;
        for (int tree : trees) {
            if (tree > mid) {
                total += tree - mid;
            }
        }

        System.out.println("total = " + total + " , left = " + left + ", mid = " + mid + " , right = " + right);
        if (m > total) {
            return binarySearch(left, mid - 1, m, trees);
        } else {
            return binarySearch(mid + 1, right, m, trees);
        }
    }
}
