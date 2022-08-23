package y22.m08.d24;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Printer {

}
class MySolution {
    public int solution(int[] priorities, int location) {
        Queue<Integer> q = new LinkedList();
        int highPriority = 0;
        for (Integer priority : priorities) {
            q.add(priority);
            if (highPriority < priority) {
                highPriority = priority;
            }
        }

        int count = 0;
        while (!q.isEmpty()) {
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
                    for (Integer priority : q)
                        if (highPriority < priority)
                            highPriority = priority;
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

class Solution {
    public int solution(int[] priorities, int location) {
        ArrayList<Integer> printer = new ArrayList<>();
        for (Integer priority : priorities){
            printer.add(priority);
        }

        int turn = 0;
        while (!printer.isEmpty()) {
            Integer priority = printer.remove(0);
            if (printer.stream().anyMatch(otherPriority -> priority < otherPriority)) {
                printer.add(priority);
            } else {
                turn++;
                if (location == 0) {
                    break;
                }
            }
            location--;
            if (location < 0) {
                location = printer.size() - 1;
            }
        }
        return turn;
    }
}