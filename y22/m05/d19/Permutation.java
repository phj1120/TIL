package y22.m05.d19;

public class Permutation {
    static int cnt = 0;
    public static void main(String[] args) {
        char[] arr = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
        permutation(arr, 0, arr.length, arr.length);
        System.out.println("cnt = " + cnt);
    }

    // 순서 없이 n 개중에서 r 개를 뽑는 경우
    static void permutation(char[] arr, int depth, int n, int r) {
        if (depth == r) {
            cnt++;
            print(arr, r);
            return;
        }

        for (int i = depth; i < n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, r);
            swap(arr, depth, i);
        }
    }

    static void swap(char[] arr, int depth, int i) {
        char temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }

    // 배열 출력
    static void print(char[] arr, int r) {
        for (int i = 0; i < r; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
