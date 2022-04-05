package y22.m03.d13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.Date;
import java.util.TimeZone;


public class Q2439 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        char[] line = new char[num];
        for (int i = 1; i <= num; i++) {
            for (int j = 0; j <num; j++) {
                if (j <= (num-1)-i) {
                    line[j] = ' ';
                } else {
                    line[j] = '*';
                }
            }
            System.out.println(line);
        }
    }
}

// 백준
// 뭐가 더 효율적일까 시간 추가 해봤는데 내가 짠게더 빠르네?
// 모르겠다
//    public static void main(String args[]) throws IOException {
//
//        long start = System.currentTimeMillis();
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int num = Integer.parseInt(br.readLine());
//        char[] line = new char[num];
//
//        for(int i = 0; i<num; i++){
//            line[i] = ' ';
//        }
//
//        for (int i = 0; i < num; i++) {
//            line[num - i - 1] = '*';
//            System.out.println(line);
//        }
//        long finish = System.currentTimeMillis();
//        System.out.println("Time = " + (finish - start));
//
//    }
//}