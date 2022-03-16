package d220316;

import java.io.*;

public class Q2522 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int n = Integer.parseInt(br.readLine());
        br.close();

        for(int i=1; i<n; i++){
            for(int j=0; j<n; j++){
                if(j<n-i)
                    sb.append(" ");
                else
                    sb.append("*");
            }
            sb.append("\n");
        }

        for(int i=n; i>0; i--){
            for(int j=0; j<n; j++){
                if(j<n-i)
                    sb.append(" ");
                else
                    sb.append("*");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}

// 백준
class Main {

    static int N;
    static String star = "*";
    static String space = "";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            space+=" ";
            star += "*";
        }
        for (int i = 1; i <= N; i++) {
            bw.write(space.substring(0,N-i) + star.substring(0, i));
            bw.newLine();
        }
        for (int i = 1; i <= N; i++) {
            bw.write(space.substring(0,i) + star.substring(i+1));
            bw.newLine();
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
