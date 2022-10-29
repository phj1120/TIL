package y22.m10.d29;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] height = {2, 3, 4, 5, 18, 17, 6};
        int i = solution.maxArea(height);
        System.out.println(i);
    }
}

class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}