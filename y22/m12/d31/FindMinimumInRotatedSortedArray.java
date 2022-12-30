package m12.d31;

public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 1};
        int correctAnswer = 1;
        int answer = solution.findMin(nums);
        System.out.println(answer == correctAnswer);
        System.out.println(answer);
    }
}

class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        // 좌측 배열이 없는 경우
        if (nums[0] <= nums[nums.length - 1]) {
            return nums[0];
        }

        while (left <= right) {
            int mid = (left + right) / 2;

            // 종료 조건
            if (mid != 0 && nums[mid] < nums[mid - 1] || mid == 0 && nums[mid] < nums[nums.length - 1]) {
                return nums[mid];
            }


            // 좌우 탐색
            if (nums[mid] >= nums[0]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return -1;
    }
}