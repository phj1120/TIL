package y22.m10.d14;

import java.util.Arrays;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);

        int left = 0;
        int right = distance;
        int minDistance;
        while (left < right) {
            int mid = (left + right) / 2;
            int now = 0;
            int removeCount = 0;
            minDistance = mid;
            for (int i = 0; i <= rocks.length; i++) {
                if (i == rocks.length) {
                    int nowDistance = distance - now;
                    minDistance = Math.min(minDistance, nowDistance);
                } else {
                    int rock = rocks[i];
                    int nowDistance = rock - now;
                    if (nowDistance >= mid) {
                        minDistance = Math.min(minDistance, rock - now);
                        now = rock;
                    } else {
                        removeCount++;
                    }
                }
            }
            if (removeCount <= n) {
                left = minDistance + 1;
            } else {
                right = minDistance;
            }
        }
        return right - 1;
    }
}

class OtherSolution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        int start = 0, end = distance;

        while (start < end) {
            int mid = (start + end + 1) / 2;
            int keep = 0, remove = 0;

            for (int i = 0; i < rocks.length; i++) {
                if (rocks[i] - keep < mid) remove++;
                else
                    keep = rocks[i];
            }

            if (remove > n) end = mid - 1;
            else
                start = mid;
        }
        return start;
    }
}

class MyBetterSolution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        int left = 0, right = distance;

        while (left < right) {
            int mid = (left + right) / 2;
            int now = 0, removeCount = 0;
            for (int i = 0; i < rocks.length; i++) {
                if (rocks[i] - now < mid) {
                    removeCount++;
                } else {
                    now = rocks[i];
                }
            }
            if (removeCount <= n) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right - 1;
    }
}

public class SteppingStone {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int distance = 25;
        int[] rocks = {2, 14, 11, 21, 17};
        int n = 2;
        int correctAnswer = 4;
        int answer = solution.solution(distance, rocks, n);
        System.out.println(correctAnswer == answer);
        System.out.println(answer);
    }
}

