package y22.m11.d22;

public class BiggerNumber {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        String number = "1231234";
//        int k = 3;
//        String correctAnswer = "3234";

//        String number = "4177252841";
//        int k = 4;
//        String correctAnswer = "775841";

        String number = "654321";
        int k = 1;
        String correctAnswer = "65432";

        String answer = solution.solution(number, k);
        System.out.println(answer.equals(correctAnswer));
        System.out.println(answer);
    }
}

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        int index = 0;
        while (k != 0) {
            if (k == number.length() - index) {
                break;
            }
            String subString = number.substring(index, index + k + 1);
            int maxIndex = index + getMaxIndexInSubString(subString);
            if (maxIndex == index) {
                answer += number.charAt(index);
                index++;
                continue;
            }
            k -= maxIndex - index;
            index = maxIndex;
            if (k == 0) {
                answer += number.substring(index);
            }
        }
        return answer;
    }

    private int getMaxIndexInSubString(String number) {
        int maxValue = Integer.MIN_VALUE;
        int maxIndex = -1;

        for (int i = 0; i < number.length(); i++) {
            if (maxValue < number.charAt(i)) {
                maxIndex = i;
                maxValue = number.charAt(i);
            }
        }

        return maxIndex;
    }
}
