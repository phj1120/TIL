package y22.m11.d10;

import java.util.*;
import java.util.stream.Collectors;

public class HikingCourse {

    public static void main(String[] args) {
        int n = 6;
        int[][] path = {{1, 2, 3}, {2, 3, 5}, {2, 4, 2}, {2, 5, 4}, {3, 4, 4}, {4, 5, 3}, {4, 6, 1}, {5, 6, 1}};
        int[] gates = {1, 3};
        int[] summits = {5};
        int[] correctAnswer = {5, 3};

//        int n = 7;
//        int[][] path = {{1, 4, 4}, {1, 6, 1}, {1, 7, 3}, {2, 5, 2}, {3, 7, 4}, {5, 6, 6}};
//        int[] summits = {2, 3, 4};
//        int[] gates = {1};
//        int[] correctAnswer = {3, 4};

        Solution solution = new Solution();
        int[] answer = solution.solution(n, path, gates, summits);
        System.out.println(Arrays.equals(correctAnswer, answer));
        System.out.println(Arrays.toString(answer));

    }

    static class Solution {

        public static Set<Integer> checkGate;
        public static Set<Integer> checkSummit;

        public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
            // 지점 : 갈 수 있는 지점(지점 : 거리)
            List<Map<Integer, Integer>> graph = new ArrayList<>();
            for (int i = 0; i < n + 1; i++) {
                graph.add(new HashMap<>());
            }

            for (int[] path : paths) {
                graph.get(path[0]).put(path[1], path[2]);
                graph.get(path[1]).put(path[0], path[2]);
            }
            checkGate = Arrays.stream(gates).boxed().collect(Collectors.toSet());
            checkSummit = Arrays.stream(summits).boxed().collect(Collectors.toSet());

            // 출입구 부터 해당 노드까지 오는데 있었던 최대 간격의 최소 값
            int minSummit = Integer.MAX_VALUE;
            int minIntensity = Integer.MAX_VALUE;

            for (int gate : gates) {
                // 방문 여부
                boolean[] isVisited = new boolean[n + 1];
                isVisited[0] = true;

                // 출입구 부터 해당 노드까지 오는데 있었던 최대 간격
                int[] intensities = new int[n + 1];
                Arrays.fill(intensities, Integer.MAX_VALUE);
                intensities[gate] = 0;

                dfs(graph, intensities, isVisited, gate);
                System.out.println(Arrays.toString(intensities));

                // intensity 가 가장 짧은 summit 과, intensity 값
                for (int summit : summits) {
                    if (intensities[summit] < minIntensity) {
                        minSummit = summit;
                        minIntensity = intensities[summit];
                    } else if (intensities[summit] == minIntensity) {
                        minSummit = Math.min(summit, minSummit);
                    }
                }
            }
            int[] result = {minSummit, minIntensity};
            return result;
        }

        public void dfs(List<Map<Integer, Integer>> graph, int[] intensities, boolean[] isVisited, int now) {
            boolean[] newIsVisited = isVisited.clone();
            int[] newIntensities = intensities.clone();

            newIsVisited[now] = true;
            // 현재 위치에서 방문 할 수 있는 노드 방문
            for (Integer next : graph.get(now).keySet()) {
                // 출입구인 경우
                if (checkGate.contains(next)) {
                    continue;
                }

                // 지금 까지 오는데 있었던 최대 간격 갱신
                newIntensities[next] = Math.max(newIntensities[now], graph.get(next).get(now));
                intensities[next] = Math.min(newIntensities[next], intensities[next]);
                // 산봉우리인 경우
                if (checkSummit.contains(next)) {
                    continue;
                }
                // 방문 한 적 없는 쉼터인 경우 방문 이어감.
                if (!newIsVisited[next]) {
                    dfs(graph, intensities, newIsVisited, next);
                }
            }
        }
    }
}