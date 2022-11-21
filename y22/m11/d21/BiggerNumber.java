package m11.d21;

public class BiggerNumber {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String answer = solution.solution("1924", 2);
        String correctAnswer = "94";
        System.out.println(answer.equals(correctAnswer));
        System.out.println(answer);
    }
}

class Solution {
    public String solution(String number, int k) {
        String result = "";
        int index = 0;
        while (k != 0) {
            System.out.println(k + " / " + index);
            int maxIndex = getMaxIndex(number, index, k);
            result += number.charAt(maxIndex);
            k -= (maxIndex - index);
            index = maxIndex;
        }
        return result;
    }

    private int getMaxIndex(String number, int i, int k) {
        int maxIndex = -1;
        int maxValue = Integer.MIN_VALUE;
        for (int j = i; j < i + k; j++) {
            if (maxValue < Character.getNumericValue(number.charAt(j))) {
                maxIndex = j;
                maxValue = Character.getNumericValue(number.charAt(j));
            }
        }
        return maxIndex;
    }
}
