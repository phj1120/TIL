package y22.m10.d11;

public class Q4673 {
    public static void main(String[] args) {
        boolean[] isSelfNumber = new boolean[10001];
        for (int i = 1; i < 10000; i++) {
            int n = selfNumber(i);
            if (n > 10000) {
                continue;
            }
            isSelfNumber[n] = true;
        }

        for (int i = 1; i <= 10000; i++) {
            if (!isSelfNumber[i]) {
                System.out.println(i);
            }
        }
    }

    public static int selfNumber(int n) {
        String number = String.valueOf(n);
        for (char ch : number.toCharArray()) {
            n += ch - '0';
        }
        return n;
    }

    public static int selfNumber2(int n) {
        int result = n;
        while (n != 0) {
            result += n % 10;
            n /= 10;
        }
        return result;
    }
}

