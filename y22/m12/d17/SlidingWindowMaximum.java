package m12.d17;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] correctAnswer = {3, 3, 5, 5, 6, 7};

//        int[] nums = {1, -1};
//        int k = 1;
//        int[] correctAnswer = {1, -1};
        int[] answer = solution.maxSlidingWindow(nums, k);
        System.out.println(Arrays.equals(correctAnswer, answer));
        System.out.println(Arrays.toString(answer));
    }
}

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Node[] nodes = new Node[nums.length];
        PriorityQueue<Node> pq = new PriorityQueue<>((node1, node2) -> {
            return node2.value - node1.value;
        });

        for (int i = 0; i < nums.length; i++) {
            nodes[i] = new Node(i, nums[i]);
        }


        int[] result = new int[nums.length - k + 1];
        int left = 0;
        int right = k - 1;
        for (int i = 0; i < k; i++) {
            pq.add(nodes[i]);
        }
        for (int i = 0; i < result.length; i++) {
            result[i] = pq.peek().value;
            if (i != result.length - 1) {
                pq.remove(nodes[left++]);
                pq.add(nodes[++right]);
            }
        }

        return result;
    }

    static class Node {
        int num;
        int value;

        public Node(int num, int value) {
            this.num = num;
            this.value = value;
        }
    }
}


class SolutionFail {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        int left = 0;
        int right = k - 1;
        for (int i = 0; i < result.length; i++) {
//            int max = (int) Arrays.stream(Arrays.copyOfRange(nums, left, right+1)).asLongStream().max().getAsLong();
            int max = Integer.MIN_VALUE;
            for (int j = left; j < right + 1; j++) {
                max = Math.max(max, nums[j]);
            }
            left++;
            right++;
            result[i] = max;
        }
        return result;
    }
}
