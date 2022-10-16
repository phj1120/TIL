package y22.m10.d16;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<CustomQueue> q = new LinkedList();
        Queue<Integer> q1 = new LinkedList();
        Queue<Integer> q2 = new LinkedList();

        for (int i = 0; i < queue1.length; i++) {
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
        }

        q.offer(new CustomQueue(q1, q2, 0));
        while (!q.isEmpty()) {
            CustomQueue now = q.poll();
            int sumQ1 = now.q1.stream().mapToInt(Integer::intValue).sum();
            int sumQ2 = now.q2.stream().mapToInt(Integer::intValue).sum();
            int newDepth = now.depth + 1;
            if (sumQ1 == sumQ2) {
                return now.depth;
            }

            if (!now.q1.isEmpty() || !now.q2.isEmpty()) {
                Queue<Integer> newQ1_1 = new LinkedList<>(now.q1);
                Queue<Integer> newQ2_1 = new LinkedList<>(now.q2);
                if (!newQ1_1.isEmpty() && !newQ2_1.isEmpty()) {
                    newQ2_1.offer(newQ1_1.poll());
                    if (!newQ1_1.equals(q1) && !newQ2_1.equals(q2)) {
                        q.offer(new CustomQueue(newQ1_1, newQ2_1, newDepth));
                    }
                }

                Queue<Integer> newQ1_2 = new LinkedList<>(now.q1);
                Queue<Integer> newQ2_2 = new LinkedList<>(now.q2);
                if (!newQ1_2.isEmpty() && !newQ2_2.isEmpty()) {
                    newQ1_2.offer(newQ2_2.poll());
                    if (!newQ1_2.equals(q1) && !newQ2_2.equals(q2)) {
                        q.offer(new CustomQueue(newQ1_2, newQ2_2, newDepth));
                    }
                }
            }
        }
        return -1;
    }

    static class CustomQueue {
        public Queue<Integer> q1 = new LinkedList();
        public Queue<Integer> q2 = new LinkedList();
        public int depth;

        public CustomQueue(Queue<Integer> q1, Queue<Integer> q2, int depth) {
            this.q1 = q1;
            this.q2 = q2;
            this.depth = depth;
        }
    }
}

public class SumSameQueue {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] queue1 = {3, 2, 7, 2};
        int[] queue2 = {4, 6, 5, 1};
        int correctResult = 2;
        int result = solution.solution(queue1, queue2);
        System.out.println(correctResult == result);
        System.out.println(result);
    }
}
