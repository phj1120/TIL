package y22.m03.d21;

public class DpFibonacci {
    public static void main(String args[]) {
        Fibonacci fibonacci = new Fibonacci();
        int n = 10;
        System.out.println("단순 재귀");
        System.out.println("fibonacci.recursion(n) = " + fibonacci.recursion(n));
        System.out.println("상향식");
        System.out.println("fibonacci.bottomUp(n) = " + fibonacci.bottomUp(n));
        System.out.println("하향식");
        System.out.println("fibonacci.topDown(n) = " + fibonacci.topDown(n));
    }
}

class Fibonacci{
    public static long[] dBottom = new long[51];
    public static long[] dTop = new long[51];

    public long recursion(int n) {
        long fibonacci = 0;
        if (n == 1 || n == 2) {
            return 1;
        }

        fibonacci = recursion(n - 1) + recursion(n - 2);
        System.out.printf("fibonacci(%d) = %d\n", n, fibonacci);
        return fibonacci;
    }

    public long bottomUp(int n) {
        dBottom[1] = 1;
        dBottom[2] = 1;
        for (int i = 2; i <= n; i++) {
            dBottom[i] = dBottom[i - 1] + dBottom[i - 2];
            System.out.printf("f(%d) = %d\n", i, dBottom[i]);
        }
        return dBottom[n];
    }

    public long topDown(int x){
        System.out.printf("f(%d) = %d\n", x, dTop[x]);
        if(x == 1 || x ==2){
            return 1;
        }
        if (dTop[x] != 0){
            System.out.printf("f(%d) = %d\n", x, dTop[x]);
            return dTop[x];
        }
        dTop[x] = topDown(x - 1) + topDown(x - 2);
        return dTop[x];
    }
}