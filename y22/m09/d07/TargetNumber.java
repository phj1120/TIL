package y22.m09.d07;

public class TargetNumber {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] numbers = new int[]{1, 1, 1, 1, 1};
        int target = 3;
        int correctAnswer = 5;
        int answer = solution.solution(numbers, target);

        System.out.println(answer == correctAnswer);
        System.out.println("answer = " + answer);
        System.out.println("correctAnswer = " + correctAnswer);
    }
}

class Solution {
    int answer = 0;
    int[] numbers;
    int target;

    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;

        dfs(0, 0);
        return answer;
    }

    public void dfs(int index, int sum) {
        // 탈출 조건
        if (numbers.length == index) {
            if (sum == target) {
                answer++;
            }
            return;
        }

        // 수행 동작
        dfs(index + 1, sum + numbers[index]);
        dfs(index + 1, sum - numbers[index]);
    }
}

