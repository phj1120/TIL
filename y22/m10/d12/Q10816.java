package y22.m10.d12;

import java.io.*;
import java.util.Arrays;

public class Q10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] line2 = br.readLine().split(" ");
        int m = Integer.parseInt(br.readLine());
        String[] line4 = br.readLine().split(" ");

        int[] cards = new int[n];
        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(line2[i]);
        }
        Arrays.sort(cards);

        int[] question = new int[m];
        for (int i = 0; i < m; i++) {
            question[i] = Integer.parseInt(line4[i]);
        }

        int[] result = new int[m];

        for (int i = 0; i < m; i++) {
            int card = question[i];
            // 총 가지고 있는 카드 개 수 : upperBound - lowerBound
            int upperBound = upperBound(cards, card);
            int lowerBound = lowerBound(cards, card);
//            System.out.println("upperBound = " + upperBound);
//            System.out.println("lowerBound = " + lowerBound);
            int number = upperBound - lowerBound;
            result[i] = number;
            bw.write(number + " ");
        }
        br.close();
        bw.flush();
        bw.close();
    }

    // 해당 값의 가장 작은 인덱스
    static int lowerBound(int[] cards, int card) {
        int left = 0;
        int right = cards.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (cards[mid] < card) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }

    static int upperBound(int[] cards, int card) {
        int left = 0;
        int right = cards.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (cards[mid] <= card) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }

}
