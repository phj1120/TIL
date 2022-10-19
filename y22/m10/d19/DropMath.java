package y22.m10.d19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DropMath {
}


class Solution {
    public int[] solution(int[] answers) {
        int count1 = 0, count2 = 0, count3 = 0;
        int[] answer1 = {1, 2, 3, 4, 5};
        int[] answer2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] answer3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int answer1Length = answer1.length;
        int answer2Length = answer2.length;
        int answer3Length = answer3.length;

        for (int i = 0; i < answers.length; i++) {
            int answer = answers[i];
            if (answer1[i % answer1Length] == answer) {
                count1++;
            }
            if (answer2[i % answer2Length] == answer) {
                count2++;
            }
            if (answer3[i % answer3Length] == answer) {
                count3++;
            }
        }

        int[] counts = {count1, count2, count3};
        int max = Arrays.stream(counts).max().getAsInt();

        List<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < counts.length; i++) {
            if (max == counts[i]) {
                tmp.add(i + 1);
            }
        }
        int[] answer = new int[tmp.size()];
        for (int i = 0; i < tmp.size(); i++) {
            answer[i] = tmp.get(i);
        }
        return answer;
    }
}