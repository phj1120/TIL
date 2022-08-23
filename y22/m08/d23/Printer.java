package y22.m08.d23;

import java.util.LinkedList;
import java.util.Queue;

public class Printer {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] priorities = {1, 1, 9, 1, 1, 1};
        int answer = solution.solution(priorities, 0);
        int result = 5;
        System.out.println(answer == result);
        System.out.println("answer = " + answer);

    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        // 1. 인쇄 목록이 담긴 큐 초기화, 우선 순위가 가장 큰 값 저장
        Queue<Integer> q = new LinkedList();
        int highPriority = 0;
        for (Integer priority : priorities) {
            q.add(priority);
            if (highPriority < priority) {
                highPriority = priority;
            }
        }

        int count = 0;
        // 2. 큐에 값이 존재 하는 경우
        while (!q.isEmpty()) {
            System.out.println(q + " " + location + " " + count);
            Integer nowPriority = q.poll();

            // 중요도가 가장 높은 경우 - 프린터 출력
            if (highPriority == nowPriority) {
                count++;
                // 출력된 값이 원하는 값일 경우
                if (location == 0) {
                    break;
                } else {
                    // 출력된 값이 원하지 않는 값일 경우
                    highPriority = 0;
                    for (Integer priority : q) {
                        if (highPriority < priority) {
                            highPriority = priority;
                        }
                    }
                    location--;
                }

                // 중요도가 가장 높지 않은 경우 - 프린터 미출력
            } else {
                // 출력 되지 않은 문서가 원하는 문서일 경우
                if (location == 0) {
                    location = q.size();
                    // 출력 되지 않은 문서가 원하지 않는 문서일 경우
                } else {
                    location--;
                }
                q.add(nowPriority);
            }
        }
        return count;
    }
}