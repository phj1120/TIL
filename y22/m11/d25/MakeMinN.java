package m11.d25;

import java.util.*;

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
    int MAX_INDEX = 32000;
    int[] dp;
    List<Set<Integer>> sets;

    public int solution(int N, int number) {
        dp = new int[MAX_INDEX];
        sets = new ArrayList<>();
        Arrays.fill(dp, -1);

        dp[0] = 0;
        sets.add(new HashSet<>(List.of(0)));
        dp[N] = 1;
        sets.add(new HashSet<>(List.of(N)));
        for (int i = 2; i < 9; i++) {
            sets.add(new HashSet<>());
            for (int j = 0; j < i; j++) {
                for (int number1 : sets.get(j)) {
                    for (int number2 : sets.get(i - j)) {
                        addDp(i, number1 + number2);
                        addDp(i, number1 - number2);
                        addDp(i, number1 / number2);
                        addDp(i, number1 * number2);
                        if (j == 1) {
                            addDp(i, number1 * (int) Math.pow(10, String.valueOf(number2).length()) + number2);
                        }
                    }
                }
            }
        }

        return dp[number];
    }

    private void addDp(int depth, int number) {
        if (number > 0 && number < MAX_INDEX && dp[number] == -1) {
            dp[number] = depth;
            sets.get(depth).add(number);
        }
    }
}