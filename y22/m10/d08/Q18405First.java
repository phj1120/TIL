package y22.m10.d08;

import java.util.*;

public class Q18405First {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] maps = new int[n][n];
        int k = sc.nextInt();

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        // 1. 입력 받으며 바이러스의 위치 저장
        Map<Integer, List<Node>> virusPosition = new HashMap<>();
        for (int i = 0; i < n; i++) { // i : y , 세로
            for (int j = 0; j < n; j++) { // j : x, 가로
                int nextInt = sc.nextInt();
                maps[i][j] = nextInt;
                if (!virusPosition.containsKey(nextInt)) {
                    virusPosition.put(nextInt, new ArrayList<Node>());
                }
                virusPosition.get(nextInt).add(new Node(i, j));
            }
        }
        virusPosition.remove(0);

        int s = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        sc.close();

        // 바이러스 이름 순서대로 정렬
        Integer[] viruses = virusPosition.keySet().toArray(new Integer[0]);
        Arrays.sort(viruses);

        // k 초 동안 반복
        for (int i = 0; i < s; i++) {
            for (int virus : viruses) {
                List<Node> virusNodes = virusPosition.get(virus);
                List<Node> newVirusNode = new ArrayList<>();
                while (!virusNodes.isEmpty()) {
                    Node now = virusNodes.remove(0);
                    for (int j = 0; j < dx.length; j++) {
                        int nx = now.x + dx[j];
                        int ny = now.y + dy[j];
                        if (nx >= 0 && nx < n && ny >= 0 && ny < n && maps[ny][nx] == 0) {
                            maps[ny][nx] = virus;
                            newVirusNode.add(new Node(ny, nx));
                        }
                    }
                }
                virusPosition.put(virus, newVirusNode);
            }
        }

//        printMap(n, maps);

        // s 초 후 (y, x) 의 바이러스 상태
        System.out.print(maps[x-1][y-1]);
    }

    private static void printMap(int n, int[][] maps) {
        for (int i = 0; i < n; i++) { // i : y , 세로
            for (int j = 0; j < n; j++) { // j : x, 가로
                System.out.print(maps[i][j]);
            }
            System.out.println();
        }
    }

    static class Node {
        int x;
        int y;

        public Node(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }
}
