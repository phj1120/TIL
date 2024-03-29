package y22.m09.d15;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> truckQueue = new LinkedList();
        Queue<Integer> bridgeQueue = new LinkedList();

        for (int truck : truck_weights) {
            truckQueue.add(truck);
        }

        for (int i = 0; i < bridge_length - 1; i++) {
            bridgeQueue.add(0);
        }
        Integer firstTruck = truckQueue.poll();
        bridgeQueue.add(firstTruck);
        int totalWeight = firstTruck;
        int time = 1;
        while (totalWeight != 0) {
            Integer out = bridgeQueue.poll();
            if (out == 0) {
                bridgeQueue.add(0);
            } else {
                totalWeight -= out;
                Integer truck = truckQueue.peek();
                if (truck != null && totalWeight + truck <= weight) {
                    truckQueue.poll();
                    bridgeQueue.add(truck);
                    totalWeight += truck;
                }
            }
            time++;
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

