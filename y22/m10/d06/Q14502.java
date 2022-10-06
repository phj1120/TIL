package y22.m10.d06;

import java.io.*;
import java.util.*;

public class Q14502 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");
        int n = Integer.parseInt(line1[0]); // 세로
        int m = Integer.parseInt(line1[1]); // 가로

        int[][] maps = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] data = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                maps[i][j] = Integer.parseInt(data[j]);
            }
        }

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        // 1. 빈칸의 위치 List 에 저장
        List<Node> blankList = new ArrayList<>();
        boolean[][] isVisitedForBlankFind = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maps[i][j] == 0 && !isVisitedForBlankFind[i][j]) {
                    Queue<Node> blankFindQueue = new LinkedList();
                    Node node = new Node(i, j);
                    blankFindQueue.offer(node);
                    blankList.add(node);
                    isVisitedForBlankFind[i][j] = true;
                    while (!blankFindQueue.isEmpty()) {
                        Node now = blankFindQueue.poll();
                        int x = now.x;
                        int y = now.y;
                        for (int k = 0; k < dx.length; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];
                            if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                                if (!isVisitedForBlankFind[ny][nx] && maps[ny][nx] == 0) {
                                    isVisitedForBlankFind[ny][nx] = true;
                                    blankFindQueue.offer(new Node(ny, nx));
                                    blankList.add(new Node(ny, nx));
                                }
                            }
                        }
                    }
                }
            }
        }

        // 6. 2-5 반복하며 최대값 구하기
        // 2. BlankList 에 담긴 노드 중 3개 선택
        int[] comArr = new int[3];
        combination(comArr, blankList.size(), 3, 0, 0);
        int maxSafe = -1;
        for (int[] blockWall : blockWallCombinations) {
            // 3. 선택한 칸을 벽으로 변경
            int[][] newMap = new int[n][m];
            for (int i = 0; i < n; i++) {
                newMap[i] = maps[i].clone();
            }
            for (int i = 0; i < blockWall.length; i++) {
                Node changeNode = blankList.get(blockWall[i]);
                newMap[changeNode.y][changeNode.x] = 1;
            }

            // 4. 바이러스 확산
            boolean[][] isVisitedForSpreadingVirus = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (newMap[i][j] == 2 && !isVisitedForSpreadingVirus[i][j]) {
                        Queue<Node> spreadingVirusQueue = new LinkedList<>();
                        spreadingVirusQueue.offer(new Node(i, j));
                        isVisitedForSpreadingVirus[i][j] = true;
                        while (!spreadingVirusQueue.isEmpty()) {
                            Node now = spreadingVirusQueue.poll();
                            int x = now.x;
                            int y = now.y;
                            for (int k = 0; k < dx.length; k++) {
                                int nx = x + dx[k];
                                int ny = y + dy[k];
                                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                                    if (!isVisitedForSpreadingVirus[ny][nx] && newMap[ny][nx] == 0) {
                                        isVisitedForSpreadingVirus[ny][nx] = true;
                                        newMap[ny][nx] = 2;
                                        spreadingVirusQueue.offer(new Node(ny, nx));
                                    }
                                }
                            }
                        }
                    }
                }
            }

            printMap(newMap);

            // 5. 안전한 칸 수 확인
            int safeNodeCount = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (newMap[i][j] == 0) {
                        safeNodeCount++;
                    }
                }
            }
            maxSafe = Math.max(safeNodeCount, maxSafe);
        }
        System.out.println(maxSafe);
    }

    private static void printMap(int[][] newMap) {
        for (int[] ints : newMap) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println();
    }

    static class Node {
        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        private int x; // 가로
        private int y; // 세로

        public Node(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }

    private static List<int[]> blockWallCombinations = new ArrayList<>();

    // 조합 코드 참고
    private static void combination(int[] comArr, int n, int r, int index, int target) {
        if (r == 0) {
            blockWallCombinations.add(comArr.clone());
            return;
        }
        if (target == n) return;

        comArr[index] = target;
        combination(comArr, n, r - 1, index + 1, target + 1); //뽑는 경우
        combination(comArr, n, r, index, target + 1); //안 뽑는 경우
    }
}
