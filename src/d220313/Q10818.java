package d220313;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10818 {
    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        String numStrings = br.readLine();
        String[] numStr = numStrings.split(" ", cnt);
        long max = -1000000;
        long min = 1000000;

        for (int i = 0; i < cnt; i++) {
            if (Integer.parseInt(numStr[i]) > max) {
                max = Integer.parseInt(numStr[i]);
            }
//            else if 를 사용하면
//            처음에 있는 값이 무조건 max 에 들어가기 때문에 안 됨
            if (Integer.parseInt(numStr[i]) < min) {
                min = Integer.parseInt(numStr[i]);
            }
        }
        System.out.printf("%d %d", min, max);
    }
}
