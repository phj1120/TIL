package y22.m04.d04;

// GCD : 최대 공약수
// 유클리드 호제법
// 두 자연수 A 와 B ( A>B ) / R = A % B
// A와 B의 최대 공약수는 B와 R의 최대 공약수와 같음
public class GCD {

    static public int euclid(int x, int y) {
        int z = x % y;
        if (z ==0) return y;
        return euclid(y, z);
    }

    public static void main(String[] args) {
        System.out.println("euclid(192, 162) = " + euclid(192, 162));
    }
}
