package y22.m11.d09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckDistance {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[][] places = {{"OOOOO", "OOOOO", "OOPOO", "OOOOO", "OOOOO"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        int[] solution1 = solution.solution(places);
        System.out.println(Arrays.toString(solution1));
    }

    static class Solution {
        public int[] solution(String[][] places) {
            List<char[][]> maps = new ArrayList<>();
            for (String[] place : places) {
                char[][] map = new char[5][5];
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        map[i][j] = place[i].charAt(j);
                    }
                }
                maps.add(map);
            }
            int[] answer = {1, 1, 1, 1, 1};
            for (int i = 0; i < 5; i++) {
                char[][] map = maps.get(i);
                for (int y = 0; y < 5; y++) {
                    for (int x = 0; x < 5; x++) {
                        if (map[y][x] == 'P') {
                            for (char[] chars : map) {
                                System.out.println(Arrays.toString(chars));
                            }
                            boolean isBreakRule = dfsBreakRule(map, x, y, x, y, 0);
                            System.out.println(isBreakRule);
                            if (isBreakRule) {
                                answer[i] = 0;
                                break;
                            }
                        }
                    }
                }
            }
            return answer;
        }

        public boolean dfsBreakRule(char[][] map, int startX, int startY, int x, int y, int depth) {
            if (depth > 2) {
                return false;
            }
            System.out.println(startX + " / " + startY + " / " + x + " / " + y);
            boolean isBreakRule = false;
            if (differenceStartSpot(startX, startY, x, y) && map[y][x] == 'P') {
                isBreakRule = true;
            }

            // 상하좌우
            int[] dx = {0, 0, -1, 1};
            int[] dy = {-1, 1, 0, 0};
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx <= 4 && ny >= 0 && ny <= 4 && differenceStartSpot(startX, startY, nx, ny)) {
                    if (map[ny][nx] != 'X') {
                        isBreakRule = dfsBreakRule(map, startX, startY, nx, ny, depth + 1) || isBreakRule;
                    }
                }
            }
            return isBreakRule;
        }

        private boolean differenceStartSpot(int startX, int startY, int x, int y) {
            return !(startX == x && startY == y);
        }
    }
}
