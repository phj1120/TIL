package y22.m10.d18;

class Solution {
    static int[] queue;

    public int solution(int[] queue1, int[] queue2) {
        // 합친 큐 생성
        queue = new int[queue1.length + queue2.length];
        long sumQ1 = 0;
        long sumQueue = 0;
        for (int i = 0; i < queue1.length; i++) {
            queue[i] = queue1[i];
            queue[i + queue1.length] = queue2[i];
            sumQ1 += queue1[i];
            sumQueue += queue1[i] + queue2[i];
        }

        // 합이 홀수 인 경우 불가능
        if (sumQueue % 2 == 1) {
            return -1;
        }

        // 투 포인터로 탐색
        int start = 0;
        int end = queue1.length - 1;
        int depth = 0;
        long halfSum = sumQueue / 2;
        while (depth < queue.length * 4) {
            if (sumQ1 == halfSum) {
                return depth;
            } else if (sumQ1 < halfSum) {
                end = addIndex(end);
                sumQ1 += queue[end];
            } else {
                sumQ1 -= queue[start];
                start = addIndex(start);
            }
            depth++;
        }
        return -1;
    }

    public int addIndex(int index) {
        if (index < queue.length - 1) {
            return ++index;
        }
        return 0;
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

