package y22.m06.d10;

import java.util.Arrays;

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

// 정확성 테스트 O / 효율성 테스트 X
class Solution1 {
    public String solution(int n) {
        String answer = recursive(n);

        return answer;
    }

    public static String recursive(int ten) {
        int quotient = ten / 3; // 몫
        int remainder = ten % 3; // 나머지

        // 124 나라는 0을 표시할 수 없으므로
        if (remainder == 0) {
            quotient -= 1;
            remainder = 4;
        }

        if (quotient == 0) return remainder + "";
        else if (quotient < 3) return quotient + "" + remainder;
        else return recursive(quotient) + remainder;
    }
}

//
class Solution2 {
    //    public static String memoization[] = new String[50000001]; // 5억 하면 메모리 오류 발생
    public static String[] memoization = new String[50000001]; // 5억 하면 메모리 오류 발생

    public static String recursive(int ten) {
        int quotient = ten / 3; // 몫
        int remainder = ten % 3; // 나머지

        if (memoization[ten] != null) {
            return memoization[ten];
        }

        // 124 나라는 0을 표시할 수 없으므로
        if (remainder == 0) {
            quotient -= 1;
            remainder = 4;
        }

        System.out.println("memoization = " + Arrays.toString(memoization));

        if (quotient == 0) return memoization[ten] = remainder + "";
        else if (quotient < 3) return memoization[ten] = quotient + "" + remainder;
        else return memoization[ten] = recursive(quotient) + remainder;
    }

    public String solution(int n) {
        String answer = recursive(n);

        return answer;
    }
}

class Solution3 {
    static String str = "";

    public String solution(int n) {
        recursive(n);
        return str;
    }

    public static void recursive(int ten) {
        int quotient = ten / 3; // 몫
        int remainder = ten % 3; // 나머지

        // 124 나라는 0을 표시할 수 없으므로
        if (remainder == 0) {
            quotient -= 1;
            remainder = 4;
        }

        if (quotient == 0) str = remainder + "";
        else if (quotient < 3) str = quotient + "" + remainder;
        else {
            recursive(quotient);
            str = str + remainder;
        }
    }
}

class Solution {
    static StringBuffer sb = new StringBuffer();

    public String solution(int n) {
        recursive(n);
        return sb.toString();
    }

    public static void recursive(int ten) {
        int quotient = ten / 3; // 몫
        int remainder = ten % 3; // 나머지

        // 124 나라는 0을 표시할 수 없으므로
        if (remainder == 0) {
            quotient -= 1;
            remainder = 4;
        }

        if (quotient == 0) sb.append(remainder);
        else if (quotient < 3) sb.append(quotient + "" + remainder);
        else {
            recursive(quotient);
            sb.append(remainder);
        }
    }
}