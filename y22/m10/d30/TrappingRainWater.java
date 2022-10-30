package y22.m10.d30;

public class TrappingRainWater {
}

class Solution {
    public int trap(int[] height) {
        int length = height.length;
        int[] left = new int[length];
        int[] right = new int[length];
        int amount = 0;
        int max = 0;
        for (int i = 0; i < length; i++) {
            if (max < height[i]) {
                max = height[i];
            }
            left[i] = max;
        }

        max = 0;
        for (int i = length - 1; i >= 0; i--) {
            if (max < height[i]) {
                max = height[i];
            }
            right[i] = max;
        }
        for (int i = 0; i < length; i++) {
            amount += (Math.min(left[i], right[i]) - height[i]);
        }
        return amount;
    }
}

class SolutionFirst {
    public int trap(int[] height) {
        int length = height.length;
        int[] left = new int[length];
        int[] right = new int[length];
        int amount = 0;
        int max = 0;
        for (int i = 0; i < length; i++) {
            if (max < height[i]) {
                max = height[i];
            }
            left[i] = Math.max(height[i], max);
        }
        max = 0;
        for (int i = length - 1; i >= 0; i--) {
            if (max < height[i]) {
                max = height[i];
            }
            right[i] = Math.max(height[i], max);
        }
        for (int i = 0; i < length; i++) {
            amount += (Math.min(left[i], right[i]) - height[i]);
        }
        return amount;
    }
}