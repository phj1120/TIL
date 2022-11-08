package y22.m11.d08;

import java.util.*;

public class LongestNode {
    // 처음 구현한 정답(클래스 사용)
    class FirstSolution {
        public int solution(int n, int[][] edge) {
            // 노드 생성
            Map<Integer, Node> nodes = new HashMap<>();
            for (int i = 0; i < n; i++) {
                nodes.put(i + 1, new Node(i + 1));
            }

            // 데이터 초기화
            for (int[] data : edge) {
                nodes.get(data[0]).addConnects(nodes.get(data[1]));
            }

            // 탐색
            int[] distances = new int[n + 1];
            Queue<Node> q = new LinkedList();
            q.add(nodes.get(1));
            while (!q.isEmpty()) {
                Node now = q.poll();
                for (Node next : now.connects) {
                    if (next.number != 1 && distances[next.number] == 0) {
                        distances[next.number] = distances[now.number] + 1;
                        q.add(next);
                    }
                }
            }

            // 거리의 최대값과 가장 먼 노드의 개수
            int max = Arrays.stream(distances).max().getAsInt();
            long count = Arrays.stream(distances).filter(i -> i == max).count();
            return (int) count;
        }
    }

    class Node {
        int number;
        List<Node> connects = new ArrayList<>();

        public void addConnects(Node node) {
            this.connects.add(node);
            node.connects.add(this);
        }

        public Node(int number) {
            this.number = number;
        }
    }

    // 그래프 - 인접 립스트
    class GraphSolution1 {
        public int solution(int n, int[][] edge) {
            // 노드 생성
            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            // 데이터 초기화
            for (int[] data : edge) {
                graph.get(data[0]).add(data[1]);
                graph.get(data[1]).add(data[0]);
            }

            // 탐색
            int[] distances = new int[n + 1];
            Queue<Integer> q = new LinkedList();
            q.add(1);
            while (!q.isEmpty()) {
                int now = q.poll();
                for (int next : graph.get(now)) {
                    if (next != 1 && distances[next] == 0) {
                        distances[next] = distances[now] + 1;
                        q.add(next);
                    }
                }
            }

            // 거리의 최대값과 가장 먼 노드의 개수
            int max = Arrays.stream(distances).max().getAsInt();
            long count = Arrays.stream(distances).filter(i -> i == max).count();
            return (int) count;
        }
    }

    // 그래프 - 2차원 배열
    class Solution {
        public int solution(int n, int[][] edge) {
            // 노드 생성
            boolean[][] graph = new boolean[n + 1][n + 1];

            // 데이터 초기화
            for (int[] data : edge) {
                graph[data[0]][data[1]] = graph[data[1]][data[0]] = true;
            }

            // 탐색
            int[] distances = new int[n + 1];
            Queue<Integer> q = new LinkedList();
            q.add(1);
            while (!q.isEmpty()) {
                int now = q.poll();
                for (int i = 0; i <= n; i++) {
                    if (graph[now][i]) {
                        if (i != 1 && distances[i] == 0) {
                            distances[i] = distances[now] + 1;
                            q.add(i);
                        }
                    }
                }
            }

            // 거리의 최대값과 가장 먼 노드의 개수
            int max = Arrays.stream(distances).max().getAsInt();
            long count = Arrays.stream(distances).filter(i -> i == max).count();
            return (int) count;
        }
    }
}
