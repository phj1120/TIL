package y22.m09.d17;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] prices) {

        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int now = prices[i];
            int count = 0;
            for (int j = i + 1; j < prices.length; j++) {
                count++;
                int next = prices[j];
                if (now > next) {
                    break;
                }
            }
            answer[i] = count;
        }

        return answer;
    }
}

class SimpleSolution extends Solution {
    public int[] solution(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                answer[i]++;
                if (prices[i] > prices[j])
                    break;
            }
        }
        return answer;
    }
}

public class Stock {
    public static void main(String[] args) {
        Solution sol = new SimpleSolution();
        int[] prices = new int[]{1, 2, 3, 2, 3};
        int[] correctResult = {4, 3, 1, 1, 0};
        int[] answer = sol.solution(prices);
        System.out.println(Arrays.equals(correctResult, answer));
        System.out.println(Arrays.toString(answer));
    }

}
