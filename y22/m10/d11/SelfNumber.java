package y22.m10.d11;

import java.util.Arrays;

public class SelfNumber {
    public static void main(String[] args) {
        boolean[] isSelfNumber = new boolean[10001];
        int i = 1;
        while (true) {
            int n = selfNumber(i);
            if (n >= 10000) {
                break;
            }
            isSelfNumber[i] = true;
            i++;
        }
        System.out.println(Arrays.toString(isSelfNumber));

    }

    public static int selfNumber(int n) {
        String number = String.valueOf(n);
        for (char ch : number.toCharArray()) {
            n += ch - '0';
        }
        return n;
    }
}

