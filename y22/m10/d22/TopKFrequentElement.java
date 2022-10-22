package y22.m10.d22;

import java.util.*;

public class TopKFrequentElement {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println(Arrays.toString(solution.topKFrequent(nums, k)));
    }
}


class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        // 1. num 이 몇개 있는지
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 2. 빈도로 분류한 frequent List
        int length = nums.length;
        List<Integer>[] frequentList = new ArrayList[length + 1];
        for (int num : map.keySet()) {
            int count = map.get(num);
            if (frequentList[count] == null) {
                frequentList[count] = new ArrayList<Integer>();
            }
            frequentList[count].add(num);
        }

        // 3. 가장 큰 값부터 순회하며 k 개 만큼 배열에 담아 반환
        int[] answer = new int[k];
        int index = 0;
        for (int i = length; i > 0; i--) {
            if (frequentList[i] != null)
                for (int num : frequentList[i])
                    answer[index++] = num;
            if (index == k)
                break;
        }
        return answer;
    }
}


class Solution2 {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public int[] topKFrequent(int[] numbers, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int number : numbers)
            map.put(
                    number,
                    map.getOrDefault(number, 0) + 1
            );

        int size = map.size();
        int[] keys = new int[size];
        int i = 0;
        for (int key : map.keySet()) keys[i++] = key;

        select(keys, map, 0, size - 1, size - k);
        return Arrays.copyOfRange(keys, size - k, size);
    }

    // Modified implementation of Hoare's selection algorithm:

    private void select(
            int[] keys,
            Map<Integer, Integer> map,
            int left,
            int right,
            int kSmallest
    ) {
        while (left != right) {
            int pivot = partition(keys, map, left, right, (left + right) / 2);

            if (kSmallest == pivot) return;

            if (kSmallest < pivot) right = pivot - 1;
            else left = pivot + 1;
        }
    }

    private int partition(
            int[] keys,
            Map<Integer, Integer> map,
            int left,
            int right,
            int pivot
    ) {
        int pivotValue = map.get(keys[pivot]);
        swap(keys, pivot, right);
        int index = left;

        for (int i = left; i <= right; i++)
            if (map.get(keys[i]) < pivotValue) {
                swap(keys, i, index);
                index++;
            }
        swap(keys, right, index);
        return index;
    }

    private void swap(int[] array, int i1, int i2) {
        int temp = array[i1];
        array[i1] = array[i2];
        array[i2] = temp;
    }
}