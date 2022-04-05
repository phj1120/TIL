package y22.m03.d21;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class AntWarrior {
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int k = Integer.parseInt(br.readLine());
        String inputString[] = br.readLine().split(" ", k);
        int input[] = new int[k];

        int idx = 0;
        for (String i : inputString) {
            input[idx] = Integer.parseInt(i);
            idx++;
        }

        int L[] = new int[k];
        int R[] = new int[k];
        int D[] = new int[k];

        L[0] = input[0];
        L[1] = input[1];
        for (int i = 2; i < k; i++) {
            L[i] = L[i - 2] + input[i];
        }

        R[k - 1] = input[k - 1];
        R[k - 2] = input[k - 2];
        for (int i = k - 3; i >= 0; i--) {
            R[i] = R[i + 2] + input[i];
        }

        int max = 0;
        for (int i = 0; i < k; i++) {
            D[i] = L[i] - input[i] + R[i];
            if (max < D[i]) {
                max = D[i];
            }
        }

        System.out.println("D = " + Arrays.toString(D));
        System.out.println("R = " + Arrays.toString(R));
        System.out.println("L = " + Arrays.toString(L));
        System.out.println("input = " + Arrays.toString(input));

        bw.write(max+"");

        br.close();
        bw.flush();
        bw.close();
    }
}

/*
처음 아이디어는 잘 생각해 냈으나 중간에 이상한 곳으로 빠졌다.
왜 좌 우 값을 더할 생각을 했을까?

한 쪽으로 쭉 가다보면 결국 그 값이 그 값인데
그래도 처음치고 재밌었다.

오래 붙들고 있으니까 머리 아픔

조금씩 꾸준히
 */