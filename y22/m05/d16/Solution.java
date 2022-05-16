// 기본 테스트 케이스는 통과 하는데
// 채점용은 실패.. 추가로 테케 만들어서 해봐도 어디가 잘 못 된건지 잘 모르겠음
// 질문하기 보니까 picture 를 복사해서 쓰라는 말이 있어서 복사해봄
// 그러니까 통과함, 사람들도 왜 그런지 모르겠다고 그러고 나도 모르겠다.
// 내부에 뭔가가 있지 않을까? 일단 로직은 맞았으니까 됐다.
// 다른 사람 코드 비교해 볼 것

package y22.m05.d16;

public class Solution {
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

    public void dfs(int[][] picture, int color, int x, int y) {
        // for (int i = 0; i< m; i++){
        //     for (int j = 0; j<n; j++){
        //         System.out.print(picture[i][j]);
        //     }
        //     System.out.println();
        // }
        // System.out.println();

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