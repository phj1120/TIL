package m12.d03;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MaxNumber {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] numbers = {0, 0, 0};
        int[] numbers = {6, 10, 2};
        String correctAnswer = "6210";
        String answer = solution.solution(numbers);

        System.out.println(correctAnswer.equals(answer));
        System.out.println(answer);
    }

    static class Solution {
        public String solution(int[] numbers) {
            List<Integer> list = Arrays.stream(numbers).boxed()
                    .sorted((i1, i2) -> {
                        String concat1 = String.valueOf(i1) + String.valueOf(i2);
                        String concat2 = String.valueOf(i2) + String.valueOf(i1);

                        return concat2.compareTo(concat1);
                    })
                    .collect(Collectors.toList());

            String answer = "";
            for (Integer integer : list) {
                answer += integer;
            }

            String checkZero = answer.replaceAll("0", "");
            if ("".equals(checkZero)) {
                return "0";
            }

            return answer;
        }
    }
}
