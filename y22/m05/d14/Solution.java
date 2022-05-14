package y22.m05.d14;

//    가장 큰 영역의 크기 = 0 반복 방문할 위치가 있는 경우
//
//        1. 다음 방문 할 위치로 이동
//        2. 방문 처리
//        3. 현재 위치의 값이 0 인 경우
//        1. 0인 부분 탐색 하며, 방문 처리
//        4. 현재 위치의 값이 0 이 아닌 경우
//        1. 영역 개수 ++
//        2. 현재 위치의 값과 같은 부분 탐색 하며, 방문 처리
//        3. 해당 영역의 크기 카운트
//        4. 가장 큰 영역의 크기 = max(해당 영역의 크기, 가장 큰 영역)
//
//        반환 영역 개수, 가장 큰 영역의 크기

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {


        int[][] pic1 = new int[][]{{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        int[][] pic2 = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};

        int[][] pic3 = new int[6][4];
        for (int i = 0; i < pic3.length; i++) {
            for (int j = 0; j < pic3[i].length; j++) {
                pic3[i][j] = 0;
            }
        }
        int[][] pic4 = new int[6][4];

        for (int i = 0; i < pic4.length; i++) {
            Arrays.fill(pic4[i], 0);
        }

        Solution sol = new Solution();
        sol.solution(6, 4, pic1);
        sol.solution(6, 4, pic2);
    }

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        boolean[][] isVisited = new boolean[6][4];

        for (int i = 0; i < isVisited.length; i++) {
            Arrays.fill(isVisited[i], false);
        }

        for (int i = 0; i < isVisited.length; i++) {
            for (int j = 0; j < isVisited[i].length; j++) {
                System.out.print(isVisited[i][j]);
            }
            System.out.println();
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}
