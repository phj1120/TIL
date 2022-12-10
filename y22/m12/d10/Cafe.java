package y22.m12.d10;

public class Cafe {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] menu = {5, 12, 30};
        int[] order = {1, 2, 0, 1};
        int k = 10;
        int correctAnswer = 3;
        int answer = solution.solution(menu, order, k);
        System.out.println(correctAnswer == answer);
        System.out.println(answer);
    }
}

class Solution {
    public int solution(int[] menu, int[] order, int k) {
        int answer = 0;
        return answer;
    }
}