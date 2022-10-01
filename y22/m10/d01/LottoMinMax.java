package y22.m10.d01;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

class SolutionLotto {
    public int[] solution(int[] lottos, int[] win_nums) {
        int alpha = 0, correctCount = 0;
        Set<Integer> set = new HashSet<>(Arrays.stream(win_nums).boxed().collect(Collectors.toList()));

        for (int lotto : lottos) {
            if (lotto == 0)
                alpha++;
            if (set.contains(lotto))
                correctCount++;
        }

        return new int[]{getRank(correctCount + alpha), getRank(correctCount)};
    }

    public int getRank(int count) {
        if (count == 0)
            return 6;
        return 7 - count;
    }
}

public class LottoMinMax {
    public static void main(String[] args) {
        SolutionLotto solutionLotto = new SolutionLotto();
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};
        int[] correctAnswer = {3, 5};
        int[] answer = solutionLotto.solution(lottos, win_nums);

        System.out.println(Arrays.equals(answer, correctAnswer));
        System.out.println(Arrays.toString(answer));
    }

}
