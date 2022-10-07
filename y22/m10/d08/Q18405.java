package y22.m10.d08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q18405 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int[][] maps = new int[n][n];

        // 1. 입력 받으며 바이러스의 위치 저장
        Map<Integer, List<Node>> virusPosition = new HashMap<>();
        for (int i = 0; i < n; i++) { // i : y , 세로
            String[] data = br.readLine().split(" ");
            for (int j = 0; j < n; j++) { // j : x, 가로
                int nextInt = Integer.parseInt(data[j]);
                maps[i][j] = nextInt;
                // 1.1 바이러스인 경우 탐색 하는데 사용 될 바이러스 위치에 저장
                if (nextInt != 0) {
                    if (!virusPosition.containsKey(nextInt)) {
                        virusPosition.put(nextInt, new ArrayList<Node>());
                    }
                    virusPosition.get(nextInt).add(new Node(i, j));
                }
            }
        }

        String[] thirdLine = br.readLine().split(" ");
        int s = Integer.parseInt(thirdLine[0]);
        int x = Integer.parseInt(thirdLine[1]);
        int y = Integer.parseInt(thirdLine[2]);
        br.close();

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        // 1.2 바이러스 번호 순서대로 정렬
        Integer[] viruses = virusPosition.keySet().toArray(new Integer[0]);
        Arrays.sort(viruses);

        // 2. k 초 동안 바이러스 전이
        for (int i = 0; i < s; i++) {
            // 2.1 번호가 낮은 바이러스 부터 전이 시작
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
                // 2.2 바이러스의 전이 가능한 위치 갱신
                virusPosition.put(virus, newVirusNode);
            }
        }
        // 3. s 초 후 (y, x) 의 바이러스 상태
        System.out.print(maps[x - 1][y - 1]);
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
