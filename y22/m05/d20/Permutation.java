package y22.m05.d20;

import java.util.Arrays;

public class Permutation {
    static int cnt = 0;

    public static void main(String[] args) {
//        char[] arr = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
//        char[] arr = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
        char[] arr = {'1', '2', '3'};
        permutation(arr, 0, arr.length);
        System.out.println("cnt = " + cnt);
    }

    // 순서 없이 arr.length 개 중에서 r 개를 뽑는 경우
    static void permutation(char[] arr, int depth, int r) {
        if (depth == r) {
            cnt++;
            System.out.println("arr : " + Arrays.toString(arr) + " | depth : " + depth + " | r : " + r);
            return;
        }

        for (int i = depth; i < arr.length; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, r);
            swap(arr, depth, i); // 원위치
        }
    }

    static void swap(char[] arr, int depth, int i) {
        char temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }
}
