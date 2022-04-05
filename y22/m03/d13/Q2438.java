package y22.m03.d13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2438 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*" );
            }
            System.out.println();
        }
    }
}

// 백준
//public class Q2438 {
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int num = Integer.parseInt(br.readLine());
//        String str = "";
//        for (int i = 1; i <= num; i++) {
//                System.out.println(str+="*");
//        }
//    }
//}
