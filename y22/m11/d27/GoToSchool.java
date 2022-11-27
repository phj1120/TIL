package y22.m11.d27;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class GoToSchool {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] puddles = {{2, 2}};
        int answer = solution.solution(4, 3, puddles);
        int correctAnswer = 4;

        System.out.println(answer == correctAnswer);
        System.out.println(answer);
    }

}

class Solution {
    int MOD = 1_000_000_007;

    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n][m];
        for (int[] puddle : puddles) {
            dp[puddle[1] - 1][puddle[0] - 1] = -1;
        }

        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 현재 위치가 웅덩이일 경우 다음으로 이동
                if (dp[i][j] == -1) {
                    continue;
                }

                // 왼쪽에서 올 수 있는 경우
                if (i - 1 >= 0 && dp[i - 1][j] != -1) {
                    dp[i][j] += dp[i - 1][j] % MOD;
                }

                // 위쪽에서 올 수 있는 경우
                if (j - 1 >= 0 && dp[i][j - 1] != -1) {
                    dp[i][j] += dp[i][j - 1] % MOD;
                }
            }
        }
        return dp[n - 1][m - 1] % MOD;
    }
}

// 성공
class SolutionWithNode {
    public int solution(int m, int n, int[][] puddles) {
        long[][] dp = new long[n][m];
        Set<Node> set = new HashSet<>();
        for (int[] puddle : puddles) {
            set.add(new Node(puddle[1] - 1, puddle[0] - 1));
        }

        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Node nowNode = new Node(i, j);
                if (set.contains(nowNode)) {
                    continue;
                }
                // 웅덩이는 어차피 0이므로, 메모리 들여 노드 생성할 필요 없다고 생각
                if (i - 1 >= 0) {
                    dp[i][j] += dp[i - 1][j] % 1000000007;
                }
                if (j - 1 >= 0) {
                    dp[i][j] += dp[i][j - 1] % 1000000007;
                }
            }
        }
        return (int) (dp[n - 1][m - 1] % 1000000007);
    }
}

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return x == node.x && y == node.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

// 시간 초과 실패
class SolutionWithList {
    public int solution(int m, int n, int[][] puddles) {
        long[][] dp = new long[n][m];
        Set<List<Integer>> set = new HashSet<>();
        for (int[] puddle : puddles) {
            set.add(List.of(puddle[1] - 1, puddle[0] - 1));
        }

        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                List nowList = List.of(i, j);
                if (set.contains(nowList)) {
                    continue;
                }
                // 웅덩이는 어차피 0이므로, 메모리 들여 노드 생성할 필요 없다고 생각
                if (i - 1 >= 0) {
                    dp[i][j] += dp[i - 1][j] % 1000000007;
                }
                if (j - 1 >= 0) {
                    dp[i][j] += dp[i][j - 1] % 1000000007;
                }
            }
        }
        return (int) (dp[n - 1][m - 1] % 1000000007);
    }
}

