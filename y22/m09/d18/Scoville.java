package y22.m09.d18;

import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> scovilleQueue = new PriorityQueue();
        for (int number : scoville) {
            scovilleQueue.add(number);
        }

        int cnt = 0;
        while (!scovilleQueue.isEmpty() && scovilleQueue.peek() < K) {
            if (scovilleQueue.size() < 2) return -1;
            int minFirst = scovilleQueue.poll();
            int minSecond = scovilleQueue.poll();
            int newScoville = minFirst + (minSecond * 2);
            scovilleQueue.add(newScoville);
            cnt++;
        }

        return cnt;
    }
}

public class Scoville {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;
        int correctResult = 2;
        int answer = solution.solution(scoville, K);
        System.out.println(correctResult == answer);
    }
}
