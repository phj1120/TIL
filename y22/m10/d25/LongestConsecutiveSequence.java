package y22.m10.d25;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
}
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums){
            set.add(num);
        }
        Integer[] numbers = set.toArray(new Integer[0]);
        Arrays.sort(numbers);

        int longest = 0; // 길이가 0일 경우
        int count = 1; // 길이가 1일 경우
        boolean consecutiveState = false;

        for (int i = 0; i< numbers.length; i++){
            if(i == numbers.length -1){
                return Math.max(longest, count);
            }

            // 연속 되는 경우
            if (numbers[i] + 1 == numbers[i+1]){
                // 연속 되는 것이 시작 된 경우
                if (!consecutiveState){
                    count = 2;
                    consecutiveState = true;
                } else{
                    // 전부터 연속 된 경우
                    count++;
                }

                // 연속 되지 않는 경우
            }else{
                // 연속된 것이 끊긴 경우
                if(consecutiveState){
                    consecutiveState = false;
                    longest = Math.max(longest, count);
                }
            }
        }
        return longest;
    }
}

class SolutionFail {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);

        int longest = -1;
        int count = 1;
        boolean consecutiveState = false;
        for (int i = 0; i < nums.length - 1; i++) {
            // 연속 되는 경우
            if (nums[i] + 1 == nums[i + 1]) {
                // 연속 되는 것이 시작 된 경우
                if (consecutiveState) {
                    count = 1;
                    consecutiveState = true;
                } else {
                    // 전부터 연속 된 경우
                    count++;
                }
                // 연속 되지 않는 경우
            } else {
                // 연속된 것이 끊긴 경우
                if (consecutiveState || i == nums.length - 2) {
                    consecutiveState = false;
                    longest = Math.max(longest, count);
                }
            }
        }
        return longest;
    }
}
