package y22.m03.d15;

//    5 입력시 아래 처럼
//    *        *
//    **      **
//    ***    ***
//    ****  ****
//    **********
//    ****  ****
//    ***    ***
//    **      **
//    *        *

// 1차 제출
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//
//public class Q2445 {
//    public static void main(String args[]) throws Exception {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuffer sb = new StringBuffer();
//
//        int num = Integer.parseInt(br.readLine());
//
//        for (int i = 2; i <= num; i++) {
//            for (int j = 1; j < i; j++) {
//                sb.append("*");
//            }
//            for (int k = 1; k <= 2 * (num - i + 1); k++) {
//                sb.append(" ");
//            }
//            for (int j = 1; j < i; j++) {
//                sb.append("*");
//            }
//            sb.append("\n");
//        }
//        for (int i = num+1; i >= 2; i--) {
//            for (int j = 1; j < i; j++) {
//                sb.append("*");
//            }
//            for (int k = 1; k <= 2 * (num - i + 1); k++) {
//                sb.append(" ");
//            }
//            for (int j = 1; j < i; j++) {
//                sb.append("*");
//            }
//            sb.append("\n");
//        }
//        System.out.println(sb);
//    }
//}

// 개선
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q2445 {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int num = Integer.parseInt(br.readLine());

        for (int i = 1; i < num; i++) {
            for (int j = 0; j < i; j++) {
                sb.append("*");
            }
            for (int k = 0; k < 2 * (num - i); k++) {
                sb.append(" ");
            }
            for (int j = 0; j < i; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        for (int i = num; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                sb.append("*");
            }
            for (int k = 0; k < 2 * (num - i); k++) {
                sb.append(" ");
            }
            for (int j = 0; j < i; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}