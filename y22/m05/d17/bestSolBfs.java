// 최예소라

package y22.m05.d17;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class bestSolBfs {
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
    public int[] solution(int m, int n, int[][] picture) {

        boolean[][] check = new boolean[m][n];
        Queue<Node> q = new LinkedList<>();
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[i].length; j++) {
                int tempMax = 0;
                if (!check[i][j] && picture[i][j] != 0) {
                    check[i][j] = true;
                    q.add(new Node(i, j));
                    tempMax++;

                    while (!q.isEmpty()) {

                        Node current = q.poll();

                        int nextX = 0;
                        int nextY = 0;

                        for (int k = 0; k < 4; k++) {
                            nextX = current.x + dx[k];
                            nextY = current.y + dy[k];

                            if (nextX < 0 || nextY < 0 || nextX >= m || nextY >= n || check[nextX][nextY])
                                continue;
                            if (picture[current.x][current.y] == picture[nextX][nextY]) {
                                check[nextX][nextY] = true;
                                q.add(new Node(nextX, nextY));
                                tempMax++;
                            }
                        } // end of for_k

                    } // end of while
                    numberOfArea++;
                    maxSizeOfOneArea = maxSizeOfOneArea < tempMax ? tempMax : maxSizeOfOneArea;
                } // end of if

            } // end of for_j
        } // end of for_i

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;

//        System.out.println(numberOfArea + "," + maxSizeOfOneArea);

        return answer;

    } // end of solution

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}


