package y22.m09.d06;

public class TargetNumber {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] numbers = new int[]{1, 1, 1, 1, 1};
//        int target = 3;
        int[] numbers = new int[]{4, 1, 2, 1};
        int target = 4;
        int correctAnswer = 2;
        int answer = solution.solution(numbers, target);
        System.out.println(answer == correctAnswer);
        System.out.println("answer = " + answer);
        System.out.println("correctAnswer = " + correctAnswer);
    }
}

class Solution {
    int answer = 0;

    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }

    public void dfs(int[] numbers, int target, int index, int sum) {
        if (numbers.length == index) {
            if (sum == target) {
                answer++;
            }
            return;
        }
        int number = numbers[index];
        dfs(numbers, target, index + 1, sum + number);
        dfs(numbers, target, index + 1, sum - number);
    }
}

