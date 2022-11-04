package y22.m11.d04;

import java.util.HashSet;
import java.util.Set;

public class EnglishConnectLastWord {
    static class Solution {
        public int[] solution(int n, String[] words) {
            int[] answer = new int[2];
            Set<String> history = new HashSet<>();
            history.add(words[0]);
            for (int i = 1; i < words.length; i++) {
                if (!isCorrectRule(words[i - 1], words[i], history)) {
                    int player = i % n + 1;
                    int turn = i / n + 1;
                    answer = new int[]{player, turn};
                    break;
                }
                history.add(words[i]);
            }
            return answer;
        }

        public boolean isCorrectRule(String prev, String now, Set<String> history) {
            return prev.charAt(prev.length() - 1) == now.charAt(0)
                    && !history.contains(now);
        }
    }
}
