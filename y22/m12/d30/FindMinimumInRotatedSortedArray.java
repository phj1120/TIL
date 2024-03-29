package m12.d30;

public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int correctAnswer = 0;
        int answer = solution.findMin(nums);
        System.out.println(answer == correctAnswer);
        System.out.println(answer);
    }
}

class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            // 좌측의 값이 우측의 값보다 작거나 같을 경우 좌측 값이 최소 값
            if (nums[left] <= nums[right]) {
                return nums[left];
            }

            int mid = (left + right) / 2;
            if (nums[mid] >= nums[left]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return -1;
    }
}