package y22.m09.d10;

import java.io.*;
import java.util.Arrays;

public class Q2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        for (int i : arr) {
            bw.write(i+"\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}

/*
5
5
2
3
4
1
 */
