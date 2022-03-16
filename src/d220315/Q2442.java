package d220315;

import java.beans.Transient;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//`print` 를 한 문자씩 찍으면 리소스가 많이 든다. 그러지 말고 `StringBuilder`로 만들어 `append`하고 한번에 찍자.

public class Q2442 {

    public static void main(String args[]) throws IOException {

        long start = System.currentTimeMillis();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= num + i - 1; j++) {
                if (j < num - i + 1) {
                    System.out.print(" ");
                }else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
        long end = System.currentTimeMillis();
        System.out.println( "실행 시간 : " + ( end - start )/1000.0 + "초");
    }
}

// 백준
// 처음 보고 for 문 두 개라더 느릴 줄 알았는데 이게 더 빠름
// 조건문이 더 무거운가?
// 계속 print 문을 실행해서 그런가?

class Main {
    public static void main(String[] args) throws Exception {

        long start = System.currentTimeMillis();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int input = Integer.parseInt(br.readLine());

        for(int i = 1; i <= input; i++) {
            for(int j = input-i; j >= 1; j--) {
                sb.append(" ");
            }
            for(int k = 1; k <= i + i - 1; k++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());

        long end = System.currentTimeMillis();
        System.out.println( "실행 시간 : " + ( end - start )/1000.0 + "초");
    }
}


// 하나 하나 print 하는 것 이 더 큰 리소스였나봄

class Q2442_Test {
    public static void main(String args[]) throws IOException {
        long start = System.currentTimeMillis();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());

        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= num - i; j++) {
                sb.append(" ");
//                System.out.print(" ");
            }
            for (int k = 1; k <= 2*i -1; k++) {
                sb.append("*");
//                System.out.print("*");
            }
            sb.append("\n");
//            System.out.print("\n");
        }
        System.out.println(sb.toString());
//

        long end = System.currentTimeMillis();
        System.out.println( "실행 시간 : " + ( end - start )/1000.0 + "초");
    }
}