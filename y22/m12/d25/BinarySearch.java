package m12.d25;

public class BinarySearch {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] nums = {-1, 0, 3, 5, 9, 12};
//        int target = 9;
//        int correctAnswer = 4;

        int[] nums = {-1, 0, 5};
        int target = -1;
        int correctAnswer = 0;
        int answer = solution.search(nums, target);
        System.out.println(correctAnswer == answer);
        System.out.println(answer);
    }
}

class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int now = nums[mid];
            if (now == target) {
                return mid;
            } else if (now > target) {
                right = mid - 1;
            } else left = mid + 1;
        }

        return -1;
    }
}
