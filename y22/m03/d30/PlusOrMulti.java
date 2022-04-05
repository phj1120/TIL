package y22.m03.d30;

import java.util.Scanner;

public class PlusOrMulti {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] a = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            a[i] = s.charAt(i) - 48;
        }

        int result = a[0];
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] == 0 || a[i + 1] == 0 || a[i + 1] == 1) {
                result += a[i + 1];
            } else {
                result *= a[i + 1];
            }
        }
        System.out.println(result);
    }
}
