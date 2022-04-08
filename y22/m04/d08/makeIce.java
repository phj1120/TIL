// 음료수 얼려먹기 문제

package y22.m04.d08;

import java.util.*;

public class makeIce {

    static int[][] arr;
    static int cnt, n, m;
    static Stack<Map<Character, Integer>> s;

    static void dfs(int x, int y) {
        arr[y][x] = 1;
        if (s.isEmpty()) return;

        if (y != 0 && arr[y - 1][x] == 0) {
            s.push(xyMap(x, y- 1));
            arr[y - 1][x] = 1;
        }
        if (y != n -1 && arr[y + 1][x] == 0) {
            s.push(xyMap(x, y+1));
            arr[y + 1][x] = 1;
        }
        if (x != 0 && arr[y][x -1] == 0) {
            s.push(xyMap(x- 1, y));
            arr[y][x-1] = 1;
        }
        if (x != m-1 && arr[y][x+1] == 0) {
            s.push(xyMap(x+1, y));
            arr[y][x+1] = 1;
        }
//        System.out.println(s);
        Map<Character, Integer> map = s.pop();
        dfs(map.get('x'), map.get('y'));
    }

    static Map<Character, Integer> xyMap(int x, int y) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('x', x);
        map.put('y', y);
        return map;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        s = new Stack<>();
        arr = new int[n][m];
        cnt = 0;
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            char[] chars = line.toCharArray();
            for (int j = 0; j < m; j++) {
                arr[i][j] = chars[j] - '0';
            }
        }
//        for (int[] subArray : arr) {
//            System.out.println(Arrays.toString(subArray));
//        }
//        System.out.println();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    s.push(xyMap(j, i));
                    dfs(j, i);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
//4 5
//00110
//00011
//11111
//00000