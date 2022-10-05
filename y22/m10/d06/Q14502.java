package y22.m10.d06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
                if (maps[i][j] == 0) {
                    Queue<Node> blankFindQueue = new LinkedList();
                    blankFindQueue.offer(new Node(i, j));
                    while (!blankFindQueue.isEmpty()) {
                        Node now = blankFindQueue.poll();
                        int x = now.x;
                        int y = now.y;
                        for (int k = 0; k < dx.length; k++) {
                            for (int l = 0; l < dy.length; l++) {
                                int nx = x + dx[k];
                                int ny = y + dy[l];
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
            System.out.println(Arrays.toString(blockWall));
            for (int i = 0; i < blockWall.length; i++) {
                Node changeNode = blankList.get(blockWall[i]);
                System.out.println(changeNode);
                newMap[changeNode.y][changeNode.x] = 1;
            }

            // 4. 바이러스 확산
//            boolean[][] isVisitedForSpreadingVirus = new boolean[n][m];
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < m; j++) {
//                    if (maps[i][j] == 0) {
//                        Queue<Node> blankFindQueue = new LinkedList();
//                        blankFindQueue.offer(new Node(i, j));
//                        while (!blankFindQueue.isEmpty()) {
//                            Node now = blankFindQueue.poll();
//                            int x = now.x;
//                            int y = now.y;
//                            for (int k = 0; k < dx.length; k++) {
//                                for (int l = 0; l < dy.length; l++) {
//                                    int nx = x + dx[k];
//                                    int ny = y + dy[l];
//                                    if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
//                                        if (!isVisitedForSpreadingVirus[ny][nx] && maps[ny][nx] == 0) {
//                                            isVisitedForSpreadingVirus[ny][nx] = true;
//                                            blankFindQueue.offer(new Node(ny, nx));
//                                            blankList.add(new Node(ny, nx));
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
            System.out.println(Arrays.deepToString(newMap));
            // 5. 안전한 칸 수 확인

        }
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
            blockWallCombinations.add(comArr);
            return;
        }
        if (target == n) return;

        comArr[index] = target;
        combination(comArr, n, r - 1, index + 1, target + 1); //뽑는 경우
        combination(comArr, n, r, index, target + 1); //안 뽑는 경우
    }
}
