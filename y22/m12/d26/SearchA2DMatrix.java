package m12.d26;

public class SearchA2DMatrix {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 3;
        boolean correctAnswer = true;
        boolean answer = solution.searchMatrix(matrix, target);
        System.out.println(answer == correctAnswer);
        System.out.println(answer);
    }
}


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int columnLength = matrix[0].length;
        int rowLength = matrix.length;

        int leftArray = 0;
        int rightArray = rowLength - 1;
        while (leftArray <= rightArray) {
            int midArray = (leftArray + rightArray) / 2;

            // 해당 배열의 사이에 있는 값일 경우
            if (matrix[midArray][0] <= target && matrix[midArray][columnLength - 1] >= target) {
                int[] nowArray = matrix[midArray];
                // 이진 탐색 한 번 더
                int left = 0;
                int right = columnLength - 1;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (nowArray[mid] == target) {
                        return true;
                    }
                    if (nowArray[mid] < target) {
                        left = mid + 1;
                    } else if (nowArray[mid] > target) {
                        right = mid - 1;
                    }
                }

                return false;
            }

            if (matrix[midArray][0] > target) { // 해당 배열의 이전에 있는 경우
                rightArray = midArray - 1;

            } else if (matrix[midArray][0] < target) { // 해당 배열의 이후에 있는 경우
                leftArray = midArray + 1;
            }
        }
        return false;
    }
}