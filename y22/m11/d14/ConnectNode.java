package m11.d14;

import java.util.*;

public class ConnectNode {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int n = 4;
//        int[][] costs = {{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}};
//        int correctAnswer = 4;
//        int n = 7;
//        int[][] costs = {{2, 3, 7}, {3, 6, 13}, {3, 5, 23}, {5, 6, 25}, {0, 1, 29}, {1, 5, 34}, {1, 2, 35}, {4, 5, 53}, {0, 4, 75}};
//        int correctAnswer = 159;
        int n = 5;
        int[][] costs = {{0, 1, 1}, {3, 4, 1}, {1, 2, 2}, {2, 3, 4}};
        int correctAnswer = 8;
        int answer = solution.solution(n, costs);
        System.out.println(correctAnswer == answer);
        System.out.println(answer);
    }

    static class Solution {
        List<Set<Integer>> connects = new ArrayList<>();
        int n;

        public int solution(int n, int[][] costs) {
            this.n = n;

            PriorityQueue<Bridge> pq = new PriorityQueue<>();
            for (int[] data : costs) {
                pq.add(new Bridge(data[0], data[1], data[2]));
            }
            int sum = 0;
            while (!isAllConnect()) {
                Bridge now = pq.poll();
                int setIndex1 = getSet(now.node1);
                int setIndex2 = getSet(now.node2);
                if (setIndex1 != setIndex2) {
                    unionSet(setIndex1, setIndex2);

                    int setIndex = getSet(now.node1);
                    connects.get(setIndex).add(now.node1);
                    connects.get(setIndex).add(now.node2);
                    sum += now.cost;
                }
            }
            return sum;
        }

        private boolean isAllConnect() {
            for (Set<Integer> connect : connects) {
                return connect.size() == n;
            }
            return false;
        }

        private void unionSet(int setIndex1, int setIndex2) {
            Set<Integer> set1 = connects.get(setIndex1);
            Set<Integer> set2 = connects.get(setIndex2);

            set1.addAll(set2);
            connects.remove(setIndex2);
        }

        private int getSet(int node) {
            boolean exist = false;
            int i = 0;
            while (i < connects.size()) {
                Set<Integer> set = connects.get(i);
                if (set.contains(node)) {
                    exist = true;
                    break;
                }
                i++;
            }
            if (!exist) {
                Set<Integer> set = new HashSet<>();
                set.add(node);
                connects.add(set);
            }
            return i;
        }

        class Bridge implements Comparable<Bridge> {
            int node1;
            int node2;
            int cost;

            public Bridge(int node1, int node2, int cost) {
                this.node1 = node1;
                this.node2 = node2;
                this.cost = cost;
            }

            @Override
            public int compareTo(Bridge b) {
                return cost - b.cost;
            }
        }

    }

    // 서로소 집합으로 구현한 크루스칼 알고리즘을 이용한 문제 풀이
    static class SimpleSolution {
        public int findParent(int[] parent, int node) {
            if (parent[node] == node)
                return node;
            return findParent(parent, parent[node]);
        }

        public void union(int[] parent, int node1, int node2) {
            int p1 = findParent(parent, node1);
            int p2 = findParent(parent, node2);

            if (p1 < p2)
                parent[p2] = p1;
            else
                parent[p1] = p2;
        }

        public int solution(int n, int[][] costs) {
            int answer = 0;
            int[] parent = new int[n];

            // 자기 자신을 부모로
            for (int i = 0; i < parent.length; i++)
                parent[i] = i;
            Arrays.sort(costs, ((o1, o2) -> o1[2] - o2[2]));

            for (int i = 0; i < costs.length; i++) {
                // 부모가 다를 경우
                if (findParent(parent, costs[i][0]) != findParent(parent, costs[i][1])) {
                    answer += costs[i][2];
                    union(parent, costs[i][0], costs[i][1]);
                }
            }
            return answer;
        }
    }
}
