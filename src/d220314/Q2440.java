package d220314;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

// 틀렸지만 결과는 같아보이는 코드
// 로직을 왜 이렇게 짰었지...
// 결과는 같은 것 처럼 보이지만
// str[num] 으로 크기가 일정하고
// * 이 없는 값에는 null 이 들어 있어서
// 오류 난거로 추정
//public class Q2440 {
//    public static void main(String args[]) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int num = Integer.parseInt(br.readLine());
//
//        for (int i = 0; i<num; i++){
//            char[] str = new char[num];
//            for (int j = num; j > i; j--) {
//                str[j-1] = '*';
//            }
//            System.out.println(str);
//        }
//    }
//}

// 성공
public class Q2440 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i<num; i++){
            char[] str = new char[num-i];

            for (int j = num-i; j > 0; j--) {
                str[j - 1] = '*';
            }
            System.out.println(str);
        }
    }
}

// 오른쪽 정렬
//public class Q2440 {
//    public static void main(String args[]) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int num = Integer.parseInt(br.readLine());
//
//        for (int i = 0; i<num; i++){
//            char[] str = new char[num];
//            for (int j = num; j > 0; j--) {
//                if(j > i) {
//                    str[j - 1] = '*';
//                }else {
//                    str[j -1] = ' ';
//                }
//
//            }
//            System.out.println(str);
//        }
//    }
//}

// 백준
//class Main {
//    public static void main(String[] args){
//
//        Scanner scan = new Scanner(System.in);
//
//        int num = scan.nextInt();
//
//        for(int i=0; i<num; i++) {
//
//            for(int j=i+1; j<=num; j++) {
//
//                System.out.print("*");
//            }
//            System.out.println();
//        }
//    }
//}
