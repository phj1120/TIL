package m12.d17;

import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
//        int k = 3;
//        int[] correctAnswer = {3, 3, 5, 5, 6, 7};

        int[] nums = {1, -1};
        int k = 1;
        int[] correctAnswer = {1, -1};
        int[] answer = solution.maxSlidingWindow(nums, k);
        System.out.println(Arrays.equals(correctAnswer, answer));
        System.out.println(Arrays.toString(answer));
    }
}

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        int left = 0;
        int right = k - 1;
        for (int i = 0; i < result.length; i++) {
//            int max = (int) Arrays.stream(Arrays.copyOfRange(nums, left, right+1)).asLongStream().max().getAsLong();
            int max = Integer.MIN_VALUE;
            for (int j = left; j < right + 1; j++) {
                max = Math.max(max, nums[j]);
            }
            left++;
            right++;
            result[i] = max;
        }
        return result;
    }
}
