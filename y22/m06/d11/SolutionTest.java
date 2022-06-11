package y22.m06.d11;

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

// 재귀
class Solution1 {
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

// 반복문
class Solution2 {

    public String solution(int n) {
        StringBuffer sb = new StringBuffer();
        while (true) {
            int quotient = n / 3; // 몫
            int remainder = n % 3; // 나머지

            if (remainder == 0) {
                quotient -= 1;
                remainder = 4;
            }

            if (quotient == 0) {
                sb.insert(0, remainder);
                break;
            } else if (quotient < 3) {
                sb.insert(0, quotient + "" + remainder);
                break;
            } else {
                n = quotient;
                sb.insert(0, remainder);
            }
        }

        return sb.toString();
    }

}

class Solution3 {

    public String solution(int n) {
        StringBuffer sb = new StringBuffer();
        while (true) {
            int quotient = n / 3; // 몫
            int remainder = n % 3; // 나머지

            if (remainder == 0) {
                quotient -= 1;
                remainder = 4;
            }

            if (quotient >= 3) {
                n = quotient;
                sb.insert(0, remainder);
            } else if (quotient == 0) {
                sb.insert(0, remainder);
                break;
            } else {
                sb.insert(0, quotient + "" + remainder);
                break;
            }
        }

        return sb.toString();
    }

}

// 성공
class Solution4 {

    public String solution(int n) {
        StringBuffer sb = new StringBuffer();
        int quotient; // 몫
        int remainder; // 나머지

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

// String : 효율성 실패
class Solution {

    public String solution(int n) {
        String str="";

        int quotient; // 몫
        int remainder; // 나머지

        while (n != 0) {
            quotient = n / 3; // 몫
            remainder = n % 3; // 나머지

            if (remainder == 0) {
                quotient -= 1;
                remainder = 4;
            }
            n = quotient;
            str = remainder + str;
        }

        return str;
    }

}