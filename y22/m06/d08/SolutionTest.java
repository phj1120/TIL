package y22.m06.d08;

public class SolutionTest {
    public static void main(String[] args) throws InterruptedException {
        long beforeTime = System.currentTimeMillis();

        Solution sol = new Solution();

        // 입력
        int n = 13;

        // 출력
        String correctAnswer = "111";

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

class Solution {
    public String solution(int n) {
        String answer = "";

        String threeN = tenToThree(n);
        StringBuffer str = new StringBuffer(threeN);
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == '0') {
                if (str.charAt(i - 1) != '0') {
                    str.replace(i, i + 1, downValueCharToString(str.charAt(i)));
                    str.replace(i - 1, i, downValueCharToString(str.charAt(i - 1)));
                } else {
                    str.replace(i, i, "4");
                    str.replace(i - 1, i, downValueCharToString(str.charAt(i - 1)));
                    str.replace(i - 2, i - 1, downValueCharToString(str.charAt(i - 2)));
                }
            }
        }
        answer = str.toString();

        return answer;
    }

    public static String tenToThree(int ten) {
        int quotient = ten / 3; // 몫
        int remainder = ten % 3; // 나머지
        if (quotient < 3) return Integer.toString(quotient) + Integer.toString(remainder);
        return tenToThree(quotient) + remainder;
    }

    public static String downValueCharToString(char ch) {
        if (ch == '1') return "4";
        else if (ch == '2') return "1";
        else return "2";
    }

}