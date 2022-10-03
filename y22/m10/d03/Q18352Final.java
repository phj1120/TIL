package y22.m10.d03;

import java.io.*;
import java.util.*;

public class Q18352Final {
    public static void main(String[] args) throws IOException {
        Map<Integer, City> cities = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] data = br.readLine().split(" ");
        int n = Integer.parseInt(data[0]);
        int m = Integer.parseInt(data[1]);
        int k = Integer.parseInt(data[2]);
        int x = Integer.parseInt(data[3]);

        boolean[] isVisited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            cities.put(i, new City(i, 0));
        }

        for (int i = 0; i < m; i++) {
            String[] line = br.readLine().split(" ");
            int start = Integer.parseInt(line[0]);
            int end = Integer.parseInt(line[1]);
            cities.get(start).addConnectCity(cities.get(end));
        }

        // 현재 위치에서 갈 수 있는 도시 중 방문하지 않은 도시를 Queue 에 넣음
        // Queue 에 넣으면서 방문 처리를 해 줌
        // 퍼져나가듯이 탐색하므로, Queue 에 넣을 때의 거리가 최단 거리임이 보장 됨
        Queue<City> queue = new LinkedList();

        // 초기 값 세팅
        City firstCity = cities.get(x);
        firstCity.setDistance(0);
        isVisited[x] = true;
        queue.offer(firstCity);
        // 넓이 우선 탐색(BFS) 시작
        while (!queue.isEmpty()) {
            City nowCity = queue.poll();
            // 현재 위치에서 갈 수 있는 도시들 중
            for (City city : nowCity.getConnectCity()) {
                // 방문한 적 없는 도시인 경우
                if (!isVisited[city.getNum()]) {
                    // 방문 처리를 하고, Queue 에 넣는다.
                    isVisited[city.getNum()] = true;
                    city.setDistance(nowCity.getDistance() + 1);
                    queue.offer(city);
                }
            }
        }

        boolean check = true;
        for (City city : cities.values()) {
            if (city.getDistance() == k) {
                bw.write(city.getNum() + "\n");
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

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public List<City> getConnectCity() {
            return connectCity;
        }

        public void addConnectCity(City connectCity) {
            this.connectCity.add(connectCity);
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }
    }
}
