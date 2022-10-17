package y22.m10.d17;

import java.util.*;

class Solution {

    public int solution(int[] queue1, int[] queue2) {
        Queue<CustomQueue> q = new LinkedList();
        int length = queue1.length + queue2.length;
        int[] queue = new int[length];
        for (int i = 0; i < queue1.length; i++) {
            queue[i] = queue1[i];
        }
        for (int i = 0; i < queue2.length; i++) {
            queue[i + queue1.length] = queue2[i];
        }

        int sum = Arrays.stream(queue).sum();

        int q1 = 0;
        int q2 = queue1.length;
        q.offer(new CustomQueue(q1, q2, 0));
        while (!q.isEmpty()) {
            CustomQueue now = q.poll();
            int newDepth = now.depth + 1;
            int nowStartQ1 = now.startQ1;
            int nowStartQ2 = now.startQ2;

            int sumQ = 0;
            if (nowStartQ1 < nowStartQ2) {
                for (int i = nowStartQ1; i < nowStartQ2; i++) {
                    sumQ += queue[i];
                }
            } else {
                for (int i = nowStartQ2; i < nowStartQ1; i++) {
                    sumQ += queue[i];
                }
            }
            if (sumQ == sum / 2) {
                return now.depth;
            }

            int addQ1 = add(nowStartQ1, length);
            if (addQ1 != q1) {
                q.add(new CustomQueue(addQ1, nowStartQ2, newDepth));

            }
            int addQ2 = add(nowStartQ2, length);
            if (addQ2 != q2) {
                q.add(new CustomQueue(nowStartQ1, addQ2, newDepth));
            }
        }
        return -1;
    }

    public int add(int now, int length) {
        if (now == length) {
            return 0;
        }
        return ++now;
    }

    static class CustomQueue {
        public int startQ1;
        public int startQ2;
        public int depth;

        public CustomQueue(int startQ1, int startQ2, int depth) {
            this.startQ1 = startQ1;
            this.startQ2 = startQ2;
            this.depth = depth;
        }
    }
}

public class SumSameQueueTwoPointer {
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
