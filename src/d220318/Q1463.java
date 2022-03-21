package d220318;


// 단순하게 재귀함수로 해결할 수 있을 줄 알았음
// 큰 수부터 나누면 빨리 처리 되겠지
// 이게 아니었음
// DP 동적 알고리즘 공부해 볼 것


import java.io.*;

public class Q1463 {

    static int cnt = 0;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        cal(n);
        bw.write(String.valueOf(cnt));

        br.close();
        bw.flush();
        bw.close();
    }

    public static int cal(int n){
        if (n % 3 == 0) {
            n /= 3;
        } else if (n % 2 == 0) {
            if ((n - 1) % 3 == 0) {
                n -= 1;
            } else {
                n /= 2;
            }
        } else{
            n -= 1;
        }
        cnt = cnt + 1;
        System.out.println("cnt = " + cnt +", n = "+ n);
        if (n != 1) {
            cal(n);
        }
        return n;
    }
}
