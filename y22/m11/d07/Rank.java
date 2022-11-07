package y22.m11.d07;

import java.util.*;
import java.util.stream.Collectors;

public class Rank {
    public static void main(String[] args) {
        int n = 5;
        int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
        int correctAnswer = 2;
        Solution solution = new Solution();
        int answer = solution.solution(n, results);
        System.out.println(answer == correctAnswer);
        System.out.println(answer);
    }

    static class Solution {
        public int solution(int n, int[][] results) {
            List<Set<Integer>> winGraph = new ArrayList<>();
            List<Set<Integer>> loseGraph = new ArrayList<>();
            int[] ranks = new int[n + 1];

            // 초기화
            for (int i = 0; i <= n; i++) {
                winGraph.add(new HashSet<Integer>());
                loseGraph.add(new HashSet<Integer>());
            }

            // 그래프에 내용 추가
            for (int[] data : results) {
                int win = data[0];
                int lose = data[1];
                winGraph.get(win).add(lose);
                loseGraph.get(lose).add(win);
            }

            // 모든 경기 기록이 있는 선수 등수 저장
            Set<Integer> rankedPlayer = new HashSet<>();
            for (int i = 1; i <= n; i++) {
                int playCount = winGraph.get(i).size() + loseGraph.get(i).size();
                if (playCount == n - 1) {
                    // 순위 = 진 횟 수 + 1
                    int rank = loseGraph.get(i).size() + 1;
                    ranks[rank] = i;
                    rankedPlayer.add(i);
                }
            }

            for (int i = 1; i <= n; i++) {
                if (!rankedPlayer.contains(i)) {
                    // 현재 선수가 이긴 사람의 등수가 확정이면, 그 사람이 이긴 사람은 현재 선수가 다 이김
                    List<Integer> nowPlayerWinList = winGraph.get(i).stream().collect(Collectors.toList());
                    for (int player : nowPlayerWinList) {
                        for (int playerWin : winGraph.get(player)) {
                            winGraph.get(i).add(playerWin);
                            loseGraph.get(playerWin).add(i);
                        }
                    }

                    // 현재 선수가 진 사람의 등수가 확정이면, 그 사람이 진 사람은 현재 선수가 다 짐
                    List<Integer> nowPlayerLoseList = loseGraph.get(i).stream().collect(Collectors.toList());
                    for (int player : nowPlayerLoseList) {
                        for (int playerWin : loseGraph.get(player)) {
                            winGraph.get(playerWin).add(i);
                            loseGraph.get(i).add(playerWin);
                        }
                    }
                }
            }

            // 순위 확정된 사람 수 확인
            int answer = 0;
            for (int i = 1; i <= n; i++) {
                if (winGraph.get(i).size() + loseGraph.get(i).size() == n - 1) {
                    answer++;
                }
            }
            return answer;
        }
    }
}
