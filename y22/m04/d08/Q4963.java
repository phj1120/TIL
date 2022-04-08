// 음료수 얼려먹기 문제

package y22.m04.d08;

import java.util.*;

public class Q4963 {

    static int[][] arr;
    static int cnt, n, m;
    static Stack<Map<Character, Integer>> s;

    static void dfs(int x, int y) {
        arr[y][x] = 0;
        if (s.isEmpty()) return;
        
//        상하좌우
        if (y != 0 && arr[y - 1][x] == 1) {
            s.push(xyMap(x, y - 1));
            arr[y - 1][x] = 1;
        }
        if (y != n -1 && arr[y + 1][x] == 1) {
            s.push(xyMap(x, y+1));
            arr[y + 1][x] = 1;
        }
        if (x != 0 && arr[y][x -1] == 1) {
            s.push(xyMap(x- 1, y));
            arr[y][x-1] = 1;
        }
        if (x != m-1 && arr[y][x+1] == 1) {
            s.push(xyMap(x+1, y));
            arr[y][x+1] = 1;
        }
//        대각선
        if (y != 0 && x != 0 && arr[y - 1][x - 1] == 1) {
            s.push(xyMap(x -1, y - 1));
            arr[y - 1][x - 1] = 1;
        }
        if (y != 0 && x != m-1 && arr[y - 1][x+1] == 1) {
            s.push(xyMap(x + 1, y - 1));
            arr[y - 1][x + 1] = 1;
        }
        if (y != n - 1 && x != 0 && arr[y + 1][x - 1] == 1) {
            s.push(xyMap(x - 1, y + 1));
            arr[y + 1][x - 1] = 1;
        }
        if (y != n - 1 && x != m - 1 && arr[y + 1][x + 1] == 1) {
            s.push(xyMap(x + 1, y + 1));
            arr[y + 1][x + 1] = 1;
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
        while (true) {
            m = sc.nextInt();
            n = sc.nextInt();
            if(n==0 && m == 0) {
                sc.close();
                break;
            }
            arr = new int[n][m];
            s = new Stack<>();
            cnt = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
//        for (int[] subArray : arr) {
//            System.out.println(Arrays.toString(subArray));
//        }
//        System.out.println();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] == 1) {
                        s.push(xyMap(j, i));
                        dfs(j, i);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }
}
//4 5
//00110
//00011
//11111
//00000