package m12.d16;

public class MinimumWindowString {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        String s = "ADOBECODEBANC";
//        String t = "ABC";
//        String correctAnswer = "BANC";
        String s = "a";
        String t = "aa";
        String correctAnswer = "";
//        String s = "ADOBECODEBANC";
//        String t = "ABC";
//        String correctAnswer = "BANC";
        String answer = solution.minWindow(s, t);
        System.out.println(correctAnswer.equals(answer));
        System.out.println(answer);
    }
}


class Solution {
    public String minWindow(String s, String t) {
        String result = "";
        if (s.length() < t.length()) {
            return result;
        }

        int[] correctAlphabet = new int[26];
        for (int i = 0; i < t.length(); i++) {
            correctAlphabet[convertInt(t.charAt(i))]++;
        }

        for (int length = t.length(); length < s.length() + 1; length++) {
            int[] alphabet = new int[26];
            for (int i = 0; i < length; i++) {
                alphabet[convertInt(s.charAt(i))]++;
            }
            int left = 0;
            int right = length;
            for (; right < s.length(); right++) {
                if (isInclude(alphabet, correctAlphabet)) {
                    return s.substring(left, right);
                }
                alphabet[convertInt(s.charAt(left++))]--;
                alphabet[convertInt(s.charAt(right))]++;
            }
            if (isInclude(alphabet, correctAlphabet)) {
                return s.substring(left, right);
            }
        }

        return result;
    }

    private int convertInt(char ch) {
        return (ch - 'A') % 26;
    }

    // children 이 parents 에 포함 되어 있는가?
    boolean isInclude(int[] parents, int[] children) {
        for (int i = 0; i < children.length; i++) {
            int child = children[i];
            int parent = parents[i];
            if (child > parent) {
                return false;
            }
        }

        return true;
    }
}