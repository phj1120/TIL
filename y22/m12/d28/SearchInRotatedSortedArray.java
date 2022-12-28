package m12.d28;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int correctAnswer = 4;

//        int[] nums = {5, 1, 3};
//        int target = 1;
//        int correctAnswer = 1;

        int answer = solution.search(nums, target);

        System.out.println(correctAnswer == answer);
        System.out.println(answer);
    }
}

class Solution {
    public int search(int[] nums, int target) {
        // 시작점 찾기
        int startIndex = -1;
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minValue) {
                startIndex = i;
                minValue = nums[i];
            }
        }

        // 필요한 pivot 메서드 테스트
        System.out.println("index -> pivot");
        for (int i = 0; i < nums.length; i++) {
            System.out.println(i + " -> " + pivot(i, startIndex, nums.length));
        }

        int length = nums.length;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            int index = pivot(middle, startIndex, length);
            if (nums[index] == target) {
                return index;
            } else if (nums[index] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return -1;
    }

    // 정상적일 경우의 인덱스를 현재 배열의 인덱스로 조정
    private int pivot(int index, int startIndex, int length) {
        return (index + startIndex) % length;
    }
}
