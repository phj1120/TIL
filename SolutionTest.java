// 작성자 : 박현준
// 작성일 : 2022.05.17.
// 설명
// 프로그래머스 코딩 테스트 연습 채점용 프로그램
// Solution 에 프로그래머스에서 작성한 코드 입력.
// 입력, 출력, 테스트 실행 부분 : 문제에서 주어진 대로 변경
// 실행 시 출력값과 실행 결과 비교해 정답 여부 출력

import java.util.Arrays;

public class SolutionTest {
    public static void main(String[] args) throws InterruptedException {
        long beforeTime = System.currentTimeMillis();

        Solution sol = new Solution();

        // 입력
        int m = 6;
        int n = 4;
        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};

        // 출력
        int[] correctAnswer = {4, 5};

        // 테스트 실행
        int[] answer = sol.solution(m, n, picture);

        String answerStr = Arrays.toString(answer);
        String correctAnswerStr = Arrays.toString(correctAnswer);

        // 결과 비교
        if (correctAnswerStr.equals(answerStr)) {
            System.out.println("테스트를 통과하였습니다.");
        } else {
            System.out.printf("실행한 결괏값 %s이(가) 기댓값 %s와(과) 다릅니다.\n", answerStr, correctAnswerStr);
        }

        long afterTime = System.currentTimeMillis();
        System.out.printf("실행 시간 : %.3f 초\n", (float) (afterTime - beforeTime) / 1000);
    }
}

class Solution {
    public static int m;
    public static int n;
    public static int sizeOfOneArea = 0;

    public static void copy(int[][] picture, int[][] arr, int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = picture[i][j];
            }
        }
    }

    public static void printArr(int[][] arr) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public void dfs(int[][] picture, int color, int x, int y) {
        if (x <= -1 || x >= m || y <= -1 || y >= n) return;
        if (picture[x][y] != color) return;
        picture[x][y] = 0;
        sizeOfOneArea++;
        dfs(picture, color, x - 1, y);
        dfs(picture, color, x + 1, y);
        dfs(picture, color, x, y - 1);
        dfs(picture, color, x, y + 1);
    }

    public int[] solution(int m, int n, int[][] picture) {
        this.m = m;
        this.n = n;
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int[][] arr = new int[m][n];
        copy(picture, arr, m, n);


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int color = arr[i][j];
                if (color == 0) continue;
//                printArr(picture);
                dfs(arr, color, i, j);
                maxSizeOfOneArea = Math.max(sizeOfOneArea, maxSizeOfOneArea);
                numberOfArea++;
                sizeOfOneArea = 0;
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}
