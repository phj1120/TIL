package y22.m10.d24;

import java.util.*;

public class ValidSudoku {

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        boolean validSudoku = solution2.isValidSudoku(board);
    }
}

class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> set;
        // 가로
        for (int i = 0; i < 9; i++) {
            set = new HashSet();
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.' && set.contains(num))
                    return false;
                else
                    set.add(num);
            }
        }

        // 세로
        for (int i = 0; i < 9; i++) {
            set = new HashSet();
            for (int j = 0; j < 9; j++) {
                char num = board[j][i];
                if (num != '.' && set.contains(num))
                    return false;
                else
                    set.add(num);
            }
        }

        // 박스
        int[][] indexs = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};
        for (int[] rows : indexs) {
            for (int[] cols : indexs) {
                set = new HashSet();
                for (int i : rows) {
                    for (int j : cols) {
                        char num = board[i][j];
                        if (num != '.' && set.contains(num))
                            return false;
                        else
                            set.add(num);
                    }
                }
            }
        }
        return true;
    }
}

class Solution2 {
    public boolean isValidSudoku(char[][] board) {
        List<Set<Character>> rows = new ArrayList<>();
        List<Set<Character>> cols = new ArrayList<>();
        Map<List<Integer>, Set<Character>> squares = new HashMap();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cols.add(new HashSet<Character>());
                rows.add(new HashSet<Character>());
                List<Integer> set = new ArrayList<>();
                set.add(i);
                set.add(j);
                squares.put(set, new HashSet<Character>());
            }
        }

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char ch = board[r][c];
                if (ch == '.') {
                    continue;
                }
                List<Integer> list = new ArrayList<>();
                list.add((r) / 3);
                list.add((c) / 3);
                if (cols.get(c).contains(ch) ||
                        rows.get(r).contains(ch) ||
                        squares.get(list).contains(ch)) {
                    return false;
                }
                cols.get(c).add(ch);
                rows.get(r).add(ch);
                squares.get(list).add(ch);
            }
        }
        return true;
    }
}