package y22.m10.d28;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums = {0, 0, 0, 0};
        List<List<Integer>> lists = solution.threeSum(nums);
        System.out.println(lists);
    }

}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            if (nums[i] > 0) break;

            int target = nums[i] * -1;
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    answer.add(list);
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                }
                if (sum <= target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return answer;
    }
}

class SolutionFirst {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 1 && nums[i] == nums[i - 1]) continue;
            if (nums[i] >= 0) break;

            int target = nums[i] * -1;
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    answer.add(list);
                }
                if (sum <= target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return answer;
    }
}