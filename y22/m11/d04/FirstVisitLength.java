package y22.m11.d04;

import java.util.*;

public class FirstVisitLength {
    class Solution {
        public int solution(String dirs) {
            Set<Road> visited = new HashSet<>();
            int nowX = 0, nowY = 0;
            // 좌우, 하상 으로 저장.
            for (char ch : dirs.toCharArray()) {
                int nextX = nowX, nextY = nowY;
                if (ch == 'L' && nowX > -5) {
                    nextX = nowX - 1;
                    visited.add(new Road(nextX, nextY, nowX, nowY));
                } else if (ch == 'R' && nowX < 5) {
                    nextX = nowX + 1;
                    visited.add(new Road(nowX, nowY, nextX, nextY));
                } else if (ch == 'U' && nowY < 5) {
                    nextY = nowY + 1;
                    visited.add(new Road(nowX, nowY, nextX, nextY));
                } else if (ch == 'D' && nowY > -5) {
                    nextY = nowY - 1;
                    visited.add(new Road(nextX, nextY, nowX, nowY));
                }
                nowX = nextX;
                nowY = nextY;
            }
            return visited.size();
        }
    }

    class Road {
        int x1;
        int y1;
        int x2;
        int y2;

        public Road(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Road road = (Road) o;
            return x1 == road.x1 && y1 == road.y1 && x2 == road.x2 && y2 == road.y2;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x1, y1, x2, y2);
        }
    }

    class Solution2 {
        public int solution(String dirs) {
            Set<List<Integer>> visited = new HashSet<>();
            int nowX = 0, nowY = 0;
            // 좌우, 하상 으로 저장.
            for (char ch : dirs.toCharArray()) {
                int nextX = nowX, nextY = nowY;
                if (ch == 'L' && nowX > -5) {
                    nextX = nowX - 1;
                    visited.add(List.of(nextX, nextY, nowX, nowY));
                } else if (ch == 'R' && nowX < 5) {
                    nextX = nowX + 1;
                    visited.add(List.of(nowX, nowY, nextX, nextY));
                } else if (ch == 'U' && nowY < 5) {
                    nextY = nowY + 1;
                    visited.add(List.of(nowX, nowY, nextX, nextY));
                } else if (ch == 'D' && nowY > -5) {
                    nextY = nowY - 1;
                    visited.add(List.of(nextX, nextY, nowX, nowY));
                }
                nowX = nextX;
                nowY = nextY;
            }
            return visited.size();
        }
    }
}