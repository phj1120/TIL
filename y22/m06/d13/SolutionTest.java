package y22.m06.d13;

public class SolutionTest {
    public static void main(String[] args) throws InterruptedException {
        long beforeTime = System.currentTimeMillis();

        Solution sol = new Solution();

        // 입력
        int n = 10;

        // 출력
        String correctAnswer = "41";

        // 테스트 실행
        String answer = sol.solution(n);

        // 결과 비교
        if (correctAnswer.equals(answer)) {
            System.out.println("테스트를 통과하였습니다.");
        } else {
            System.out.printf("실행한 결괏값 " + answer + "이(가) 기댓값 " + correctAnswer + "와(과) 다릅니다.\n");
        }

        long afterTime = System.currentTimeMillis();
        System.out.printf("실행 시간 : %.3f 초\n", (float) (afterTime - beforeTime) / 1000);
    }
}

// 재귀
class Solution {
    static StringBuilder sb = new StringBuilder();

    public String solution(int n) {
        recursive(n);
        return sb.toString();
    }

    public static void recursive(int ten) {
        if (ten == 0) return;

        int quotient = ten / 3;  // 몫
        int remainder = ten % 3;  // 나머지

        // 124 나라는 0을 표시할 수 없으므로
        if (remainder == 0) {
            quotient -= 1;
            remainder = 4;
        }

        recursive(quotient);
        sb.append(remainder);
    }
}

// 반복문
class Solution2 {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        int quotient, remainder; // 몫, 나머지

        while (n != 0) {
            quotient = n / 3; // 몫
            remainder = n % 3; // 나머지

            if (remainder == 0) {
                quotient -= 1;
                remainder = 4;
            }
            n = quotient;
            sb.insert(0, remainder);
        }
        return sb.toString();
    }
}