package d220317;

import java.io.*;

public class Q10991 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        String word = "*";
        String space = "";

        for (int j = 0; j < num; j++) {
            space += " ";
        }

        for (int i = 1; i <= num; i++) {
            bw.write(space.substring(0, num-i)+word);
            word += " *";
            bw.newLine();
        }

        br.close();
        bw.flush();
        bw.close();
    }
}


class Q10991_2 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        String word = "*";
        String space = "";

        for (int j = 0; j < num; j++) {
            word += " *";
            space += " ";
        }

//        for (int i = 1; i <= num; i++) {
//            bw.write(space.substring(0, num-i)+word.substring(0, 2*i));
//            bw.newLine();
//        }

//        for (int i = 0; i <= 2*num; i += 2) {
//            bw.write(space.substring(i/2) + word.substring(0, i));
//            bw.newLine();
//        }

        for (int i = 0; i < 2 * num - 1; i += 2) {
            bw.write(space.substring(i / 2+1) + word.substring(0, i + 1));
            bw.newLine();
        }

        br.close();
        bw.flush();
        bw.close();
    }
}

// 속도가 느려서 백준에 있는 거랑 내생각 추가해서 다시 짜보고 해봤는데 걸린 시간은 비슷했다.
// 같은 코드인데 Java 8 이 Java 11 보다 빠르네?
// 이건 왜 그런지 모르겠다.

class Main3 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        String word = "*";
        String space = "";

        for (int j = 0; j < num; j++) {
            word += " *";
            space += " ";
        }

        for (int i = 1; i <= 2 * num - 1; i += 2) {
            bw.write(space.substring(i / 2) + word.substring(0, i-1));
            bw.newLine();
        }

        br.close();
        bw.flush();
        bw.close();
    }
}