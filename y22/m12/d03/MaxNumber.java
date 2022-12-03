package m12.d03;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MaxNumber {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] numbers = {6, 10, 2};
        String correctAnswer = "6210";
        String answer = solution.solution(numbers);

        System.out.println(correctAnswer.equals(answer));
        System.out.println(answer);
    }

    static class Solution {
        public String solution(int[] numbers) {
            List<Integer> list = Arrays.stream(numbers).boxed().collect(Collectors.toList());
            list.sort((i1, i2) -> {
                String s1 = i1.toString();
                String s2 = i2.toString();

                return s2.compareTo(s1);
            });

            String answer = "";
            for (Integer integer : list) {
                answer += integer;
            }

            return answer;
        }
    }
}
