package y22.m12.d14;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        String s = "ABAB";
//        int k = 2;
//        int correctAnswer = 4;

        String s = "AABABBA";
        int k = 1;
        int correctAnswer = 4;

//        String s = "AAAB";
//        int k = 0;
//        int correctAnswer = 3;

//        String s = "ABBB";
//        int k = 2;
//        int correctAnswer = 4;

//        String s = "IFLAKDTODTSNQDHMESGLECHFHTGLDFEAHKMBJPAGDMTIJIOQBPDBMBFNKFFDRSESRDINQICMDRQHLSQIKTHKQLEGBMIESPTSGADR";
//        int k = 5;
//        int correctAnswer = 8;

        int answer = solution.characterReplacement(s, k);
        System.out.println(correctAnswer == answer);
        System.out.println(answer);
    }
}

class Solution {
    public int characterReplacement(String s, int k) {
        int maxLength = 0;
        int[] alphabet = new int[26];
        int left = 0;
        int maxAlphabetCount = 0;
        for (int right = 0; right < s.length(); right++) {
            int now = s.charAt(right) - 'A';
            alphabet[now]++;
            maxAlphabetCount = Math.max(maxAlphabetCount, alphabet[now]);
            if (right - left + 1 - maxAlphabetCount <= k) {
                maxLength = Math.max(maxLength, right - left + 1);
                continue;
            }
            alphabet[s.charAt(left++) - 'A']--;
        }

        return maxLength;
    }
}

class SolutionBetter {
    public int characterReplacement(String s, int k) {
        int maxLength = 0;
        int[] alphabet = new int[26];
        int left = 0;
        int maxAlphabetCount = 0;
        for (int right = 0; right < s.length(); right++) {
            int now = s.charAt(right) - 'A';
            alphabet[now]++;
            maxAlphabetCount = Math.max(maxAlphabetCount, alphabet[now]);
            if (right - left + 1 - maxAlphabetCount > k) {
                alphabet[s.charAt(left++) - 'A']--;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}

class SolutionFail {
    public int characterReplacement(String s, int k) {
        int maxLength = 0;
        for (int left = 0; left < s.length(); left++) {
            int changeCount = 0;
            int firstDifferentIndex = 0;
            int repeatLength = 0;
            char repeatCharacter = s.charAt(left);
            for (int right = left; right < s.length(); right++) {
                // 반복 되는 경우
                if (s.charAt(right) == repeatCharacter) {
                    repeatLength++;
                    continue;
                }
                // 반복 되지 않는 경우
                // 바꿀 수 있는 경우
                if (changeCount < k) {
                    // 이번 문자열 반복에 처음 다른 문자열이 나온 경우
                    if (firstDifferentIndex < left) {
                        firstDifferentIndex = right;
                    }
                    changeCount++;
                    repeatLength++;
                    continue;
                }
                // 바꿀 수 없는 경우
                if (k == 0) {
                    left = right;
                    break;
                }
                left = Math.max(0, firstDifferentIndex - 1);
                break;
            }
            maxLength = Math.max(maxLength, repeatLength);
        }

        for (int left = 0; left < s.length(); left++) {
            int changeCount = 0;
            int firstDifferentIndex = 0;
            int repeatLength = 0;
            char repeatCharacter = s.charAt(Math.min(left + 1, s.length() - 1));
            for (int right = left; right < s.length(); right++) {
                // 반복 되는 경우
                if (s.charAt(right) == repeatCharacter) {
                    repeatLength++;
                    continue;
                }
                // 반복 되지 않는 경우
                // 바꿀 수 있는 경우
                if (changeCount < k) {
                    // 이번 문자열 반복에 처음 다른 문자열이 나온 경우
                    if (firstDifferentIndex < right) {
                        firstDifferentIndex = left;
                    }
                    changeCount++;
                    repeatLength++;
                    continue;
                }
                // 바꿀 수 없는 경우
                if (k == 0) {
                    left = right;
                    break;
                }
                break;
            }
            maxLength = Math.max(maxLength, repeatLength);
        }

        return maxLength;
    }
}
