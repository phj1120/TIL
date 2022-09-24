package y22.m09.d24;

import java.util.Arrays;

class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;
        int[] answer = new int[2];

        for (int i = 1; i < total / 2; i++) {
            if (total % i == 0) {
                int x = total / i;
                int y = i;
                if (x * y - 2 * x - 2 * y + 4 == yellow) {
                    answer = new int[]{x, y};
                    break;
                }
            }
        }
        return answer;
    }
}

public class Carpet {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int brown = 10;
        int yellow = 2;
        int[] correctAnswer = {4, 3};
        int[] answer = solution.solution(brown, yellow);
        System.out.println(Arrays.equals(correctAnswer, answer));
        System.out.println(Arrays.toString(answer));
    }
}

class Solution1 {
    public int[] solution(int brown, int yellow) {
        int b = -1 * (brown + 4) / 2;
        int c = brown + yellow;
        int sqrt = (int) Math.sqrt(b * b - 4 * c);

        int[] answer = {(-b + sqrt) / 2, (-b - sqrt) / 2};
        return answer;
    }
}
