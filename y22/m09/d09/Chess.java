package y22.m09.d09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Chess {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nm = br.readLine();
        String[] size = nm.split(" ");
        int n = Integer.parseInt(size[0]);
        int m = Integer.parseInt(size[1]);

        char[][] board = new char[n][m];
        for (int i = 0; i < n; i++) {
            char[] line = br.readLine().toCharArray();
            board[i] = line;
        }

        char[][] chessBoard1 = {
                {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}
        };

        char[][] chessBoard2 = {
                {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}
        };

        int minCnt = Integer.MAX_VALUE;
        for (int i = 0; i < n - 7; i++) {
            for (int j = 0; j < m - 7; j++) {
                int cnt = 0;
                for (int y = 0; y < 8; y++) {
                    int dy = y + i;
                    for (int x = 0; x < 8; x++) {
                        int dx = x + j;
                        if (chessBoard1[y][x] != board[dy][dx]) {
                            cnt++;
                        }
                    }
                }
                if (minCnt > cnt) {
                    minCnt = cnt;
                }
                cnt = 0;
                for (int y = 0; y < 8; y++) {
                    int dy = y + i;
                    for (int x = 0; x < 8; x++) {
                        int dx = x + j;
                        if (chessBoard2[y][x] != board[dy][dx]) {
                            cnt++;
                        }
                    }
                }
                if (minCnt > cnt) {
                    minCnt = cnt;
                }
            }
        }
        System.out.print(minCnt);
    }
}

class BestSolution {
    public static int getSolution(int startRow, int startCol, String[] board) {
        String[] orgBoard = {"WBWBWBWB", "BWBWBWBW"};
        int whiteSol = 0;
        for (int i = 0; i < 8; i++) {
            int row = startRow + i;
            for (int j = 0; j < 8; j++) {
                int col = startCol + j;
                if (board[row].charAt(col) != orgBoard[row%2].charAt(j))
                    whiteSol++;
            }
        }

        return Math.min(whiteSol, 64 - whiteSol);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        sc.nextLine();

        String[] board = new String[row];
        for (int i = 0; i < row; i++)
            board[i] = sc.nextLine();

        int sol = Integer.MAX_VALUE;
        for (int i = 0; i <= row - 8; i++) {
            for (int j = 0; j <= col - 8; j++) {
                int curSol = getSolution(i, j, board);
                if (sol > curSol)
                    sol = curSol;
            }
        }
        System.out.print(sol);
        sc.close();
    }
}