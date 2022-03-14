package d220314;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2441 {
        public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i<num; i++){
            char[] str = new char[num];
            for (int j = num; j > 0; j--) {
                if(j > i) {
                    str[j - 1] = '*';
                }else {
                    str[j -1] = ' ';
                }

            }
            System.out.println(str);
        }
    }
}

