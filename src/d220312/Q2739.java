package d220312;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Q2739 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        for (int i = 1; i<=9; i++){
            System.out.printf("%d * %d = %d\n", num, i, num*i);
        }
    }
}

// 버퍼리

class Baek1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());

        for (int i = 1; i <= 9; i++) {
            System.out.println(a + " * " + i + " = " + a*i);
        }
    }

}