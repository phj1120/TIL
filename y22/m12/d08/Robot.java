package y22.m12.d08;

import java.util.Arrays;

public class Robot {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String command = "GRGLGRG";
        int[] correctAnswer = {2, 2};
        int[] answer = solution.solution(command);
        System.out.println(Arrays.equals(correctAnswer, answer));
        System.out.println(Arrays.toString(answer));
    }
}

class Solution {
    public int[] solution(String command) {
        int[] answer = {};
        return answer;
    }
}
