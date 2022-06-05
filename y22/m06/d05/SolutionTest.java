package y22.m06.d05;

public class SolutionTest {
    public static void main(String[] args) throws InterruptedException {
        long beforeTime = System.currentTimeMillis();

        Solution sol = new Solution();

        // 입력
        int w = 8;
        int h = 12;

        // 출력
        long correctAnswer = 80;

        // 테스트 실행
        long answer = sol.solution(w, h);

        // 결과 비교
        if (correctAnswer == answer) {
            System.out.println("테스트를 통과하였습니다.");
        } else {
            System.out.printf("실행한 결괏값 %d이(가) 기댓값 %d와(과) 다릅니다.\n", answer, correctAnswer);
        }

        long afterTime = System.currentTimeMillis();
        System.out.printf("실행 시간 : %.3f 초\n", (float) (afterTime - beforeTime) / 1000);
    }
}

class Solution {
    public long solution(int w, int h) {
        long wLong = w, hLong = h;

        return (wLong*hLong)-((wLong+hLong)-gcd(wLong, hLong));
    }

    static public long gcd(long x, long y){
        if (x % y == 0) return y;
        return gcd(y, x%y);
    }

    public long gcd2(long x, long y) {
        while (true) {
            long z = x % y;
            if (z == 0) {
                return y;
            } else {
                x = y;
                y = z;
            }
        }
    }
}