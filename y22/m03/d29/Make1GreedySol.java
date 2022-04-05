package y22.m03.d29;

import java.util.Scanner;

// 최대한 많이 나누기
public class Make1GreedySol {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int result = 0;
        while (true) {
            int target = (n / k) * k;
            result += (n - target);
            n = target;

            if(n<k) break;

            result += 1;
            n /= k;
        }
        result += (n - 1);
        System.out.println(result);
    }
}
