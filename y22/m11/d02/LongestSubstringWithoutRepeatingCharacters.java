package y22.m11.d02;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int length = solution.lengthOfLongestSubstring("");
        System.out.println(length);
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set set = new HashSet();
        int left = 0;
        int maxLength = 0;
        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}

// 문자 반복 없는 가장 긴 부분 문자열 길이
class SolutionFirst {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        if (s.isEmpty()) {
            return 0;
        }
        int maxLength = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            // right 증가 후 중복 확인
            if (isRepeat(s, left, ++right)) {
                // 중복이 아니게 될 떄까지 left 증가
                while (isRepeat(s, ++left, right)) {
                }
            } else {
                maxLength = Math.max(maxLength, right - left + 1);
            }
        }
        return maxLength;
    }

    private boolean isRepeat(String s, int left, int right) {
        if (left == right) {
            return false;
        }

        Set set = new HashSet();
        for (int i = left; i <= right; i++) {
            char now = s.charAt(i);
            if (set.contains(now)) {
                return true;
            }
            set.add(now);
        }
        return false;
    }
}

