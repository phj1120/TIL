package y22.m11.d01;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int length = solution.lengthOfLongestSubstring("abcabcbb");
        System.out.println(length);
    }
}

// 문자 반복 없는 가장 긴 부분 문자열 길이
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isRepeat(s, left, right)) {
                left = i;
            } else {
                right++;
                maxLength = Math.max(maxLength, right - left + 1);
            }
        }

        return maxLength;
    }

    private boolean isRepeat(String s, int left, int right) {
        Set set = new HashSet();
        for (int i = left; i < right; i++) {
            char now = s.charAt(i);
            if (set.contains(now)) {
                return true;
            }
            set.add(now);
        }
        return false;
    }

    private boolean isRepeat2(String s, int left, int right) {
        int length = right - left + 1;
        for (int i = 1; i <= length / 2; i++) {
            for (int j = 0; j < i; j++) {
                if (s.charAt(right - j) != s.charAt(right - j - i)) {
                    continue;
                }
                if (j == i - 1) {
                    return true;
                }
            }


        }
        return false;
    }
}