package d220323;

// m 원을 만들기 위한 최소한의 화폐 개수
// 첫 줄 : N, M / 화패 개수, 환전할 금액
// 이후의 N 줄에 각 화폐의 가치

import java.util.Arrays;
import java.util.Scanner;

public class Money {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int money = sc.nextInt();

//        s와 dp 동일
        int[] standard = new int[num+1]; //  통화 기준
        int[] moneySum = new int[10000]; // 돈 합 한 값

        int standardSum = 0;
        for (int i = 0; i < num; i++) {
            standard[i] = sc.nextInt();
            standardSum += standard[i];
            moneySum[i+1] = moneySum[i] + standard[i];
        }

        int moneyIdx = 0;
        for (int i = num+1; moneySum[i-1] <= money; i++) {
            moneySum[i] = moneySum[(int) (i - Math.pow(2, num) + 1)] + standardSum;
            if (moneySum[i] == money) {
                moneyIdx = i;
            }
        }

        if (moneySum[moneyIdx] == money) {
            System.out.print((int)(moneyIdx - Math.pow(2, num)));
        }else {
            System.out.println(-1);
        }
    }
}
