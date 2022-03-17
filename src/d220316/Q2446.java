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

class Main2 {

    static int N;
    static String star = "*";
    static String space = "";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

//      미리 최대(2(n-1))개의 별이 찍힌 문장 생성
        for (int i = 0; i < 2*(N-1); i++) {
            star += "*";
        }

//      미리 찍어둔 문장에서 substring 으로 필요한 만큼 별을 가져옴
//        별의 개수가 2개씩 감소하므로 i-=2
        for (int i = 2*(N-1)+1; i > 0 ; i=i-2) {
            bw.write(space + star.substring(0, i));
//            공백이 하나씩 추가 되므로 +=.
            space+=" ";
            bw.newLine();
        }
        space = space.substring(0, space.length()-1);
        for (int i = 3; i < 2*(N-1)+2 ; i=i+2) {
            space = space.substring(0, space.length()-1);
            bw.write(space + star.substring(0, i));
            bw.newLine();
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
