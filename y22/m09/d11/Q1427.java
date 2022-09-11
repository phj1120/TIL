package y22.m09.d11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int[] numbers = new int[line.length()];
        for (int i = 0; i < line.length(); i++) {
            numbers[i] = line.charAt(i) - '0';
        }
        Arrays.sort(numbers);

        for (int i = line.length() - 1; i >= 0; i--) {
            System.out.print(numbers[i]);
        }
    }
}

class Q1427_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        Integer[] numbers = new Integer[line.length()];
        for (int i = 0; i < line.length(); i++) {
            numbers[i] = line.charAt(i) - '0';
        }
//        Arrays.sort(numbers, (i1, i2) -> {
////            return i1.compareTo(i2) * -1;
//            return i2.compareTo(i1);
//        });
        Arrays.sort(numbers, (x, y) -> y - x);

        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]);
        }
    }
}
