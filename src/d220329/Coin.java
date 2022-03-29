package d220329;

import java.util.Scanner;

public class Coin {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;

        int[] coinTypes = {500, 100, 50, 10};

        for (int coin : coinTypes) {
//            cnt = cnt + n / coin;
//            n = n - (n / coin) * coin;
            cnt += n / coin;
            n %= coin;
        }
        System.out.println(cnt);
    }
}
