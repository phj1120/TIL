package y22.m10.d02;

import java.util.*;

class Main {
    public static void main(String[] args) {
        Map<Integer, City> cities = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        String[] data = sc.nextLine().split(" ");
        int n = Integer.parseInt(data[0]);
        int m = Integer.parseInt(data[1]);
        int k = Integer.parseInt(data[2]);
        int x = Integer.parseInt(data[3]);

        boolean[] isVisited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            cities.put(i, new City(i, 0));
        }

        for (int i = 0; i < m; i++) {
            String[] line = sc.nextLine().split(" ");
            int start = Integer.parseInt(line[0]);
            int end = Integer.parseInt(line[1]);
            cities.get(start).addConnectCity(cities.get(end));
        }
        sc.close();

        Queue<City> queue = new LinkedList();
        queue.offer(cities.get(x));
        isVisited[x] = true;
        while (!queue.isEmpty()) {
            City nowCity = queue.poll();

            for (City city : nowCity.getConnectCity()) {
                if (!isVisited[city.getNum()]) {
                    isVisited[city.getNum()] = true;
                    int distance = nowCity.getDistance() + 1;
                    city.setDistance(distance);
                    if (distance == k) {
                        result.add(city.getNum());
                    }
                    queue.offer(city);
                }
            }
        }

        if (result.isEmpty()) {
            System.out.println(-1);
        } else {
            Collections.sort(result);
            for (int number : result) {
                System.out.println(number);
            }
        }
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

public class FindCityDistance {
}
