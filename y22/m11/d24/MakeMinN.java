package m11.d24;

import java.util.Arrays;

public class MakeMinN {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int answer = solution.solution(5, 12);
        int correctAnswer = 4;
        System.out.println(answer == correctAnswer);
        System.out.println(answer);
    }

}

class Solution {
    public int solution(int N, int number) {
        int[] dp = new int[32001]; // N 으로 해당 인덱스의 수를 만들 수 있는 최소의 개 수
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[N] = 1;
        int answer = 0;

        for (int i = 2; i < 9; i++) {
            dp[i] = Arrays.asList(
                            dp[valid(i + N)],
                            dp[valid(i - N)],
                            dp[valid(i / N)],
                            dp[valid(i * N)])
                    .stream().mapToInt(Integer::intValue).min().orElseThrow() + 1;
        }

        if (dp[number] > 8) {
            return -1;
        }
        return dp[number];
    }

    public int valid(int index) {
        if (index >= 0 && index < 9) {
            return index;
        }
        return 32000;
    }
}