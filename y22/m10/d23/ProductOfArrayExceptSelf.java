package y22.m10.d23;

public class ProductOfArrayExceptSelf {
}

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];

        answer[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }
        int tmp = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            tmp *= nums[i + 1];
            answer[i] *= tmp;
        }
        return answer;
    }
}

class OtherSolution {
    public int[] productExceptSelfNumsAsPrefix(int[] nums) {
        int[] output = new int[nums.length];
        output[0] = 1;

        for (int i = 0; i < nums.length - 1; i++)
            output[i + 1] = output[i] * nums[i];

        for (int i = nums.length - 2; i >= 0; i--) {
            output[i] = nums[i + 1] * output[i];
            nums[i] = nums[i] * nums[i + 1];
        }
        return output;
    }
}