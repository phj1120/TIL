package d220329;

import java.util.Scanner;

// 최대한 많이 나누기
public class Make1Greedy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int cnt = 0;
        while (true) {
            if (n == 1) break;
            if (n % k == 0) n /= k;
            else n -= 1;
            cnt++;
        }
        System.out.println(cnt);
    }
}
