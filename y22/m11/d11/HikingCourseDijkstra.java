package y22.m11.d11;

import java.util.*;
import java.util.stream.Collectors;

public class HikingCourseDijkstra {
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

        // 출입구 부터 해당 노드까지 오는데 있었던 최대 간격의 최소 값
        public static int minSummit = Integer.MAX_VALUE;
        public static int minIntensity = Integer.MAX_VALUE;

        public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
            // 지점 : 갈 수 있는 지점(지점 : 거리)
            List<Map<Integer, Integer>> graph = new ArrayList<>();
            for (int i = 0; i < n + 1; i++) {
                graph.add(new HashMap<>());
            }
            checkGate = Arrays.stream(gates).boxed().collect(Collectors.toSet());
            checkSummit = Arrays.stream(summits).boxed().collect(Collectors.toSet());

            for (int[] path : paths) {
                int start = path[0], end = path[1], distance = path[2];
                // 시작 : 출입구 ||  도착 : 봉우리
                if (checkGate.contains(start) || checkSummit.contains(end)) {
                    graph.get(start).put(end, distance);
                    continue;
                }
                // 쉼터 -> 쉼터
                graph.get(path[0]).put(path[1], path[2]);
                graph.get(path[1]).put(path[0], path[2]);
            }
            for (int summit : summits) {
                graph.get(0).put(summit, 0);
            }
            boolean[] isVisited = new boolean[n + 1];
            isVisited[0] = true;

            // 출입구 부터 해당 노드까지 오는데 있었던 최대 간격
            int[] intensities = new int[n + 1];
            Arrays.fill(intensities, Integer.MAX_VALUE);
            intensities[0] = 0;
//            dijkstra(graph, intensities, isVisited, 0);

            Queue<Integer> queue = new LinkedList();
            queue.add(0);
            while (queue.isEmpty()) {


            }
            System.out.println(Arrays.toString(intensities));

            return new int[]{minSummit, minIntensity};
        }

        public void dijkstra(List<Map<Integer, Integer>> graph, int[] intensities, boolean[] isVisited, int now) {
            isVisited[now] = true;
            // 현재 위치에서 방문 할 수 있는 거리가 가장 짧은 노드 방문
            Integer min = graph.get(now).keySet().stream().min(
                    (k1, k2) -> {
                        return graph.get(now).get(k1) - graph.get(now).get(k2);
                    }
            ).get();

            // 최대 간격 갱신


            dijkstra(graph, intensities, isVisited, min);
        }
    }
}


