package y22.m09.d04;

import java.util.*;

public class DevelopFunction {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};
        int[] correctResult = {1, 3, 2};

        int[] answer = solution.solution(progresses, speeds);
        System.out.println(Arrays.equals(correctResult, answer));
    }
}

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        // 완료한 시기 구해 completeList 에 저장
        List<Integer> completeList = new ArrayList<>();
        for (int i = 0; i < progresses.length; i++) {
            int progress = progresses[i];
            int speed = speeds[i];
            int completeDay = (int) Math.ceil((double) (100 - progress) / speed);
            completeList.add(completeDay);
        }

        // 배포시 배포되는 기능 개수 distributionList 에 저장
        List<Integer> distributionList = new ArrayList<>();
        while (!completeList.isEmpty()) {
            int distributionCount = 1;
            int distribution = completeList.remove(0);

            while (!completeList.isEmpty()) {
                if (distribution >= completeList.get(0)) {
                    completeList.remove(0);
                    distributionCount++;
                } else {
                    break;
                }
            }
            distributionList.add(distributionCount);
        }

        // distributionList 배열로 변환
        int[] answer = new int[distributionList.size()];
        for (int i = 0; i < distributionList.size(); i++) {
            answer[i] = distributionList.get(i);
        }
        return answer;
    }
}