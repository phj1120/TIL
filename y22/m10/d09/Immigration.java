package y22.m10.d09;

import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long left = 0;
        long right = (long) times[times.length - 1] * n; // (long * int = long)
        return binarySearch(left, right, n, times);
    }

    public long binarySearch(long left, long right, long n, int[] times) {
        if (left == right)
            return left;
        long mid = (left + right) / 2;
        long nowCompletedCount = 0;
        for (int time : times) {
            nowCompletedCount += mid / time;
        }
        if (nowCompletedCount >= n) {
            return binarySearch(left, mid, n, times);
        } else {
            return binarySearch(mid + 1, right, n, times);
        }
    }
}


class CorrectSolution {
    public long solution(int n, int[] times) {
        long left = 0;
        long right = (long) Arrays.stream(times).max().getAsInt() * n; // (long * int = long)
        return binarySearch(left, right, n, times);
    }

    public long binarySearch(long left, long right, long n, int[] times) {
        if (left < right) {
            long mid = (left + right) / 2;
            long nowCompletedCount = 0;
            for (int time : times) {
                nowCompletedCount += mid / time;
            }
            if (nowCompletedCount >= n) {
                return binarySearch(left, mid, n, times);
            } else {
                return binarySearch(mid + 1, right, n, times);
            }
        }
        return left;
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