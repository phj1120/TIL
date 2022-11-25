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
    int[] dp;
    List<Set<Integer>> sets;

    public int solution(int N, int number) {
        dp = new int[99999999];
        sets = new ArrayList<>();
        Arrays.fill(dp, -1);

        dp[0] = 0;
        sets.add(new HashSet<>(List.of(0)));
        dp[N] = 1;
        sets.add(new HashSet<>(List.of(N)));
        for (int i = 2; i < 9; i++) {
            sets.add(new HashSet<>());
            for (Integer prevNumber : sets.get(i - 1)) {
                addDp(i, prevNumber + N);
                addDp(i, prevNumber - N);
                addDp(i, prevNumber / N);
                addDp(i, prevNumber * N);
                addDp(i, prevNumber * 10 + N);
            }
        }

        return dp[number];
    }

    private void addDp(int i, Integer number) {
        if (number > 0 && dp[number] == -1) {
            dp[number] = i;
            sets.get(i).add(number);
        }
    }
}