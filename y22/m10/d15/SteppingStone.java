package y22.m10.d15;

import java.util.Arrays;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        int left = 0;
        int right = distance;

        while (left < right) {
            int mid = (left + right) / 2;
            int now = 0;
            int deleteCount = 0;
            for (int i = 0; i < rocks.length; i++) {
                if (rocks[i] - now < mid) {
                    deleteCount++;
                } else {
                    now = rocks[i];
                }
            }
            if (deleteCount <= n) {
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

