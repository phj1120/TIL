package y22.m06.d04;

// 합계: 66.7 / 100.0

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

// 합계: 66.7 / 100.0
// 실패 및 시간 초과
class Solution1 {
    public long solution(int w, int h) {
        long answer;
        double slope = (double) h / (double) w;

        // (ax, by) // x와 y가 정수인 (0, 0) 이후의 최소 값
        long ax = w, by = h;

        for (long i = 1; i < w; i++) {
            double y = slope * i;
            if (y - (long) y == 0) {
                ax = i;
                by = (long) y;
                break;
            }
        }

        long cnt = 0;
        // 선이 지나가는 칸의 개수
        for (long i = 0; i < ax; i++) {
            for (long j = 0; j < by; j++) {
                // y = j 일 경우 x 의 값
                double x = j / slope;
                // x = i 일 경우 y 의 값
                double y = slope * i;

                if ((y >= j && y < j + 1) || (x >= i && x < i + 1)) {
                    cnt++;
                }
            }
        }

        long totalCross = cnt * w / ax;
        answer = w * h - totalCross;
        System.out.println(answer);
        return answer;
    }
}

// 합계: 38.9 / 100.0
// y 그래프 아래에 있는 것은 다 되겠지 라는 생각으로 함
// w = 5, h =3 반례로 실패
class Solution {
    public long solution(int w, int h) {
        long answer = 1;
        double slope = (double) h / (double) w;

        // (ax, by) // x와 y가 정수인 (0, 0) 이후의 최소 값
        long ax = w, by = h;

        for (long i = 1; i < w; i++) {
            double y = slope * i;
            if (y - (long) y == 0) {
                ax = i;
                by = (long) y;
                break;
            }
        }

        long cnt = 0;
        // y 그래프 아래에 있는 칸의 개수 ( 지나지 않는 부분 )
        for (int i = 0; i < ax; i++) {
            cnt += (int) slope * i;
        }

        long cross = ax * by - 2 * cnt;
        long totalCross = cross * (w / ax);
        answer = w * h - totalCross;
        return answer;
    }
}