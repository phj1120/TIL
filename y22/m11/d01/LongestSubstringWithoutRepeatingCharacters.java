package y22.m11.d01;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int length = solution.lengthOfLongestSubstring("aab");
        System.out.println(length);
    }
}

// 문자 반복 없는 가장 긴 부분 문자열 길이
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int maxLength = 0;
        for (int i = 0; i <= s.length(); i++) {
            if (isRepeat(s, left, right)) {
                right = i;
                left = i;
            } else {
                maxLength = Math.max(maxLength, right - left + 1);
                right = Math.min(right + 1, s.length() - 1);
            }
        }
        // 마지막의 경우 고려하는 코드 추가
        return maxLength;
    }

    private boolean isRepeat(String s, int left, int right) {
        Set set = new HashSet();
        if (left == right) {
            return false;
        }

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