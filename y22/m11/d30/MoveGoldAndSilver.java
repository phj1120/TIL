package m11.d30;

// 지금 내가 구현 할 수 있는 레벨은 아닌 것 같아 정답을 적어보면서 공부 했음
// 문제 푸는 방법은 이해 했는데 구현은 못 할 듯.
public class MoveGoldAndSilver {
    class Solution {
        public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
            int cityLength = g.length;
            long start = 0;
            long end = (long) (10e9 * 2 * 10e5 * 2);
            long answer = end;

            while (start <= end) {
                long mid = (start + end) / 2;
                int goldMax = 0;
                int silverMax = 0;
                int mineralMax = 0;

                // 각 도시 탐색 하며 현재 시간에 운반 할 수 있는 금의 양, 은의 양, 총 자원의 양 구함
                for (int i = 0; i < cityLength; i++) {
                    int nowGold = g[i];
                    int nowSilver = s[i];
                    int nowWeight = w[i];
                    int nowTime = t[i];

                    // 현재 시간에 운반 할 수 있는 횟 수
                    long moveCount = mid / (nowTime * 2);
                    if (mid % (nowTime * 2) >= t[i]) {
                        moveCount++;
                    }

                    goldMax += Math.min(nowGold, moveCount * nowWeight);
                    silverMax += Math.min(nowSilver, moveCount * nowWeight);
                    mineralMax += Math.min(nowGold + nowSilver, moveCount * nowWeight);
                }

                // 현재 시간에 운반할 수 있는
                // 금의 양보다 크거나 같고,
                // 은의 양보다 크거나 같고,
                // 운반 할 수 있는 자원의 양이 구하는 금과 은의 양보다 크거나 같으면
                // 최소 시간을 찾기 위해 왼쪽 부분 탐색
                if (a <= goldMax && b <= silverMax && a + b <= mineralMax) {
                    end = mid - 1;
                    answer = Math.min(answer, mid);
                    continue;
                }

                // 오른쪽 부분 탐색
                start = mid + 1;
            }

            return answer;
        }
    }
}

