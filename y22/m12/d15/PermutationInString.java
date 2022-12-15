package m12.d15;

import java.util.Arrays;

public class PermutationInString {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        String s1 = "ab";
//        String s2 = "eidbaooo";
//        boolean correctAnswer = true;
//
        String s1 = "adc";
        String s2 = "dcda";
        boolean correctAnswer = true;
        boolean answer = solution.checkInclusion(s1, s2);
        System.out.println(correctAnswer == answer);
        System.out.println(answer);
    }
}

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // s1 이 더 긴 경우
        if (s1.length() > s2.length()) {
            return false;
        }

        // s1 의 길이 만큼 두 배열 초기화
        int[] correctAlphabet = new int[26];
        int[] alphabet = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            correctAlphabet[s1.charAt(i) - 'a']++;
            alphabet[s2.charAt(i) - 'a']++;
        }

        // 슬라이딩 윈도우 활용해 부분 s2 의 문자열이 s1 의 순열인지 확인
        int left = 0;
        for (int right = s1.length(); right < s2.length(); right++) {
            if (Arrays.equals(correctAlphabet, alphabet)) {
                return true;
            }
            alphabet[s2.charAt(left++) - 'a']--;
            alphabet[s2.charAt(right) - 'a']++;
        }

        return Arrays.equals(correctAlphabet, alphabet);
    }
}