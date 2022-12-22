package m12.d22;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] correctAnswer = {1, 1, 4, 2, 1, 1, 0, 0};
        int[] answer = solution.dailyTemperatures(temperatures);

        System.out.println(Arrays.equals(answer, correctAnswer));
        System.out.println(Arrays.toString(answer));
    }
}

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int day = 0; day < temperatures.length; day++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[day]) {
                int pastDay = stack.pop();
                answer[pastDay] = day - pastDay;
            }
            stack.push(day);
        }

        return answer;
    }
}