package y22.m04.d04;

public class Factorial {
    //    반복적으로 구현한 n!
    static int factorial_iterative(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // 재귀적으로 구현한 n!
    static int result = 1;

    static int factorial_recursive(int n) {
        if(n <= 1) return result;
        return n * factorial_recursive(n - 1);
    }
    // 점화식을 그대로 이용하기 때문에 코드가 더 간결함    

    public static void main(String[] args) {
        System.out.println("반복적으로 구현 : " + factorial_iterative(10));
        System.out.println("재귀적으로 구현 : " + factorial_recursive(10));
    }
}
