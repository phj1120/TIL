package y22.m10.d20;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] correctAnswer = new int[]{0, 1};
        int[] answer = solution.twoSum(nums, target);
        System.out.println(Arrays.equals(answer, correctAnswer));
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int diff = target - num;
            if (map.containsKey(num)) {
                return new int[]{map.get(num), i};
            }
            map.put(diff, i);
        }
        return new int[]{};
    }
}