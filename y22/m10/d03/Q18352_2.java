package y22.m10.d03;

import java.io.*;
import java.util.*;

public class Q18352_2 {
    public static void main(String[] args) throws IOException {
        Map<Integer, City> cities = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] data = br.readLine().split(" ");
        int n = Integer.parseInt(data[0]);
        int m = Integer.parseInt(data[1]);
        int k = Integer.parseInt(data[2]);
        int x = Integer.parseInt(data[3]);

        // 거리를 -1 으로 초기화 해 -1 일 경우 방문한 적 없는 도시로.
        for (int i = 1; i <= n; i++) {
            cities.put(i, new City(i, -1));
        }

        for (int i = 0; i < m; i++) {
            String[] line = br.readLine().split(" ");
            int start = Integer.parseInt(line[0]);
            int end = Integer.parseInt(line[1]);
            cities.get(start).connectCity.add(cities.get(end));
        }

        Queue<City> queue = new LinkedList();
        // 초기 값 세팅
        City firstCity = cities.get(x);
        firstCity.distance = 0;
        queue.offer(firstCity);
        // 넓이 우선 탐색(BFS) 시작
        while (!queue.isEmpty()) {
            City nowCity = queue.poll();
            // 현재 위치에서 갈 수 있는 도시들 중
            for (City city : nowCity.connectCity) {
                // 방문한 적 없는 도시인 경우
                if (city.distance == -1) {
                    // 방문 처리를 하고, Queue 에 넣는다.
                    city.distance = nowCity.distance + 1;
                    queue.offer(city);
                }
            }
        }

        boolean check = true;
        for (City city : cities.values()) {
            if (city.distance == k) {
                bw.write(city.num + "\n");
                check = false;
            }
        }
        if (check) {
            bw.write(String.valueOf(-1));
        }

        br.close();
        bw.flush();
        bw.close();
    }

    static class City {
        private int num;
        private List<City> connectCity = new ArrayList<>();
        private int distance;

        public City(int num, int distance) {
            this.num = num;
            this.distance = distance;
        }
    }
}
