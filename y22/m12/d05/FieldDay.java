package y22.m12.d05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FieldDay {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] ability = {{40, 10, 10}, {20, 5, 0}, {30, 30, 30}, {70, 0, 70}, {100, 100, 100}};
        int correctAnswer = 210;
        int answer = solution.solution(ability);
        System.out.println(answer == correctAnswer);
        System.out.println(answer);
    }
}


class Solution {
    List<List<Integer>> eventOrders = new ArrayList<>();

    public void setEventOrders() {

    }

    public int solution(int[][] ability) {
        // 학생 정보 담긴 Map 생성
        Map<Integer, int[]> studentAbility = new HashMap<>();
        for (int i = 0; i < ability.length; i++) {
            studentAbility.put(i, ability[i]);
        }

        // 뽑을 순서 정함
        setEventOrders();


        // 뽑기
        int maxSum = 0;
        for (List<Integer> eventOrder : eventOrders) {
            // 학생들 목록 초기화
            List<Integer> students = new ArrayList<>();
            for (int i = 0; i < ability.length; i++) {
                students.add(i);
            }
            int sum = 0;
            for (Integer event : eventOrder) {
                // 해당 종목의 점수가 가장 높은 사람 복사한 리스트에서 빼고 점수 더함
            }
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
}