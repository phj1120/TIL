package y22.m09.d08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            // 1. 한 개의 기능을 개발 하는데 필요한 날짜 계산
            double days = (100 - progresses[i]) / (double) speeds[i]; // 하나 이상이 double 형이어야함
            int daysUp = (int) Math.ceil(days);

            // 2. 함께 배포할 기능의 index 찾기
            int j = i + 1; // for 문 밖에서도 사용하기 위해
            for (; j < progresses.length; j++) {
                if (progresses[j] + daysUp * speeds[j] < 100)
                    break;
            }

            // 3. 이번에 배포할 기능의 개수 추가 하기
            // j : 같이 배포할 수 없는 첫 인덱스
            // j-1 까지 같이 배포할 수 있음
            // j - 1 - i + 1
            answer.add(j - i);


            // j-1 까지 배포했으니 다음은 j 부터 시작해야함
            // i++ 후 다음 반복문이 시작하므로
            // j-1
            i = j - 1;
        }

        // 1중이라 for 문으로 돌려도 되지만 스트림 활용
        return answer.stream().mapToInt(i -> i.intValue()).toArray();
    }
}
