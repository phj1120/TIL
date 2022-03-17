package d220317;

import java.io.*;

public class Q10992 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());

        String space = "";
        String word = "*";

        for (int i = 1; i < 2*num-1; i++) {
            space += " ";
            word += "*";
        }

        for (int i = 0; i < num; i++) {
            if (i == 0 || i == num - 1) {
                bw.write(space.substring(0, num - i - 1) + word.substring(0, 2 * (i) + 1));
            } else {
                bw.write(space.substring(0, num - i - 1) +"*"+space.substring(0,2 * (i-1) + 1)+"*");
            }
            bw.newLine();
        }

        br.close();
        bw.flush();
        bw.close();
    }
}


// 어 이렇게 하면 1일때 두줄 나오네 안 됨..
class Q10992_fail {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());

        String space = "";
        String word = "*";

        for (int i = 1; i < 2*num-1; i++) {
            space += " ";
            word += "*";
        }

        bw.write(space+word.substring(0, 1));
        bw.newLine();

        for (int i = 2; i < num; i++) {
            bw.write(space.substring(i-1)+"*"+space.substring(0, 2*(i-2)-1)+"*");
            bw.newLine();
        }

        bw.write(word);

        br.close();
        bw.flush();
        bw.close();
    }
}

// 백준
// 아예 이렇게 찍을수도 있구만

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i<n-1; i++) {
            for(int j = 0; j<n-i-1; j++) bw.write(' ');
            bw.write('*');
            for(int j = 0; j<i*2-1; j++) bw.write(' ');
            if(i != 0) bw.write('*');
            bw.write('\n');
        }
        for(int i = 0; i<n*2-1; i++) bw.write('*');
        br.close();
        bw.flush();
        bw.close();
    }
}
