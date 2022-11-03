package y22.m11.d03;

public class MakePrimeNumber {
    static class Solution {
        public int solution(int[] nums) {
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    for (int k = j + 1; k < nums.length; k++) {
                        int sum = nums[i] + nums[j] + nums[k];
                        if (isPrimeNumber(sum)) count++;
                    }
                }
            }
            return count;
        }

        public boolean isPrimeNumber(int number) {
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) return false;
            }
            return true;
        }
    }
}

