package y22.m09.d12;

import java.io.*;
import java.util.*;

public class Q18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        String[] arr = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(arr[i]));
        }
        Integer[] numbers = set.toArray(new Integer[0]);
        Arrays.sort(numbers);

        HashMap<Integer, Integer> rank = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            rank.put(numbers[i], i);
        }

        for (int i = 0; i < arr.length; i++) {
            bw.write(rank.get(Integer.parseInt(arr[i]))+" ");
//            result += rank.get(Integer.parseInt(arr[i])) + " "; // 시간 초과
        }
        bw.flush();
        bw.close();
    }
}
