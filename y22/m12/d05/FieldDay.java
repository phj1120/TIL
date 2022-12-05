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
   public int solution(int[][] ability) {
        int studentLength = ability.length;
        int abilityLength = ability[0].length;

        // 학생 정보 담긴 Map 생성
        Map<Integer, int[]> studentAbility = new HashMap<>();
        for (int i = 0; i < studentLength; i++) {
            studentAbility.put(i, ability[i]);
        }

        // 뽑을 순서 정함
        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < abilityLength; i++) {
            values.add(i);
        }

        List<List<Integer>> eventOrders = new ArrayList<>();
        boolean[] isPicked = new boolean[abilityLength];
        recursiveEventOrders(values, eventOrders, new ArrayList<>(), isPicked);

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
                int maxAbilityStudent = getMaxAbilityStudent(studentAbility, students, event);
                students.remove(Integer.valueOf(maxAbilityStudent));
                sum += studentAbility.get(maxAbilityStudent)[event];
            }
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }

    public void recursiveEventOrders(List<Integer> values, List<List<Integer>> results, List<Integer> nowPicked, boolean[] isPicked) {
        if (nowPicked.size() == values.size()) {
            results.add(nowPicked);
            return;
        }

        for (Integer value : values) {
            if (!isPicked[value]) {
                List<Integer> newPicked = new ArrayList<>(nowPicked);
                newPicked.add(value);
                boolean[] newIsPicked = isPicked.clone();
                newIsPicked[value] = true;
                recursiveEventOrders(values, results, newPicked, newIsPicked);
            }
        }
    }

    private int getMaxAbilityStudent(Map<Integer, int[]> studentAbility, List<Integer> students, Integer event) {
        int maxAbilityValue = -1;
        int maxAbilityStudent = -1;
        for (int i = 0; i < students.size(); i++) {
            int student = students.get(i);
            int abilityValue = studentAbility.get(student)[event];
            if (abilityValue > maxAbilityValue) { // 같은 경우 처리 어떻게?
                maxAbilityStudent = student;
                maxAbilityValue = abilityValue;
            }
        }
        return maxAbilityStudent;
    }
}

class BestSolution {
    static int answer = 0;
    static boolean[] check;

    public int solution(int[][] ability) {
        check = new boolean[ability.length];
        recursive(0, ability[0].length, ability, 0);

        return answer;
    }

    public static void recursive(int index, int length, int[][] ability, int sum) {
        if (index == length) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = 0; i < ability.length; i++) {
            if (!check[i]) {
                check[i] = true;
                recursive(index + 1, length, ability, sum + ability[i][index]);
                check[i] = false;
            }
        }
    }
}