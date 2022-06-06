package y22.m06.d06;

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

class Solution1 {
    public long solution(int w, int h) {
        long wLong = w, hLong = h;
        long gcd = gcd(wLong, hLong);

        long cnt = 0;
        for (int i = 0; i < wLong / gcd; i++) {
            cnt += Math.ceil(i * hLong / wLong);
        }

        long partEmpty = (wLong / gcd) * (hLong / gcd) - 2 * cnt;
        long totalEmpty = partEmpty * gcd;

        return (wLong * hLong) - totalEmpty;
    }

    static public long gcd(long x, long y) {
        if (x % y == 0) return y;
        return gcd(y, x % y);
    }
}

class Solution {
    public long solution(int w, int h) {
        long wLong = w, hLong = h;

        // (minX, minY) // x와 y가 정수인 (0, 0) 이후의 최소 값
        long minX = w, minY = h;

        for (int i = 1; i < w; i++) {
            double y = i * (double) hLong / (double) wLong;
            if (y - (long) y == 0) {
                minX = i;
                minY = (long) y;
                break;
            }
        }

        // 동일한 패턴 반복 횟 수
        long repeatCnt = wLong / minX;

        // 그래프 아래에 있는 칸의 개수
        long cnt = 0;
        for (int i = 0; i < wLong / repeatCnt; i++) {
            cnt += Math.ceil(i * hLong / wLong);
        }

        // 반복 되는 패턴에 빈 칸의 개수
        long partEmpty = (wLong / repeatCnt) * (hLong / repeatCnt) - 2 * cnt;

        // 전체에서 빈 칸의 개수
        long totalEmpty = partEmpty * repeatCnt;

        // 멀쩡한 사각형의 개수
        return (wLong * hLong) - totalEmpty;
    }
}