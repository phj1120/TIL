package y22.m10.d16;

import java.util.Collections;
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
        while (q.isEmpty()) {
            CustomQueue now = q.poll();
            int sumQ1 = q1.stream().mapToInt(Integer::intValue).sum();
            int sumQ2 = q2.stream().mapToInt(Integer::intValue).sum();
            if (sumQ1 == sumQ2) {
                return now.depth;
            }
            int newDepth = now.depth + 1;
            Queue<Integer> newQ1_1 = new LinkedList<>(now.q1);
            Queue<Integer> newQ2_1 = new LinkedList<>(now.q2);
            newQ2_1.offer(newQ1_1.poll());
            q.offer(new CustomQueue(newQ1_1, newQ2_1, newDepth));

            Queue<Integer> newQ1_2 = new LinkedList<>(now.q1);
            Queue<Integer> newQ2_2 = new LinkedList<>(now.q2);
            newQ1_2.offer(newQ2_2.poll());
            q.offer(new CustomQueue(newQ1_2, newQ2_2, newDepth));
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

}
