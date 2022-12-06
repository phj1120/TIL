package y22.m12.d06;

import java.util.Arrays;

public class Mendel {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] queries = {{3, 1}, {2, 3}, {3, 9}};
        String[] correctAnswer = {"RR", "Rr", "RR"};
        String[] answer = solution.solution(queries);

        System.out.println(Arrays.equals(answer, correctAnswer));
        System.out.println(Arrays.toString(answer));
    }
}

class Solution {
    public String[] solution(int[][] queries) {
        // queries 를 반복해 결과 값에 담는다
        String[] answer = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];

            int generate = query[0];
            int index = query[1] - 1;
            answer[i] = recursive(generate, index);
        }

        return answer;
    }

    public String recursive(int generate, int index) {
        // 1세대일 경우
        if (generate == 1) {
            return "Rr";
        }

        // 2세대일 경우
        String[] types = {"RR", "Rr", "Rr", "rr"};
        if (generate == 2) {
            return types[index];
        }

        // 현재 인덱스가 어디에 속하는지 계산 한다.
        if (index < (int) Math.pow(4, generate - 1) / 4) {
            return "RR";
        } else if (index < (int) Math.pow(4, generate - 1) / 4 * 3) {
            return recursive(generate - 1, index % (int) Math.pow(4, generate - 2));
        } else {
            return "rr";
        }
    }
}