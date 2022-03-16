package d220316;

import java.io.*;

// for 문을 이렇게 많이 돌려도 되는게 맞나... 
// 오늘은 여기까지 하고 내일 다른 사람거 봐보자 
public class Q2446 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());
        br.close();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++)
                sb.append(" ");
            for (int k = 1; k < 2 * (n - i); k++)
                sb.append("*");
            sb.append("\n");
        }
        for (int i = n -2 ; i > 1 -2 ; i--) {
            for (int j = 0; j < i; j++)
                sb.append(" ");
            for (int k = 1; k < 2 * (n - i); k++)
                sb.append("*");
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}

