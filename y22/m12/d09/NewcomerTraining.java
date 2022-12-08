package y22.m12.d09;

import java.util.PriorityQueue;

public class NewcomerTraining {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] ability = {10, 3, 7, 2};
        int number = 2;
        int correctAnswer = 37;

        int answer = solution.solution(ability, number);
        System.out.println(answer == correctAnswer);
        System.out.println(answer);
    }

}

class Solution {
    public int solution(int[] ability, int number) {
        PriorityQueue<Integer> pq = new PriorityQueue();
        for (int data : ability) {
            pq.add(data);
        }

        for (int i = 0; i < number; i++) {
            int sum = pq.poll() + pq.poll();
            pq.add(sum);
            pq.add(sum);
        }

        return pq.stream().mapToInt(Integer::intValue).sum();
    }
}