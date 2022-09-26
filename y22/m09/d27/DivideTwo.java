package y22.m09.d27;

import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int answer = Integer.MAX_VALUE;
        for (int[] wire : wires) {
            if (!map.containsKey(wire[0])) {
                map.put(wire[0], new ArrayList<Integer>());
            }
            map.get(wire[0]).add(wire[1]);
        }

        for (int[] wire : wires) {
            map.get(wire[0]).remove(new Integer(wire[1]));
            Queue<Integer> queue = new LinkedList<>();
            boolean[] isVisited = new boolean[n + 1];

            queue.add(1);
            isVisited[1] = true;
            while (!queue.isEmpty()) {
                int now = queue.poll();
                for (int next : map.getOrDefault(now, new ArrayList<>())) {
                    if (!isVisited[next]) {
                        queue.add(next);
                        isVisited[next] = true;
                    }
                }
                for (int key : map.keySet()) {
                    if (!isVisited[key] && map.get(key).contains(now)) {
                        queue.add(key);
                        isVisited[key] = true;
                    }
                }
            }
            int cnt = 0;
            for (boolean state : isVisited) {
                if (state) cnt++;
            }
            answer = Math.min(answer, Math.abs(2 * cnt - n));
            map.get(wire[0]).add(wire[1]);
        }
        return answer;
    }
}

public class DivideTwo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] wires = {{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}};
        int n = 9;
        int correctAnswer = 3;
        int answer = solution.solution(n, wires);
        System.out.println(correctAnswer == answer);
        System.out.println(answer);
    }
}
