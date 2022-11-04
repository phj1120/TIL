package y22.m11.d04;

import java.util.*;

public class Delivery {
    class FirstSolution {
        public int solution(int N, int[][] road, int K) {
            // villages : <마을 번호:<갈 수 있는 마을 번호 : 시간>>
            Map<Integer, Map<Integer, Integer>> villages = new HashMap<>();
            for (int i = 1; i <= N; i++) {
                villages.put(i, new HashMap<Integer, Integer>());
            }

            // 정보 저장(최단 시간의 다리)
            for (int[] data : road) {
                int v1 = data[0];
                int v2 = data[1];
                int t = data[2];
                if (!villages.get(v1).containsKey(v2) ||
                        (villages.get(v1).containsKey(v2) && villages.get(v1).get(v2) > t)) {
                    villages.get(v1).put(v2, t);
                    villages.get(v2).put(v1, t);
                }
            }

            // 탐색
            int count = 0;
            int[] times = new int[N + 1];
            Queue<Integer> q = new LinkedList<>();
            times[1] = 0;
            q.add(1);
            while (!q.isEmpty()) {
                int now = q.poll();
                Map<Integer, Integer> nexts = villages.get(now);
                for (int next : nexts.keySet()) {
                    if (times[next] == 0 ||
                            times[next] > times[now] + nexts.get(next)) {
                        times[next] = times[now] + nexts.get(next);
                        q.add(next);
                    }
                }
            }

            // K 시간 이내에 배달 가능한 마을 수 확인
            for (int i = 2; i < times.length; i++) {
                if (times[i] <= K) {
                    count++;
                }
            }
            // 1번 마을 무조건 배달 가능.
            count++;

            return count;
        }
    }
}
