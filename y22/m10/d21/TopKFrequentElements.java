package y22.m10.d21;

import java.util.*;
import java.util.stream.IntStream;

public class TopKFrequentElements {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 1;

        // map.values 로 가져오면 List 일줄 알았음 그래서 이 이상한 코드가 나옴
        IntStream stream = Arrays.stream(map.values().stream()
                .filter(i -> {
                    return i == max;
                })
                .mapToInt(i -> i)
                .toArray());

        // Stream -> int[]
        int[] ints = map.values().stream()
                .filter(i -> {
                    return i == max;
                })
                .mapToInt(i -> i)
                .toArray();

        Integer[] array = map.keySet().toArray(new Integer[0]);
        Arrays.sort(array, (i1, i2) -> {
            return map.get(i1) - map.get(i2);
        });
    }

    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                int numCount = map.getOrDefault(num, 0) + 1;
                map.put(num, numCount);
            }


            Integer[] array = map.keySet().toArray(new Integer[0]);
            Arrays.sort(array, (i1, i2) -> {
                return map.get(i2) - map.get(i1);
            });

            int[] answer = new int[k];
            for (int i = 0; i < k; i++) {
                answer[i] = array[i];
            }
            return answer;
        }
    }
}

