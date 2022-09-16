package y22.m09.d16;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> truckQueue = new LinkedList();
        Queue<Integer> bridgeQueue = new LinkedList();

        for (int truck : truck_weights) {
            truckQueue.add(truck);
        }

        for (int i = 0; i < bridge_length; i++) {
            bridgeQueue.add(0);
        }

        int bridgeWeight = 0;
        int time = 0;
        while (!truckQueue.isEmpty() || bridgeWeight != 0) {
            if (truckQueue.isEmpty() && bridgeWeight == 0) {
                break;
            }
            time++;
            int out = bridgeQueue.poll();
            bridgeWeight -= out;
            if (!truckQueue.isEmpty() && truckQueue.peek() + bridgeWeight <= weight) {
                int truck = truckQueue.poll();
                bridgeQueue.offer(truck);
                bridgeWeight += truck;
                continue;
            }
            bridgeQueue.offer(0);

        }
        return time;
    }
}

public class BridgeTruck {
    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7, 4, 5, 6};
        int correctResult = 8;
        Solution solution = new Solution();
        int answer = solution.solution(bridge_length, weight, truck_weights);
        System.out.println(correctResult == answer);
        System.out.println(correctResult);
        System.out.println(answer);
    }
}
