package y22.m10.d11;

import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        int left = 0;
        int right = times[times.length - 1] * n;
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (check(mid, n, times)) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static boolean check(int mid, int n, int[] times) {
        long totalTime = 0;
        for (int time : times) {
            totalTime += mid / time;
        }
        return totalTime >= n;
    }
}

public class Immigration {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 6;
        int[] times = {7, 10};
        long correctAnswer = 28;
        long answer = solution.solution(n, times);
        System.out.println(correctAnswer == answer);
        System.out.println(answer);
    }
}