package y22.m10.d13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q4396 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line1 = br.readLine();
        int n = Integer.parseInt(line1);
        char[][] mineMap = new char[n][n];
        char[][] playMap = new char[n][n];
        char[][] resultMap = new char[n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            mineMap[i] = line.toCharArray();
        }
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            playMap[i] = line.toCharArray();
        }

        boolean isGameOver = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char mineNumber = '.';
                if (playMap[i][j] == 'x') {
                    if (mineMap[i][j] == '*') {
                        isGameOver = true;
                    }
                    mineNumber = (char) (getNumber(j, i, mineMap) + '0');
                }
                resultMap[i][j] = mineNumber;
            }
        }

        // 지뢰가 눌렸다면, 모든 지뢰 표시
        if (isGameOver) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (mineMap[i][j] == '*')
                        resultMap[i][j] = '*';
                }
            }
        }

        // 게임 결과 출력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(resultMap[i][j]);
            }
            System.out.println();
        }
    }

    // 주위 인접 칸에 있는 지뢰 개수
    public static int getNumber(int x, int y, char[][] mineMap) {
        int n = mineMap.length;
        int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};
        int[] dy = {-1, -1, -1, 0, 1, 1, 1, 0};

        int mineCount = 0;
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            // 맵의 범위 내에서만 탐색
            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if (mineMap[ny][nx] == '*')
                    mineCount++;
            }
        }
        return mineCount;
    }
}
